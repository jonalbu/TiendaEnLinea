package co.tiendaenlinea.modelo;

import java.util.*;
import java.util.stream.*;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<Producto> productos = new ArrayList<>();

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
    }

    public void agregarProducto(Producto p) { productos.add(p); }

    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    public List<Producto> getProductos() { return productos; }

    @Override
    public String toString() {
        return "Pedido #" + idPedido + " de " + cliente.getNombre() +
                " - Total: $" + calcularTotal();
    }
}