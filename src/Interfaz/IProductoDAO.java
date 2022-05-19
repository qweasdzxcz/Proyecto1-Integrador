
package Interfaz;

import Modelo.Producto;
import java.util.List;

public interface IProductoDAO {
    public int agregarProducto(Producto pro);
    public List listarProducto();
    public boolean eliminarProducto(int id);
    public Producto buscarProducto(int id);
    public int actualizar(Producto pr);
}
