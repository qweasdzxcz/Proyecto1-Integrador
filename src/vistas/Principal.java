package vistas;

import Controlador.EmpleadoControlador;

import Controlador.ProductoControlador;
import Controlador.VentaControlador;

import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;

import Modelo.VentaDAO;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Atxy2k.CustomTextField.RestrictedTextField;
import Modelo.Detalle_VentaDAO;

public final class Principal extends javax.swing.JFrame {

    Producto pro = new Producto();
    ProductoDAO proDAO = new ProductoDAO();
    DefaultTableModel tablaPro = new DefaultTableModel();

    String filtro = "id_producto";
    DefaultTableModel tablaBuscar = new DefaultTableModel();

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/dos.png")).getImage());
        tablaDatos();
        restricciones();
    }

    public void restricciones() {

        //EMPLEADOS
        RestrictedTextField nomEmp = new RestrictedTextField(nombreEmpleado);
        nomEmp.setLimit(30);
        nomEmp.setAcceptSpace(true);
        nomEmp.setOnlyText(true);

        RestrictedTextField dniEmp = new RestrictedTextField(dniEmpleado);
        dniEmp.setLimit(8);
        dniEmp.setOnlyNums(true);

        RestrictedTextField userEmp = new RestrictedTextField(usuarioEmpleado);
        userEmp.setLimit(10);

        RestrictedTextField passEmp = new RestrictedTextField(passEmpleado);
        nomEmp.setLimit(10);

        RestrictedTextField celEmp = new RestrictedTextField(celularEmpleado);
        celEmp.setLimit(8);
        celEmp.setOnlyNums(true);

        //PRODUCTO
        RestrictedTextField nomPro = new RestrictedTextField(nombreProducto);
        nomPro.setLimit(30);
        nomPro.setAcceptSpace(true);
        nomPro.setOnlyText(true);

        RestrictedTextField descriPro = new RestrictedTextField(descripcionProducto);
        descriPro.setLimit(30);
        descriPro.setAcceptSpace(true);
        descriPro.setOnlyText(true);

        RestrictedTextField cantiProd = new RestrictedTextField(cantidadProducto);
        cantiProd.setLimit(3);
        cantiProd.setOnlyNums(true);

        RestrictedTextField precioProd = new RestrictedTextField(precioProducto);
        precioProd.setLimit(3);
        precioProd.setOnlyNums(true);

        //VENTA
        RestrictedTextField cli = new RestrictedTextField(lblCliente);
        cli.setLimit(30);
        cli.setOnlyText(true);
        cli.setAcceptSpace(true);

        RestrictedTextField cantiV = new RestrictedTextField(lblCantidad);
        cantiV.setLimit(3);
        cantiV.setOnlyNums(true);
    }

    //TABLA BUSCAR
    public void tablaDatos() {
        String a = txtValor.getText();
        if (jcxBuscar.getSelectedItem() == "ID") {
            filtro = "id_producto";
        }
        if (jcxBuscar.getSelectedItem() == "NOMBRE") {
            filtro = "nombre";
        }
        List<Producto> listaProd = proDAO.b(filtro, a);
        //System.out.println("filtro : " + filtro + "\n" + "valor : " + a);
        tablaBuscar = (DefaultTableModel) tablaOpciones.getModel();

        Object[] obj = new Object[5];
        for (int i = 0; i < listaProd.size(); i++) {
            obj[0] = listaProd.get(i).getId_producto();
            obj[1] = listaProd.get(i).getNombre();
            obj[2] = listaProd.get(i).getDescripcion();
            obj[3] = listaProd.get(i).getCantidad();
            obj[4] = listaProd.get(i).getPrecio();

            tablaBuscar.addRow(obj);
        }
        tablaOpciones.setModel(tablaBuscar);
    }

    public void limpiarTablaBuscar() {
        for (int i = 0; i < tablaBuscar.getRowCount(); i++) {
            tablaBuscar.removeRow(i);
            i = i - 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        NUEVA_VENTA = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtValor = new javax.swing.JTextField();
        jcxBuscar = new javax.swing.JComboBox<>();
        btn_agregarVenta = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaOpciones = new javax.swing.JTable();
        lblCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_seleccionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaNuevaVenta = new javax.swing.JTable();
        btn_eliminarVenta = new javax.swing.JButton();
        btn_generarVenta = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JTextField();
        EMPLEADOS = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        btn_agregarEmpleado = new javax.swing.JButton();
        btn_actualizarEmpleado = new javax.swing.JButton();
        btn_eliminarEmpleado = new javax.swing.JButton();
        btn_listarEmpleado = new javax.swing.JButton();
        btn_limpiarTxtEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        rolEmpleado = new javax.swing.JComboBox<>();
        idEmpleado = new javax.swing.JLabel();
        btn_editarEmpleado = new javax.swing.JButton();
        btn_excelEmpleados = new javax.swing.JButton();
        PRODUCTOS = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        descripcionProducto = new javax.swing.JTextField();
        cantidadProducto = new javax.swing.JTextField();
        precioProducto = new javax.swing.JTextField();
        btn_agregarProducto = new javax.swing.JButton();
        btn_actualizarProducto = new javax.swing.JButton();
        btn_listarProducto = new javax.swing.JButton();
        btn_eliminarProducto = new javax.swing.JButton();
        btn_limpiarTxtProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        idProducto = new javax.swing.JLabel();
        btn_excelProductos = new javax.swing.JButton();
        btn_editarProducto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaVentas = new javax.swing.JTable();
        btn_excelVentas = new javax.swing.JButton();
        btn_listarVentas = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaDetallesVentas = new javax.swing.JTable();
        btn_excelDetalles = new javax.swing.JButton();
        btn_listarDetalles = new javax.swing.JButton();
        panelInicio = new javax.swing.JPanel();
        btn_cerrarSesionPrincipal = new javax.swing.JButton();
        btn_salirPrincipal = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        nombreActivo = new javax.swing.JLabel();
        usuarioActivo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        rolActivo = new javax.swing.JLabel();
        codigoProductoVenta = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 51));

        NUEVA_VENTA.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR PRODUCTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtValor.setToolTipText("");
        txtValor.setAutoscrolls(false);
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        jcxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NOMBRE" }));

        btn_agregarVenta.setText("AGREGAR");
        btn_agregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarVentaActionPerformed(evt);
            }
        });

        tablaOpciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "STOCK", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOpcionesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaOpciones);
        if (tablaOpciones.getColumnModel().getColumnCount() > 0) {
            tablaOpciones.getColumnModel().getColumn(0).setPreferredWidth(15);
            tablaOpciones.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaOpciones.getColumnModel().getColumn(2).setPreferredWidth(120);
            tablaOpciones.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablaOpciones.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 153, 51));
        lblCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCantidadActionPerformed(evt);
            }
        });
        lblCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblCantidadKeyTyped(evt);
            }
        });

        jLabel2.setText("CANTIDAD");

        btn_seleccionar.setText("SELECT");
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_seleccionar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_agregarVenta)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_agregarVenta)
                        .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_seleccionar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tablaNuevaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "CANT.", "PRECIO", "TOTAL"
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
            tablaNuevaVenta.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaNuevaVenta.getColumnModel().getColumn(1).setPreferredWidth(180);
            tablaNuevaVenta.getColumnModel().getColumn(2).setPreferredWidth(120);
            tablaNuevaVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablaNuevaVenta.getColumnModel().getColumn(4).setPreferredWidth(30);
            tablaNuevaVenta.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        btn_eliminarVenta.setText("ELIMINAR");
        btn_eliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarVentaActionPerformed(evt);
            }
        });

        btn_generarVenta.setText("GENERAR VENTA");
        btn_generarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarVentaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("TOTAL :");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("CLIENTE");

        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 153, 51));
        lblCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblClienteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btn_generarVenta)
                        .addGap(34, 34, 34)
                        .addComponent(btn_eliminarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_eliminarVenta)
                        .addComponent(btn_generarVenta)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NUEVA_VENTALayout = new javax.swing.GroupLayout(NUEVA_VENTA);
        NUEVA_VENTA.setLayout(NUEVA_VENTALayout);
        NUEVA_VENTALayout.setHorizontalGroup(
            NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NUEVA_VENTALayout.setVerticalGroup(
            NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NUEVA_VENTALayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(NUEVA_VENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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

        btn_agregarEmpleado.setText("AGREGAR");
        btn_agregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarEmpleadoActionPerformed(evt);
            }
        });

        btn_actualizarEmpleado.setText("ACTUALIZAR");
        btn_actualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarEmpleadoActionPerformed(evt);
            }
        });

        btn_eliminarEmpleado.setText("ELIMINAR");
        btn_eliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarEmpleadoActionPerformed(evt);
            }
        });

        btn_listarEmpleado.setText("LISTAR");
        btn_listarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarEmpleadoActionPerformed(evt);
            }
        });

        btn_limpiarTxtEmpleado.setText("LIMPIAR CAMPOS");
        btn_limpiarTxtEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarTxtEmpleadoActionPerformed(evt);
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
            tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(25);
            tablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(60);
            tablaEmpleados.getColumnModel().getColumn(5).setPreferredWidth(65);
        }

        jLabel23.setText("ROL");

        rolEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));

        idEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idEmpleado.setForeground(new java.awt.Color(255, 102, 51));

        btn_editarEmpleado.setText("EDITAR");

        btn_excelEmpleados.setText("REPORTE EXCEL");

        javax.swing.GroupLayout EMPLEADOSLayout = new javax.swing.GroupLayout(EMPLEADOS);
        EMPLEADOS.setLayout(EMPLEADOSLayout);
        EMPLEADOSLayout.setHorizontalGroup(
            EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADOSLayout.createSequentialGroup()
                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EMPLEADOSLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADOSLayout.createSequentialGroup()
                                        .addComponent(btn_agregarEmpleado)
                                        .addGap(18, 18, 18))
                                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                                        .addComponent(btn_eliminarEmpleado)
                                        .addGap(17, 17, 17)))
                                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_listarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_actualizarEmpleado))
                                .addGap(18, 18, 18)
                                .addComponent(btn_editarEmpleado))
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
                                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(celularEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarioEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dniEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rolEmpleado, 0, 300, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, EMPLEADOSLayout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(idEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_excelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_limpiarTxtEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        EMPLEADOSLayout.setVerticalGroup(
            EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADOSLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EMPLEADOSLayout.createSequentialGroup()
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(idEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addComponent(btn_agregarEmpleado)
                            .addComponent(btn_actualizarEmpleado)
                            .addComponent(btn_editarEmpleado))
                        .addGap(18, 18, 18)
                        .addGroup(EMPLEADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_eliminarEmpleado)
                            .addComponent(btn_listarEmpleado))
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiarTxtEmpleado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_excelEmpleados)
                .addContainerGap(27, Short.MAX_VALUE))
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

        btn_agregarProducto.setText("AGREGAR");
        btn_agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarProductoActionPerformed(evt);
            }
        });

        btn_actualizarProducto.setText("ACTUALIZAR");
        btn_actualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarProductoActionPerformed(evt);
            }
        });

        btn_listarProducto.setText("LISTAR");
        btn_listarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarProductoActionPerformed(evt);
            }
        });

        btn_eliminarProducto.setText("ELIMINAR");
        btn_eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarProductoActionPerformed(evt);
            }
        });

        btn_limpiarTxtProducto.setText("LIMPIAR CAMPOS");
        btn_limpiarTxtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarTxtProductoActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "STOCK", "PRECIO"
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
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        idProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idProducto.setForeground(new java.awt.Color(255, 102, 51));

        btn_excelProductos.setText("REPORTE EN EXCEL");
        btn_excelProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelProductosActionPerformed(evt);
            }
        });

        btn_editarProducto.setText("EDITAR");

        javax.swing.GroupLayout PRODUCTOSLayout = new javax.swing.GroupLayout(PRODUCTOS);
        PRODUCTOS.setLayout(PRODUCTOSLayout);
        PRODUCTOSLayout.setHorizontalGroup(
            PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(108, 108, 108))
                                    .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PRODUCTOSLayout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(70, 70, 70))
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel13)))
                                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(descripcionProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(precioProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(nombreProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_agregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_eliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_listarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_actualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btn_editarProducto))))
                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_excelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(btn_limpiarTxtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        PRODUCTOSLayout.setVerticalGroup(
            PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PRODUCTOSLayout.createSequentialGroup()
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel13)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel14)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel15))
                            .addGroup(PRODUCTOSLayout.createSequentialGroup()
                                .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(descripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_agregarProducto)
                            .addComponent(btn_actualizarProducto)
                            .addComponent(btn_editarProducto))
                        .addGap(18, 18, 18)
                        .addGroup(PRODUCTOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_eliminarProducto)
                            .addComponent(btn_listarProducto))
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiarTxtProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btn_excelProductos)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PRODUCTOS", PRODUCTOS);

        tablaListaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID VENTA", "ID VENDEDOR", "CLIENTE", "FECHA", "MONTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaListaVentas);

        btn_excelVentas.setText("EXCEL");
        btn_excelVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelVentasActionPerformed(evt);
            }
        });

        btn_listarVentas.setText("LISTAR");
        btn_listarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_excelVentas)
                    .addComponent(btn_listarVentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_excelVentas)
                        .addGap(18, 18, 18)
                        .addComponent(btn_listarVentas))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REGISTRO DE VENTAS", jPanel4);

        tablaDetallesVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID DETALLES", "ID VENTAS", "PRODUCTO", "CANTIDAD", "PRECIO DE VENTA", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaDetallesVentas);

        btn_excelDetalles.setText("EXCEL");
        btn_excelDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelDetallesActionPerformed(evt);
            }
        });

        btn_listarDetalles.setText("LISTAR");
        btn_listarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_excelDetalles)
                    .addComponent(btn_listarDetalles))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btn_excelDetalles)
                        .addGap(18, 18, 18)
                        .addComponent(btn_listarDetalles))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DETALLES DE VENTAS", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1140, 520));

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setForeground(new java.awt.Color(255, 153, 51));

        btn_cerrarSesionPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        btn_cerrarSesionPrincipal.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_cerrarSesionPrincipal.setText("CERRAR SESION");
        btn_cerrarSesionPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionPrincipalActionPerformed(evt);
            }
        });

        btn_salirPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        btn_salirPrincipal.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_salirPrincipal.setText("SALIR");
        btn_salirPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirPrincipalActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.png"))); // NOI18N

        nombreActivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombreActivo.setForeground(new java.awt.Color(255, 102, 51));

        usuarioActivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioActivo.setForeground(new java.awt.Color(255, 102, 51));
        usuarioActivo.setText("admin");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("USUARIO :");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("NOMBRE :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("ROL :");

        rolActivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rolActivo.setForeground(new java.awt.Color(255, 102, 51));

        codigoProductoVenta.setEditable(false);
        codigoProductoVenta.setBackground(new java.awt.Color(255, 255, 255));
        codigoProductoVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codigoProductoVenta.setForeground(new java.awt.Color(255, 255, 255));
        codigoProductoVenta.setBorder(null);
        codigoProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoProductoVentaActionPerformed(evt);
            }
        });

        lblNombre.setBackground(new java.awt.Color(0, 0, 0));
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("n");

        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("de");

        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));

        lblStock.setForeground(new java.awt.Color(255, 255, 255));
        lblStock.setText("stoc");

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(logo)
                .addGap(162, 162, 162)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rolActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(nombreActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(usuarioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(codigoProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cerrarSesionPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_salirPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInicioLayout.createSequentialGroup()
                                        .addComponent(codigoProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelInicioLayout.createSequentialGroup()
                                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usuarioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel18)
                                            .addComponent(nombreActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rolActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22)))))
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(btn_cerrarSesionPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_salirPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)))
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 200));

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

    private void btn_agregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarEmpleadoActionPerformed

    }//GEN-LAST:event_btn_agregarEmpleadoActionPerformed

    private void btn_listarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarEmpleadoActionPerformed

    }//GEN-LAST:event_btn_listarEmpleadoActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked

    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void btn_actualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarEmpleadoActionPerformed

    }//GEN-LAST:event_btn_actualizarEmpleadoActionPerformed

    private void btn_limpiarTxtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarTxtEmpleadoActionPerformed
        //limpiarTxtEmpleado();
    }//GEN-LAST:event_btn_limpiarTxtEmpleadoActionPerformed

    private void btn_eliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarEmpleadoActionPerformed

    }//GEN-LAST:event_btn_eliminarEmpleadoActionPerformed

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

    private void btn_limpiarTxtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarTxtProductoActionPerformed

    }//GEN-LAST:event_btn_limpiarTxtProductoActionPerformed

    private void btn_listarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarProductoActionPerformed

    }//GEN-LAST:event_btn_listarProductoActionPerformed

    private void btn_eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarProductoActionPerformed

    }//GEN-LAST:event_btn_eliminarProductoActionPerformed

    private void btn_agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarProductoActionPerformed

    }//GEN-LAST:event_btn_agregarProductoActionPerformed

    private void lblCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCantidadActionPerformed

    }//GEN-LAST:event_lblCantidadActionPerformed

    private void btn_salirPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirPrincipalActionPerformed

    }//GEN-LAST:event_btn_salirPrincipalActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked

    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btn_actualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarProductoActionPerformed

    }//GEN-LAST:event_btn_actualizarProductoActionPerformed

    private void btn_cerrarSesionPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionPrincipalActionPerformed

    }//GEN-LAST:event_btn_cerrarSesionPrincipalActionPerformed

    private void btn_excelProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelProductosActionPerformed

    }//GEN-LAST:event_btn_excelProductosActionPerformed

    private void btn_excelVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelVentasActionPerformed

    }//GEN-LAST:event_btn_excelVentasActionPerformed

    private void btn_excelDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelDetallesActionPerformed

    }//GEN-LAST:event_btn_excelDetallesActionPerformed

    private void btn_listarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarVentasActionPerformed

    }//GEN-LAST:event_btn_listarVentasActionPerformed

    private void btn_listarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarDetallesActionPerformed

    }//GEN-LAST:event_btn_listarDetallesActionPerformed

    private void btn_agregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarVentaActionPerformed


    }//GEN-LAST:event_btn_agregarVentaActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btn_eliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarVentaActionPerformed

    }//GEN-LAST:event_btn_eliminarVentaActionPerformed

    private void btn_generarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarVentaActionPerformed

    }//GEN-LAST:event_btn_generarVentaActionPerformed

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char validar = evt.getKeyChar();
        if (jcxBuscar.getSelectedItem() == "ID") {
            if (Character.isLetter(validar)) {
                getToolkit().beep();
                evt.consume();
                // JOptionPane.showMessageDialog(null, "INGRESE SOLO NUMEROS");
            }
        }
        if (jcxBuscar.getSelectedItem() == "NOMBRE") {
            if (Character.isDigit(validar)) {
                getToolkit().beep();
                evt.consume();
                // JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS");           
            }
        }
        limpiarTablaBuscar();
        tablaDatos();
    }//GEN-LAST:event_txtValorKeyTyped

    private void tablaOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOpcionesMouseClicked
    

    }//GEN-LAST:event_tablaOpcionesMouseClicked

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void lblCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblCantidadKeyTyped

    }//GEN-LAST:event_lblCantidadKeyTyped

    private void lblClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblClienteKeyTyped
