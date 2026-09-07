package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import  model.Cita;

public class RepositoryCita {

    private Connection connection;
    
    public RepositoryCita(Connection connection){
        this.connection = connection;
    }

    HashMap<Integer,Cita> mapaCitas = new HashMap<>();

    public Integer verificarId(Integer id){
        String sql = "SELECT * FROM cita WHERE id = ?";
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


    public void registrarCita(Cita cita){
        String sql = "INSERT INTO cita(id,id_paciente,especialidad,estado,fecha) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cita.id());
            statement.setInt(2, cita.idPaciente().id());
            statement.setString(3, cita.especialidad());
            statement.setString(4, cita.estado());
            statement.setString(5, cita.fecha());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }
        mapaCitas.put(cita.id(), cita);
    }
}