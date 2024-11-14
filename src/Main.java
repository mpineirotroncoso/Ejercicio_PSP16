import controller.AscensorController;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("Ascensor", 50);
        menu.addEntrada("Subir");
        menu.addEntrada("Bajar");

        AscensorController.crearAscensor();
        AscensorController.crearVentana();

        while (true) {
            int opcion = menu.generarMenu();

            switch (opcion) {
                case 1:
                    AscensorController.subirAscensor();
                    break;
                case 2:
                    AscensorController.bajarAscensor();
                    break;
            }
        }
    }
}