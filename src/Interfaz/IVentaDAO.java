package Interfaz;

import Modelo.Detalle_Venta;
import Modelo.Venta;
import java.util.List;

public interface IVentaDAO {
    
    public int grabarVentas(Venta ve);
    public int ID_venta();
    public int grabarDetalles(Detalle_Venta det);
    public boolean actualizarCantidad(int cantidad, int id);
    public String buscarFecha(int id);
    public List listarVenta();
    public List listarDetalles();
    
}
