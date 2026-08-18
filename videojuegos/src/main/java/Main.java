import util.InputValidator;
import services.*;
public class Main {
    public static void main(String[] args) {
        InputValidator validaciones = new InputValidator();
        VideojuegoServices services = new VideojuegoServices();
        int descicion = 0;
        while (descicion != 6) {
            descicion = validaciones.menuPrincipal();
            switch (descicion) {
                case 1:
                    services.registrarVideojuego();
                    break;
                case 2:
                    services.mostrarVideojuegos();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("GRACIAS POR USAR EL SISTEMA :)");
                    break;
            }
        }
    }
}
