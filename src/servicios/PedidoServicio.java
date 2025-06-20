package servicios;

import data.GesData;
import modelos.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * En esta clase se encuentran metodos para gestionar los pedidos, insertarlos, listarlos, etc
 * @author Raúl Ferrándiz Sáez
 * @version 1.2
 */

public class PedidoServicio {
    public BocadilloServicio bocadilloServicio;
    //Se utiliza para almacenar los datos de la base de datos
    private List<Pedido> listaPedidos=new ArrayList<>();

    /*
    public List<Usuario> obtenerUsuariosFicheroCaracter(){
        FileReader fichero_usuarios = null;
        try{
            fichero_usuarios = new FileReader("persistencia/Usuarios.dat");
            BufferedReader br = new BufferedReader(fichero_usuarios);
            String linea="";
            Usuario nuevo;
            while (linea!=null){
                linea = br.readLine();
                if (linea!=null){
                    String[] datos = linea.split(";");
                    if (datos.length==6){
                        System.out.println("Añadimos usuario cocina");
                        nuevo = new Cocina(datos[0], datos[1], datos[2], datos[3], datos[4], LocalDate.now());
                        System.out.println(nuevo.getUsuario());
                    }else if (datos.length==9){
                        System.out.println("Añadimos usuario alumno");
                        nuevo = new Alumno(datos[0], datos[1], datos[2], datos[3], datos[4], LocalDate.now(), null, datos[7], datos[8]);
                        System.out.println(nuevo.getUsuario());
                    }else if (datos.length==7){
                        System.out.println("Añadimos usuario administrador");
                        nuevo = new Administrador(datos[0], datos[1], datos[2], datos[3], datos[4], LocalDate.now());
                        System.out.println(nuevo.getUsuario());
                    }
                }
                System.out.println(linea);
            }


            br.close();
            fichero_usuarios.close();
        }catch (IOException eio){
            System.out.println(eio.getMessage());
        }

        return listaUsuarios;
    }

     */

    /**
     * (nos devuelve la lista con todos los pedidos que se encuentran en el archivo de pedidos.dat)
     * @return listaPedidos
     * @throws IOException
     */
    //RECUPERAR TODOS LOS Pedidos
    public List<Pedido> obtenerPedidos() throws IOException {
        FileInputStream fis =null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("src/persistencia/Pedido.dat");
            ois = new ObjectInputStream(fis);
            Pedido p;
            while (true){
                p=(Pedido) ois.readObject();
                listaPedidos.add(p);
            }

        }catch (EOFException e){
            e.getMessage();
        }catch (FileNotFoundException e){
            e.getMessage();
        }catch (IOException e){
            e.getMessage();
        }catch (ClassNotFoundException e){
            e.getMessage();
        }finally {
            try{
                if (ois!=null)ois.close();
                if (fis!=null)fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return listaPedidos;
    }

    /**
     * Añade el pedido que le pasamos al archivo pedido.dat
     * @param nuevo
     */
    public static void insertarPedido (Pedido nuevo){
        try{
            FileOutputStream fos = new FileOutputStream("src/persistencia/Pedido.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Añadiendo: "+nuevo.getId_pedido());
            nuevo.setId_pedido(autoincrementoPedidoID());
            oos.writeObject(nuevo);

            fos.close();
            oos.flush();
            oos.close();

        }catch (EOFException e){
            e.getMessage();
        }catch (FileNotFoundException e){
            e.getMessage();
        }catch (IOException e){
            e.getMessage();
        }
    }

    /**
     * Imprime todos los pedidos de la lista de Pedido.dat uno uno
     */
    public void volcarLista(){

        try{
            FileOutputStream fos = new FileOutputStream("src/persistencia/Pedido.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //oos.writeObject(new Pedido(1, "Lala", 1, ));
            //oos.writeObject(new Administrador("Lala", "lola", "perez", "lola@gmail.com", "12345", LocalDate.now()));
            for(Pedido u: GesData.listaPedidos){
                oos.writeObject(u);
            }
            fos.close();
            oos.flush();
            oos.close();
        }catch (EOFException e){
            e.getMessage();
        }catch (FileNotFoundException e){
            e.getMessage();
        }catch (IOException e){
            e.getMessage();
        }
    }

    /**
     * En este metodo coje un número que se encuentra en el archivo uidP.txt y le aumenta 1, para insertarlo en el id del pedido
     * Y luego lo vuelve a insertar en el archivo para el siguiente pedido
     * @return numeroLeido
     */
    public static int autoincrementoPedidoID() {
        int numeroLeido = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("src/persistencia/uidP.txt"));
            numeroLeido = dis.readInt();
            numeroLeido ++;

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try{
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/persistencia/uidP.txt"));
            dos.writeInt(numeroLeido);
            System.out.println(numeroLeido);

            dos.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return numeroLeido;
    }

    /**
     * Este metodo nos muestra todos los pedidos que hay y nos muestra los datos que especificamos
     */
    public void listaPedidos () {
        for(Pedido p: GesData.listaPedidos) {
            int id_bocadillo = p.getId_bocadillo();
            String nombre = obtenerBocadilloId(id_bocadillo);
            System.out.print("Fecha: " + p.getFecha() + ", Id pedidos: " + p.getId_pedido() + ", Bocadillo: " + nombre + ", Estado: " + p.getEstado());
            System.out.println();
        }
    }

    /**
     * Nos devuelve el nombre de un bocadillo que coincida con la id que establecemos
     * @param id
     * @return nombre
     */
    public static String obtenerBocadilloId(int id) {
        for (Bocadillo b : GesData.listaBocadillos) {
            if (b.getId() == id) {
                return b.getNombre();
            }
        }
        return "Bocadillo no encontrado";
    }

    /**
     * Devuelve el día de la semana en español y pone la primera letra en mayúscula para la fecha actual.
     *
     * @return el nombre del día en español (por ejemplo, "lunes", "martes", etc.)
     */
    public static String obtenerDiaSemana() {
        LocalDate fechaActual = LocalDate.now();
        String dia = fechaActual.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        String diam = dia.substring(0, 1).toUpperCase() + dia.substring(1).toLowerCase();
        return diam;
    }


}
