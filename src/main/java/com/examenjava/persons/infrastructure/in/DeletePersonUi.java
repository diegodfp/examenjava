package com.examenjava.persons.infrastructure.in;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.examenjava.persons.domain.service.PersonsService;

public class DeletePersonUi {
    private final PersonsService personsService ;

    public DeletePersonUi(PersonsService personsService) {
        this.personsService = personsService;
    }
    
    public void showPersonDeleteUi(){
        JFrame frame = new JFrame("Eliminar Avión");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        frame.add(panel);

        JLabel idLabel = new JLabel("id de la persona:");
        JTextField idField = new JTextField();

        JButton deleteButton = new JButton("Eliminar");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id =  Integer.parseInt(idField.getText());

                    int confirm = JOptionPane.showConfirmDialog(frame, "¿Está seguro de que desea eliminar el registro ?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        personsService.deletePersons(id);
                        JOptionPane.showMessageDialog(frame, "Registro eliminado correctamente");
                        frame.dispose();
                    }
            }
        });

        frame.setVisible(true);
    }
}
