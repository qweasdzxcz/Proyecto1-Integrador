
package Modelo;

public class Detalle_Venta {
    
     private int id_detallesVenta;
    private int id_venta;
    private int id_producto;
    private int cantidad;
    private double precioVenta;

    public Detalle_Venta() {
    }

    public Detalle_Venta(int id_detallesVenta, int id_venta, int id_producto, int cantidad, double precioVenta) {
        this.id_detallesVenta = id_detallesVenta;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getId_detallesVenta() {
        return id_detallesVenta;
    }

    public void setId_detallesVenta(int id_detallesVenta) {
        this.id_detallesVenta = id_detallesVenta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
