package services;
import java.util.HashMap;

import model.Paciente;
import repository.RepositoryCita;
import repository.RepositoryPaciente;

public class Services {
    
    private RepositoryCita repositoryCita;
    private RepositoryPaciente repositoryPaciente;

    public Services(RepositoryCita repositoryCita,RepositoryPaciente repositoryPaciente){
        this.repositoryCita = repositoryCita;
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
}
