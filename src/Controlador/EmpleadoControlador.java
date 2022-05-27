package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;
import static vistas.Principal.*;
import configuracion.ReportesExcel;

public class EmpleadoControlador implements ActionListener {

    private Principal principal;
    private EmpleadoDAO empDAO;
    Empleado emp = new Empleado();
    DefaultTableModel tablaEmp = new DefaultTableModel();

    public EmpleadoControlador(Principal principal, EmpleadoDAO empDAO) {
        this.principal = principal;
        this.empDAO = empDAO;
        this.principal.btn_agregarEmpleado.addActionListener(this);
        this.principal.btn_listarEmpleado.addActionListener(this);
        this.principal.btn_limpiarTxtEmpleado.addActionListener(this);
        this.principal.btn_eliminarEmpleado.addActionListener(this);
        this.principal.btn_actualizarEmpleado.addActionListener(this);
        this.principal.btn_editarEmpleado.addActionListener(this);
        this.principal.btn_excelEmpleados.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Principal.btn_agregarEmpleado) {
            if (rolActivo.getText().equals("Vendedor")) {
                JOptionPane.showMessageDialog(null, "NO ESTAS AUTORIZADO");
            } else {
                agregarEmpleado();
                limpiarTablaEmpleado();
                listarEmpleado(tablaEmpleados);
            }
        }
        if (e.getSource() == Principal.btn_editarEmpleado) {
            if (rolActivo.getText().equals("Vendedor")) {
                JOptionPane.showMessageDialog(null, "NO ESTAS AUTORIZADO");
            } else {
                editarEmpleado();
            }
        }
        if (e.getSource() == Principal.btn_actualizarEmpleado) {
            if (rolActivo.getText().equals("Vendedor")) {
                JOptionPane.showMessageDialog(null, "NO ESTAS AUTORIZADO");
            } else {
                actualizarEmpleado();
            }
        }
        if (e.getSource() == Principal.btn_eliminarEmpleado) {
            eliminarEmpleado();
        }
        if (e.getSource() == Principal.btn_listarEmpleado) {
            limpiarTablaEmpleado();
            listarEmpleado(principal.tablaEmpleados);
        }
        if (e.getSource() == Principal.btn_limpiarTxtEmpleado) {
            limpiarTxtEmpleado();
        }
        if (e.getSource() == Principal.btn_excelEmpleados) {
            ReportesExcel.reporteEmpleados();
            String fileName = "REPORTE DE EMPLEADOS";
            String home = System.getProperty("user.home");
            ReportesExcel.abrirReporte(home + "\\Downloads\\" + fileName + ".xlsx");
        }
    }

    public void listarEmpleado(JTable tabla) {

        List<Empleado> listaEmple = empDAO.listarEmpleado();
        tablaEmp = (DefaultTableModel) tablaEmpleados.getModel();
        Object[] obj = new Object[7];
        for (int i = 0; i < listaEmple.size(); i++) {
            obj[0] = listaEmple.get(i).getId_empleado();
            obj[1] = listaEmple.get(i).getNombre();
            obj[2] = listaEmple.get(i).getDni();
            obj[3] = listaEmple.get(i).getUsuario();
            obj[4] = listaEmple.get(i).getContraseña();
            obj[5] = listaEmple.get(i).getCelular();
            obj[6] = listaEmple.get(i).getRol();
            tablaEmp.addRow(obj);
        }
        tablaEmpleados.setModel(tablaEmp);
    }

    public void limpiarTablaEmpleado() {
        for (int i = 0; i < tablaEmp.getRowCount(); i++) {
            tablaEmp.removeRow(i);
            i = i - 1;
        }
    }

    public void limpiarTxtEmpleado() {
        idEmpleado.setText("");
        nombreEmpleado.setText("");
        dniEmpleado.setText("");
        usuarioEmpleado.setText("");
        passEmpleado.setText("");
        celularEmpleado.setText("");
    }

    public void agregarEmpleado() {

        if (!"".equals(nombreEmpleado.getText()) && !"".equals(dniEmpleado.getText())
                && !"".equals(usuarioEmpleado.getText()) && !"".equals(passEmpleado.getText())
                && !"".equals(celularEmpleado.getText()) && rolEmpleado.getSelectedIndex() >= 0) {

            emp.setNombre(nombreEmpleado.getText());
            emp.setDni(dniEmpleado.getText());
            emp.setUsuario(usuarioEmpleado.getText());
            emp.setContraseña(passEmpleado.getText());
            emp.setCelular(celularEmpleado.getText());
            emp.setRol(rolEmpleado.getSelectedItem().toString());
            empDAO.agregarEmpleado(emp);
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
            limpiarTxtEmpleado();
            limpiarTablaEmpleado();
            listarEmpleado(principal.tablaEmpleados);
        } else {
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
        }
    }

    public void editarEmpleado() {
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            int fila = principal.tablaEmpleados.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN FILA");
            } else {
                idEmpleado.setText(tablaEmpleados.getValueAt(fila, 0).toString());
                nombreEmpleado.setText(tablaEmpleados.getValueAt(fila, 1).toString());
                dniEmpleado.setText(tablaEmpleados.getValueAt(fila, 2).toString());
                usuarioEmpleado.setText(tablaEmpleados.getValueAt(fila, 3).toString());
                passEmpleado.setText(tablaEmpleados.getValueAt(fila, 4).toString());
                celularEmpleado.setText(tablaEmpleados.getValueAt(fila, 5).toString());
                rolEmpleado.setSelectedItem(tablaEmpleados.getValueAt(fila, 6).toString());
            }
        }
    }

    public void actualizarEmpleado() {
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO ESTAS AUTORIZADO");

        } else {
            if ("".equals(idEmpleado.getText())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN FILA");
            } else {
                emp.setDni(dniEmpleado.getText());
                emp.setNombre(nombreEmpleado.getText());
                emp.setUsuario(usuarioEmpleado.getText());
                emp.setContraseña(passEmpleado.getText());
                emp.setCelular(celularEmpleado.getText());
                emp.setRol(rolEmpleado.getSelectedItem().toString());
                emp.setId_empleado(Integer.parseInt(idEmpleado.getText()));
                if (!"".equals(dniEmpleado.getText()) || !"".equals(nombreEmpleado.getText())
                        || !"".equals(usuarioEmpleado.getText()) || !"".equals(passEmpleado.getText())
                        || !"".equals(celularEmpleado.getText()) || !"".equals(rolEmpleado.getSelectedItem().toString())) {
                    empDAO.actualizarEmpleado(emp);
                    limpiarTxtEmpleado();
                    limpiarTablaEmpleado();
                    listarEmpleado(principal.tablaEmpleados);
                }
            }
        }
    }

    public void eliminarEmpleado() {
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            int fila = principal.tablaProductos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN FILA");
            } else {
                int pregunta = JOptionPane.showConfirmDialog(null, "DESEA ELIMINAR ?");
                if (pregunta == 0) {
                    int id = Integer.parseInt(principal.tablaEmpleados.getValueAt(fila, 0).toString());
                    empDAO.eliminarEmpleado(id);

                    limpiarTablaEmpleado();
                    listarEmpleado(principal.tablaEmpleados);
                }
            }
        }
    }

}
