
package DAO;

import Modelo.Producto;
import configuracion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements Interfaz.IProductoDAO{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int respuesta;
    
    @Override
    public int agregarProducto(Producto pro) {
        String sql = "insert into producto(nombre,descripcion,cantidad,precio) values(?,?,?,?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getCantidad());
            ps.setDouble(4, pro.getPrecio());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return respuesta;
    }

    @Override
    public List listarProducto() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();

                pro.setId_producto(rs.getInt("id_producto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setPrecio(rs.getDouble("precio"));


                lista.add(pro);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public boolean eliminarProducto(int id) {
        String sql = "delete from producto where id_producto = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public Producto buscarProducto(int id) {
         Producto p=new Producto();
        String sql = "select * from producto where id_producto=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setCantidad(rs.getInt(4));
                p.setPrecio(rs.getDouble(5));
                
            }
        } catch (Exception e) {
        }
        return p ;
    }

    @Override
    public int actualizar(Producto pr) {
        String sql = "update producto set nombre=?,descripcion=?,cantidad=?,precio=? where id_producto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getDescripcion());
            ps.setInt(3, pr.getCantidad());
            ps.setDouble(4, pr.getPrecio());          
            ps.setInt(5, pr.getId_producto());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return respuesta;
    }
    
}
