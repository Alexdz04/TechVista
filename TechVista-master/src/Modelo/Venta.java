package Modelo;

// Esta clase modela una venta en el sistema, con detalles como el ID de la venta, el cliente, el vendedor y el total de la venta.
public class Venta {
    private int id;
    private String cliente;
    private String vendedor;
    private double total;

    // Construtor vacio
    public Venta() {
    }

    // Constructor con parametros
    public Venta(int id, String cliente, String vendedor, double total) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public double getTotal() {
        return total;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
