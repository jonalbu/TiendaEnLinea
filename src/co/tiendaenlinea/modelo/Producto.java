package co.tiendaenlinea.modelo;


public abstract class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}