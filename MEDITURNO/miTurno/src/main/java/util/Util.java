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
                System.out.println("[3] BUSCAR PACICIENTE");
                System.out.println("[4] CAMBIAR TELEFONO DEL PACIENTE");
                System.out.println("[5] ELIMINAR PAPACIENTE");
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
        Integer num = -1;
        do {
            try {
                System.out.println(mensaje);
                num = Integer.parseInt(entrada.nextLine());
                if (num < 0) {
                    System.out.println("Numero no valido");
                }
        
            } catch (NumberFormatException e) {
                System.err.println("Ingrese un numero");
            }
        } while (num < 0);
        return num;
    }

    public Integer validarMenuCita(){
        Integer elegir = null;
        try {
            do {
                System.out.println("Ingrese que desea hacer:");
                System.out.println("[1] REGISTRAR CITA");
                System.out.println("[2] MOSTRAR CITAS");
                System.out.println("[3] BUSCAR CITAS DEL PACIENTE");
                System.out.println("[4] CANCELAR CITA");
                System.out.println("[5] REGRESAR");
                elegir = Integer.parseInt(entrada.nextLine());
                if (elegir > 5 || elegir < 1) {
                    System.out.println("Numero ingresado no valido");
                }
            } while (elegir > 5 || elegir < 1);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero");
        }
        return elegir;
    }
}
