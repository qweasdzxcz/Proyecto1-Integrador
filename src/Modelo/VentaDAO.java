package Modelo;

import configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int respuesta;
    
    public int grabarVentas(Venta ve) {
        String sql = "insert into nueva_venta(id_empleado,monto) values (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getId_empleado());
            ps.setDouble(2,ve.getMonto());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return respuesta;
    }
    
    public int ID_venta() {

        int idVenta = 0;
        String sql = "select max(id_venta) from nueva_venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idVenta = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return idVenta;
    }
    
    public int grabarDetalles(Detalle_Venta det) {
        String sql = "insert into detalles_ventas(id_venta,id_producto,cantidad,precioVenta) values (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, det.getId_venta());
            ps.setInt(2, det.getId_producto());
            ps.setInt(3, det.getCantidad());
            ps.setDouble(4, det.getPrecioVenta());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return respuesta;
    }
    
    public boolean actualizarCantidad(int cantidad, int id) {
        String sql = "UPDATE producto set cantidad=? where id_producto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
