import utils.Validaciones;

import java.time.LocalDate;
import java.util.Scanner;

public class Usuario {
   /*
    public static String nombre;
    private String usuario;
    private String correo;
    private String curso;
    public static String contra;
    private String alergias [];
    private LocalDate fecha_nacimiento;
    static Scanner sc = new Scanner(System.in);
    public static String color;
    public static int intentos = 0;
    public static int max_intentos = 3;
    public static int inicsesion = 0;
    public static int inicsesion_max = 1;
    public static boolean menor = false;
    //private int rol


    public Usuario(String usuario, String correo, String curso, String[] alergias, LocalDate fecha_nacimiento) {
        this.usuario = usuario;
        this.correo = correo;
        this.curso = curso;
        this.alergias = alergias;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Usuario.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public static String getContra() {
        return contra;
    }

    public static void setContra(String contra) {
        Usuario.contra = contra;
    }

    public String[] getAlergias() {
        return alergias;
    }

    public void setAlergias(String[] alergias) {
        this.alergias = alergias;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void mostrarAlergias(){
        if (alergias != null){
            System.out.println("ALERGIAS DEL USUARIO:");
            for (int i = 0; i < alergias.length; i++) {
                System.out.println(alergias[i]);
            }
        } else {
            System.out.println("No tiene alergias el usuario");
        }

    }


    public void mostrarInfo() {
        System.out.println("Usuario{" +
                "usuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", curso='" + curso + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '"');
        mostrarAlergias();
    }

    public static void crearUsuario(){
        String respuesta;
        String apellido;
        String email;
        String dni;
        String ano;
        String contra2;

        System.out.println("==== Registro de Usuario ====");

        //CAPTCHA
        boolean fin = false;

        do {
            long valor1 = Math.round(Math.random() * 101 + 50);
            long valor2 = Math.round(Math.random() * 101 + 50);
            long suma = valor1 + valor2;

            System.out.println("====CAPTCHA====");
            System.out.println("Introduce el resultado de esta suma " + valor1 + " + " + valor2 + "=");

            respuesta = sc.nextLine();

            if (respuesta.equals(String.valueOf(suma))) {
                System.out.println("La suma es correcta");
                fin = true;
            }
        } while (!fin);

        // Nombre
        do {
            System.out.println("Ingrese su nombre:");
            nombre = sc.nextLine();
        } while (!Validaciones.val_nombre(nombre));

        // Apellido
        do {
            System.out.println("Ingrese su primer apellido:");
            apellido = sc.nextLine();
        } while (!Validaciones.val_nombre(apellido));

        //Email
        do {
            System.out.println("Ingrese su email:");
            email = sc.nextLine();
        } while (!Validaciones.val_email(email));

        //DNI
        do {
            System.out.println("Introduzca su DNI:");
            dni = sc.nextLine();
        } while (!Validaciones.val_dni(dni));

        //Fecha de nacimiento:
        do {
            System.out.println("Dime tu fecha de nacimiento(dd/mm/yyyy):");
            ano = sc.nextLine();
        } while (!Validaciones.val_fecha(ano) && !menor);

        //Si es menor
        if (menor) {
            System.out.println("Eres menor de edad");
            return;
        }

        //Contraseña
        do {
            System.out.println("Introduzca una contraseña:");
            contra = sc.nextLine();
        } while (!Validaciones.val_contra(contra));

        do {
            System.out.println("Introduce la contraseña de nuevo:");
            contra2 = sc.nextLine();
        } while (!contra.equals(contra2));

        //Pregunta de seguridad
        do {
            System.out.println("Pregunta de seguridad: ¿Cual es tu color favorito?");
            color = sc.nextLine();
        } while (!Validaciones.val_color(color));

        //Dice que el registro a salido correcamente y los datos introducidos
        System.out.println("Usuario creado con exito");
        System.out.println("El nombre introducido es: " + nombre);
        System.out.println("El apellido introducido es: " + apellido);
        System.out.println("El email introducido es: " + email);
        System.out.println("El DNI introducido es: " + dni);
        System.out.println("La fecha de nacimiento introducida es: " + ano);
        System.out.println("La contraseña introducida es:" + contra);
    }

    /**
     *
     * @param nombre
     * @return devuelve falso cuando en nombre tiene algun caracter que no sea una letra o cuando su longitud sea inferior a 3 digitos
     */


