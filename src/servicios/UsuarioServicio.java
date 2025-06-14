package servicios;

import data.GesData;
import modelos.Administrador;
import modelos.Alumno;
import modelos.Cocina;
import modelos.Usuario;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServicio implements Crud {
    //Se utiliza para almacenar los datos de la base de datos
    private List<Usuario> listaUsuarios=new ArrayList<>();

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

    /**
     * (nos devuelve la lista con todos los usuarios que se encuentran en el archivo de usuarios.dat)
     * @return listaUsuarios
     * @throws IOException
     */
    //RECUPERAR TODOS LOS USUARIOS
    public List<Usuario> obtenerUsuarios() throws IOException {
        FileInputStream fis =null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("src/persistencia/Usuarios.dat");
            ois = new ObjectInputStream(fis);
            Usuario u;
            while (true){
                u=(Usuario) ois.readObject();
                listaUsuarios.add(u);
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

        return listaUsuarios;
    }

    /**
     * Añade el usuario que le pasamos al archivo usuarios.dat
     * @param nuevo
     */
    public static void insertarUsuario (Usuario nuevo){
        try{
            FileOutputStream fos = new FileOutputStream("src/persistencia/Usuarios.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Añadiendo: "+nuevo.getNombre());
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
     * Imprime todos los usuarios de la lista de Usuarios.dat uno uno
     */
    public void volcarLista(){

        try{
            FileOutputStream fos = new FileOutputStream("src/persistencia/Usuarios.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //oos.writeObject(new Administrador("Lala", "lola", "perez", "lola@gmail.com", "12345", LocalDate.now()));
            for(Usuario u: GesData.listaUsuarios){
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

    //Estos no tienen funcionalidad aún
    //BUSCAR USUARIO POR ID
    public Usuario buscar(String usuario) {
        for (Usuario itemUsuario : listaUsuarios) {
            if (itemUsuario.getUsuario().equals(usuario)) return itemUsuario;
        }
        System.out.println("El usuario no se encuentra almacenado");
        return null;
    }
    //MODIFICAR
    public void modificar(Usuario modificado){
        //Busco el usuario a modificar
        Usuario usu = buscar(modificado.getUsuario());

        //usu = modificado; // Comprobar

        usu.setUsuario(modificado.getUsuario()); //Asignamos los nuevos valores uno a uno
        usu.setNombre(modificado.getNombre());

    }

    //ELiMINAR
    public void eliminar(String usuario){
        for(Usuario itemUsuario : listaUsuarios ){
            if(itemUsuario.getUsuario().equals(usuario))
            {
                listaUsuarios.remove(itemUsuario);
                break;
            }
        }
        System.out.println("El usuario se ha eliminado");

    }
    
}
