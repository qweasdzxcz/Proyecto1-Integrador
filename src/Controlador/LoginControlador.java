package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.ProductoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.Login;
import static vistas.Login.lblMensaje;
import static vistas.Login.txtPassword;
import static vistas.Login.txtUsuario;
import vistas.Principal;

public class LoginControlador implements ActionListener {

    private Login login;
    private EmpleadoDAO empDAO;
    Empleado emp = new Empleado();

    public LoginControlador(Login login, EmpleadoDAO empDAO) {
        this.login = login;
        this.empDAO = empDAO;
        this.login.btn_ingresar.addActionListener(this);
        this.login.btn_salir.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.btn_ingresar) {
            validar();
        }
        if (e.getSource() == login.btn_salir) {
            System.exit(0);
        }
    }

    public void validar() {
        String usuario = txtUsuario.getText();
        String contraseña = String.valueOf(txtPassword.getPassword());

        //diferente de vacio
        if (!"".equals(usuario) && !"".equals(contraseña)) {
            emp = empDAO.validar(usuario, contraseña);
            if (emp.getUsuario() != null && emp.getContraseña() != null) {

                ProductoDAO proDAO = new ProductoDAO();
                Principal principal = new Principal();

                ProductoControlador producControlador = new ProductoControlador(principal, proDAO);

                principal.setVisible(true);

                String nombre = empDAO.buscarNombre(usuario);
                String rol = empDAO.buscarRol(usuario);

                Principal.usuarioActivo.setText(txtUsuario.getText());
                Principal.nombreActivo.setText(nombre);
                Principal.rolActivo.setText(rol);

                login.dispose();

            } else {
                txtUsuario.setText("");
                txtPassword.setText("");
                txtUsuario.requestFocus();
                lblMensaje.setText("      " + "USUARIO O CONTRASEÑA INCORRECTO");
            }
        } else if (!"".equals(usuario) && "".equals(contraseña)) {
            txtPassword.requestFocus();
            lblMensaje.setText("              " + "INGRESE CONTRASEÑA");

        } else if ("".equals(usuario) && !"".equals(contraseña)) {
            txtUsuario.requestFocus();
            lblMensaje.setText("              " + "INGRESE USUARIO");

        } else {
            txtUsuario.requestFocus();
            lblMensaje.setText("     " + "INGRESE USUARIO Y CONTRASEÑA");
        }
    }

//    private void dispose() {
//        Login lo=new Login();
//        lo.setVisible(false);
//        
//    }
}
