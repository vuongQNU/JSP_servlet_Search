package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Province;
import org.example.util.DatabaseConnection;

public class ProvinceDAO {
	 private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public List<Province> getAll() {
        List<Province> provinces = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection())
                {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM provinces");
            while (rs.next()) {
                Province province = new Province();
                province.setIdProvince(rs.getInt("idProvince"));
                province.setNameProvince(rs.getString("nameProvince"));
                provinces.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provinces;
    }
}