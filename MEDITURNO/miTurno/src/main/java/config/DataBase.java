package config;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


public class DataBase {

    private final String url = "jdbc:postgresql://localhost:5432/mediTurno";    
    private final String user = "postgres";
    private final String password = "tomi.cardo";

    public Connection conectarDb() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
    
}
