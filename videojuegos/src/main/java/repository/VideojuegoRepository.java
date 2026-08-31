package repository;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.math.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Videojuego;
public class VideojuegoRepository {

    private Connection connection;

    public VideojuegoRepository(Connection connection){
        this.connection = connection;
    }

    private final HashMap<Integer,Videojuego> mapa = new HashMap<>();

    public void agregarVideojuego(int id, Videojuego videojuego){
        String sql = """
                INSERT INTO videojuegos(id,nombre,genero,precio,cantidad)
                VALUES(?,?,?,?,?)
                """;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2, videojuego.getNombre());
            statement.setString(3, videojuego.getGenero());
            statement.setBigDecimal(4, videojuego.getPrecio());
            statement.setInt(5, videojuego.getCantidad());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERROR AL AGREGAR VIDEOJUEGO");
        }
        mapa.put(id,videojuego);
    }


    public void eliminarVideojuego(int id){
        String sql = "DELETE FROM videojuegos WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERROR AL ELIMINAR VIDEOJUEGO");
        }
        mapa.remove(id);
    }


    public HashMap<Integer,Videojuego> retornarVideojuegos(){
        String sql = "SELECT * FROM videojuegos";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                String genero = result.getString("genero");
                BigDecimal precio = result.getBigDecimal("precio");
                int cantidad = result.getInt("cantidad");
                Videojuego videojuego = new Videojuego(id, nombre, genero, precio, cantidad);
                mapa.put(id, videojuego);
            }
        } catch (SQLException e) {
            System.err.println("ERROR AL RETORNAR VIDEOJUEGOS"+e.getMessage());
        }
        return this.mapa;
    }

    public Integer juegoExistente(int id){
        String sql = "SELECT * FROM videojuegos WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("ERROR EN OBTENER ID" + e.getMessage());
        }
        return null;
    }

    public Videojuego obtenerVideojuego(int id){
        String sql = "SELECT * FROM videojuegos WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String nombre = result.getString("nombre");
                String genero = result.getString("genero");
                BigDecimal precio = result.getBigDecimal("precio");
                int cantidad = result.getInt("cantidad");
                Videojuego videojuego = new Videojuego(id, nombre, genero, precio, cantidad);
                return videojuego;
            }
        } catch (SQLException e) {
            System.err.println("ERROR EN OBTENER VIDEOJUEGO " + e.getMessage());
        }
        return null;
    }


    public void cambiarNombre(int id,String nombre){
        String sql = """
                UPDATE videojuegos
                SET nombre = ?
                WHERE id = ?
                """;;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setInt(2, id);
            statement.executeUpdate();//PARA INSERT, UPDATE Y DELETE
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
        Videojuego videojuego = mapa.get(id);
        videojuego.setNombre(nombre);
    }


    public void cambiarGenero(int id,String genero){
        Videojuego videojuego = mapa.get(id);
       videojuego.setGenero(genero);
    }


    public void cambiarPrecio(int id,BigDecimal precio){
        Videojuego videojuego = mapa.get(id);
        videojuego.setPrecio(precio);
    }

    public void cambiarCantidad(int id,int cantidad){
        Videojuego videojuego = mapa.get(id);
        videojuego.setCantidad(cantidad);
    }

    public Boolean mapaVacio(HashMap<?,?> map){
        return this.mapa.isEmpty();
    }
}
