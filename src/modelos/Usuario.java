package modelos;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Usuario {
    private String usuario; // nombre usaurio
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private LocalDate fechaNacimiento;

    public Usuario(){}

    public Usuario(String usuario, String nombre, String email, String password){
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Usuario(String usuario, String nombre, String apellidos, String email, String password,  LocalDate fechaNacimiento) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    //TODO: añadir alergias

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
