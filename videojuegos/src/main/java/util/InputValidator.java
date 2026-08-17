package util;
import java.util.*;
import java.math.*;
public class InputValidator {
    Scanner scr = new Scanner(System.in);

    public int menuPrincipal(){
        int descicion = 0;
        do {
            try {
                System.out.println("INGRESE QUE DESEA HACER");
                System.out.println("[1] REGISTRAR VIDEOJUEGO");
                System.out.println("[2] MOSTRAR VIDEOJUEGOS");
                System.out.println("[3] BUSCAR VIDEOJUEGO");
                System.out.println("[4] ACTUALIZAR VIDEOJUEGO");
                System.out.println("[5] ELIMINAR VIDEOJUEGO");
                System.out.println("[6] SALIR");
                descicion = Integer.parseInt(scr.nextLine());
                if (descicion < 1 || descicion > 6) {
                    System.err.println("Numero ingresado no válido");
                }
            } catch (NumberFormatException e) {
                System.err.println("Dato ingresado no válido");
            }
        } while (descicion < 1 || descicion > 6);
        return descicion;
    }

    public BigDecimal validarPrecio(Scanner scr){ //BigDecimal para precios
        BigDecimal precio = BigDecimal.ZERO;
        Boolean precioCorrecto = false;
        do {
            try{
                System.out.println("Ingresa el precio");
                String entrada = scr.nextLine();
                precio = new BigDecimal(entrada);
                if (precio.compareTo(BigDecimal.ZERO) < 0) { //Se compara para que no sea negativo
                    throw new IllegalArgumentException("Numero no valido"); //Lanza excepcion y se para el flujo
                }
                else{
                    precioCorrecto = true;
                }
            }catch(NumberFormatException e){
                System.err.println("Debes ingresar un numero");
            }
            catch(IllegalArgumentException e){ 
                System.err.println("Error: "+e.getMessage()); 
            }
        } while (!precioCorrecto);
        return precio;
    }

    public int validarNegativos(Scanner scr, String mensaje){
        Boolean positivo = false;
        int cantidad = 0;
        do {
            try {
                System.out.println(mensaje);
                cantidad = Integer.parseInt(scr.nextLine());
                if (cantidad >= 0) {
                    positivo = true;
                }
                else{
                    System.err.println("Dato ingresado no valido");
                }
            } catch (NumberFormatException e) {
                System.err.println("Ingresa un numero por favor");
            }
        } while (!positivo);
        return cantidad;
    }
}
