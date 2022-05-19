
package Interfaz;

import Modelo.Empleado;
import java.util.List;


public interface IEmpleadoDAO {
    //ACCEDER
    public Empleado validar(String usuario, String contraseña);
    //CRUD
    public int agregarEmpleado(Empleado em);
    public List listarEmpleado();
    public boolean eliminarEmpleado(int id);
    public int actualizarEmpleado(Empleado em);
    //BUSQUEDA
    public String buscarNombre(String usuario);
    public String buscarRol(String rol);
    public String buscarId(String usuario);
      
}
