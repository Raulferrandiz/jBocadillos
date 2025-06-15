package data;
import modelos.Bocadillo;
import modelos.Pedido;
import modelos.Usuario;
import servicios.BocadilloServicio;
import servicios.PedidoServicio;
import servicios.UsuarioServicio;

import java.io.IOException;
import java.util.List;

public class GesData {
    public static List<Usuario> listaUsuarios;
    public static List<Bocadillo> listaBocadillos;
    public static List<Pedido> listaPedidos;
    private static UsuarioServicio usuarioServicio = new UsuarioServicio();
    private static BocadilloServicio bocadilloServicio = new BocadilloServicio();
    private static PedidoServicio pedidoServicio = new PedidoServicio();

    public static void cargarBocadillos() throws IOException {
        listaBocadillos = bocadilloServicio.obtenerBocadillos();
    }

    public static void cargarPedidos() throws IOException {
        listaPedidos = pedidoServicio.obtenerPedidos();
    }

    public static void cargarUsuarios() throws IOException {
        //usuarioServicio.volcarLista();
        listaUsuarios = usuarioServicio.obtenerUsuarios();
    }

}
