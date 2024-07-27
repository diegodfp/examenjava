package com.examenjava.persons_skills.infrastructure.in;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.examenjava.persons.domain.entity.Persons;
import com.examenjava.persons.domain.service.PersonsService;
import com.examenjava.skill.domain.entity.Skill;
import com.examenjava.skill.domain.service.SkillService;

public class DetailsPersonSkllsUi {
    private final PersonsService personsService;
    private final SkillService skillService;

    private Map<Integer, Skill> skillMap;
    private Map< Integer, Persons> persoMap;

    public DetailsPersonSkllsUi(PersonsService personsService, SkillService skillService) {
        this.personsService = personsService;
        this.skillService = skillService;
        this.skillMap = new HashMap<>();
    }

    public void ShowDetailsPersonsSkillsUi() {
        JFrame frame = new JFrame("Buscar Persona por Skill");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        frame.add(panel);

        JLabel skillLabel = new JLabel("Seleccione un Skill para buscar las personas");
        JComboBox<String> skillComboBox = new JComboBox<>();

        JLabel personLabel = new JLabel("Estos son las personas que tienen esa skill");
        JComboBox<String> personComboBox = new JComboBox<>();



        panel.add(skillLabel);
        panel.add(skillComboBox);

        panel.add(personLabel);
        panel.add(personComboBox);

        skillComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSkill = (String) skillComboBox.getSelectedItem();
                Skill selectedPlane = skillMap.get(selectedSkill);

                if (selectedPlane != null) {
                    // originalPlates = selectedPlane.getPlates();
                    // platesField.setText(selectedPlane.getPlates());
                    // capacityField.setText(String.valueOf(selectedPlane.getCapacity()));
                    // fabricationDateChooser.setDate(selectedPlane.getFabricationDate());
                    // statusComboBox.setSelectedItem(getKeyByValue(statusMap, selectedPlane.getIdStatus()));
                    // modelComboBox.setSelectedItem(getKeyByValue(modelMap, selectedPlane.getIdModel()));
                    // airlineComboBox.setSelectedItem(getKeyByValue(airlineMap, selectedPlane.getIdAerolinea()));
                }
            }
        });

    }
}
