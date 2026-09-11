package controller;

import util.Util;
import java.util.HashMap;
import java.util.Scanner;
import model.*;
import services.ServicesPaciente;
import services.ServicesCita;
public class ControllerPaciente {
    Scanner entrada = new Scanner(System.in);
    
    Util util = new Util();
    ControlCita cita = new ControlCita();

    public void flujoPaciente(ServicesPaciente servicesPaciente,ServicesCita servicesCita){
        Integer eleccion = null;
        menuPaciente:
        while (true) {
            eleccion = util.validarMenuPaciente();
            switch (eleccion) {
                case 1:
                    Integer id = util.validarNegativosInt("Ingrese el id del paciente");
                    Boolean pacienteEncontrado = servicesPaciente.pacienteExistente(id);
                    if(!pacienteEncontrado){
                        System.out.println("Ingresa el nombre del paciente");
                        String nombre = entrada.nextLine();
                        System.out.println("Ingresa el telefono del paciente");
                        String telefono = entrada.nextLine();
                        servicesPaciente.registrarPaciente(id, nombre, telefono);
                        System.out.println("PACIENTE REGISTRADO");
                    }
                    else{
                        System.err.println("Ya hay un usuario registrado con ese id");
                    }
                    break;
                case 2:
                    HashMap<Integer,Paciente> paciente = servicesPaciente.mostrarPacientes();
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
                    Paciente buscPaciente = servicesPaciente.buscarPaciente(buscarId);
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
                    Paciente pacienteExistente = servicesPaciente.buscarPaciente(idCambiarTelefono);
                    if (pacienteExistente != null) {
                        System.out.println("Ingrese el nuevo telefono del paciente:");
                        String tel = entrada.nextLine();
                        servicesPaciente.cambiarTelefonoPaciente(tel,pacienteExistente); 
                        System.out.println("telefono cambiado con exito");
                    }
                    else{
                        System.err.println("Paciente no existente");
                    }
                    break;
                case 5:
                    Integer idEliminarPaciente = util.validarNegativosInt("Ingrese el id del paciente que desea eliminar");
                    Paciente pacienteEliminar = servicesPaciente.buscarPaciente(idEliminarPaciente);
                    if (pacienteEliminar != null) {
                        HashMap<Integer,Cita> citasPaciente = servicesCita.citasPaciente(idEliminarPaciente, pacienteEliminar);

                        if (citasPaciente.isEmpty()) {
                            servicesPaciente.eliminarPaciente(idEliminarPaciente);
                            System.out.println("PACIENTE ELIMINADO");
                        }
                        else{
                            System.err.println("El paciente tiene citas registradas y no se puede eliminar");
                        }
                    }
                    else{
                        System.err.println("Paciente no encontrado");
                    }
                    break;
                case 6:
                    cita.flujoCita(servicesCita,servicesPaciente);
                    break;
                default:
                    System.out.println("GRACIAS POR USAR EL SISTEMA :)");
                    break menuPaciente;
            }
        }
        entrada.close();
    }
}
