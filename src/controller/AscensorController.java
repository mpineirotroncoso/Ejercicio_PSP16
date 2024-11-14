package controller;

import model.Ascensor;
import view.AscensorWindow;
import view.PisoActualField;

public class AscensorController {
    static int pisoActual = 0;
    static int plantas = 20;
    static Ascensor ascensor;
    static AscensorWindow ascensorWindow;
    static PisoActualField pisoActualField; // textfield superior de la ventana

    public AscensorController(int pisoActual, int plantas) {
        AscensorController.pisoActual = pisoActual;
        AscensorController.plantas = plantas;
    }

    public static void crearAscensor() {
        ascensor = new Ascensor(pisoActual, plantas);
    }

    public static void crearWindow() {
        pisoActualField = new PisoActualField("Piso actual: " + pisoActual);
        ascensorWindow = new AscensorWindow(pisoActualField);
    }

    public static void seleccionarPlanta(int planta) {
        if (planta > ascensor.getPisoActual()) {
            SubirHilo subirHilo = new SubirHilo(ascensor, planta);
            subirHilo.start();
        } else {
            BajarHilo bajarHilo = new BajarHilo(ascensor, planta);
            bajarHilo.start();
        }
    }
}
