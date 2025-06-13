import java.io.Serial;
import java.io.Serializable;
import java.util.Scanner;

public class Bocadillo implements Serializable {
    private int id;
    private String nombre;
    private boolean es_caliente;
    private String[] ingredientes;
    private String[] alergenos;
    private double precio;
    static Scanner sc = new Scanner(System.in);


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

    /*
    public static void mostrarBocadillosSemana() {
        System.out.println("LISTADO DE BOCADILLOS DE LA SEMANA:");

        boolean hayBocadillos = false;
        for (int i = 0; i < Main.lista_semana.length; i++) {
            if (Main.lista_semana[i] != null) {
                Main.lista_semana[i].mostrarInfo();
                System.out.println("--------------------");
                hayBocadillos = true;
            }
        }

        if (!hayBocadillos) {
            System.out.println("❌ No hay bocadillos disponibles");
        }
    }

    public void mostrarCuriosidades(){

    }

    public void mostrarAlergenos(){

    }

    public void mostrarIngredientes(){

    }
}



        /*
        lista_semana[0] = new Bocadillo(
                1,
                "Salchichon",
                false,
                new String[] {"Salchichon", "Masa de madre", "Aceite de oliva"},
                null,
                1.5
        );

        lista_semana[1] = new Bocadillo(
                2,
                "Jamón serrano",
                false,
                new String[] {"Jamón serrano", "Masa de madre", "Aceite de oliva"},
                null,
                1.5
        );

        lista_semana[2] = new Bocadillo(
                3,
                "Jamón york",
                false,
                new String[] {"Jamón york", "Masa de madre", "Aceite de oliva"},
                null,
                1.5
        );

        lista_semana[3] = new Bocadillo(
                4,
                "Pechuga de pavo",
                false,
                new String[] {"pechuga de pavo", "Masa de madre", "Aceite de oliva"},
                null,
                1.5
        );

        lista_semana[4] = new Bocadillo(
                5,
                "Queso",
                false,
                new String[] {"Queso", "Masa de madre", "Aceite de oliva"},
                null,
                1.5
        );

        lista_semana[5] = new Bocadillo(
                6,
                "Bocadillo de Tortilla de patatas",
                true,
                new String[] {"Huevos", "patatas", "Masa de madre", "Aceite de oliva"},
                null,
                3
        );

        lista_semana[6] = new Bocadillo(
                7,
                "Bocadillo de Salchicha Blanca",
                true,
                new String[] {"Queso", "Salchicha blanca", "Masa de madre", "Aceite de oliva"},
                null,
                3
        );

        lista_semana[7] = new Bocadillo(
                8,
                "Bocadillo de Bacón",
                true,
                new String[] {"Bacón", "Masa de madre", "Aceite de oliva"},
                null,
                3
        );

        lista_semana[8] = new Bocadillo(
                9,
                "Bocadillo de lomo",
                true,
                new String[] {"Lomo", "Masa de madre", "Aceite de oliva"},
                null,
                3
        );

        lista_semana[9] = new Bocadillo(
                10,
                "Bocadillo de Salchichas",
                true,
                new String[] {"Salchichas", "Masa de madre", "Aceite de oliva"},
                null,
                3
        );

        System.out.println("LISTADO DE BOCADILLOS");
        for (int i = 0; i < lista_semana.length; i++) {
            lista_semana[i].mostrarInfo();
        }

         */



