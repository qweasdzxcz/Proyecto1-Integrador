package vistas;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static vistas.Login.txtPassword;
import static vistas.Login.txtUsuario;

public class Principal extends javax.swing.JFrame {

    Empleado emp = new Empleado();
    EmpleadoDAO empDAO = new EmpleadoDAO();
    DefaultTableModel tablaEmp = new DefaultTableModel();

    Producto pro = new Producto();
    ProductoDAO proDAO = new ProductoDAO();
    DefaultTableModel tablaPro = new DefaultTableModel();

    DefaultTableModel tablaNuevaV = new DefaultTableModel();
    int objVenta;


    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    //EMPLEADO
    public void listarEmpleado() {
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
    //FIN EMPLEADO

    //PRODUCTO
    public void listarProducto() {
        List<Producto> listaProd = proDAO.listarProducto();
        tablaPro = (DefaultTableModel) tablaProductos.getModel();

        Object[] obj = new Object[6];
        for (int i = 0; i < listaProd.size(); i++) {
            obj[0] = listaProd.get(i).getId_producto();
            obj[1] = listaProd.get(i).getNombre();
            obj[2] = listaProd.get(i).getDescripcion();
            obj[3] = listaProd.get(i).getCantidad();
            obj[4] = listaProd.get(i).getPrecio();

            tablaPro.addRow(obj);
        }
        tablaProductos.setModel(tablaPro);
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
    //FIN PRODUCTO
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        NUEVA_VENTA = new javax.swing.JPanel();
        codP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JTextField();
        codigoProductoVenta = new javax.swing.JTextField();
        buscarProducto = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        agregarVenta = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaNuevaVenta = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        EMPLEADOS = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idEmpleado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dniEmpleado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        usuarioEmpleado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passEmpleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        celularEmpleado = new javax.swing.JTextField();
        agregarEmpleado = new javax.swing.JButton();
        actualizarEmpleado = new javax.swing.JButton();
        eliminarEmpleado = new javax.swing.JButton();
        listarEmpleado = new javax.swing.JButton();
        limpiarEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        rolEmpleado = new javax.swing.JComboBox<>();
        PRODUCTOS = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        idProducto = new javax.swing.JTextField();
        descripcionProducto = new javax.swing.JTextField();
        cantidadProducto = new javax.swing.JTextField();
        precioProducto = new javax.swing.JTextField();
        agregarProducto = new javax.swing.JButton();
        actualizarProducto = new javax.swing.JButton();
        listarProducto = new javax.swing.JButton();
        eliminarProducto = new javax.swing.JButton();
        limpiarProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableListaVentas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaDetallesVentas = new javax.swing.JTable();
        panelInicio = new javax.swing.JPanel();
        cerrarSesionPrincipal = new javax.swing.JButton();
        salirPrincipal = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nombreActivo = new javax.swing.JLabel();
        usuarioActivo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        rolActivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NUEVA_VENTA.setForeground(new java.awt.Color(51, 51, 255));

        codP.setText("COD. PRODUCTO");

        jLabel2.setText("DESCRIPCION");

        jLabel3.setText("CANTIDAD");

        jLabel4.setText("STOCK");

        lblCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCantidadActionPerformed(evt);
            }
        });

        codigoProductoVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codigoProductoVenta.setForeground(new java.awt.Color(255, 102, 51));
        codigoProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoProductoVentaActionPerformed(evt);
            }
        });

        buscarProducto.setText("BUSCAR");
        buscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductoActionPerformed(evt);
            }
        });

        jLabel16.setText("NOMBRE");

        lblStock.setForeground(new java.awt.Color(51, 51, 255));

        lblNombre.setForeground(new java.awt.Color(51, 51, 255));

        lblDescripcion.setForeground(new java.awt.Color(51, 51, 255));

        agregarVenta.setText("AGREGAR");
        agregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarVentaActionPerformed(evt);
            }
        });

        jButton2.setText("ELIMINAR");

        jButton3.setText("GENERAR VENTA");

        jLabel19.setText("PRECIO");

        lblPrecio.setForeground(new java.awt.Color(51, 51, 255));

        tablaNuevaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaNuevaVenta);
        if (tablaNuevaVenta.getColumnModel().getColumnCount() > 0) {
            tablaNuevaVenta.getColumnModel().getColumn(0).setPreferredWidth(35);
        }

        jLabel20.setText("TOTAL :");

        javax.swing.GroupLayout NUEVA_VENTALayout = new javax.swing.GroupLayout(NUEVA_VENTA);
        NUEVA_VENTA.setLayout(NUEVA_VENTALayout);
        NUEVA_VENTALayout.setHorizontalGroup(
            NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(buscarProducto)
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                                        .addComponent(agregarVenta)
                                        .addGap(44, 44, 44)
                                        .addComponent(jButton2)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NUEVA_VENTALayout.createSequentialGroup()
                                .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                                        .addComponent(codP, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codigoProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblCantidad)
                                                .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                .addComponent(lblStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(50, 50, 50)))))
                .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NUEVA_VENTALayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(75, 75, 75)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        NUEVA_VENTALayout.setVerticalGroup(
            NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(jLabel20))
                        .addGap(63, 63, 63))
                    .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codP)
                            .addComponent(codigoProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buscarProducto)
                        .addGap(18, 18, 18)
                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarVenta)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("NUEVA VENTA", NUEVA_VENTA);

        jLabel1.setText("ID");

        jLabel5.setText("NOMBRE");

        nombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreEmpleadoActionPerformed(evt);
            }
        });

        jLabel6.setText("DNI");

        dniEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniEmpleadoActionPerformed(evt);
            }
        });

        jLabel7.setText("USUARIO");

        jLabel8.setText("PASSWORD");

        jLabel9.setText("CELULAR");

        agregarEmpleado.setText("AGREGAR");
        agregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEmpleadoActionPerformed(evt);
            }
        });

        actualizarEmpleado.setText("ACTUALIZAR");
        actualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEmpleadoActionPerformed(evt);
            }
        });

        eliminarEmpleado.setText("ELIMINAR");
        eliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEmpleadoActionPerformed(evt);
            }
        });

        listarEmpleado.setText("LISTAR");
        listarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarEmpleadoActionPerformed(evt);
            }
        });

        limpiarEmpleado.setText("LIMPIAR CAMPOS");
        limpiarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarEmpleadoActionPerformed(evt);
            }
        });

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DNI", "USUARIO", "PASSWORD", "CELULAR", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);
        if (tablaEmpleados.getColumnModel().getColumnCount() > 0) {
            tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(60);
            tablaEmpleados.getColumnModel().getColumn(5).setPreferredWidth(65);
        }

        jLabel23.setText("ROL");

        rolEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));

        javax.swing.GroupLayout EMPLEADOSLayout = new javax.swing.GroupLayout(EMPLEADOS);
        EMPLEADOS.setLayout(EMPLEADOSLayout);
        EMPLEADOSLayout.setHorizontalGroup(
            EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADOSLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EMPLEADOSLayout.createSequentialGroup()
                                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADOSLayout.createSequentialGroup()
                                        .addComponent(agregarEmpleado)
                                        .addGap(18, 18, 18))
                                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                                        .addComponent(eliminarEmpleado)
                                        .addGap(17, 17, 17)))
                                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(listarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(actualizarEmpleado)))
                            .addGroup(EMPLEADOSLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(limpiarEmpleado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dniEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(celularEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreEmpleado)
                            .addComponent(rolEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        EMPLEADOSLayout.setVerticalGroup(
            EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADOSLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(dniEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(usuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(passEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(celularEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(rolEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarEmpleado)
                            .addComponent(actualizarEmpleado))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminarEmpleado)
                            .addComponent(listarEmpleado))
                        .addGap(18, 18, 18)
                        .addComponent(limpiarEmpleado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EMPLEADOS", EMPLEADOS);

        jLabel11.setText("ID");

        jLabel12.setText("NOMBRE");

        jLabel13.setText("DESCRIPCION");

        jLabel14.setText("CANTIDAD");

        jLabel15.setText("PRECIO");

        nombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProductoActionPerformed(evt);
            }
        });

        idProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProductoActionPerformed(evt);
            }
        });

        descripcionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionProductoActionPerformed(evt);
            }
        });

        cantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadProductoActionPerformed(evt);
            }
        });

        precioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioProductoActionPerformed(evt);
            }
        });

        agregarProducto.setText("AGREGAR");
        agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoActionPerformed(evt);
            }
        });

        actualizarProducto.setText("ACTUALIZAR");
        actualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarProductoActionPerformed(evt);
            }
        });

        listarProducto.setText("LISTAR");
        listarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarProductoActionPerformed(evt);
            }
        });

        eliminarProducto.setText("ELIMINAR");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });

        limpiarProducto.setText("LIMPIAR CAMPOS");
        limpiarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarProductoActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "CANTIDAD", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductos);

        javax.swing.GroupLayout PRODUCTOSLayout = new javax.swing.GroupLayout(PRODUCTOS);
        PRODUCTOS.setLayout(PRODUCTOSLayout);
        PRODUCTOSLayout.setHorizontalGroup(
            PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PRODUCTOSLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PRODUCTOSLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(descripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PRODUCTOSLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PRODUCTOSLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(73, 73, 73)
                                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PRODUCTOSLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(listarProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(actualizarProducto, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eliminarProducto)
                            .addComponent(agregarProducto)
                            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(limpiarProducto)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        PRODUCTOSLayout.setVerticalGroup(
            PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12))
                            .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarProducto)
                            .addComponent(actualizarProducto))
                        .addGap(18, 18, 18)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminarProducto)
                            .addComponent(listarProducto))
                        .addGap(18, 18, 18)
                        .addComponent(limpiarProducto))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PRODUCTOS", PRODUCTOS);

        tableListaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID VENTA", "ID VENDEDOR", "FECHA", "MONTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableListaVentas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REGISTRO DE VENTAS", jPanel4);

        tablaDetallesVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID DETALLES", "ID VENTAS", "ID PRODUCTO", "CANTIDAD", "PRECIO DE VENTA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaDetallesVentas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DETALLES DE VENTAS", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 830, 500));

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setForeground(new java.awt.Color(255, 153, 51));

        cerrarSesionPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        cerrarSesionPrincipal.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        cerrarSesionPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        cerrarSesionPrincipal.setText("CERRAR SESION");
        cerrarSesionPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionPrincipalActionPerformed(evt);
            }
        });

        salirPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        salirPrincipal.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        salirPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        salirPrincipal.setText("SALIR");
        salirPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirPrincipalActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\INTEGRADOR\\integrador_avance2_1\\build\\classes\\imagenes\\Chosita burger.png")); // NOI18N

        nombreActivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreActivo.setForeground(new java.awt.Color(255, 102, 51));

        usuarioActivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuarioActivo.setForeground(new java.awt.Color(255, 102, 51));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("USUARIO :");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("NOMBRE :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("PRESENTAR");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("ROL :");

        rolActivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rolActivo.setForeground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel10)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rolActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(nombreActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(usuarioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cerrarSesionPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(salirPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cerrarSesionPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salirPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(9, 9, 9)
                                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usuarioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                    .addComponent(nombreActivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(rolActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(panelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoProductoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoProductoVentaActionPerformed

    private void dniEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniEmpleadoActionPerformed

    private void nombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreEmpleadoActionPerformed

    //EMPLEADO
    private void agregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEmpleadoActionPerformed
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO ESTAS AUTORIZADO");
        } else {
            if (!"".equals(nombreEmpleado.getText()) && !"".equals(dniEmpleado.getText())
                    && !"".equals(usuarioEmpleado.getText()) && !"".equals(passEmpleado.getText())
                    && !"".equals(celularEmpleado.getText())) {

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
                listarEmpleado();
            } else {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            }
        }
    }//GEN-LAST:event_agregarEmpleadoActionPerformed

    private void listarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarEmpleadoActionPerformed
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO ESTAS AUTORIZADO");

        } else {
            limpiarTablaEmpleado();
            listarEmpleado();
        }
    }//GEN-LAST:event_listarEmpleadoActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        int fila = tablaEmpleados.rowAtPoint(evt.getPoint());
        idEmpleado.setText(tablaEmpleados.getValueAt(fila, 0).toString());
        nombreEmpleado.setText(tablaEmpleados.getValueAt(fila, 1).toString());
        dniEmpleado.setText(tablaEmpleados.getValueAt(fila, 2).toString());
        usuarioEmpleado.setText(tablaEmpleados.getValueAt(fila, 3).toString());
        passEmpleado.setText(tablaEmpleados.getValueAt(fila, 4).toString());
        celularEmpleado.setText(tablaEmpleados.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void actualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarEmpleadoActionPerformed
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
                if (!"".equals(dniEmpleado.getText()) || !"".equals(nombreEmpleado.getText()) || !"".equals(usuarioEmpleado.getText()) || !"".equals(passEmpleado.getText()) || !"".equals(celularEmpleado.getText())) {
                    empDAO.actualizarEmpleado(emp);
                    limpiarTxtEmpleado();
                    limpiarTablaEmpleado();
                    listarEmpleado();
                }
            }
        }

    }//GEN-LAST:event_actualizarEmpleadoActionPerformed

    private void limpiarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarEmpleadoActionPerformed
        limpiarTxtEmpleado();
    }//GEN-LAST:event_limpiarEmpleadoActionPerformed

    private void eliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEmpleadoActionPerformed
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            if (!"".equals(idEmpleado.getText())) {
                int pregunta = JOptionPane.showConfirmDialog(null, "DESEA ELIMINAR ?");
                if (pregunta == 0) {
                    int id = Integer.parseInt(idEmpleado.getText());
                    empDAO.eliminarEmpleado(id);
                    limpiarTxtEmpleado();
                    limpiarTablaEmpleado();
                    listarEmpleado();
                } else {
                    limpiarTxtEmpleado();
                }
            }
        }
    }//GEN-LAST:event_eliminarEmpleadoActionPerformed
    //FIN EMPLEADO

    private void idProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProductoActionPerformed

    private void nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProductoActionPerformed

    private void descripcionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionProductoActionPerformed

    private void cantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProductoActionPerformed

    private void precioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioProductoActionPerformed

    //PRODUCTO
    private void limpiarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarProductoActionPerformed
        limpiarTxtProducto();
    }//GEN-LAST:event_limpiarProductoActionPerformed

    private void listarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarProductoActionPerformed
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            limpiarTablaProducto();
            listarProducto();
        }
    }//GEN-LAST:event_listarProductoActionPerformed

    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            if (!"".equals(idProducto.getText())) {
                int pregunta = JOptionPane.showConfirmDialog(null, "DESEA ELIMINAR ?");
                if (pregunta == 0) {
                    int id = Integer.parseInt(idProducto.getText());
                    proDAO.eliminarProducto(id);
                    limpiarTxtProducto();
                    limpiarTablaProducto();
                    listarProducto();
                } else {
                    limpiarTxtProducto();
                }
            }
        }
    }//GEN-LAST:event_eliminarProductoActionPerformed

    private void agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoActionPerformed
        if (rolActivo.getText().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "NO AUTORIZADO");
        } else {
            if (!"".equals(nombreProducto.getText()) && !"".equals(descripcionProducto.getText())
                    && !"".equals(cantidadProducto.getText()) && !"".equals(precioProducto.getText())) {

                pro.setNombre(nombreProducto.getText());
                pro.setDescripcion(descripcionProducto.getText());
                pro.setCantidad(Integer.parseInt(cantidadProducto.getText()));
                pro.setPrecio(Double.parseDouble(precioProducto.getText()));
                proDAO.agregarProducto(pro);
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                limpiarTxtProducto();
                limpiarTablaProducto();
                listarProducto();
            } else {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            }
        }
    }//GEN-LAST:event_agregarProductoActionPerformed

    //VENTA BUSQUEDA
    private void buscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductoActionPerformed
         String codProducto = codigoProductoVenta.getText();
        //diferente de vacio
        if (!"".equals(codProducto)) {
            int a = Integer.parseInt(codProducto);
            pro = proDAO.buscar(a);
            if (pro.getId_producto() > 0) {

                lblNombre.setText(pro.getNombre());
                lblDescripcion.setText(pro.getDescripcion());
                lblStock.setText(Integer.toString(pro.getCantidad()));
                lblPrecio.setText(Double.toString(pro.getPrecio()));
                lblCantidad.requestFocus();

            } else {
                lblNombre.setText("");
                lblDescripcion.setText("");
                lblCantidad.setText("");
                lblStock.setText("");
                lblPrecio.setText("");
                codigoProductoVenta.requestFocus();
                JOptionPane.showMessageDialog(null, "NO ENCONTRADO");
            }
        } else {
            lblNombre.setText("");
            lblDescripcion.setText("");
            lblCantidad.setText("");
            lblStock.setText("");
            lblPrecio.setText("");
            codigoProductoVenta.requestFocus();
            JOptionPane.showMessageDialog(null, "LLENAR CAMPO");
        }
    }//GEN-LAST:event_buscarProductoActionPerformed

    private void lblCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCantidadActionPerformed

    private void salirPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirPrincipalActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirPrincipalActionPerformed
    //TABLA PRODUCTO
    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int fila = tablaProductos.rowAtPoint(evt.getPoint());
        idProducto.setText(tablaProductos.getValueAt(fila, 0).toString());
        nombreProducto.setText(tablaProductos.getValueAt(fila, 1).toString());
        descripcionProducto.setText(tablaProductos.getValueAt(fila, 2).toString());
        cantidadProducto.setText(tablaProductos.getValueAt(fila, 3).toString());
        precioProducto.setText(tablaProductos.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void actualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarProductoActionPerformed
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
                if (!"".equals(nombreProducto.getText()) || !"".equals(descripcionProducto.getText()) || !"".equals(cantidadProducto.getText()) || !"".equals(precioProducto.getText())) {
                    proDAO.actualizar(pro);
                    limpiarTxtProducto();
                    limpiarTablaProducto();
                    listarProducto();
                }
            }
        }
    }//GEN-LAST:event_actualizarProductoActionPerformed

    private void cerrarSesionPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionPrincipalActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_cerrarSesionPrincipalActionPerformed

    private void agregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarVentaActionPerformed
        if (!"".equals(lblCantidad.getText())) {
            String id = codigoProductoVenta.getText();
            String nombre = lblNombre.getText();
            String descripcion = lblDescripcion.getText();
            int cantidad = Integer.parseInt(lblCantidad.getText());
            int stock = Integer.parseInt(lblStock.getText());
            double precio = Double.parseDouble(lblPrecio.getText());
            double total = cantidad * precio;

            if (stock >= cantidad) {
                objVenta++;
                tablaNuevaV = (DefaultTableModel) tablaNuevaVenta.getModel();
                ArrayList listaVenta = new ArrayList();
                listaVenta.add(objVenta);
                listaVenta.add(id);
                listaVenta.add(nombre);
                listaVenta.add(descripcion);
                listaVenta.add(cantidad);
                listaVenta.add(precio);
                listaVenta.add(total);

                Object[] NV = new Object[7];
                NV[0] = listaVenta.get(0);
                NV[1] = listaVenta.get(1);
                NV[2] = listaVenta.get(2);
                NV[3] = listaVenta.get(3);
                NV[4] = listaVenta.get(4);
                NV[5] = listaVenta.get(5);
                NV[6] = listaVenta.get(6);

                tablaNuevaV.addRow(NV);
                tablaNuevaVenta.setModel(tablaNuevaV);
            } else {
                JOptionPane.showMessageDialog(null, "NO DISPONIBLE , REABASTECER");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE CANTIDAD");
        }
    }//GEN-LAST:event_agregarVentaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EMPLEADOS;
    private javax.swing.JPanel NUEVA_VENTA;
    private javax.swing.JPanel PRODUCTOS;
    private javax.swing.JButton actualizarEmpleado;
    private javax.swing.JButton actualizarProducto;
    private javax.swing.JButton agregarEmpleado;
    private javax.swing.JButton agregarProducto;
    private javax.swing.JButton agregarVenta;
    private javax.swing.JButton buscarProducto;
    private javax.swing.JTextField cantidadProducto;
    private javax.swing.JTextField celularEmpleado;
    private javax.swing.JButton cerrarSesionPrincipal;
    private javax.swing.JLabel codP;
    private javax.swing.JTextField codigoProductoVenta;
    private javax.swing.JTextField descripcionProducto;
    private javax.swing.JTextField dniEmpleado;
    private javax.swing.JButton eliminarEmpleado;
    private javax.swing.JButton eliminarProducto;
    private javax.swing.JTextField idEmpleado;
    private javax.swing.JTextField idProducto;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lblCantidad;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JButton limpiarEmpleado;
    private javax.swing.JButton limpiarProducto;
    private javax.swing.JButton listarEmpleado;
    private javax.swing.JButton listarProducto;
    public static javax.swing.JLabel nombreActivo;
    private javax.swing.JTextField nombreEmpleado;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JTextField passEmpleado;
    private javax.swing.JTextField precioProducto;
    public static javax.swing.JLabel rolActivo;
    private javax.swing.JComboBox<String> rolEmpleado;
    private javax.swing.JButton salirPrincipal;
    private javax.swing.JTable tablaDetallesVentas;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaNuevaVenta;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tableListaVentas;
    public static javax.swing.JLabel usuarioActivo;
    private javax.swing.JTextField usuarioEmpleado;
    // End of variables declaration//GEN-END:variables

    private String String(Object selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
