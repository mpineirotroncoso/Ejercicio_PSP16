package view;

import controller.AscensorController;

import javax.swing.*;

public class BotonAscensor extends JButton {
    public BotonAscensor(String text) {
        super(text);
        setSize(200, 50);
        addActionListener(e -> {
            AscensorController.seleccionarPlanta(Integer.parseInt(text));
        });

    }
}
