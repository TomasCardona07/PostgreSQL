package controller;

import util.Util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import config.DataBase;
import model.Paciente;
import repository.RepositoryCita;
import repository.RepositoryPaciente;
import services.Services;
public class Controller {
    Scanner entrada = new Scanner(System.in);
    
    Util util = new Util();


    //Todo esta adentro del try para evitar inicializar services como NULL
    public void flujo(){
        try {
            //IDEA PENDIENTE: Poner la conexion en el main
            DataBase conexion = new DataBase();
            Connection connection = conexion.conectarDb();
            RepositoryCita repositoryCita = new RepositoryCita(connection);   
            RepositoryPaciente repositoryPaciente = new RepositoryPaciente(connection);
            Services services = new Services(repositoryCita,repositoryPaciente);

            Integer eleccion = null;
            menuPaciente:
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
                            services.registrarPaciente(id, nombre, telefono);
                            System.out.println("PACIENTE REGISTRADO");
                        }
                        else{
                            System.err.println("Ya hay un usuario registrado con ese id");
                        }
                        break;
                    case 2:
                        HashMap<Integer,Paciente> paciente = services.mostrarPacientes();
                        if (paciente != null) {
                            for (Paciente p : paciente.values()) {
                                System.out.println("ID: " + p.id());
                                System.out.println("NOMBRE: " + p.nombre());
                                System.out.println("TELEFONO: " + p.telefono());
                                System.out.println("-----------------------");
                            }
                        }
                        else{
                            System.err.println("No hay pacientes registrados");
                        }
                        break;
                    case 3:
                        Integer buscarId = util.validarNegativosInt("Ingrese el id del usuario que desea buscar");
                        Paciente buscPaciente = services.buscarPaciente(buscarId);
                        if (buscPaciente != null) {
                            System.out.println("PACIENTE ENCONTRADO");
                            System.out.println("ID: " + buscPaciente.id());
                            System.out.println("NOMBRE: " + buscPaciente.nombre());
                            System.out.println("TELEFONO: " + buscPaciente.telefono());
                        }
                        else{
                            System.out.println("NO EXISTE UN PACIENTE REGISTRADO CON ESE ID");
                        }
                        break;
                    case 4:
                        Integer idCambiarTelefono = util.validarNegativosInt("Ingrese el id del usuario que desea buscar");
                        Paciente pacienteExistente = services.buscarPaciente(idCambiarTelefono);
                        if (pacienteExistente != null) {
                            System.out.println("Ingrese el nuevo telefono del paciente:");
                            String tel = entrada.nextLine();
                            services.cambiarTelefonoPaciente(tel,pacienteExistente); 
                            System.out.println("telefono cambiado con exito");
                        }
                        else{
                            System.err.println("Paciente no existente");
                        }
                        break;
                    default:
                        System.out.println("GRACIAS POR USAR EL SISTEMA :)");
                        break menuPaciente;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en conectar a base de datos" + e.getMessage());
        }
    }
}
