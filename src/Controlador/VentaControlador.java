package Controlador;

import Modelo.Detalle_Venta;
import Modelo.Detalle_VentaDAO;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import configuracion.ReportesExcel;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;
import static vistas.Principal.*;

public class VentaControlador implements ActionListener {

    private Principal principal;
    private VentaDAO ventaDAO;
    private Detalle_VentaDAO detalleDAO;
    EmpleadoDAO empDAO = new EmpleadoDAO();
    Venta venta = new Venta();
    Detalle_Venta deta = new Detalle_Venta();
    ProductoDAO proDAO = new ProductoDAO();
    Producto pro = new Producto();
    DefaultTableModel tablaNuevaV = new DefaultTableModel();
    int objVenta = 0;

    //datos
    int id = 0;
    String nombre = "";
    String descripcion = "";
    int stock = 0;
    double precio = 0;

    double totalPagar = 0;

    DefaultTableModel tablaListaV = new DefaultTableModel();
    DefaultTableModel tablaDetallesV = new DefaultTableModel();

    //busqueda pdf
    //String idVenta="";
    public VentaControlador(Principal principal, VentaDAO ventaDAO, Detalle_VentaDAO detalleDAO) {
        this.principal = principal;
        this.ventaDAO = ventaDAO;
        this.detalleDAO = detalleDAO;

        this.principal.btn_generarVenta.addActionListener(this);
        this.principal.btn_agregarVenta.addActionListener(this);
        this.principal.btn_eliminarVenta.addActionListener(this);
        this.principal.btn_listarVentas.addActionListener(this);
        this.principal.btn_listarDetalles.addActionListener(this);
        this.principal.btn_excelVentas.addActionListener(this);
        this.principal.btn_excelDetalles.addActionListener(this);

        this.principal.btn_seleccionar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Principal.btn_generarVenta) {
            if (!"".equals(principal.lblCliente.getText()) && objVenta >= 1) {
                //JOptionPane.showMessageDialog(null, "VENTA GENERADA");

                generarVenta();

                generarDetalles();
                actualizarCantidad();
                generarComprobante();
                limpiarTablaNuevaV();
                limpiarTxtNuevaVenta();
                TotalPagar();

                principal.limpiarTablaBuscar();
                principal.tablaDatos();
                String fileName = "REPORTE DE VENTA NRO";
                String idVenta = String.valueOf(ventaDAO.ID_venta());
                abrirReportePDF("C:\\Users\\User" + "\\Downloads\\" + fileName + " " + idVenta + ".pdf");
            }
        }
        if (e.getSource() == Principal.btn_agregarVenta) {
            agregarTabla();
        }
        if (e.getSource() == Principal.btn_eliminarVenta) {
            eliminar();
        }
        if (e.getSource() == Principal.btn_seleccionar) {
            seleccionar();
        }
        if (e.getSource() == Principal.btn_listarVentas) {
            limpiarTablaListaVenta();
            listarVenta();
        }
        if (e.getSource() == Principal.btn_listarDetalles) {
            limpiarTablaListaDetalles();
            listarDetalles();
        }
        if (e.getSource() == Principal.btn_excelVentas) {

            ReportesExcel.reporteVentas();
            String fileName = "REPORTE DE VENTAS";
            String home = System.getProperty("user.home");
            ReportesExcel.abrirReporte(home + "\\Downloads\\" + fileName + ".xlsx");

        }
        if (e.getSource() == Principal.btn_excelDetalles) {
            ReportesExcel.reporteDetalles();
            String fileName = "REPORTE DE DETALLES VENTAS";
            String home = System.getProperty("user.home");
            ReportesExcel.abrirReporte(home + "\\Downloads\\" + fileName + ".xlsx");
        }
    }

    public void limpiarTxtNuevaVenta() {
        lblCantidad.setText("");
        lblCliente.setText("");
    }

    public void TotalPagar() {
        totalPagar = 0;
        int numFila = tablaNuevaVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double acumulado = Double.parseDouble(String.valueOf(tablaNuevaVenta.getModel().getValueAt(i, 5)));
            totalPagar = totalPagar + acumulado;
        }
        lblTotal.setText(String.valueOf(totalPagar));
    }

    public void seleccionar() {

        int fila = tablaOpciones.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ELIJA UNA FILA");
        } else {
            id = Integer.parseInt(tablaOpciones.getValueAt(fila, 0).toString());
            nombre = tablaOpciones.getValueAt(fila, 1).toString();
            descripcion = tablaOpciones.getValueAt(fila, 2).toString();
            stock = Integer.parseInt(tablaOpciones.getValueAt(fila, 3).toString());
            precio = Double.parseDouble(tablaOpciones.getValueAt(fila, 4).toString());

            lblCantidad.requestFocus();
        }

    }

    public void agregarTabla() {
        if (!"".equals(nombre) && !"".equals(lblCantidad.getText()) && !"".equals(descripcion) && !"".equals(stock) && !"".equals(precio)) {

            String idV = codigoProductoVenta.getText();
            String nombreV = lblNombre.getText();
            String descripcionv = descripcion;
            int cantidadV = Integer.parseInt(lblCantidad.getText());
            int stockV = stock;
            double precioV = precio;
            double total = cantidadV * precioV;

            if (stock >= cantidadV) {
                objVenta++;
                tablaNuevaV = (DefaultTableModel) tablaNuevaVenta.getModel();

                //no se repitan prioductos
                for (int i = 0; i < tablaNuevaVenta.getRowCount(); i++) {
                    if (tablaNuevaVenta.getValueAt(i, 2).equals(lblNombre.getText())) {
                        JOptionPane.showMessageDialog(null, "EL PRODUCTO SE REPITE, MODIFIQUE LA CANTIDAD");
                        return;

                    }
                }
                ArrayList listaVenta = new ArrayList();
                listaVenta.add(objVenta);
                listaVenta.add(id);
                listaVenta.add(nombre);
                listaVenta.add(descripcion);
                listaVenta.add(cantidadV);
                listaVenta.add(precio);
                listaVenta.add(total);

                Object[] NV = new Object[6];
                NV[0] = listaVenta.get(1);
                NV[1] = listaVenta.get(2);
                NV[2] = listaVenta.get(3);
                NV[3] = listaVenta.get(4);
                NV[4] = listaVenta.get(5);
                NV[5] = listaVenta.get(6);

                tablaNuevaV.addRow(NV);
                tablaNuevaVenta.setModel(tablaNuevaV);

                limpiarTxtNuevaVenta();
                TotalPagar();
            } else {
                JOptionPane.showMessageDialog(null, "NO DISPONIBLE , REABASTECER");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE CANTIDAD");
        }
    }

    public void eliminar() {

        int fila = principal.tablaNuevaVenta.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "SELECCIONA EL PRODUCTO QUE DESEA BORRAR");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "DESEA ELIMINAR ?");
            if (pregunta == 0) {
                tablaNuevaV = (DefaultTableModel) tablaNuevaVenta.getModel();
                tablaNuevaV.removeRow(fila);
                TotalPagar();
            }
            //limpiarNuevaVenta();
        }
    }

    private void generarVenta() {
        int empleado = Integer.parseInt(empDAO.buscarId(usuarioActivo.getText()));
        double monto = totalPagar;
        String cli=lblCliente.getText();
        venta.setId_empleado(empleado);
        venta.setCliente(cli);
        venta.setMonto(monto);
        ventaDAO.grabarVentas(venta);
        JOptionPane.showMessageDialog(null, "VENTA REALIZADA CON EXITO");
    }

    private void generarDetalles() {
        //String f = detalleDAO.buscarFecha(ventaDAO.ID_venta());
        for (int i = 0; i < tablaNuevaVenta.getRowCount(); i++) {
            String nomPro = tablaNuevaVenta.getValueAt(i, 1).toString();
            int cantidad = Integer.parseInt(tablaNuevaVenta.getValueAt(i, 3).toString());
            double precioD = Double.parseDouble(tablaNuevaVenta.getValueAt(i, 4).toString());
            int idVenta = ventaDAO.ID_venta();
            deta.setId_venta(idVenta);
            deta.setNom_producto(nomPro);
            deta.setCantidad(cantidad);
            deta.setPrecioVenta(precioD);

            detalleDAO.grabarDetalles(deta);
        }
    }

    public void actualizarCantidad() {
        for (int i = 0; i < tablaNuevaVenta.getRowCount(); i++) {
            int cod = Integer.parseInt(tablaNuevaVenta.getValueAt(i, 0).toString());
            int cantidadComprada = Integer.parseInt(tablaNuevaVenta.getValueAt(i, 3).toString());
            pro = proDAO.buscarProducto(cod);
            int cantidadActual = pro.getCantidad() - cantidadComprada;
            ventaDAO.actualizarCantidad(cantidadActual, cod);
        }
    }

    public void limpiarTablaNuevaV() {
        for (int i = 0; i < tablaNuevaV.getRowCount(); i++) {
            tablaNuevaV.removeRow(i);
            i = i - 1;
        }
    }

    private void generarComprobante() {

        try {
            int idVenta = ventaDAO.ID_venta();
            FileOutputStream archivo;
            String fileName = "REPORTE DE VENTA NRO";
            String home = System.getProperty("user.home");
            File file = new File(home + "\\Downloads\\" + fileName + " " + idVenta + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/imagenes/Logo.png");

            //FECHA
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();

            fecha.add("FECHA : " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\nHORA : " + new SimpleDateFormat("HH:mm").format(date));

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            //TAMAÑÓ DE COLUMNAS
            float[] ColumnaEncabezado = new float[]{50f, 10f, 60f, 45f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Encabezado.ALIGN_CENTER);

            Encabezado.addCell(img);
            /*
            MEDIO
             */
            String tel = "987654321";
            String ruc = "20756845242";
            String dir = "Lima, MZ. GATITAS LOTE 24 URBANIZACION GATOS";
            String vacio="            ";
            Encabezado.addCell(" ");
            Encabezado.addCell("\nRUC : " + ruc + "\n\nBOLETA DE VENTA " + "\n\n" + vacio + "ID : " + idVenta);
            Encabezado.addCell(fecha);

            doc.add(Encabezado);

            //TELEFONO Y DIRECCION
            Paragraph f = new Paragraph();
            f.add(Chunk.NEWLINE);
            f.add("Telefono:" + tel + "\nDireccion:" + dir + "\n");
            f.setAlignment(Element.ALIGN_LEFT);
            doc.add(f);

            //CLIENTE
            Paragraph cliente = new Paragraph();

            cliente.add(Chunk.NEWLINE);
            String cli = lblCliente.getText();
            cliente.add("CLIENTE  : " + cli);
            doc.add(cliente);

            Paragraph producto = new Paragraph();
            producto.add(Chunk.NEWLINE);
            producto.add("LISTA DE PRODUCTOS" + "\n\n");
            producto.setAlignment(Element.ALIGN_CENTER);
            doc.add(producto);

            //PRODUCTOS DE LA TABLA
            PdfPTable productosComprados = new PdfPTable(4);
            productosComprados.setWidthPercentage(100);
            productosComprados.getDefaultCell().setBorder(0);
            //TAMAÑÓ DE COLUMNAS
            float[] columnaProducto = new float[]{60f, 20f, 20f, 20f};
            productosComprados.setWidths(columnaProducto);
            productosComprados.setHorizontalAlignment(productosComprados.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell pro2 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell pro3 = new PdfPCell(new Phrase("Precio U.", negrita));
            PdfPCell pro4 = new PdfPCell(new Phrase("Precio total", negrita));
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            //BACKGROUND
            pro1.setBackgroundColor(BaseColor.ORANGE);
            pro2.setBackgroundColor(BaseColor.ORANGE);
            pro3.setBackgroundColor(BaseColor.ORANGE);
            //AÑADIR
            pro4.setBackgroundColor(BaseColor.ORANGE);
            productosComprados.addCell(pro1);
            productosComprados.addCell(pro2);
            productosComprados.addCell(pro3);
            productosComprados.addCell(pro4);
            for (int i = 0; i < tablaNuevaVenta.getRowCount(); i++) {
                String nombre = tablaNuevaVenta.getValueAt(i, 1).toString();
                String cantidad = tablaNuevaVenta.getValueAt(i, 3).toString();
                String precioU = tablaNuevaVenta.getValueAt(i, 4).toString();
                String precioT = tablaNuevaVenta.getValueAt(i, 5).toString();

                productosComprados.addCell(nombre);
                productosComprados.addCell(cantidad);
                productosComprados.addCell(precioU);
                productosComprados.addCell(precioT);
            }
            doc.add(productosComprados);

            Paragraph total = new Paragraph();
            total.add(Chunk.NEWLINE);
            total.add("TOTAL : "+"    " + lblTotal.getText());
            total.setAlignment(Element.ALIGN_RIGHT);
            doc.add(total);

            doc.close();
            archivo.close();
            JOptionPane.showMessageDialog(null, "REPORTE PDF GENERADO " + idVenta);

        } catch (Exception e) {
            System.out.println(e.toString());
        }//flipqweasd
    }

    public static void abrirReportePDF(String nombreArchivo) {
        //RUTA
        String file = new String("");
        try {
            //DEFINIENDO PROPIEDAD FILE

            File objetoFile = new File(nombreArchivo);

            Desktop.getDesktop().open(objetoFile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void listarVenta() {
        List<Venta> listaVenta = ventaDAO.listarVenta();
        tablaListaV = (DefaultTableModel) tablaListaVentas.getModel();
        Object[] obj = new Object[5];

        for (int i = 0; i < listaVenta.size(); i++) {
            obj[0] = listaVenta.get(i).getId_venta();
            obj[1] = listaVenta.get(i).getId_empleado();
            obj[2] = listaVenta.get(i).getCliente();
            obj[3] = listaVenta.get(i).getFecha();
            obj[4] = listaVenta.get(i).getMonto();
            tablaListaV.addRow(obj);
        }
        tablaListaVentas.setModel(tablaListaV);
    }

    public void limpiarTablaListaVenta() {
        for (int i = 0; i < tablaListaV.getRowCount(); i++) {
            tablaListaV.removeRow(i);
            i = i - 1;
        }
    }

    public void listarDetalles() {
        List<Detalle_Venta> listaDeta = detalleDAO.listarDetalles();
        tablaDetallesV = (DefaultTableModel) tablaDetallesVentas.getModel();
        Object[] obj = new Object[6];
//        System.out.println(listaVenta.size());
        for (int i = 0; i < listaDeta.size(); i++) {
            obj[0] = listaDeta.get(i).getId_detallesVenta();
            obj[1] = listaDeta.get(i).getId_venta();
            obj[2] = listaDeta.get(i).getNom_producto();
            obj[3] = listaDeta.get(i).getCantidad();
            obj[4] = listaDeta.get(i).getPrecioVenta();
            obj[5] = listaDeta.get(i).getFecha();
            tablaDetallesV.addRow(obj);
        }
        tablaDetallesVentas.setModel(tablaDetallesV);
    }

    public void limpiarTablaListaDetalles() {
        for (int i = 0; i < tablaDetallesV.getRowCount(); i++) {
            tablaDetallesV.removeRow(i);
            i = i - 1;
        }
    }
}
