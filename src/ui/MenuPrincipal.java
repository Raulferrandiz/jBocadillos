package ui;

import java.util.Scanner;

public class MenuPrincipal {
    static Scanner sc = new Scanner(System.in);
    public static void menu(){
        String inicio = "";
        do {

            System.out.println("===== Menú de Inicio =====");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Bocadillos");
            System.out.println("3. Realizar Pedido");
            System.out.println("4. Consultar Pedidos");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && utils.Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Gestionar Usuarios");

                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Gestionar Bocadillos");
                            break;
                        case 3:
                            System.out.println("Opción seleccionada: Realizar Pedido");

                            break;
                        case 4:
                            System.out.println("Opción seleccionada: Consultar Pedidos");
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
