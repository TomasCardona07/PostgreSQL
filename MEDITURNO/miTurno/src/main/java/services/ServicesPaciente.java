package services;
import java.util.HashMap;

import model.Paciente;
import repository.RepositoryPaciente;

public class ServicesPaciente {
    
    private RepositoryPaciente repositoryPaciente;

    public ServicesPaciente(RepositoryPaciente repositoryPaciente){

        this.repositoryPaciente = repositoryPaciente;
    }

    public Boolean pacienteExistente(Integer id){
        if(repositoryPaciente.verificarId(id) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void registrarPaciente(Integer id,String nombre,String telefono){
        Paciente paciente = new Paciente(id, nombre, telefono);
        repositoryPaciente.registrarPaciente(id, paciente);
    }

    public HashMap<Integer,Paciente> mostrarPacientes(){
        HashMap<Integer,Paciente> pacientes = repositoryPaciente.mostrarPacientes();

        if (pacientes.isEmpty()) {
            return null; //se recomienda lanzar excepción
        }
        return pacientes;
    }

    public Paciente buscarPaciente(Integer id){
        Paciente paciente = repositoryPaciente.buscarPaciente(id);
        if (paciente == null) {
            return null;
        }
        else{
            return paciente;
        }
    }

    public void cambiarTelefonoPaciente(String tel,Paciente paciente){
        try {
            paciente = paciente.cambiarTelefono(tel);
        } catch (NullPointerException e) {
            System.err.println("error " + e.getMessage());
        }
        
        repositoryPaciente.cambiarTelefono(paciente);
    }
    public void eliminarPaciente(Integer id){
        repositoryPaciente.eliminarPaciente(id);
    }
}
