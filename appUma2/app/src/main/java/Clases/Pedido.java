package Clases;

import java.util.ArrayList;

public class Pedido {
    public int idPedido;
    public int numeroPedido;
    public double tiempoAproximado;
    public int estado;
    public int mesero;
    public int cajero;
    public int cocinero;
    public ArrayList<platoPedido> listaPlatoPedido = new ArrayList<platoPedido>();
    public int numeroMesa;

    public Pedido() {
    }

    public Pedido(int numeroPedido, double tiempoAproximado, int estado, int mesero, int cajero, int cocinero, int cantidad, int estadoPlatoPedido, Plato plato, String observacion, int numeroMesa) {
        this.numeroPedido = numeroPedido;
        this.tiempoAproximado = tiempoAproximado;
        this.estado = estado;
        this.mesero = mesero;
        this.cajero = cajero;
        this.cocinero = cocinero;
        this.listaPlatoPedido.add(new platoPedido(cantidad, estado, plato, observacion));
        this.numeroMesa = numeroMesa;
    }


    public void agregarAdicional(int cantidad, int estadoPlatoPedido, Plato plato, String observacion) {
        this.listaPlatoPedido.add(new platoPedido(cantidad, estadoPlatoPedido, plato, observacion));
    }

    public void despacharPedido() {
        for (platoPedido plato : this.listaPlatoPedido) {
            plato.setEstado(3);
        }
        this.estado = 3;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getIdPedido(){
        return this.idPedido;
    }

    public void setIdPedido(int idPedido){
        this.idPedido=idPedido;
    }

    public double getTiempoAproximado() {
        return tiempoAproximado;
    }

    public void setTiempoAproximado(double tiempoAproximado) {
        this.tiempoAproximado = tiempoAproximado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMesero() {
        return mesero;
    }

    public void setMesero(int mesero) {
        this.mesero = mesero;
    }

    public int getCajero() {
        return cajero;
    }

    public void setCajero(int cajero) {
        this.cajero = cajero;
    }

    public int getCocinero() {
        return cocinero;
    }

    public void setCocinero(int cocinero) {
        this.cocinero = cocinero;
    }

    public ArrayList<platoPedido> getListaPlatoPedido() {
        return listaPlatoPedido;
    }

    public void setListaPlatoPedido(ArrayList<platoPedido> listaPlatoPedido) {
        this.listaPlatoPedido = listaPlatoPedido;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numeroPedido=" + numeroPedido + ", tiempoAproximado=" + tiempoAproximado + ", estado=" + estado + ", mesero=" + mesero + ", cajero=" + cajero + ", cocinero=" + cocinero + ", listaPlatoPedido=" + listaPlatoPedido + ", numeroMesa=" + numeroMesa + '}';
    }
}
