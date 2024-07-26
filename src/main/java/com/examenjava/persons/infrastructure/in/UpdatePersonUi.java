package com.examenjava.persons.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.examenjava.city.domain.entity.City;
import com.examenjava.city.domain.service.CityService;
import com.examenjava.gender.domain.entity.Gender;
import com.examenjava.gender.domain.service.GenderService;
import com.examenjava.persons.domain.entity.Persons;
import com.examenjava.persons.domain.service.PersonsService;

public class UpdatePersonUi {
     private final PersonsService personsService;
    private final CityService cityService;
    private final GenderService genderService;

    private Map<String, Integer> cityMap;
    private Map<String, Integer> gendermMap;

    public UpdatePersonUi (PersonsService personsService, CityService cityService, GenderService genderService) {
        this.personsService = personsService;
        this.cityService = cityService;
        this.genderService = genderService;

        this.cityMap = new HashMap<>();
        this.gendermMap = new HashMap<>();
    }

    public void showPersonUpdateUi() {
        JFrame frame = new JFrame("Actualizar Persona");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
        frame.add(panel);

        JLabel idLabel = new JLabel("id de la persona:");
        JTextField idField = new JTextField();

        JLabel nombrLabel = new JLabel("nombre:");
        JTextField nombreField = new JTextField();

        JLabel apellidoLabel = new JLabel("apellido:");
        JTextField apellidoField = new JTextField();

        JLabel ciudadLabel = new JLabel("Ciudad:");
        JComboBox<String> ciudadComboBox = new JComboBox<>();

        JLabel direccionLabel = new JLabel("direccion:");
        JTextField direccionField = new JTextField();

        JLabel edadLabel = new JLabel("edad:");
        JTextField edadField = new JTextField();

        JLabel emailLabel = new JLabel("email:");
        JTextField emailField = new JTextField();

        JLabel generoLabel = new JLabel("Genero:");
        JComboBox<String> generoComboBox = new JComboBox<>();

        JButton registerButton = new JButton("Actualizar");

        JButton backButton = new JButton("Regresar");


        List<City> cities = cityService.getAllCities();
        for (City city : cities) {
            ciudadComboBox.addItem(city.getName());
            cityMap.put(city.getName(), city.getId());
        }

        List<Gender> genders = genderService.getAllGenders();
        for (Gender gender : genders) {
            generoComboBox.addItem(gender.getName());
            gendermMap.put(gender.getName(), gender.getId());
        }

        panel.add(idLabel);
        panel.add(idField);

        panel.add(nombrLabel);
        panel.add(nombreField);

        panel.add(apellidoLabel);
        panel.add(apellidoField);

        panel.add(ciudadLabel);
        panel.add(ciudadComboBox);

        panel.add(direccionLabel);
        panel.add(direccionField);

        panel.add(edadLabel);
        panel.add(edadField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(generoLabel);
        panel.add(generoComboBox);

        panel.add(registerButton);
        panel.add(backButton);

         // Acción del botón registrar
         registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id =  Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int idCiudad = cityMap.get((String) ciudadComboBox.getSelectedItem());
                String direccion = direccionField.getText();
                int edad =  Integer.parseInt(edadField.getText());
                String email = emailField.getText();
                int idGender = gendermMap.get((String) generoComboBox.getSelectedItem());


                Persons person = new Persons();
                person.setName(nombre);
                person.setLastname(apellido);
                person.setIdcity(idCiudad);
                person.setAddress(direccion);
                person.setAge(edad);
                person.setEmail(email);
                person.setIdgender(idGender);



                personsService.updatePersons(person, id);

                JOptionPane.showMessageDialog(frame, "Persona actualizada exitosamente");
                frame.dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        frame.setVisible(true);
    }
}
