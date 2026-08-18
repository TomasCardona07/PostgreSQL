package services;
import java.util.HashMap;
import java.util.Scanner;
import repository.VideojuegoRepository;
import model.Videojuego;
import java.math.*;
import util.*;
public class VideojuegoServices {

    Scanner scr = new Scanner(System.in);
    VideojuegoRepository mapas = new VideojuegoRepository();
    InputValidator validaciones = new InputValidator();


    public void registrarVideojuego(){
        System.out.println("REGISTRAR VIDEOJUEGO:");
        System.out.println("Ingrese el id del juego");
        int id = Integer.parseInt(scr.nextLine());
        if (mapas.obtenerId(id) == null) {
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
        for (Videojuego map : mapa.values()) {
            System.out.println("ID: "+ map.getId());
            System.out.println("NOMBRE: "+ map.getNombre());
            System.out.println("GENERO: "+ map.getGenero());
            System.out.println("PRECIO: "+ map.getPrecio());
            System.out.println("CANTIDAD: "+ map.getCantidad());
            System.out.println("============================");
        }
    }

    public void buscarVideojuego(){
        System.out.println("BUSCAR VIDEOJUEGO:");
        System.out.println("Ingrese el id del videojuego que desea buscar");
        //pendiente: hacer metodo de buscar videojuego
    }
}
