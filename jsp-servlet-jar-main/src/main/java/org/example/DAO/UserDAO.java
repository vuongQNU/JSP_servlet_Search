package org.example.DAO;

import org.example.model.User;

import java.util.List;

public interface UserDAO {
    User findByUsernameAndPassword(String username, String password);
    List<User> searchUsersByFollow(int minFollowers, int minFollowing);
    void save(User user);
    User findById(Long id);
    List<User> findAll();
    User findByUsername(String username);
}
