
package Modelo;

public class Venta {
   
     private int id_venta;
    private int id_empleado;
    private double monto;
    
    public Venta() {       
    }
    
    public Venta(int id_venta, int id_empleado, double monto) {
        this.id_venta = id_venta;
        this.id_empleado = id_empleado;
        this.monto = monto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
   
}
