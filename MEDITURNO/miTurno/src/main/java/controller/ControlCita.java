package controller;

import java.util.HashMap;
import java.util.Scanner;

import model.Cita;
import model.Paciente;
import services.*;
import util.*;

public class ControlCita {
    Scanner entrada = new Scanner(System.in);
    Util util = new Util();

    public void flujoCita(ServicesCita servicesCita,ServicesPaciente servicesPaciente){

        Integer eleccion = null;
        Boolean ciclo = true;

        while (ciclo) {
            eleccion = util.validarMenuCita();
            switch (eleccion) {
                case 1:
                    Integer idPaciente = util.validarNegativosInt("Ingrese el id del paciente que desea registar la cita");
                    Paciente paciente = servicesPaciente.buscarPaciente(idPaciente);
                    if (paciente != null) {
                        Integer idRegistrarCita = util.validarNegativosInt("Ingrese el id de la cita");
                        Boolean citaExistente = servicesCita.citaExistente(idRegistrarCita);
                        if (!citaExistente) {
                            System.out.println("Ingrese la especialidad");
                            String especialidad = entrada.nextLine();
                            System.out.println("Ingrese la fecha");
                            String fecha = entrada.nextLine();
                            String estado = "PROGRAMADA";
                            Cita cita = new Cita(idRegistrarCita,paciente, especialidad, estado, fecha);
                            servicesCita.registarCita(cita);
                            System.out.println("CITA REGISTRADA");
                        }
                        else{
                            System.err.println("ese id ya existe");
                        }
                    }
                    else{
                        System.err.println("Paciente no existente");
                    }
                    break;
                case 2:
                    HashMap<Integer,Cita> mapaCitas = servicesCita.mostrarCitas();
                    if (mapaCitas != null) {
                        for (Cita cita : mapaCitas.values()) {
                            System.out.println("ID DE LA CITA: " + cita.id());
                            System.out.println("ID PACIENTE: " + cita.idPaciente().id());
                            System.out.println("ESPECIALIDAD: " +cita.especialidad());
                            System.out.println("ESTADO: " + cita.estado());
                            System.out.println("FECHA: " + cita.fecha());
                            System.out.println("--------------------------");
                        }
                    }
                    else{
                        System.err.println("no hay citas registradas");
                    }
                    break;

                case 3:
                    break;
                case 4:
                    break;
                default:
                    ciclo = false;
                    break;
            }
        }


    }
}
