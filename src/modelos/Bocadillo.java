package modelos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bocadillo implements Serializable {
    private int id;
    private String nombre;
    private boolean es_caliente;
    private List<String> ingredientes = new ArrayList<>();
    private List<String> alergenos = new ArrayList<>();
    private double precio;
    private String dia;

    public Bocadillo(int id, String nombre, boolean es_caliente, List<String> ingredientes, List<String> alergenos, double precio, String dia) {
        this.id = id;
        this.nombre = nombre;
        this.es_caliente = es_caliente;
        this.ingredientes = ingredientes;
        this.alergenos = alergenos;
        this.precio = precio;
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEs_caliente() {
        return es_caliente;
    }

    public void setEs_caliente(boolean es_caliente) {
        this.es_caliente = es_caliente;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(List<String> alergenos) {
        this.alergenos = alergenos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        if (es_caliente) System.out.println("Tipo: Caliente: ");
        else System.out.println("Tipo: Frío ");
        if (ingredientes != null) {
            System.out.println("Ingredientes: ");
            for (int i = 0; i < ingredientes.size(); i++) {
                System.out.println("\t *" + ingredientes.get(i));
            }
        }
        if (alergenos != null) {
            System.out.println("Ingredientes: ");
            for (int i = 0; i < alergenos.size(); i++) {
                System.out.println("\t *" + alergenos.get(i));
            }
        }

    }
}
