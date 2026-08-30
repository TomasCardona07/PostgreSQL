package config;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexion {

    private final String url = "jdbc:postgresql://localhost:5432/tienda";
    private final String user = "postgres";
    private final String password = "tomi.cardo";
    
    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
}