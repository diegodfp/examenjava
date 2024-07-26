package com.examenjava.persons.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examenjava.persons.domain.entity.Persons;
import com.examenjava.persons.domain.service.PersonsService;
import com.examenjava.common.config.DatabaseConfig;
import com.examenjava.gender.domain.entity.Gender;
public class PersonsRepository implements PersonsService {
     @Override
    public void createPersons(Persons persons) {
        String sql = "INSERT INTO persons (name, lastname, idcity, addres, age, email, idgender) VALUES ( ?, ?, ? , ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {              
            statement.setString(1, persons.getName());
            statement.setString(2, persons.getLastname());
            statement.setInt(3, persons.getIdcity()); 
            statement.setString(4, persons.getAddress());
            statement.setInt(5, persons.getAge());
            statement.setString(6, persons.getEmail());
            statement.setInt(7, persons.getIdgender());
            
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    persons.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persons findPersonsById(int id) {
        String sql = "SELECT id,name, lastname, idcity, addres, age, email, idgender FROM persons WHERE id = ?";
        Persons persons = null;

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    persons = new Persons();
                    persons.setId(resultSet.getInt("id"));
                    persons.setName(resultSet.getString("name"));
                    persons.setLastname(resultSet.getString("lastname"));
                    persons.setIdcity(resultSet.getInt("idcity"));
                    persons.setAddress(resultSet.getString("addres"));
                    persons.setAge(resultSet.getInt("age"));
                    persons.setEmail(resultSet.getString("email"));
                    persons.setIdgender(resultSet.getInt("idgender"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public void updatePersons(Persons persons, int id) {
        String sql = "UPDATE persons SET  name = ?, lastname = ?, idcity = ?, addres = ?, age = ? ,  email = ?, idgender = ? WHERE id = ?";
        System.out.println(persons.getId());
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {              
            statement.setString(1, persons.getName());
            statement.setString(2, persons.getLastname());
            statement.setInt(3, persons.getIdcity()); 
            statement.setString(4, persons.getAddress());
            statement.setInt(5, persons.getAge());
            statement.setString(6, persons.getEmail());
            statement.setInt(7, persons.getIdgender());
            statement.setInt(8, id);  
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deletePersons(int id) {
        String query = "DELETE FROM persons WHERE id = ?";
        try  (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persons> getAllPersons() {
  String sql = "SELECT id, name FROM persons";
        List<Persons> persons = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Persons person = new Persons();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));;
                persons.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }
}
