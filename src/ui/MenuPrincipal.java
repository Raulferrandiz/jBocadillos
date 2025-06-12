package ui;

import autenticar.AuthService;

import java.util.Scanner;

public class MenuPrincipal {
    static Scanner sc = new Scanner(System.in);
    public static void menuInicio(){
        String inicio = "";
        do {

            System.out.println("===== Menú de Inicio =====");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Recuperar contraseña");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && utils.Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Iniciar Sesión");
                            AuthService.login();
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Recuperar contraseña");
                            break;
                        case 0:
                            System.out.println("Gracias por usar mi programa");
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } else if (inicio.length() == 0) {
                    System.out.println("No has ingresado ninguna opción");
                } else {
                    System.out.println("El valor no es númerico, introduce un valor númerico.");
                }
            }

        } while (!inicio.equals("0"));

    }


}
