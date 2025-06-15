package ui;

import autenticar.MenuAutenticar;
import data.GesData;
import modelos.Pedido;
import servicios.PedidoServicio;
import utils.Validaciones;

import java.util.Scanner;

public class MenuCocina {
    static Scanner sc = new Scanner(System.in);
    public static PedidoServicio pedidoServicio = new PedidoServicio();
    public static void menuCocina(){
        String inicio = "";
        do {

            System.out.println("===== Menú de COCINERA=====");
            System.out.println("1. Ver Pedidos");
            System.out.println("2. Entregar un Pedido");
            System.out.println("0. Cerrar Sesión");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Ver pedidos");
                            pedidoServicio.listaPedidos();
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Entregar un Pedido");
                            entregarPedido();
                            break;
                        case 0:
                            System.out.println("Cerrar Sesión");
                            MenuAutenticar.menuAuth();
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

    public static void entregarPedido() {
        pedidoServicio.listaPedidos();
        System.out.println("Introduce el id del pedido que quieres entregar:");
        String num = sc.nextLine();
        if (Validaciones.esNum(num)){
            int id_pedido = Integer.parseInt(num);
            for (Pedido p : GesData.listaPedidos) {
                if (p.getId_pedido() == id_pedido) {
                    if (p.getEstado().equals("Entregado")) {
                        System.out.println("El pedido ya fue entregado");
                    } else {
                        p.setEstado("Entregado");
                        System.out.println("Pedido " + id_pedido + " entregado.");
                        pedidoServicio.volcarLista();
                    }
                    return;
                }
            }
            System.out.println("Pedido no encontrado.");
        }else {
            System.out.println("Valor no valido");
        }


    }
}
