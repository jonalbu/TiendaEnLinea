package co.tiendaenlinea.modelo;

public class Cliente extends Usuario {
    private int idCliente;

    public Cliente(int idCliente, String nombre, String correo) {
        super(nombre, correo);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Cliente #" + idCliente + ": " + nombre + " - " + correo;
    }
}
