package ui;

import data.GesData;
import modelos.Bocadillo;
import modelos.Pedido;
import modelos.Usuario;
import servicios.BocadilloServicio;
import servicios.PedidoServicio;
import utils.Validaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAlumno {
    static Scanner sc = new Scanner(System.in);
    public static BocadilloServicio bocadilloServicio = new BocadilloServicio();
    public static PedidoServicio pedidoServicio = new PedidoServicio();

    public static void menu(Usuario u){
        String menuAlumno = "";
        do {

            System.out.println("===== Menú de Alumno =====");
            System.out.println("1. Pedir un Bocadillo");
            System.out.println("2. Ver Listado de Bocadillos");
            System.out.println("3. Ver Pedidos");
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
                            pedirBocadillo(u);
                            break;
                        case 2:
                            System.out.println("OPCIÓN SELECCIONADA = Ver Listado de Bocadillos");
                            bocadilloServicio.listaBocadilos();
                            break;
                        case 3:
                            System.out.println("OPCIÓN SELECCIONADA = Ver Pedidos");
                            pedidoServicio.listaPedidos();
                            break;
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

    public static void pedirBocadillo(Usuario u) {
        int num = 1;
        int id_pedido = PedidoServicio.autoincrementoPedidoID();
        String id_usuario = u.getUsuario();

        String dia = "Sábado"; // o usar obtenerDiaSemanaActualEnEspanol()
        System.out.println("Hoy es: " + dia);
        System.out.println("==== Bocadillos de Hoy ====");

        List<Bocadillo> disponibles = new ArrayList<>();

        for (Bocadillo b : GesData.listaBocadillos) {
            if (b.getDia().equalsIgnoreCase(dia)) {
                System.out.print(num + ". " + b.getNombre() + ", " + b.getPrecio() + ", Ingredientes: " + b.getIngredientes() + ", Alergenos" + b.getAlergenos());
                if (b.isEs_caliente()) {
                    System.out.print("Tipo: Caliente, ");
                } else {
                    System.out.println("Tipo: Frío, ");
                }
                System.out.println();
                disponibles.add(b);
                num++;
            }
        }



        System.out.print("Elige un Bocadillo: ");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion >= 1 && opcion <= disponibles.size()) {
            Bocadillo elegido = disponibles.get(opcion - 1);
            System.out.println("Seleccionaste: " + elegido.getNombre());
            Pedido p;
            p = new Pedido(id_pedido, id_usuario, elegido.getId(), LocalDate.now(), "Pendiente");
            PedidoServicio pedidoServicio = new PedidoServicio();
            System.out.println("Añadiendo bocadillo a fichero...");
            GesData.listaPedidos.add(p);
            pedidoServicio.volcarLista();
        } else {
            System.out.println("Opción no válida.");
        }
    }

}
