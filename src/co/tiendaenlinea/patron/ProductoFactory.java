package co.tiendaenlinea.patron;

import co.tiendaenlinea.modelo.*;

public class ProductoFactory {
    public static Producto crearProducto(String tipo, String nombre, double precio, double valorExtra) {
        switch (tipo.toLowerCase()) {
            case "fisico":
                return new ProductoFisico(nombre, precio, valorExtra);
            case "digital":
                return new ProductoDigital(nombre, precio, valorExtra);
            default:
                throw new IllegalArgumentException("Tipo de producto no válido: " + tipo);
        }
    }
}