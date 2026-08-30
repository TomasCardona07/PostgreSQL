import util.InputValidator;
import services.*;
import java.sql.Connection;
import config.*;
import repository.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        InputValidator validaciones = new InputValidator();
        VideojuegoServices services = null; //Se declara antes del try porque el try lo oculta del resto del codigo
        //Otra opcion seria las funciones del main adentro de try pero asi no se hace en spring boot

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.conectar();
            VideojuegoRepository repository = new VideojuegoRepository(connection);
            services = new VideojuegoServices(repository);
        } catch (SQLException e) {
            System.err.println("ERROR EN CONECTAR CON BASE DE DATOS");
        }

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
                    services.buscarVideojuego();
                    break;
                case 4:
                    services.actualizarVideojuego();
                    break;
                case 5:
                    services.eliminarVideojuego();
                    break;
                default:
                    System.out.println("GRACIAS POR USAR EL SISTEMA :)");
                    break;
            }
        }
    }
}
