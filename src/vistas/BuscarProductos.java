package vistas;

import Modelo.ProductoDAO;
import Modelo.Producto;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarProductos extends javax.swing.JFrame {

    Producto pro = new Producto();
    ProductoDAO proDAO = new ProductoDAO();
    DefaultTableModel tablaPro = new DefaultTableModel();

    Principal principal = new Principal();

    String filtro = "id";

    public BuscarProductos() {
        initComponents();
        setLocationRelativeTo(null);
        tablaDatos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtValor = new javax.swing.JTextField();
        jcxBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_listar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 39, 190, 32));

        jcxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NOMBRE" }));
        jPanel1.add(jcxBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 39, 113, 32));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PROD.", "NOMBRE", "DESCRIPCION", "STOCK", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(25);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 115, 552, 437));

        btn_listar.setText("listar");
        btn_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 89, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarActionPerformed
//        if(!"".equals(txtValor.getText())){
//            limpiarTablaProducto();
//            listarProducto();
//            
//        }else {
        // limpiarTablaProducto();
        // tablaDatos();   


    }//GEN-LAST:event_btn_listarActionPerformed

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char validar = evt.getKeyChar();
        if (jcxBuscar.getSelectedItem() == "ID") {
            if (Character.isLetter(validar)) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(null, "INGRESE SOLO NUMEROS");
            }
        }
        if (jcxBuscar.getSelectedItem() == "NOMBRE") {
            if (Character.isDigit(validar)) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS");
            }
        }
        limpiarTablaProducto();
        tablaDatos();
    }//GEN-LAST:event_txtValorKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int pregunta = JOptionPane.showConfirmDialog(null, "DESEA EL PRODUCTO ?");
        if (pregunta == 0) {
            boolean vis=true;
            Principal inicio = new Principal();
            inicio.setVisible(vis);
            int fila = tabla.rowAtPoint(evt.getPoint());
            Principal.codigoProductoVenta.setText(tabla.getValueAt(fila, 0).toString());
            Principal.lblNombre.setText(tabla.getValueAt(fila, 1).toString());
            Principal.lblDescripcion.setText(tabla.getValueAt(fila, 2).toString());
            Principal.lblStock.setText(tabla.getValueAt(fila, 3).toString());
            Principal.lblPrecio.setText(tabla.getValueAt(fila, 4).toString());
        
            
           //BuscarProductos buscarP=new BuscarProductos();     
            
            
        }
    }//GEN-LAST:event_tablaMouseClicked

    public void limpiarTablaProducto() {
        for (int i = 0; i < tablaPro.getRowCount(); i++) {
            tablaPro.removeRow(i);
            i = i - 1;
        }
    }

    void tablaDatos() {
        String a = txtValor.getText();
        if (jcxBuscar.getSelectedItem() == "ID") {
            filtro = "id_producto";
        }
        if (jcxBuscar.getSelectedItem() == "NOMBRE") {
            filtro = "nombre";
        }
        List<Producto> listaProd = proDAO.b(filtro, a);
        //System.out.println("filtro : " + filtro + "\n" + "valor : " + a);
        tablaPro = (DefaultTableModel) tabla.getModel();

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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_listar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcxBuscar;
    public static javax.swing.JTable tabla;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
