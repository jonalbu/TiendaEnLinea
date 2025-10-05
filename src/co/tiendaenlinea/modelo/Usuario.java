package co.tiendaenlinea.modelo;

public class Usuario {
    protected String nombre;
    protected String correo;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " (" + correo + ")";
    }
}
