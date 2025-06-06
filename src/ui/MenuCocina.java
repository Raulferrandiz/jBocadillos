package ui;

import utils.Validaciones;

import java.util.Scanner;

public class MenuCocina {
    static Scanner sc = new Scanner(System.in);
    public static void menuCocina(){
        String inicio = "";
        do {

            System.out.println("===== Menú de COCINERA=====");
            System.out.println("1. VER PEDIDOS");
            System.out.println("2. Gestionar Bocadillos");
            System.out.println("3. Crear Usuario");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Ver pedidos");

                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Gestionar Bocadillos");
                            break;
                        case 3:
                            System.out.println("Opción seleccionada: Crear Usuario");

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
