package controller;

import model.Ascensor;

public class BajarHilo extends Thread{
    Ascensor ascensor;
    int planta;

    public BajarHilo(Ascensor ascensor, int planta) {
        this.ascensor = ascensor;
        this.planta = planta;
    }

    public void run() {
        if (ascensor.isEnMovimiento()) {
            throw new RuntimeException("El ascensor ya está en movimiento");
        }
        ascensor.setEnMovimiento(true);
        while (ascensor.getPisoActual() > planta && planta >= 0) {
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ascensor.bajar();
            AscensorController.pisoActualField.setText("Piso actual: " + ascensor.getPisoActual());
            System.out.println("Bajando al piso " + ascensor.getPisoActual());
        }
        ascensor.setEnMovimiento(false);
    }
}
