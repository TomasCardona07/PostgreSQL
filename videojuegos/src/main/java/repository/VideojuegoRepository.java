package repository;
import java.util.HashMap;
import java.sql.Connection;
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
        mapa.put(id,videojuego);
    }


    public void eliminarVideojuego(int id){
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
            System.err.println("Error en extraer datos de PostgreSQL");
        }
        return this.mapa;
    }

    public Videojuego obtenerId(int id){
        return mapa.get(id);
    }


    public void cambiarNombre(int id,String nombre){
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
