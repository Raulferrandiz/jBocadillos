package autenticar;

import modelos.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAutenticar {

    /**
     *
     * @return redirige al menu correspondiente, y si el usuario inicia sesión correctamente devuelve el usuario
     */
    public static Usuario menuAuth(){
        Usuario usuarioActivo = null;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.println("1. Iniciar Sesión");
                System.out.println("2. Recuperar Contraseña");
                System.out.println("0. Salir");

                String opcion = entrada.nextLine();

                switch (opcion) {
                    case "1":
                       usuarioActivo = AuthService.login();
                        break;
                    case "2":
                        System.out.println("Sin funcionalidad");
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.out.println("Opción no valida");
                }
            } catch (InputMismatchException e){
                System.out.println("Debes introducir un valor entero");
               // entrada.nextLine();
            }
        // No termina el bucle hasta que un usuario tenga la sesión iniciada
        }while (usuarioActivo==null);
        //Sesion.iniciarSesion(usuarioActivo);

        return usuarioActivo;
    }
}
