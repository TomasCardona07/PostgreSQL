package util;
import java.util.Scanner;
public class Util {
    Scanner entrada = new Scanner(System.in);

    public Integer validarMenuPaciente(){
        Integer elegir = null;
        try {
            do {
                System.out.println("Ingrese que desea hacer:");
                System.out.println("[1] REGISTRAR PACIENTE");
                System.out.println("[2] MOSTRAR PACIENTES");
                System.out.println("[3] BUSCAR PACIENTE");
                System.out.println("[4] CAMBIAR TELEFONO DEL PACIENTE");
                System.out.println("[5] ELIMINAR PACIENTE");
                System.out.println("[6] VER MENU DE CITAS");
                System.out.println("[7] SALIR");
                elegir = Integer.parseInt(entrada.nextLine());
                if (elegir > 7 || elegir < 1) {
                    System.out.println("Numero ingresado no valido");
                }
            } while (elegir > 7 || elegir < 1);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero");
        }
        return elegir;
    }

    public Integer validarNegativosInt(String mensaje){
        Integer num = null;
        try {
            do {
                System.out.println(mensaje);
                num = Integer.parseInt(entrada.nextLine());
                if (num < 0) {
                    System.out.println("Numero no valido");
                }
            } while (num < 0);
        } catch (NumberFormatException e) {
            System.err.println("Ingrese un numero por favor");
        }
        return num;
    }
}
