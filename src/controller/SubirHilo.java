package controller;

import model.Ascensor;

public class SubirHilo extends Thread {
    Ascensor ascensor;
    int planta;

    public SubirHilo(Ascensor ascensor, int planta) {
        this.ascensor = ascensor;
        this.planta = planta;
    }

    public void run() {
        if (ascensor.isEnMovimiento()) {
            throw new RuntimeException("El ascensor ya está en movimiento");
        }
        ascensor.setEnMovimiento(true);
        while (ascensor.getPisoActual() < planta && planta <= ascensor.getPlantas()) {
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ascensor.subir();
            System.out.println("Subiendo al piso " + ascensor.getPisoActual());
        }
        ascensor.setEnMovimiento(false);
    }
}
