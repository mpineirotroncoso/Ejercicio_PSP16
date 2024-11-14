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
    static MusicaHilo musicaHilo;

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
        if(!enMovimiento()) {
            reproducirMusica("src/resources/ascensor.wav");
        }

    }

    public static boolean enMovimiento() {
        return ascensor.isEnMovimiento();
    }

    public static void reproducirMusica(String rutaArchivo) {
        if (musicaHilo != null && musicaHilo.isAlive()) {
            musicaHilo.interrupt();
        }
        musicaHilo = new MusicaHilo(rutaArchivo);
        musicaHilo.start();
    }
}
