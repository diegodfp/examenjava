package com.examenjava.gender.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examenjava.common.config.DatabaseConfig;
import com.examenjava.gender.domain.entity.Gender;
import com.examenjava.gender.domain.service.GenderService;

public class GenderRepository  implements GenderService{

    @Override
    public List<Gender> getAllGenders() {
  String sql = "SELECT id, name FROM gender";
        List<Gender> genders = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Gender gender = new Gender();
                gender.setId(resultSet.getInt("id"));
                gender.setName(resultSet.getString("name"));
                genders.add(gender);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genders;
    }

}
