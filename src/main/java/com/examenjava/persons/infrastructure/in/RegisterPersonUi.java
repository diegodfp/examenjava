package com.examenjava.persons.infrastructure.in;

import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import com.examenjava.city.domain.service.CityService;
import com.examenjava.country.domain.service.CountryService;
import com.examenjava.gender.domain.service.GenderService;
import com.examenjava.persons.domain.service.PersonsService;
import com.examenjava.region.domain.service.RegionService;

public class RegisterPersonUi {
    private final PersonsService personsService;
    private final CityService cityService;
    private final GenderService genderService;

    private Map<String, Integer> cityMap;
    private Map<String, Integer> gendermMap;

    public RegisterPersonUi(PersonsService personsService, CityService cityService, GenderService genderService,
            Map<String, Integer> cityMap, Map<String, Integer> gendermMap) {
        this.personsService = personsService;
        this.cityService = cityService;
        this.genderService = genderService;
        this.cityMap = cityMap;
        this.gendermMap = gendermMap;
    }

    public void showPersonRegisterUi() {
        JFrame frame = new JFrame("Registrar Persona");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        frame.add(panel);

        // Componentes de la interfaz
        JLabel nombrLabel = new JLabel("nombre:");
        JTextField nombreField = new JTextField();

        JLabel capacityLabel = new JLabel("apellido:");
        JTextField capacityField = new JTextField();

        JLabel ciudadLabel = new JLabel("Ciudad:");
        JComboBox<String> ciudadComboBox = new JComboBox<>();

        JLabel edadLabel = new JLabel("edad:");
        JTextField edadField = new JTextField();

        JLabel emailLabel = new JLabel("email:");
        JTextField emailField = new JTextField();

        JLabel generoLabel = new JLabel("Genero:");
        JComboBox<String> generoComboBox = new JComboBox<>();

        JButton registerButton = new JButton("Registrar");

        JButton backButton = new JButton("Regresar");
    }

}
