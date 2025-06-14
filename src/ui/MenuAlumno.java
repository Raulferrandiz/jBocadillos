package ui;

import data.GesData;
import modelos.Bocadillo;
import utils.Validaciones;

import java.util.Scanner;

public class MenuAlumno {
    static Scanner sc = new Scanner(System.in);

    public static void menu(){
        String menuAlumno = "";
        do {

            System.out.println("===== Menú de Alumno =====");
            System.out.println("1. Pedir un Bocadillo");
            System.out.println("2. Ver Listado de Bocadillos");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Añadir Incidencia");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opción:");

            menuAlumno = sc.nextLine();

            if (menuAlumno.length() < 2) {
                if (menuAlumno.length() > 0 && Validaciones.esNum(menuAlumno)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(menuAlumno);
                    switch (ini) {
                        case 1:
                            System.out.println("OPCIÓN SELECCIONADA = Pedir un Bocadillo");
                            pedirBocadillo();
                            break;
                        case 2:
                            System.out.println("OPCIÓN SELECCIONADA = Ver Listado de Bocadillos");

                            break;
                        case 3:
                            System.out.println("OPCIÓN SELECCIONADA = Cancelar Pedido");
                            break;
                        case 4:
                            System.out.println("OPCIÓN SELECCIONADA = Añadir Incidencia");
                        case 0:
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } else if (menuAlumno.length() == 0) {
                    System.out.println("No has ingresado ninguna opción");
                } else {
                    System.out.println("El valor no es númerico, introduce un valor númerico.");
                }
            }

        } while (!menuAlumno.equals("0"));
    }

    public static void pedirBocadillo(){
        for(Bocadillo b: GesData.listaBocadillos) {
            if (b.getDia().equals("Sabado")) {
                System.out.print(b.getNombre() + ", Alergenos: " + b.getAlergenos() + ", Ingredientes: " + b.getIngredientes() + ", Precio: " + b.getPrecio());
                if (b.isEs_caliente()) {
                    System.out.print("Tipo: Caliente, ");
                } else {
                    System.out.println("Tipo: Frío, ");
                }
                System.out.println();
            }
        }
    }
}
