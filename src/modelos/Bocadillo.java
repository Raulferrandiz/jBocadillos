package modelos;



public class Bocadillo {
    private int id;
    private String nombre;
    private boolean es_caliente;
    private String[] ingredientes;
    private String[] alergenos;
    private double precio;

    public Bocadillo(int id, String nombre, boolean es_caliente, String[] ingredientes, String[] alergenos, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.es_caliente = es_caliente;
        this.ingredientes = ingredientes;
        this.alergenos = alergenos;
        this.precio = precio;
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

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String[] getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String[] alergenos) {
        this.alergenos = alergenos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        if (es_caliente) System.out.println("Tipo: Caliente: ");
        else System.out.println("Tipo: Frío ");
        if (ingredientes != null) {
            System.out.println("Ingredientes: ");
            for (int i = 0; i < ingredientes.length; i++) {
                System.out.println("\t *" + ingredientes[i]);
            }
        }
        if (alergenos != null) {
            System.out.println("Ingredientes: ");
            for (int i = 0; i < alergenos.length; i++) {
                System.out.println("\t *" + alergenos[i]);
            }
        }

    }
}
