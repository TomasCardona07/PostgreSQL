package services;
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

}
