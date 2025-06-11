import autenticar.AuthService;
import autenticar.MenuAutenticar;
import data.GesData;

import javax.xml.transform.SourceLocator;
import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.util.AbstractList;
import java.util.List;
import java.util.Scanner;

import modelos.Administrador;
import modelos.Alumno;
import modelos.Cocina;
import modelos.Usuario;
import servicios.UsuarioServicio;
import ui.MenuAdministrador;
import ui.MenuAlumno;
import ui.MenuCocina;

public class Main {
    static Scanner sc = new Scanner(System.in);
    //static Bocadillo lista_semana[] = new Bocadillo[10];
    public static void main(String[] args) throws IOException {
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        //usuarioServicio.volcarLista();
      //  UsuarioServicio usuarioServicio = new UsuarioServicio();

        // Llamar al método volcarLista() para volcar los usuarios al archivo
        //usuarioServicio.volcarLista();


      /*  try {
            // Llamar al método obtenerUsuarios y obtener la lista de usuarios
            List<Usuario> usuarios = usuarioServicio.obtenerUsuarios();
            System.out.println(usuarios.size());
            // Mostrar los usuarios obtenidos
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getUsuario());  // Imprime el nombre del usuario (o cualquier propiedad)
            }
        } catch (IOException e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        }*/
        //contra: 12345Aa#

        GesData.cargarUsuarios();
        Usuario activo;

        List<Usuario> usuarios = usuarioServicio.obtenerUsuarios();
        System.out.println(usuarios.size());
        for(Usuario u: GesData.listaUsuarios) System.out.println(u.getNombre());

        activo = MenuAutenticar.menuAuth();
        System.out.println("Main"+activo.getNombre());

        if (activo==null){
            System.out.println("NO ESTÁS EN EL SISTEMA");
        } else if (activo instanceof Alumno) {
            MenuAlumno.menu();
        } else if (activo instanceof Administrador) {
            MenuAdministrador.menuAdmin();
        } else if (activo instanceof Cocina) {
            MenuCocina.menuCocina();
        }


/*
        crearBocadillos();


    public static void gestionarUsuarios (){
        String inicio = "";
        do {

            System.out.println("===== Gestionar Usuarios =====");
            System.out.println("1. Mostrar Usuarios");
            System.out.println("2. Añadir Nuevo Usuario");
            System.out.println("0. Volver");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && utils.Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Mostrar usuarios");
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Añadir Nuevo Usuario");

                            break;
                        case 0:
                            System.out.println("Volviendo al menú de Inicio...");
                            return;
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

    public static void gestionarBocadillo(){
        String inicio = "";
        do {

            System.out.println("===== Gestionar Bocadillos =====");
            System.out.println("1. Mostrar Bocadillos Disponibles");
            System.out.println("2. Ver Detalles de un Bocadillos");
            System.out.println("0. Volver");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && utils.Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            Bocadillo.mostrarBocadillosSemana();
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Añadir Nuevo Usuario");

                            break;
                        case 0:
                            System.out.println("Volviendo al menú de Inicio...");
                            return;
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
    public static void crearBocadillos() {
        lista_semana[0] = new Bocadillo(1, "Bocadillo de Jamón", false, new String[]{"Pan", "Jamón"}, new String[]{"Gluten"}, 3.50);
        lista_semana[1] = new Bocadillo(2, "Bocadillo de Pollo", true, new String[]{"Pan", "Pollo"}, new String[]{"Gluten", "Huevo"}, 4.00);
        System.out.println("✅ Bocadillos Creados");
    }

 */


    }
}
