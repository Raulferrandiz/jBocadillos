package modelos;

import java.time.LocalDate;

public class Cocina extends Usuario {
    public Cocina() {
    }

    public Cocina(String usuario, String nombre, String apellidos, String email, String password, LocalDate fechaNacimiento) {
        super(usuario, nombre, apellidos, email, password, fechaNacimiento);
    }
}
