package com.examenjava.city.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examenjava.city.domain.entity.City;
import com.examenjava.city.domain.service.CityService;
import com.examenjava.common.config.DatabaseConfig;

public class CityRepository implements CityService {

    @Override
    public List<City> getAllCities() {
  String sql = "SELECT id, name FROM city";
        List<City> cities = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

}
