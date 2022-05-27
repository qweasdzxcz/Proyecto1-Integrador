package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;
import static vistas.Principal.*;
import configuracion.ReportesExcel;
import vistas.Login;
import Modelo.EmpleadoDAO;
import javax.swing.JOptionPane;

public class ProductoControlador implements ActionListener {

    private Principal principal;
    private ProductoDAO proDAO;
    Producto pro = new Producto();
    DefaultTableModel tablaPro = new DefaultTableModel();

    public ProductoControlador(Principal principal, ProductoDAO proDAO) {
        this.principal = principal;
        this.proDAO = proDAO;
        this.principal.btn_agregarProducto.addActionListener(this);
        this.principal.btn_listarProducto.addActionListener(this);
        this.principal.btn_limpiarTxtProducto.addActionListener(this);
        this.principal.btn_eliminarProducto.addActionListener(this);
        this.principal.btn_actualizarProducto.addActionListener(this);
        this.principal.btn_editarProducto.addActionListener(this);
        this.principal.btn_excelProductos.addActionListener(this);

        this.principal.btn_cerrarSesionPrincipal.addActionListener(this);
        this.principal.btn_salirPrincipal.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Principal.btn_agregarProducto) {
            agregarProducto();
            limpiarTablaProducto();
            listarProducto(principal.tablaProductos);
        }
        if (e.getSource() == Principal.tablaProductos.getSelectedRows()) {
            tablaActualizar();
        }
        if (e.getSource() == Principal.btn_actualizarProducto) {
            actualizarProducto();
        }
        if (e.getSource() == Principal.btn_eliminarProducto) {
            eliminarProducto();
        }
        if (e.getSource() == Principal.btn_listarProducto) {
            limpiarTablaProducto();
            listarProducto(principal.tablaProductos);
        }
        if (e.getSource() == Principal.btn_limpiarTxtProducto) {
            limpiarTxtProducto();
        }
        if (e.getSource() == Principal.btn_excelProductos) {
            ReportesExcel.reporteProductos();
            String fileName = "REPORTE DE PRODUCTOS";
            String home = System.getProperty("user.home");
            ReportesExcel.abrirReporte(home + "\\Downloads\\" + fileName + ".xlsx");
        }
        if (e.getSource() == Principal.btn_cerrarSesionPrincipal) {
            cerrarSesion();
        }
        if (e.getSource() == Principal.btn_salirPrincipal) {
            salir();
        }

    }

    public void listarProducto(JTable tabla) {

        tablaPro = (DefaultTableModel) tabla.getModel();

        List<Producto> listaProd = proDAO.listarProducto();
        //tablaEmp = (DefaultTableModel) tablaEmpleados.getModel();
        Object[] obj = new Object[5];
        for (int i = 0; i < listaProd.size(); i++) {
            obj[0] = listaProd.get(i).getId_producto();
            obj[1] = listaProd.get(i).getNombre();
            obj[2] = listaProd.get(i).getDescripcion();
            obj[3] = listaProd.get(i).getCantidad();
            obj[4] = listaProd.get(i).getPrecio();

            tablaPro.addRow(obj);
        }
        tabla.setModel(tablaPro);
    }

    public void limpiarTablaProducto() {
        for (int i = 0; i < tablaPro.getRowCount(); i++) {
            tablaPro.removeRow(i);
            i = i - 1;
        }
    }

    public void limpiarTxtProducto() {
        idProducto.setText("");
        nombreProducto.setText("");
        descripcionProducto.setText("");
        cantidadProducto.setText("");
        precioProducto.setText("");
    }

    public void agregarProducto() {
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            if (!"".equals(nombreProducto.getText()) && !"".equals(descripcionProducto.getText())
                    && !"".equals(cantidadProducto.getText()) && !"".equals(precioProducto.getText())) {
                String nombre = principal.nombreProducto.getText();
                String descripcion = principal.descripcionProducto.getText();
                int cantidad = Integer.parseInt(principal.cantidadProducto.getText());
                double precio = Double.parseDouble(principal.precioProducto.getText());
                pro.setNombre(nombre);
                pro.setDescripcion(descripcion);
                pro.setCantidad(cantidad);
                pro.setPrecio(precio);
                proDAO.agregarProducto(pro);
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                limpiarTxtProducto();
                limpiarTablaProducto();
                listarProducto(Principal.tablaProductos);
            } else {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            }
        }
    }

    public void tablaActualizar() {
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            int fila = principal.tablaProductos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN FILA");
            } else {
                idProducto.setText(tablaProductos.getValueAt(fila, 0).toString());
                nombreProducto.setText(tablaProductos.getValueAt(fila, 1).toString());
                descripcionProducto.setText(tablaProductos.getValueAt(fila, 2).toString());
                cantidadProducto.setText(tablaProductos.getValueAt(fila, 3).toString());
                precioProducto.setText(tablaProductos.getValueAt(fila, 4).toString());
            }
        }
    }

    public void actualizarProducto() {
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            if ("".equals(idProducto.getText())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN FILA");
            } else {

                pro.setNombre(nombreProducto.getText());
                pro.setDescripcion(descripcionProducto.getText());
                pro.setCantidad(Integer.parseInt(cantidadProducto.getText()));
                pro.setPrecio(Double.parseDouble(precioProducto.getText()));
                pro.setId_producto(Integer.parseInt(idProducto.getText()));
                if (!"".equals(nombreProducto.getText()) || !"".equals(descripcionProducto.getText())
                        || !"".equals(cantidadProducto.getText()) || !"".equals(precioProducto.getText())) {
                    proDAO.actualizar(pro);
                    limpiarTxtProducto();
                    limpiarTablaProducto();
                    listarProducto(principal.tablaProductos);
                }
            }
        }
    }

    public void eliminarProducto() {
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            int fila = principal.tablaProductos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN FILA");
            } else {
                int pregunta = JOptionPane.showConfirmDialog(null, "DESEA ELIMINAR ?");
                if (pregunta == 0) {
                    int id = Integer.parseInt(principal.tablaProductos.getValueAt(fila, 0).toString());
                    proDAO.eliminarProducto(id);

                    limpiarTablaProducto();
                    listarProducto(principal.tablaProductos);
                }
            }
        }
    }

    public void cerrarSesion() {
        Login login = new Login();
        EmpleadoDAO empDAO = new EmpleadoDAO();
        LoginControlador loginControlador = new LoginControlador(login, empDAO);
        login.setVisible(true);
        principal.dispose();
    }

    public void salir() {
        System.exit(0);
    }
}
