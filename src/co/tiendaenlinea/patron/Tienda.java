package co.tiendaenlinea.patron;

import java.util.*;
import java.util.stream.*;
import co.tiendaenlinea.modelo.*;

public class Tienda {
    private static Tienda instancia;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    private Tienda() {}

    public static Tienda getInstancia() {
        if (instancia == null) {
           instancia = new Tienda();
        }
        return instancia;
    }

    public void agregarCliente(Cliente c) { clientes.add(c); }
    public void agregarProducto(Producto p) { productos.add(p); }
    public void agregarPedido(Pedido p) { pedidos.add(p); }

    public List<Cliente> getClientes() { return clientes; }
    public List<Producto> getProductos() { return productos; }
    public List<Pedido> getPedidos() { return pedidos;}

    public void mostrarProductosCaros(double limite) {
        System.out.println("\nProductos con precio mayor a $" + limite + ":");
        productos.stream()
                .filter(p -> p.getPrecio() > limite)
                .forEach(System.out::println);
    }

    public List<Cliente> buscarClientesPorNombre(String texto) {
        return clientes.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> obtenerNombresDeProductos() {
        return productos.stream()
                .map(Producto::getNombre)
                .collect(Collectors.toList());
    }
}