    /**
     * Esta funcion hace el login de un usuario
     *//*
    public static void login_usuario() {

        String seguridad;
        String respuesta;
        String user;
        String password;

        int inten = 0;

        System.out.println("==== Login ====");

        //Si ha bloqueado el login con 3 intentos se puede desbloquear con esto
        if (intentos == max_intentos) {

            System.out.println("Desbloquea el usuario:");

            //CAPTCHA
            boolean fin = false;

            do {
                long valor1 = Math.round(Math.random() * 101 + 50);
                long valor2 = Math.round(Math.random() * 101 + 50);
                long suma = valor1 + valor2;

                System.out.println("====CAPTCHA====");
                System.out.println("Introduce el resultado de esta suma " + valor1 + " + " + valor2 + "=");

                respuesta = sc.nextLine();

                if (respuesta.equals(String.valueOf(suma))) {
                    System.out.println("La suma es correcta");
                    fin = true;
                }
            } while (!fin);

            do {
                System.out.println("¿Cuál es tu color favorito? (Pregunta de Seguridad):");
                seguridad = sc.nextLine();
                if (!seguridad.equals(color)) {
                    System.out.println("La pregunta de seguridad es incorrecta");
                }
                if (seguridad.equals(color)) {
                    //Cuando finaliza vuelve los intentos a 0
                    intentos = 0;
                    inicsesion = 0;
                }
            } while (!seguridad.equals(color));

        }

        //Si no se ha llegado al maximo de intentos o se ha iniciado sesión antes
        while (intentos < max_intentos && inicsesion < inicsesion_max) {

            do {
                System.out.println("Introduce el nombre de usuario:");
                user = sc.nextLine();
                if (!user.equals(nombre)) {
                    intentos++;
                    inten++;
                    int resta = max_intentos - intentos;
                    System.out.println("El nombre se usuario es incorrecto, Intentos restantes: " + resta);
                    if (intentos == max_intentos) {
                        System.out.println("Sesión bloqueada temporalmente");
                        return;
                    }
                }
            } while (!user.equals(nombre));

            do {
                System.out.println("Introduce la contraseña:");
                password = sc.nextLine();
                if (!password.equals(contra)) {
                    intentos++;
                    inten++;
                    int resta = max_intentos - intentos;
                    System.out.println("La contraseña es incorrecta, Intentos restantes: " + resta);
                    if (intentos == max_intentos) {
                        System.out.println("Sesión bloqueada temporalmente");
                        return;
                    }
                }
            } while (!password.equals(contra));

            System.out.println("Sesión iniciada correctamente");
            inicsesion++;
        }

        //Si ya has iniciado sesión no puedes volver a iniciar sesion
        if (inicsesion == 1) {
            System.out.println("Ya has iniciado sesion");
        }
    }

    /**
     * Hace la funcion de recuperar contraseña
     *//*
    public static void recuperar_contra() {

        String user;
        String seguridad;

        do {
            System.out.println("Introduce el nombre de usuario:");
            user = sc.nextLine();
            if (!user.equals(nombre)) {
                System.out.println("El nombre de usuario es incorrecto");
            }
        } while (!user.equals(nombre));

        do {
            System.out.println("Introduce tu color favorito (Pregunta de seguridad):");
            seguridad = sc.nextLine();
            if (!seguridad.equals(color)) {
                System.out.println("La pregunta de seguridad es incorrecta");
            }
        } while (!seguridad.equals(color));

        //Si el nombre de usuario y la pregunta de seguridad son correctas permite cambiar la contraseña
        do {
            System.out.println("Introduce la nueva contraseña:");
            contra = sc.nextLine();
            if (!Validaciones.val_contra(contra)) {
                System.out.println("El formato de la contraseña no es valido");
            }
        } while (!Validaciones.val_contra(contra));
        System.out.println("Contraseña cambiada correctamente");
        System.out.println("La nueva contraseña es: " + contra);
    }
    */

}
