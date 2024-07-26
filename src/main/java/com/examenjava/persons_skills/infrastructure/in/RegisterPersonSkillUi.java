package com.examenjava.persons_skills.infrastructure.in;

import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.sql.Date;

import com.examenjava.persons.domain.entity.Persons;
import com.examenjava.persons.domain.service.PersonsService;
import com.examenjava.persons_skills.domain.entity.Persons_skills;
import com.examenjava.persons_skills.domain.service.Persons_skillsService;
import com.examenjava.skill.domain.entity.Skill;
import com.examenjava.skill.domain.service.SkillService;
import com.toedter.calendar.JDateChooser;

public class RegisterPersonSkillUi {
    private final PersonsService personsService;
    private final Persons_skillsService persons_skillsService;
    private final SkillService skillService;

    private Map<String, Integer> personMap;
    private Map<String, Integer> skillMap;

    public RegisterPersonSkillUi(PersonsService personsService, Persons_skillsService persons_skillsService,
            SkillService skillService) {
        this.personsService = personsService;
        this.persons_skillsService = persons_skillsService;
        this.skillService = skillService;

        this.personMap = new HashMap<>();
        this.skillMap = new HashMap<>();
    }

    public void showPersonSkillsUi() {
        JFrame frame = new JFrame("Registrar Persona");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        frame.add(panel);

        JLabel fechaLabel = new JLabel("Fecha de Registro(formato AAAA-MM-DD):");
        JDateChooser fabricationDateChooser = new JDateChooser();;
        fabricationDateChooser.setDateFormatString("yyyy-MM-dd");


        JLabel personLabel = new JLabel("Nombre de la persona:");
        JComboBox<String> personComboBox = new JComboBox<>();

        JLabel skillLabel = new JLabel("Skill a agregar:");
        JComboBox<String> skillComboBox = new JComboBox<>();

        JButton registerButton = new JButton("Registrar");
        JButton backButton = new JButton("Regresar");
        List<Persons> persons = personsService.getAllPersons();
        for (Persons person : persons) {
            personComboBox.addItem(person.getName() );
            personMap.put(person.getName(), person.getId());
        }

        List<Skill> skills = skillService.getAllSkills();
        for (Skill skill : skills) {
            skillComboBox.addItem(skill.getName());
            skillMap.put(skill.getName(), skill.getId());
        }

        panel.add(fechaLabel);
        panel.add(fabricationDateChooser);

        panel.add(personLabel);
        panel.add(personComboBox);

        panel.add(skillLabel);
        panel.add(skillComboBox);

        panel.add(registerButton);
        panel.add(backButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date registroDate = fabricationDateChooser.getDate();
                java.sql.Date registration_date = new java.sql.Date(registroDate.getTime());
                int idperson = personMap.get((String) personComboBox.getSelectedItem());
                int idskill = skillMap.get((String) skillComboBox.getSelectedItem());


                Persons_skills persons_skills = new Persons_skills();
                persons_skills.setRegistration_date(registration_date);
                persons_skills.setIdperson(idperson);
                persons_skills.setIdskill(idskill);

                persons_skillsService.createPersons_skills(persons_skills);

                JOptionPane.showMessageDialog(frame, "Persona registrada exitosamente");
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
