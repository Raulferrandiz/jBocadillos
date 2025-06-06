package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
    public List<String> alergias = new ArrayList<>();
    public String curso;
    public String num_expediente;

    public Alumno(String usuario, String nombre, String apellidos, String email, String password, LocalDate fechaNacimiento,
                  List<String> alergias, String curso, String num_expediente) {
        super(usuario, nombre, apellidos, email, password, fechaNacimiento);
        this.alergias = alergias;
        this.curso = curso;
        this.num_expediente = num_expediente;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNum_expediente() {
        return num_expediente;
    }

    public void setNum_expediente(String num_expediente) {
        this.num_expediente = num_expediente;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "usuario='" + getUsuario() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", fechaNacimiento=" + getFechaNacimiento() +
                ", alergias=" + alergias +
                ", curso='" + curso + '\'' +
                ", num_expediente='" + num_expediente + '\'' +
                '}';
    }




/*
    Alumno(){}
    public Alumno(String usuario, String nombre, String email, String password, String[] alergias) {
        super(usuario, nombre, email, password);
        this.alergias = alergias;
    }

    public Alumno(String usuario, String nombre, String apellidos, String email, String password, LocalDate fechaNacimiento, String[] alergias, String curso, String num_expediente) {
        super(usuario, nombre, apellidos, email, password, fechaNacimiento);
        this.alergias = alergias;
        this.curso=curso;
        this.num_expediente=num_expediente;
    }

     */

}
