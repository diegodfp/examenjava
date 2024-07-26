package com.examenjava.skill.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examenjava.common.config.DatabaseConfig;
import com.examenjava.skill.domain.entity.Skill;
import com.examenjava.skill.domain.service.SkillService;

public class SkillRepository implements SkillService {

    @Override
    public void createSkill(Skill skill) {
        String sql = "INSERT INTO skill (name) VALUES ( ?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, skill.getName());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    skill.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Skill> getAllSkills() {
 String sql = "SELECT id, name FROM skill";
        List<Skill> skills = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getInt("id"));
                skill.setName(    resultSet.getString("name"));
                skills.add(skill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skills;
    }

}
