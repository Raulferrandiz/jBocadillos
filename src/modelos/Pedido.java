package modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class Pedido implements Serializable {
    private int id_pedido;
    private String id_ususario;
    private int id_bocadillo;
    private LocalDate fecha;
    private String estado;

    public Pedido(int id_pedido, String id_ususario, int id_bocadillo, LocalDate fecha, String estado) {
        this.id_pedido = id_pedido;
        this.id_ususario = id_ususario;
        this.id_bocadillo = id_bocadillo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_ususario() {
        return id_ususario;
    }

    public void setId_ususario(String id_ususario) {
        this.id_ususario = id_ususario;
    }

    public int getId_bocadillo() {
        return id_bocadillo;
    }

    public void setId_bocadillo(int id_bocadillo) {
        this.id_bocadillo = id_bocadillo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void mostrarDetallesPedido(){
        System.out.println("----DETALLES DEL PEDIDO----");
        System.out.println("Id del pedido: " + id_pedido);
        System.out.println("Id del usuario: " + id_ususario);
        System.out.println("Id del bocadillo: " + id_bocadillo);
        System.out.println("Fecha del pedido: " + fecha);
        System.out.println("Estado: " + estado);
    }
}
