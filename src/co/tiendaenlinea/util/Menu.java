package co.tiendaenlinea.util;

import co.tiendaenlinea.modelo.*;
import co.tiendaenlinea.patron.*;
import java.util.*;

public class Menu {

    public void iniciar() {
        Tienda tienda = Tienda.getInstancia();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n========= MENÚ TIENDA EN LÍNEA =========");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar producto");
            System.out.println("3. Crear pedido");
            System.out.println("4. Ver productos caros");
            System.out.println("5. Buscar clientes por nombre");
            System.out.println("6. Mostrar nombres de productos");
            System.out.println("7. Mostrar lista de Clientes");
            System.out.println("8. Mostrar lista de Pedidos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> registrarCliente(sc, tienda);
                    case 2 -> registrarProducto(sc, tienda);
                    case 3 -> crearPedido(sc, tienda);
                    case 4 -> mostrarProductosCaros(sc, tienda);
                    case 5 -> buscarClientesContengan(sc, tienda);
                    case 6 -> mostrarNombres(tienda);
                    case 7 -> listarClientes(tienda);
                    case 8 -> listarPedidos(tienda);
                    case 9 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("¡Error! debe ingresar un número válido.");
            }
            finally {
                if (opcion != 9) {
                System.out.println("\n----------------¿Qué mas deseas hacer?---------------------\n");
                }
            }

        } while (opcion != 9);

        sc.close();
        System.out.println("Programa finalizado correctamente.");
    }

    private void registrarCliente(Scanner sc, Tienda tienda) {
        System.out.print("ID del cliente: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        tienda.agregarCliente(new Cliente(id, nombre, correo));
        System.out.println("Cliente registrado correctamente.");
    }

    private void registrarProducto(Scanner sc, Tienda tienda) {
        System.out.print("Tipo (fisico/digital): ");
        String tipo = sc.nextLine();
        System.out.print("Nombre: ");
        String nomProd = sc.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print(tipo.equalsIgnoreCase("fisico") ? "Peso (kg): " : "Tamaño (MB): ");
        double extra = Double.parseDouble(sc.nextLine());
        tienda.agregarProducto(ProductoFactory.crearProducto(tipo, nomProd, precio, extra));
        System.out.println("Producto registrado correctamente.");
    }

    private void crearPedido(Scanner sc, Tienda tienda) {
        System.out.print("ID del cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());
        Optional<Cliente> cliente = tienda.getClientes().stream()
                .filter(c -> c.getIdCliente() == idCliente)
                .findFirst();

        if (cliente.isEmpty()) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Pedido pedido = new Pedido((int) (Math.random() * 10000), cliente.get());
        tienda.getProductos().forEach(System.out::println);
        System.out.print("Nombre del producto a agregar: ");
        String nomBuscar = sc.nextLine();
        tienda.getProductos().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nomBuscar))
                .findFirst()
                .ifPresent(pedido::agregarProducto);

        tienda.agregarPedido(pedido);
        System.out.println("Pedido creado: " + pedido);
    }

    private void listarPedidos (Tienda tienda) {
        tienda.getPedidos()
                .forEach(System.out::println);
    }

    private void mostrarProductosCaros(Scanner sc, Tienda tienda) {
        System.out.print("Mostrar productos con precio mayor a: ");
        double limite = Double.parseDouble(sc.nextLine());
        tienda.mostrarProductosCaros(limite);
    }

    private void buscarClientesContengan (Scanner sc, Tienda tienda) {
        System.out.print("Buscar clientes que contengan: ");
        String texto = sc.nextLine();
        tienda.buscarClientesPorNombre(texto).forEach(System.out::println);
    }

    private void listarClientes (Tienda tienda) {
        tienda.getClientes()
                .forEach(System.out ::println);

    }

    private void mostrarNombres(Tienda tienda) {
        System.out.println("\nLista de nombres de productos:");
        tienda.obtenerNombresDeProductos().forEach(System.out::println);
    }
}