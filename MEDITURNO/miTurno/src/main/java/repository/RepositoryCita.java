package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;

import  model.Cita;
import model.Paciente;

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
        String sql = """
        INSERT INTO cita(id,id_paciente,especialidad,estado,fecha)
         VALUES(?,?,?,?,?)
         """;
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


    public HashMap<Integer,Cita> mostrarCitas(){
        String sql = """
        SELECT cita.id AS id_cita,
            cita.fecha,
            cita.especialidad,
            cita.estado,
            paciente.id AS id_paciente,
            paciente.nombre,
            paciente.telefono
        FROM paciente 
        JOIN cita 
        ON paciente.id = cita.id_paciente;
                """;;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer idPaciente = resultSet.getInt("id_paciente");
                String nombrePac = resultSet.getString("nombre");
                String tel = resultSet.getString("telefono");
                Paciente paciente = new Paciente(idPaciente, nombrePac, tel);

                Integer idCita = resultSet.getInt("id_cita");
                String estado = resultSet.getString("estado");
                String especialidad = resultSet.getString("especialidad");
                String fecha = resultSet.getString("fecha");
                Cita cita = new Cita(idCita, paciente, especialidad, estado, fecha);

                mapaCitas.put(idCita,cita);
            }
            return mapaCitas;

        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
        return null;
    }
}