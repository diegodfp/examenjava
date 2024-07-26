package com.examenjava.gender.infrastructure.in;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUi {

    public void showMainUi(){
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
        registrarSkillButton.setBounds(50, 30, 200, 25); 
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

        });
    }
}
