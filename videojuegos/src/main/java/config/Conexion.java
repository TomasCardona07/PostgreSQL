package config;
import java.sql.Connection; //conexiones de SQL
import java.sql.DriverManager; //driver SQL
import java.sql.SQLException;

public class Conexion{
    private final String url = "jdbc:postgresql://localhost:5432/tienda"; //DIRECCIÓN DE LA BASE DE DATOS DE MANERA LOCAL
    private final String usuario = "postgres"; 
    private final String password = "tomi.cardo";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url,usuario,password);
    }
}
