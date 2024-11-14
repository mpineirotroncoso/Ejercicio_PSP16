import controller.AscensorController;

public class Main {
    public static void main(String[] args) {
        AscensorController ascensorController = new AscensorController(0, 20);
        Menu menu = new Menu("Ascensor", 50);
        menu.addEntrada("Subir");
        menu.addEntrada("Bajar");
        while (true) {
            int opcion = menu.generarMenu();

            switch (opcion) {
                case 1:
                    ascensorController.subirAscensor();
                    break;
                case 2:
                    ascensorController.bajarAscensor();
                    break;
            }
        }
    }
}