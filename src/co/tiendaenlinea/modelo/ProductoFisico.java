package co.tiendaenlinea.modelo;

public class ProductoFisico extends Producto {
    private double peso;

    public ProductoFisico(String nombre, double precio, double peso) {
        super(nombre, precio);
        this.peso = peso;
    }

    @Override
    public String toString() {
        return nombre + " [Físico, $" + precio + ", " + peso + " kg]";
    }
}
