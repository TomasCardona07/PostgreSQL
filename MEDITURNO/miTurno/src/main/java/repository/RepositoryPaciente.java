package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import model.Paciente;

public class RepositoryPaciente {

    private Connection connection;

    public RepositoryPaciente(Connection connection){
        this.connection = connection;
    }

    HashMap<Integer,Paciente> mapaPacientes = new HashMap<>();


    public Integer verificarId(Integer id){
        String sql = "SELECT * FROM paciente WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
        return null;
    }

    public void registrarPaciente(Integer id,Paciente paciente){
        String sql = "INSERT INTO paciente(id,nombre,telefono) VALUES(?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(1, paciente.nombre());
            statement.setString(3, paciente.telefono());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
        mapaPacientes.put(id, paciente);
    }

    public HashMap<Integer,Paciente> mostrarPacientes(){
        String sql = "SELECT * FROM paciente";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Integer id = result.getInt("id");
                String nombre = result.getString("nombre");
                String telefono = result.getString("telefono");
                Paciente paciente = new Paciente(id, nombre, telefono);
                mapaPacientes.put(id, paciente);
            }
        } catch (SQLException e) {
            System.err.println("Error " +e.getMessage());
        }
        return mapaPacientes;
    }
}

