package repository;
import java.util.HashMap;
import java.math.*;
import model.Videojuego;
public class VideojuegoRepository {

    private final HashMap<Integer,Videojuego> mapa = new HashMap<>();

    public void agregarVideojuego(int id, Videojuego videojuego){
        mapa.put(id,videojuego);
    }


    public void eliminarVideojuego(int id){
        mapa.remove(id);
    }


    public HashMap<Integer,Videojuego> retornarVideojuegos(){
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
}
