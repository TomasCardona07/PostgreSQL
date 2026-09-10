
import java.sql.Connection;
import java.sql.SQLException;

import config.DataBase;
import controller.ControllerPaciente;
import repository.RepositoryCita;
import repository.RepositoryPaciente;
import services.ServicesPaciente;
import services.ServicesCita;

public class Main {
    
    public static void main(String[] args) {
        try {
            DataBase conexion = new DataBase();
            Connection connection = conexion.conectarDb();
            RepositoryCita repositoryCita = new RepositoryCita(connection);   
            RepositoryPaciente repositoryPaciente = new RepositoryPaciente(connection);
            ServicesPaciente servicesPaciente = new ServicesPaciente(repositoryPaciente);
            ServicesCita servicesCita = new ServicesCita(repositoryCita);

            ControllerPaciente controlador = new ControllerPaciente();
            controlador.flujoPaciente(servicesPaciente,servicesCita);
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }
    /*
    pendiente:
    -validar util: no permitir String en el id
    - añadir funcion: permitir cancelar citas
    -no eliminar un paciente con citas registradas
    */
}
