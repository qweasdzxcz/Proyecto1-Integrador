package Modelo;

import configuracion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int respuesta;
    
    //ACCEDER DESDE EL LOGIN
    public Empleado validar(String usuario, String contraseña) {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM empleado WHERE usuario=? AND contraseña=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setId_empleado(rs.getInt("id_empleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDni(rs.getString("dni"));
                emp.setUsuario(rs.getString("usuario"));
                emp.setContraseña(rs.getString("contraseña"));
                emp.setCelular(rs.getString("celular"));
                emp.setCelular(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return emp;
    }
    
    //CRUD
    public int agregarEmpleado(Empleado em) {
        String sql = "insert into empleado(nombre,dni,usuario,contraseña,celular,rol) values(?,?,?,?,?,?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, em.getNombre());
            ps.setString(2, em.getDni());
            ps.setString(3, em.getUsuario());
            ps.setString(4, em.getContraseña());
            ps.setString(5, em.getCelular());
            ps.setString(6, em.getRol());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return respuesta;
    } 
    
    public List listarEmpleado() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();

                em.setId_empleado(rs.getInt("id_empleado"));

                em.setNombre(rs.getString("nombre"));
                em.setDni(rs.getString("dni"));
                em.setUsuario(rs.getString("usuario"));
                em.setContraseña(rs.getString("contraseña"));
                em.setCelular(rs.getString("celular"));
                em.setRol(rs.getString("rol"));
                lista.add(em);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public boolean eliminarEmpleado(int id) {
        String sql = "delete from empleado where id_empleado = ?";
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
    
    public int actualizarEmpleado(Empleado em) {
        String sql = "update empleado set nombre=?,dni=?,usuario=?,contraseña=?,celular=?,rol=? where id_empleado=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, em.getNombre());
            ps.setString(2, em.getDni());
            ps.setString(3, em.getUsuario());
            ps.setString(4, em.getContraseña());
            ps.setString(5, em.getCelular());
            ps.setString(6, em.getRol());
            ps.setInt(7, em.getId_empleado());

            ps.executeUpdate();
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
             System.out.println(e.toString());
        }
        return respuesta;
    }
    
    public String buscarNombre(String usuario) {
        String nombre = null;
        String sql = "select nombre from empleado where usuario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre");
            } else {
                nombre = null;
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
        return nombre;
    }
    
    public String buscarRol(String rol) {
        String ROL = null;
        String sql = "select rol from empleado where usuario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rol);
            rs = ps.executeQuery();
            if (rs.next()) {
                ROL = rs.getString("rol");
            } else {
                ROL = null;
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
        return ROL;
    }
    
    public String buscarId(String usuario) {
        String ID = null;
        String sql = "select id_empleado from empleado where usuario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getString("id_empleado");
            } else {
                ID  = null;
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
        return ID;
    }
}
