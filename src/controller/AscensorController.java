package controller;

import model.Ascensor;

import java.util.Scanner;

public class AscensorController {
    static int pisoActual = 0;
    static int plantas = 20;
    static Ascensor ascensor = new Ascensor(pisoActual, plantas);

    public AscensorController(int pisoActual, int plantas) {
        AscensorController.pisoActual = pisoActual;
        AscensorController.plantas = plantas;
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
}
