package data;
import modelos.Usuario;
import servicios.UsuarioServicio;

import java.io.IOException;
import java.util.List;

public class GesData {
    public static List<Usuario> listaUsuarios;
    private static UsuarioServicio usuarioServicio = new UsuarioServicio();

    public static void cargarBocadillos(){
        //lista_semana[0] = new Bocadillo(1, "Bocadillo de Jamón", false, new String[]{"Pan", "Jamón"}, new String[]{"Gluten"}, 3.50);
        //lista_semana[1] = new Bocadillo(2, "Bocadillo de Pollo", true, new String[]{"Pan", "Pollo"}, new String[]{"Gluten", "Huevo"}, 4.00);
        System.out.println("✅ Bocadillos Creados");
    }
    public static void cargarPedidos(){

    }
    public static void cargarCalendarios(){

    }

    public static void cargarUsuarios() throws IOException {
        //usuarioServicio.volcarLista();
        listaUsuarios = usuarioServicio.obtenerUsuarios();
    }

    public static void actualizarUsuarios(Usuario modificado){
        //usuarioServicio.modificarUsuario(modificado);
    }

    public static void insertarUsuario (Usuario nuevo){
        listaUsuarios.add(nuevo);
    }

    public static void eliminarUsuario (Usuario eliminar){
       // usuarioServicio.eliminarUsuario(eliminar.getUsuario());
    }
}
