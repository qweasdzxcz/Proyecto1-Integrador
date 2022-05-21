package DAO;

import configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Venta;
import Modelo.Detalle_Venta;
import java.util.ArrayList;
import java.util.List;

public class VentaDaoImpl implements Interfaz.IVentaDAO{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int respuesta;

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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
        } catch (Exception e) {
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

    @Override
    public List listarVenta() {
        String sql = "select * from nueva_venta";
        List<Venta> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta vent=new Venta();               
                vent.setId_venta(rs.getInt("id_venta"));
                vent.setId_empleado(rs.getInt("id_empleado"));
                vent.setFecha(rs.getString("fechaVenta"));
                vent.setMonto(rs.getDouble("monto"));
                lista.add(vent);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    @Override
    public List listarDetalles() {
        String sql = "select * from detalles_ventas";
        List<Detalle_Venta> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Detalle_Venta detaVen=new Detalle_Venta();
                detaVen.setId_detallesVenta(rs.getInt("id_detallesVenta"));
                detaVen.setId_venta(rs.getInt("id_venta"));
                detaVen.setId_producto(rs.getInt("id_producto"));
                detaVen.setCantidad(rs.getInt("cantidad"));
                detaVen.setPrecioVenta(rs.getDouble("precioVenta"));
                lista.add(detaVen);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return lista;
    }
}
