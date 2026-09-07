package services;

import model.Cita;
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
}
