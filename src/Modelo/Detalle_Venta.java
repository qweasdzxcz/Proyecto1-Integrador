
package Modelo;

public class Detalle_Venta {
    
     private int id_detallesVenta;
    private int id_venta;
    private String nom_producto;
    private int cantidad;
    private double precioVenta;
    private String fecha;

    public Detalle_Venta() {
    }

    public Detalle_Venta(int id_detallesVenta, int id_venta, String nom_producto, int cantidad, double precioVenta, String fecha) {
        this.id_detallesVenta = id_detallesVenta;
        this.id_venta = id_venta;
        this.nom_producto = nom_producto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.fecha = fecha;
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

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
      
}