//        char validar = evt.getKeyChar();
//        if (jcxBuscar.getSelectedItem() == "NOMBRE") {
//            if (Character.isDigit(validar)) {
//                getToolkit().beep();
//                evt.consume();
//                JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS");
//            }
//        }
    }//GEN-LAST:event_lblClienteKeyTyped

    public static void main(String args[]) {
        Principal principal = new Principal();

        ProductoDAO proDAO = new ProductoDAO();
        EmpleadoDAO empDAO = new EmpleadoDAO();
        VentaDAO ventaDAO = new VentaDAO();
        Detalle_VentaDAO detalleDAO =new Detalle_VentaDAO();
        
        ProductoControlador producControlador = new ProductoControlador(principal, proDAO);
        EmpleadoControlador empleControlador = new EmpleadoControlador(principal, empDAO);
        VentaControlador ventaControlador = new VentaControlador(principal, ventaDAO, detalleDAO);

        principal.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EMPLEADOS;
    private javax.swing.JPanel NUEVA_VENTA;
    private javax.swing.JPanel PRODUCTOS;
    public static javax.swing.JButton btn_actualizarEmpleado;
    public static javax.swing.JButton btn_actualizarProducto;
    public static javax.swing.JButton btn_agregarEmpleado;
    public static javax.swing.JButton btn_agregarProducto;
    public static javax.swing.JButton btn_agregarVenta;
    public static javax.swing.JButton btn_cerrarSesionPrincipal;
    public static javax.swing.JButton btn_editarEmpleado;
    public static javax.swing.JButton btn_editarProducto;
    public static javax.swing.JButton btn_eliminarEmpleado;
    public static javax.swing.JButton btn_eliminarProducto;
    public static javax.swing.JButton btn_eliminarVenta;
    public static javax.swing.JButton btn_excelDetalles;
    public static javax.swing.JButton btn_excelEmpleados;
    public static javax.swing.JButton btn_excelProductos;
    public static javax.swing.JButton btn_excelVentas;
    public static javax.swing.JButton btn_generarVenta;
    public static javax.swing.JButton btn_limpiarTxtEmpleado;
    public static javax.swing.JButton btn_limpiarTxtProducto;
    public static javax.swing.JButton btn_listarDetalles;
    public static javax.swing.JButton btn_listarEmpleado;
    public static javax.swing.JButton btn_listarProducto;
    public static javax.swing.JButton btn_listarVentas;
    public static javax.swing.JButton btn_salirPrincipal;
    public static javax.swing.JButton btn_seleccionar;
    public static javax.swing.JTextField cantidadProducto;
    public static javax.swing.JTextField celularEmpleado;
    public static javax.swing.JTextField codigoProductoVenta;
    public static javax.swing.JTextField descripcionProducto;
    public static javax.swing.JTextField dniEmpleado;
    public static javax.swing.JLabel idEmpleado;
    public static javax.swing.JLabel idProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JComboBox<String> jcxBuscar;
    public static javax.swing.JTextField lblCantidad;
    public static javax.swing.JTextField lblCliente;
    public static javax.swing.JLabel lblDescripcion;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblPrecio;
    public static javax.swing.JLabel lblStock;
    public static javax.swing.JLabel lblTotal;
    private javax.swing.JLabel logo;
    public static javax.swing.JLabel nombreActivo;
    public static javax.swing.JTextField nombreEmpleado;
    public static javax.swing.JTextField nombreProducto;
    private javax.swing.JPanel panelInicio;
    public static javax.swing.JTextField passEmpleado;
    public static javax.swing.JTextField precioProducto;
    public static javax.swing.JLabel rolActivo;
    public static javax.swing.JComboBox<String> rolEmpleado;
    public static javax.swing.JTable tablaDetallesVentas;
    public static javax.swing.JTable tablaEmpleados;
    public static javax.swing.JTable tablaListaVentas;
    public static javax.swing.JTable tablaNuevaVenta;
    public static javax.swing.JTable tablaOpciones;
    public static javax.swing.JTable tablaProductos;
    public static javax.swing.JTextField txtValor;
    public static javax.swing.JLabel usuarioActivo;
    public static javax.swing.JTextField usuarioEmpleado;
    // End of variables declaration//GEN-END:variables

    private String String(Object selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
