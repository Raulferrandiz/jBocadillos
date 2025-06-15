package servicios;

import data.GesData;
import modelos.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BocadilloServicio implements Crud {
    //Se utiliza para almacenar los datos de la base de datos
    private List<Bocadillo> listaBocadillos=new ArrayList<>();

    //RECUPERAR TODOS LOS BOCADILLOS
    public List<Bocadillo> obtenerBocadillos()  {
        FileInputStream fis =null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("src/persistencia/Bocadillo.dat");
            ois = new ObjectInputStream(fis);
            Bocadillo u;
            while (true){
                u=(Bocadillo) ois.readObject();
                listaBocadillos.add(u);
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
        return listaBocadillos;
    }

    public static void insertarBocadillo (Bocadillo nuevo){
        try{
            FileOutputStream fos = new FileOutputStream("src/persistencia/Bocadillo.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Añadiendo: "+nuevo.getNombre());
            nuevo.setId(autoincrementoBocataID());
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

    public static int autoincrementoBocataID() {
        int numeroLeido = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("src/persistencia/uidB.txt"));
            numeroLeido = dis.readInt();
            numeroLeido ++;

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try{
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/persistencia/uidB.txt"));
            dos.writeInt(numeroLeido);
            System.out.println(numeroLeido);

            dos.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return numeroLeido;
    }

    public void volcarLista(){
        System.out.println("CREANDO BOCADILLOS");
        List<String> ingredientes = new ArrayList<>();
        List<String> alergenos = new ArrayList<>();
        try{
            FileOutputStream fos = new FileOutputStream("src/persistencia/Bocadillo.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //oos.writeObject(new Bocadillo(1, "Salchicha", true, ingredientes, alergenos, 2.10, "Sábado"));
            for(Bocadillo b: GesData.listaBocadillos){
                oos.writeObject(b);
            }
            fos.close();
            oos.flush();
            oos.close();
        }catch (EOFException e){
            e.getMessage();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.getMessage();
        }


    }

    public void listaBocadilos () {
        for(Bocadillo b: GesData.listaBocadillos) {
            System.out.print(b.getNombre() + ", Alergenos: " + b.getAlergenos() + ", Ingredientes: " + b.getIngredientes() + ", Precio: " + b.getPrecio());
            if (b.isEs_caliente()) {
                System.out.print(", Tipo: Caliente, ");
            } else {
                System.out.println("Tipo: Frío, ");
            }
            System.out.print(", Día: " + b.getDia());
            System.out.println();
        }
    }

    //BUSCAR Bocadillos POR ID
    public Bocadillo buscar(String bocadillo){
        for(Bocadillo itemBocadillo : listaBocadillos ){
            if(itemBocadillo.getNombre().equals(bocadillo)) return itemBocadillo;
        }
        System.out.println("El bocadillo no se encuentra almacenado");
        return null;
    }

    //INSERTAR UN NUEVO BOCADILLO
    public void insertar(Bocadillo nuevo){
        listaBocadillos.add(nuevo);
        System.out.println("El bocadillo ha sido insertado");
    }

    //MODIFICAR UN BOCADILLO
    public void modificar(Bocadillo modificado){
        //Busco el bocadillo a modificar
        Bocadillo boc = buscar(modificado.getNombre());

        //Asignamos los nuevos valores uno a uno
        boc.setNombre(modificado.getNombre());

    }

    //ELiMINAR
    public void eliminar(String bocadillo){
        for(Bocadillo itemBocadillo : listaBocadillos ){
            if(itemBocadillo.getNombre().equals(bocadillo))
            {
                listaBocadillos.remove(itemBocadillo);
                break;
            }
        }
        System.out.println("El bocadillo se ha eliminado");

    }


}

