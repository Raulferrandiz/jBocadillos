package servicios;

import modelos.Alumno;
import modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BocadilloServicio implements Crud {
    //Se utiliza para almacenar los datos de la base de datos
    private List<Usuario> listaUsuarios=new ArrayList<>();
        //RECUPERAR TODOS LOS USUARIOS
        public List<Usuario> obtenerUsuarios(){
            //listaUsuarios.add(new Alumno("lolito","Lolo","lolo@gmail.com","12345",null));
            //listaUsuarios.add(new Alumno("pepita","Pepa","pepa@gmail.com","12345",null));
            //listaUsuarios.add(new Administrador("admin","Carla","carla@gmail.com","12345"));
            //listaUsuarios.add(new Cocina("cocina","Victoria","victoria@gmail.com","12345"));
            return listaUsuarios;
        }

        //BUSCAR USUARIO POR ID
        public Usuario buscar(String usuario){
            for(Usuario itemUsuario : listaUsuarios ){
                if(itemUsuario.getUsuario().equals(usuario)) return itemUsuario;
            }
            System.out.println("El usuario no se encuentra almacenado");
            return null;
        }
        //INSERTAR UN NUEVO USUARIO

        public void insertar(Usuario nuevo){
            listaUsuarios.add(nuevo);
            System.out.println("El usuario ha sido insertado");
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
