package autenticar;
import data.GesData;
import modelos.Usuario;
import utils.Validaciones;

import java.util.Scanner;

public class AuthService {
    static Scanner entrada = new Scanner(System.in);

    //login
    public static Usuario login(){
        String usuario = "";
        String password = "";

        do {
           System.out.println("===LOGIN DE USUARIO===");
           System.out.println("Introduce tu nombre de ususario:");
           usuario = entrada.nextLine();
        }while (usuario.length() == 0);
        do {
            System.out.println("Introduce la contraseña:");
            password = entrada.nextLine();
        }while (password.length() == 0);

        for (Usuario item : GesData.listaUsuarios) {
            if (item!= null) {
                if (item.getUsuario().equalsIgnoreCase(usuario) && item.getPassword().equals(password)){
                    System.out.println("USUARIO ENCONTRADO");
                    return item;
                }
            }
        }
        System.out.println("El usuario o la contraseña son incorrectos");
        return null;
    }



    //recuperar contraseña
}
