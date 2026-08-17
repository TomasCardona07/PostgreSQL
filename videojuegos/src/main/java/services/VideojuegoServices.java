package services;
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
}
