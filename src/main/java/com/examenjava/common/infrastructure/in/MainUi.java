package com.examenjava.common.infrastructure.in;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.examenjava.city.domain.service.CityService;
import com.examenjava.gender.domain.service.GenderService;
import com.examenjava.persons.domain.service.PersonsService;
import com.examenjava.persons.infrastructure.in.RegisterPersonUi;
import com.examenjava.skill.domain.service.SkillService;
import com.examenjava.skill.infrastructure.in.RegistrarSkillUi;

public class MainUi {

    private final PersonsService personsService;
    private final CityService cityService;
    private final GenderService genderService; 
    private final SkillService skillService;

    


    public MainUi(PersonsService personsService, CityService cityService, GenderService genderService,
            SkillService skillService) {
        this.personsService = personsService;
        this.cityService = cityService;
        this.genderService = genderService;
        this.skillService = skillService;
    }

    public void showMainUi() {
        JFrame frame = new JFrame("Control de usuarios por skills");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        // Crear un panel para colocar los componentes
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        JButton registerPersonButton = new JButton("Registrar Persona");
        registerPersonButton.setBounds(50, 30, 200, 25);
        panel.add(registerPersonButton);
            
        JButton asignarSkillButton = new JButton("Asignar Skill a una Persona");
        asignarSkillButton.setBounds(50, 30, 200, 25);
        panel.add(asignarSkillButton);

        JButton registrarSkillButton = new JButton("Crear una nueva  habilidad");
        registrarSkillButton.setBounds(50, 60, 200, 25);
        panel.add(registrarSkillButton);

        JButton consultarButton = new JButton("Consultar Personas por habilidad");
        consultarButton.setBounds(50, 30, 200, 25);
        panel.add(consultarButton);

        JButton updateButton = new JButton("Actualizar informacion de persona");
        updateButton.setBounds(50, 30, 200, 25);
        panel.add(updateButton);

        JButton deleteButton = new JButton("Eliminar a una persona");
        deleteButton.setBounds(50, 30, 200, 25);
        panel.add(deleteButton);

        registerPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                RegisterPersonUi registerPersonUi = new RegisterPersonUi(personsService, cityService, genderService);
                registerPersonUi.showPersonRegisterUi(); 
            }
        });


        registrarSkillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                RegistrarSkillUi registrarSkillUi = new RegistrarSkillUi(skillService);
                registrarSkillUi.showSkillRegisterUi();
            }
        });
    }
}
