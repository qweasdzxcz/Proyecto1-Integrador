package Modelo;

import configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Venta;
import Modelo.Detalle_Venta;
import java.util.ArrayList;
import java.util.List;

public class Detalle_VentaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int respuesta;
    
    public int grabarDetalles(Detalle_Venta det) {
                String sql = "insert into detalles_ventas(id_venta,nombre_producto,cantidad,precioVenta,fechaD) values (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, det.getId_venta());
            ps.setString(2, det.getNom_producto());
            ps.setInt(3, det.getCantidad());
            ps.setDouble(4, det.getPrecioVenta());
            ps.setString(5, det.getFecha());
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
    
    public String buscarFecha(int id) {
        String FECHA = null;
        String sql = "select fechaVenta from nueva_venta where id_venta=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                FECHA = rs.getString("fechaVenta");
            } else {
                FECHA = null;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
        return FECHA;
    }
    
    public List listarDetalles() {
        String sql = "select * from detalles_ventas";
        List<Detalle_Venta> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Detalle_Venta detaVen=new Detalle_Venta();
                detaVen.setId_detallesVenta(rs.getInt("id_detallesVentas"));
                detaVen.setId_venta(rs.getInt("id_venta"));
                detaVen.setNom_producto(rs.getString("nombre_producto"));
                detaVen.setCantidad(rs.getInt("cantidad"));
                detaVen.setPrecioVenta(rs.getDouble("precioVenta"));
                detaVen.setFecha(rs.getString("fechaD"));
                lista.add(detaVen);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
}
