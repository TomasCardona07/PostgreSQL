import util.InputValidator;

public class Main {
    public static void main(String[] args) {
        InputValidator validaciones = new InputValidator();
        int descicion = 0;
        while (descicion != 6) {
            descicion = validaciones.menuPrincipal();
            switch (descicion) {
                case 1:
                    break;
                case 2:
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
