package ui;

import autenticar.AuthService;
import data.GesData;
import modelos.*;
import servicios.BocadilloServicio;
import servicios.UsuarioServicio;
import utils.Validaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAdministrador {
    static Scanner sc = new Scanner(System.in);
    public static void menuAdmin(){
        String inicio = "";
        do {

            System.out.println("===== Menú de ADMINISTRADOR =====");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Bocadillos");
            System.out.println("3. Crear Usuario");
            System.out.println("0. Cerrar Sesión");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Gestionar Usuarios");
                            gestionarUsuarios();
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Gestionar Bocadillos");
                            gestionarBocadillos();
                            break;
                        case 3:
                            System.out.println("Opción seleccionada: Crear Usuario");
                            crearUsuario();
                            break;
                        case 0:
                            System.out.println("Gracias por usar mi programa");
                            System.out.println("Saliendo...");
                            AuthService.login();
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

    public static void gestionarUsuarios(){
        String inicio = "";
        do {

            System.out.println("===== Gestion de Usuarios =====");
            System.out.println("1. Crear Usuarios");
            System.out.println("2. Buscar Usuario");
            System.out.println("3. Ver todos los Usuarios");
            System.out.println("4. Eliminar un Usuario");
            System.out.println("0. Volver al Menú de Administrador");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Crear Usuarios");
                            crearUsuario();
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Gestionar Bocadillos");
                            break;
                        case 3:
                            System.out.println("Opción seleccionada: Crear Usuario");
                            crearUsuario();
                            break;
                        case 4:
                            System.out.println("Opción seleccionada: Crear Usuario");

                            break;
                        case 0:
                            System.out.println("Volviendo ...");
                            menuAdmin();
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

    public static void crearUsuario(){
        Usuario nuevo = null;
        String usuario;
        String nombre;
        String apellidos;
        String email;
        String password;
        String password2;
        LocalDate fecha_nacimiento = null;
        String rolm ="";
        String alergiasm = "";
        List<String> alergias = new ArrayList<>();
        String cursom = "";
        String curso = "";
        String num_expediente = "";

        System.out.println("==== Registro de Usuario ====");

        //Usuario
        do {
            System.out.println("Ingrese el nombre de usuario:");
            usuario = sc.nextLine();
        }while (!Validaciones.valNombre(usuario));

        // Nombre
        do {
            System.out.println("Ingrese el nombre:");
            nombre = sc.nextLine();
        } while (!Validaciones.valNombre(nombre));

        // Apellido
        do {
            System.out.println("Ingrese sus apellidos:");
            apellidos = sc.nextLine();
        } while (!Validaciones.valNombre(apellidos));

        //Email
        do {
            System.out.println("Ingrese su email:");
            email = sc.nextLine();
        } while (!Validaciones.valEmail(email));

        //Contraseña
        do {
            System.out.println("Introduzca una contraseña:");
            password = sc.nextLine();
        } while (!Validaciones.valContra(password));

        //Repetir contraseña
        do {
            System.out.println("Introduce la contraseña de nuevo:");
            password2 = sc.nextLine();
        } while (!password.equals(password2));

        //Seleccionar Rol de usuario
        boolean opcionValidaSeleccionada = false;  // Flag para controlar la validación de la opción seleccionada
        do {
            System.out.println("==== Selección de Rol de usuario ====");
            System.out.println("1. Alumno");
            System.out.println("2. Cocinera");
            System.out.println("3. Administrador");

            rolm = sc.nextLine();

            // Validar que se haya seleccionado una opción válida
            if (rolm.equals("1") || rolm.equals("2") || rolm.equals("3")) {
                opcionValidaSeleccionada = true;
                int ini = Integer.parseInt(rolm);
                switch (ini) {
                    case 1:
                        System.out.println("Rol seleccionado: ALUMNO");
                        //Seleccionar alergias
                        seleccionarAlergias(alergias, alergiasm);
                        // Seleccionar curso
                        curso = seleccionarCurso();
                        // Número de expediente
                        do {
                            System.out.println("Introduce el número de expediente del alumno:");
                            num_expediente = sc.nextLine();
                        } while (!Validaciones.esNum(num_expediente));
                        nuevo = new Alumno(usuario, nombre, apellidos, email, password, fecha_nacimiento, alergias, curso, num_expediente);

                        break;
                    case 2:
                        System.out.println("Rol seleccionado: COCINERA");
                        nuevo = new Cocina(usuario, nombre, apellidos, email, password, fecha_nacimiento);
                        break;
                    case 3:
                        System.out.println("Rol seleccionado: ADMINISTRADOR");
                        nuevo = new Administrador(usuario, nombre, apellidos, email, password, fecha_nacimiento);
                        break;
                }
            } else {
                System.out.println("Opción no válida");
            }
        } while (!opcionValidaSeleccionada);

        System.out.println("==== Datos introducidos ====");
        System.out.println("Nombre de usuario: " + usuario);
        System.out.println("Nombre del alumno: " + nombre);
        System.out.println("Apellidos del alumno: " + apellidos);
        System.out.println("Email del alumno: " + email);
        System.out.println("Contraseña del alumno: " + password);
        System.out.println("Fecha de nacimiento: " + fecha_nacimiento);

        if (rolm.equals("1")) {
            System.out.println("Alergias seleccionadas: " + alergias);
            System.out.println("Curso seleccionado: " + curso);
            System.out.println("Número de expediente: " + num_expediente);
        }

        if (nuevo != null){
            UsuarioServicio usuarioServicio = new UsuarioServicio();
            System.out.println("Añadiendo usuario a fichero...");
            GesData.listaUsuarios.add(nuevo);
            //UsuarioServicio.insertarUsuario(nuevo);
            usuarioServicio.volcarLista();
        }

    }

    public static void seleccionarAlergias(List<String> alergias, String alergiasm) {
        do {
            System.out.println("==== Selección de alergias ====");
            System.out.println("1. Gluten");
            System.out.println("2. Lactosa");
            System.out.println("3. Sésamo");
            System.out.println("4. Pescado");
            System.out.println("0. Salir");
            alergiasm = sc.nextLine();

            if (alergiasm.length() < 2) {
                if (alergiasm.length() > 0 && Validaciones.esNum(alergiasm)) {
                    int ini2 = Integer.parseInt(alergiasm);
                    switch (ini2) {
                        case 1:
                            System.out.println("Alergia seleccionada: Gluten");
                            alergias.add("Gluten");
                            break;
                        case 2:
                            System.out.println("Alergia seleccionada: Lactosa");
                            alergias.add("Lactosa");
                            break;
                        case 3:
                            System.out.println("Alergia seleccionada: Sésamo");
                            alergias.add("Sésamo");
                            break;
                        case 4:
                            System.out.println("Alergia seleccionada: Pescado");
                            alergias.add("Pescado");
                            break;
                        case 0:
                            System.out.println("Alergias seleccionadas" + alergias);
                            System.out.println("Saliendo del seleccionador de alergias...");
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } else if (alergiasm.length() == 0) {
                    System.out.println("No has ingresado ninguna opción");
                } else {
                    System.out.println("El valor no es numérico, introduce un valor numérico.");
                }
            }
        } while (!alergiasm.equals("0"));
    }

    //Seleccionar curso
    public static String seleccionarCurso() {
        String cursom;
        String curso = null;

        do {
            System.out.println("==== Selección de Curso ====");
            System.out.println("1. 1ºESO");
            System.out.println("2. 2ºESO");
            System.out.println("3. 3ºESO");
            System.out.println("4. 4ºESO");
            cursom = sc.nextLine();

            if (cursom.length() < 2) {
                if (cursom.length() > 0 && Validaciones.esNum(cursom)) {
                    // Convertir el valor de cursom a entero
                    int ini = Integer.parseInt(cursom);
                    switch (ini) {
                        case 1:
                            System.out.println("Curso seleccionado: 1ºESO");
                            curso = "1ºESO";
                            System.out.println("Curso:" + curso);
                            break;
                        case 2:
                            System.out.println("Curso seleccionado: 2ºESO");
                            curso = "2ºESO";
                            System.out.println("Curso:" + curso);
                            break;
                        case 3:
                            System.out.println("Curso seleccionado: 3ºESO");
                            curso = "3ºESO";
                            System.out.println("Curso:" + curso);
                            break;
                        case 4:
                            System.out.println("Curso seleccionado: 4ºESO");
                            curso = "4ºESO";
                            System.out.println("Curso:" + curso);
                            break;
                        default:
                            System.out.println("Curso no válido");
                    }
                } else if (cursom.length() == 0) {
                    System.out.println("No has ingresado ninguna opción");
                } else {
                    System.out.println("El valor no es numérico, introduce un valor numérico.");
                }
            }
        }while (curso == null);

        return curso;
    }

    public static void eliminarUsuario() {

    }

    public static void gestionarBocadillos(){
        String inicio = "";
        do {

            System.out.println("===== Gestion de Bocadillos =====");
            System.out.println("1. Crear Bocadillo");
            System.out.println("2. Buscar Bocadillo");
            System.out.println("3. Ver todos los Usuarios");
            System.out.println("4. Eliminar un Usuario");
            System.out.println("0. Volver al Menú de Administrador");
            System.out.println("Selecciona una opción:");

            inicio = sc.nextLine();

            if (inicio.length() < 2) {
                if (inicio.length() > 0 && Validaciones.esNum(inicio)) {
                    //Aqui se cambia el valor del inico a entero
                    int ini = Integer.parseInt(inicio);
                    switch (ini) {
                        case 1:
                            System.out.println("Opción seleccionada: Crear Bocadillo");
                            crearBocadillo();
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Gestionar Bocadillos");
                            break;
                        case 3:
                            System.out.println("Opción seleccionada: Crear Usuario");
                            crearUsuario();
                            break;
                        case 4:
                            System.out.println("Opción seleccionada: Crear Usuario");

                            break;
                        case 0:
                            System.out.println("Volviendo ...");
                            menuAdmin();
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

    public static void crearBocadillo(){
        Bocadillo nuevo = null;
        int id = 0;
        String nombre;
        boolean es_caliente = false;
        String calientem;
        List<String> ingredientes = new ArrayList<>();
        String ingredientem;
        List<String> alergenos = new ArrayList<>();
        String alergenosm = "";
        double precio = 0;
        String preciom = "";
        String dia;

        System.out.println("==== Crear Bocadillo ====");

        //Nombre
        do {
            System.out.println("Ingrese un nombre para el Bocadillo:");
            nombre = sc.nextLine();
        } while (!Validaciones.valNombre(nombre));

        // ¿Es caliente o frío?
        int opcion = 0;
        do {
            System.out.println("Selecciona el tipo de bocadillo:");
            System.out.println("1. Caliente");
            System.out.println("2. Frío");

            calientem = sc.nextLine();

            if (calientem.length() < 2) {
                if (calientem.length() > 0 && Validaciones.esNum(calientem)) {
                    int ini2 = Integer.parseInt(calientem);
                    switch (ini2) {
                        case 1:
                            System.out.println("El Bocadillo es Caliente");
                            es_caliente = true;
                            break;
                        case 2:
                            System.out.println("El Bocadillo es Frío");
                            es_caliente = false;
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } else if (calientem.length() == 0) {
                    System.out.println("No has ingresado ninguna opción");
                } else {
                    System.out.println("El valor no es numérico, introduce un valor numérico.");
                }
            }
        } while (!calientem.equals("1") && !calientem.equals("2"));

        //Añadir ingredientes
        System.out.println("Ingresa los Ingredientes del Bocadillo:");
        System.out.println("Para salir introduce la palabra 'fin' ");
        do {
            ingredientem = sc.nextLine();

                if (calientem.length() > 0 && Validaciones.valNombre(ingredientem)) {
                    System.out.println("Se ha añadido a la lista de ingredientes: " + ingredientem);
                    System.out.println("Introduce otro ingrediente o termina con 'fin'");
                    ingredientes.add(ingredientem);

                } else if (calientem.length() == 0) {
                    System.out.println("No has ingresado ningún ingrediente");
                }

        } while (!ingredientem.equals("fin"));


        //Añadir alergias
        seleccionarAlergias(alergenos, alergenosm);

        //Añadir día
        dia = seleccionarDia();

        //Precio del Bocadillo
        do {
            System.out.println("Introduce el Precio del Bocadillo: ");
            preciom = sc.nextLine();
            if (!Validaciones.valPrecio(preciom)){
                precio = Double.parseDouble(preciom);
                System.out.println(preciom);
                System.out.println("El precio del Bocadillo es: " + precio);
            }
        }while (Validaciones.valPrecio(preciom));

        System.out.println("==== Datos del Bocadillo ====");
        System.out.println("Nombre del Bocadillo: " + nombre);
        if (es_caliente) {
            System.out.println("El Bocadillo es Caliente");
        } else if (!es_caliente) {
            System.out.println("El Bocadillo es Frío");
        }
        System.out.println("Ingredientes: " + ingredientes);
        System.out.println("Alergenos: " + alergenos);
        System.out.println("El Precio es: " + precio);
        System.out.println("El Día es: " + dia);

        System.out.println("¿Son correctos los datos? (S/N)");
        String correcto = sc.nextLine();

        nuevo = new Bocadillo(id, nombre, es_caliente, ingredientes, alergenos, precio, dia);

        if (correcto.equals("S")) {
            if (nuevo != null){
                BocadilloServicio bocadilloServicio = new BocadilloServicio();
                System.out.println("Añadiendo bocadillo a fichero...");
                GesData.listaBocadillos.add(nuevo);
                //UsuarioServicio.insertarUsuario(nuevo);
                bocadilloServicio.volcarLista();
            }
        } else if (correcto.equals("N")) {
            crearBocadillo();
        } else {
            System.out.println("No es una opción válida");
        }


    }

    public static String seleccionarDia() {
        String diam;
        String dia = null;

        do {
            System.out.println("==== Selecciona el día de la Semana del Bocadillo ====");
            System.out.println("1. Lunes");
            System.out.println("2. Martes");
            System.out.println("3. Miércoles");
            System.out.println("4. Jueves");
            System.out.println("5. Viernes");
            System.out.println("6. Sabado");
            diam = sc.nextLine();

            if (diam.length() < 2) {
                if (diam.length() > 0 && Validaciones.esNum(diam)) {
                    // Convertir el valor de diam a entero
                    int ini = Integer.parseInt(diam);
                    switch (ini) {
                        case 1:
                            System.out.println("Día seleccionado: Lunes");
                            dia = "Lunes";
                            System.out.println("Día:" + dia);
                            break;
                        case 2:
                            System.out.println("Día seleccionado: Martes");
                            dia = "Martes";
                            System.out.println("Día:" + dia);
                            break;
                        case 3:
                            System.out.println("Día seleccionado: Miércoles");
                            dia = "Miercoles";
                            System.out.println("Día:" + dia);
                            break;
                        case 4:
                            System.out.println("Día seleccionado: Jueves");
                            dia = "Jueves";
                            System.out.println("Día:" + dia);
                            break;
                        case 5:
                            System.out.println("Día seleccionado: Viernes");
                            dia = "Viernes";
                            System.out.println("Día:" + dia);
                            break;
                        case 6:
                            System.out.println("Día seleccionado: Sabado");
                            dia = "Sabado";
                            System.out.println("Día:" + dia);
                            break;
                        default:
                            System.out.println("Día no válido");
                    }
                } else if (diam.length() == 0) {
                    System.out.println("No has ingresado ninguna opción");
                } else {
                    System.out.println("El valor no es numérico, introduce un valor numérico.");
                }
            }
        }while (dia == null);

        return dia;
    }
}
