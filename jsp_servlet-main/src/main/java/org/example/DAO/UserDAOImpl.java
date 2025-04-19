package org.example.DAO;

import org.example.model.Follow;
import org.example.model.User;
import org.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = mapRowToUser(resultSet);
                loadFollows(user, connection); // Tải danh sách following và followers
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (username, password, role, created_at) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setTimestamp(4, Timestamp.valueOf(user.getCreatedAt()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = mapRowToUser(resultSet);
                loadFollows(user, connection); // Tải danh sách following và followers
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = mapRowToUser(resultSet);
                loadFollows(user, connection); // Tải danh sách following và followers
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = mapRowToUser(resultSet);
                loadFollows(user, connection); // Tải danh sách following và followers
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users (email, dob, province_id, avatar) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setDate(2, Date.valueOf(user.getDob()));
            stmt.setInt(3, user.getProvince_id());
            stmt.setString(4, user.getAvatar());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET email = ?, dob = ?, province_id = ?, avatar = ? WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setDate(2, Date.valueOf(user.getDob()));
            stmt.setInt(3, user.getProvince_id());
            stmt.setString(4, user.getAvatar());
            stmt.setLong(5, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User mapRowToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(resultSet.getString("role"));
        user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return user;
    }

    // Tải danh sách following và followers từ bảng follows
    private void loadFollows(User user, Connection connection) throws SQLException {
        // Lấy danh sách following
        String followingSql = "SELECT * FROM follows WHERE follower_id = ?";
        List<Follow> following = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(followingSql)) {
            stmt.setLong(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Follow follow = new Follow();
                follow.setFollowerId(rs.getLong("follower_id"));
                follow.setFollowingId(rs.getLong("following_id"));
                follow.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                following.add(follow);
            }
        }
        user.setFollowing(following);

        // Lấy danh sách followers
        String followersSql = "SELECT * FROM follows WHERE following_id = ?";
        List<Follow> followers = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(followersSql)) {
            stmt.setLong(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Follow follow = new Follow();
                follow.setFollowerId(rs.getLong("follower_id"));
                follow.setFollowingId(rs.getLong("following_id"));
                follow.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                followers.add(follow);
            }
        }
        user.setFollowers(followers);
    }
}