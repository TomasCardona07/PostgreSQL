package services;
import java.util.HashMap;
import java.util.Scanner;
import repository.VideojuegoRepository;
import model.Videojuego;
import java.math.*;
import util.*;
public class VideojuegoServices {

    Scanner scr = new Scanner(System.in);

    private VideojuegoRepository mapas;

    public VideojuegoServices(VideojuegoRepository repository){
        this.mapas = repository;
    }

    InputValidator validaciones = new InputValidator();

    public void registrarVideojuego(){
        System.out.println("REGISTRAR VIDEOJUEGO:");
        int id = validaciones.validarNegativos(scr, "Ingrese el id del videojuego");
        if (mapas.juegoExistente(id) == null) {
            System.out.println("Ingrese el nombre del videojuego");
            String nombre = scr.nextLine();
            System.out.println("Ingrese el genero del videojuego");
            String genero = scr.nextLine();
            BigDecimal precio = validaciones.validarPrecio(scr);
            int cantidad = validaciones.validarNegativos(scr, "Ingrese la cantidad");
            Videojuego videojuego = new Videojuego(id, nombre, genero, precio, cantidad);
            mapas.agregarVideojuego(id, videojuego);
        }
        else{
            System.err.println("ID ya existente");
        }
    }

    public void mostrarVideojuegos(){
        System.out.println("VIDEOJUEGOS REGISTRADOS:");
        HashMap<Integer,Videojuego> mapa = mapas.retornarVideojuegos();
        if(!mapas.mapaVacio(mapa)){
            for (Videojuego map : mapa.values()) {
            System.out.println("ID: "+ map.getId());
            System.out.println("NOMBRE: "+ map.getNombre());
            System.out.println("GENERO: "+ map.getGenero());
            System.out.println("PRECIO: "+ map.getPrecio());
            System.out.println("CANTIDAD: "+ map.getCantidad());
            System.out.println("============================");
            }
        }
        else{
            System.err.println("NO HAY VIDEOJUEGOS REGISTRADOS");
        }
    }

    public void buscarVideojuego(){
        System.out.println("BUSCAR VIDEOJUEGO:");
        int id = validaciones.validarNegativos(scr, "Ingrese el id del videojuego que desea buscar");
        Videojuego videojuego = mapas.obtenerVideojuego(id);
        if (videojuego != null) {
            System.out.println("ID: "+ videojuego.getId());
            System.out.println("NOMBRE: "+ videojuego.getNombre());
            System.out.println("GENERO: "+ videojuego.getGenero());
            System.out.println("PRECIO: "+ videojuego.getPrecio());
            System.out.println("CANTIDAD: "+ videojuego.getCantidad());
        } else {
            System.err.println("Videojuego no encontrado");
        }
    }

    public void actualizarVideojuego(){
        int id = validaciones.validarNegativos(scr, "Ingrese el id del videojuego que desea modificar");
        Integer videojuego = mapas.juegoExistente(id);
        if (videojuego != null) {
            System.out.println("VIDEOJUEGO ENCONTRADO");
            System.out.println("Ingrese el nuevo nombre del juego");
            String nombre = scr.nextLine();
            mapas.cambiarNombre(id, nombre);
            System.out.println("Ingrese el nuevo genero del videojuego");
            String genero = scr.nextLine();
            BigDecimal precio = validaciones.validarPrecio(scr);
            Videojuego videoJuegoCambiado = new Videojuego(id, nombre, genero, precio, id);
            mapas.agregarVideojuego(id, videoJuegoCambiado);
        }
        else{
            System.err.println("Videojuego no encontrado");
        }
    }

    public void eliminarVideojuego(){
        int id = validaciones.validarNegativos(scr,"Ingrese el id del videojuego que desea eliminar");
        if(mapas.juegoExistente(id) != null){
            mapas.eliminarVideojuego(id);
            System.out.println("VIDEOJUEGO ELIMINADO");
        }
        else{
            System.err.println("VIDEOJUEGO NO ENCONTRADO");
        }
    }
}
