package com.examenjava.persons_skills.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.examenjava.common.config.DatabaseConfig;
import com.examenjava.persons_skills.domain.entity.Persons_skills;
import com.examenjava.persons_skills.domain.service.Persons_skillsService;

public class Persons_skillRepository implements Persons_skillsService{

    @Override
    public void createPersons_skills(Persons_skills persons_skills) {
        String sql = "INSERT INTO persons_skill (registration_date, idperson, idskill) VALUES ( ?, ? , ?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, persons_skills.getRegistration_date());
            statement.setInt(2, persons_skills.getIdperson());
            statement.setInt(3, persons_skills.getIdskill());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    persons_skills.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
