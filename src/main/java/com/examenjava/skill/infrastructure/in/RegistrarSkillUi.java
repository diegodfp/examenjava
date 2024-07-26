package com.examenjava.skill.infrastructure.in;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.examenjava.skill.domain.entity.Skill;
import com.examenjava.skill.domain.service.SkillService;

public class RegistrarSkillUi {
    private final SkillService skillService;

    public RegistrarSkillUi(SkillService skillService) {
        this.skillService = skillService;
    }

    public void showSkillRegisterUi() {
        JFrame frame = new JFrame("Registrar Skill");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        frame.add(panel);

        JLabel nombrLabel = new JLabel("nombre de skill:");
        JTextField nombreField = new JTextField();

        JButton registerButton = new JButton("Registrar");

        panel.add(nombrLabel);
        panel.add(nombreField);

        panel.add(registerButton);

        // Acción del botón registrar
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = nombreField.getText();
                if (skillService.isSkillsExists(nombre)) {
                    JOptionPane.showMessageDialog(frame, "El skill ya está registrado.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //

                Skill skill = new Skill();
                skill.setName(nombre);

                skillService.createSkill(skill);

                JOptionPane.showMessageDialog(frame, "Skill registrado exitosamente");
                frame.dispose();
            }
        });
        frame.setVisible(true);

    }
}
