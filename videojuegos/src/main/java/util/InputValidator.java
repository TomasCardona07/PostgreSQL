package util;
import java.util.*;
public class InputValidator {
    Scanner scr = new Scanner(System.in);

    public int menuPrincipal(){
        int descicion = 0;
        do {
            try {
                System.out.println("INGRESE QUE DESEA HACER");
                System.out.println("[1] REGISTRAR VIDEOJUEGO");
                System.out.println("[2] MOSTRAR VIDEOJUEGO");
                System.out.println("[3] BUSCAR VIDEOJUEGO");
                System.out.println("[4] ACTUALIZAR VIDEOJUEGO");
                System.out.println("[5] ELIMINAR VIDEOJUEGO");
                System.out.println("[6] SALIR");
                descicion = Integer.parseInt(scr.nextLine());
                if (descicion < 1 || descicion > 6) {
                    System.err.println("Numero ingresado no valido");
                }
            } catch (Exception e) {
                System.err.println("Dato ingresado no valido");
            }
        } while (descicion < 1 || descicion > 6);
        return descicion;
    }
}
