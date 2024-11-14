package controller;

import model.Ascensor;
import view.AscensorWindow;

import java.util.Scanner;

public class AscensorController {
    static int pisoActual = 0;
    static int plantas = 20;
    static Ascensor ascensor;
    static AscensorWindow ascensorWindow;

    public AscensorController(int pisoActual, int plantas) {
        AscensorController.pisoActual = pisoActual;
        AscensorController.plantas = plantas;
    }

    public static void crearAscensor() {
        ascensor = new Ascensor(0, 20);
    }

    public static void crearVentana() {
        ascensorWindow = new AscensorWindow();
    }

    public static void subirAscensor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A qué piso quieres subir?");
        SubirHilo subirHilo = new SubirHilo(ascensor, sc.nextInt());
        subirHilo.start();
    }

    public static void bajarAscensor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A qué piso quieres bajar?");
        BajarHilo bajarHilo = new BajarHilo(ascensor, sc.nextInt());
        bajarHilo.start();
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
