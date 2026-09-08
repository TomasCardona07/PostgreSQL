package services;

import java.util.HashMap;

import model.Cita;
import model.Paciente;
import repository.RepositoryCita;

public class ServicesCita {
    private RepositoryCita repositoryCita;

    public ServicesCita(RepositoryCita repositoryCita){
        this.repositoryCita = repositoryCita;
    }


    public Boolean citaExistente(Integer id){
        if(repositoryCita.verificarId(id) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void registarCita(Cita cita){
        repositoryCita.registrarCita(cita);
    }

    public HashMap<Integer,Cita> mostrarCitas(){
        return repositoryCita.mostrarCitas();
    }

    public HashMap<Integer,Cita> citasPaciente(Integer idPaciente,Paciente paciente){
        return repositoryCita.citasPaciente(idPaciente,paciente);
    }
}
