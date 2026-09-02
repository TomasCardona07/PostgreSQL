package repository;

import java.sql.Connection;

public class RepositoryCita {

    private Connection connection;
    
    public RepositoryCita(Connection connection){
        this.connection = connection;
    }
}