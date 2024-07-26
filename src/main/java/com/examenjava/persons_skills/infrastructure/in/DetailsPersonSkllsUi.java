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

    private Map<String, Integer> skillMap;
    private Map<String, Integer> persoMap;

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


        List<Skill> skills = skillService.getAllSkills();
        for (Skill skill : skills) {
            skillComboBox.addItem(skill.getName());
            skillMap.put(skill.getName(), skill.getId());
        }
        
    }
}
