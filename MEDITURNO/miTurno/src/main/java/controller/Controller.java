package controller;

import util.Util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import config.DataBase;
import repository.RepositoryCita;
import repository.RepositoryPaciente;
import services.Services;
public class Controller {
    Scanner entrada = new Scanner(System.in);
    
    Util util = new Util();
    //pendiente: VERIFICAR E INICIALIZAR SERVICES

    public void flujo(){
        try {
            DataBase conexion = new DataBase();
            Connection connection = conexion.conectarDb();
            RepositoryCita repositoryCita = new RepositoryCita(connection);
            RepositoryPaciente repositoryPaciente = new RepositoryPaciente(connection);
            services = new Services(repositoryCita,repositoryPaciente);
        } catch (SQLException e) {
            System.err.println("Error en conectar a base de datos");
        }

        Integer eleccion = null;
        while (true) {
            eleccion = util.validarMenuPaciente();
            switch (eleccion) {
                case 1:
                    Integer id = util.validarNegativosInt("Ingrese el id del paciente");
                    Boolean pacienteEncontrado = services.pacienteExistente(id);
                    if(!pacienteEncontrado){
                        System.out.println("Ingresa el nombre del paciente");
                        String nombre = entrada.nextLine();
                        System.out.println("Ingresa el telefono del paciente");
                        String telefono = entrada.nextLine();
                        //crear objeto
                    }
                    else{
                        System.err.println("Ya hay un usuario registrado con ese id");
                    }
                    break;
            
                default:
                    break;
            }
        }
    }
}
