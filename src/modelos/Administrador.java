package modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrador extends Usuario implements Serializable {


        public int nivel;


        Administrador(){}
        public Administrador(String usuario, String nombre, String email, String password) {
            super(usuario, nombre, email, password);
            this.nivel=3;
        }

        public Administrador(String usuario, String nombre, String apellidos, String email, String password, LocalDate fechaNacimiento) {
            super(usuario, nombre, apellidos, email, password, fechaNacimiento);
            this.nivel=3;
        }
}
