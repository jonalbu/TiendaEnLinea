package co.tiendaenlinea.modelo;

public class ProductoDigital extends Producto {
    private double tamanoMB;

    public ProductoDigital(String nombre, double precio, double tamanoMB) {
        super(nombre, precio);
        this.tamanoMB = tamanoMB;
    }

    @Override
    public String toString() {
        return nombre + " [Digital, $" + precio + ", " + tamanoMB + " MB]";
    }
}