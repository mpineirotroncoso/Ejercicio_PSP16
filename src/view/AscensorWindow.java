package view;

import javax.swing.*;
import java.awt.*;

public class AscensorWindow extends JFrame {
    public AscensorWindow(PisoActualField pisoActualField) {

        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(new BorderLayout());
        panelNorte.add(pisoActualField);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(7, 3));
        for (int i = 0; i < 21; i++) {
            panelCentral.add(new BotonAscensor(String.valueOf(i)));
        }
        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral);
        setTitle("Ascensor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
