package configuracion;

import com.mysql.jdbc.Connection;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportesExcel {

    public static void main(String arg[]) {
//        reporteProductos();
        //reporteVentas();
        reporteDetalles();
        //String fileName = "REPORTE DE VENTAS";
        String fileName = "REPORTE DE DETALLES VENTAS";
        String home = System.getProperty("user.home");
        abrirReporte(home + "\\Downloads\\" + fileName + ".xlsx");

    }
    
    public static void reporteEmpleados() {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = (Sheet) book.createSheet("Empleados");

        try {
            //logo 
            InputStream logo = new FileInputStream("src/imagenes/Logo.png");
            byte[] bytes = IOUtils.toByteArray(logo);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            logo.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();
            //TAMAÑO DE IMG
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(1);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            //TAMAÑO DE IMG
            pict.resize(3, 8);

            //ESTILO TITULO
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            //FILA DEL TITULO
            Row filaTitulo = sheet.createRow(9);
            //COLUMNA TITULO
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Empleados");
            //FILA INICIO , FILA FIN , COLUM , ULTIMA COLUM
            sheet.addMergedRegion(new CellRangeAddress(9, 10, 1, 3));
            //CABECERA
            String[] cabecera = new String[]{"ID","NOMBRE","DNI","USUARIO","CELULAR","ROL"};

            //ESTILO CABECERA
            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            //FILA PARA ENCABEZADO
            Row filaEncabezados = sheet.createRow(11);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion cn = new Conexion();
            PreparedStatement ps;
            ResultSet rs;

            Connection con = (Connection) cn.getConnection();

            //fila de inicio para guardar  datos
            int numFilaDatos = 12;
            //ESTILO DATOS
            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            String sql = "SELECT id_empleado,nombre,dni,usuario,celular,rol FROM empleado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    CeldaDatos.setCellValue(rs.getString(a + 1));

                }
                numFilaDatos++;
            }
            //ajsute a contenido
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);

            sheet.setZoom(120);
            //genera y ruta
            String fileName = "REPORTE DE EMPLEADOS";
            String home = System.getProperty("user.home");
            File file = new File(home + "\\Downloads\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void reporteProductos() {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = (Sheet) book.createSheet("Producto");

        try {
            //logo 
            InputStream logo = new FileInputStream("src/imagenes/Logo.png");
            byte[] bytes = IOUtils.toByteArray(logo);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            logo.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();
            //TAMAÑO DE IMG
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(1);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            //TAMAÑO DE IMG
            pict.resize(3, 8);

            //ESTILO TITULO
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            //FILA DEL TITULO
            Row filaTitulo = sheet.createRow(9);
            //COLUMNA TITULO
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Productos");
            //FILA INICIO , FILA FIN , COLUM , ULTIMA COLUM
            sheet.addMergedRegion(new CellRangeAddress(9, 10, 1, 3));
            //CABECERA
            String[] cabecera = new String[]{"ID", "NOMBRE", "DESCRIPCION", "CANTIDAD", "PRECIO"};

            //ESTILO CABECERA
            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            //FILA PARA ENCABEZADO
            Row filaEncabezados = sheet.createRow(11);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion cn = new Conexion();
            PreparedStatement ps;
            ResultSet rs;

            Connection con = (Connection) cn.getConnection();

            //fila de inicio para guardar  datos
            int numFilaDatos = 12;
            //ESTILO DATOS
            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            String sql = "SELECT id_producto,nombre,descripcion,cantidad,precio FROM producto";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    CeldaDatos.setCellValue(rs.getString(a + 1));

                }
                numFilaDatos++;
            }
            //ajsute a contenido
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);

            sheet.setZoom(120);
            //genera y ruta
            String fileName = "REPORTE DE PRODUCTOS";
            String home = System.getProperty("user.home");
            File file = new File(home + "\\Downloads\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void reporteVentas() {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = (Sheet) book.createSheet("Ventas");

        try {
            //logo 
            InputStream logo = new FileInputStream("src/imagenes/Logo.png");
            byte[] bytes = IOUtils.toByteArray(logo);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            logo.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();
            //TAMAÑO DE IMG
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(1);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            //TAMAÑO DE IMG
            pict.resize(3, 8);

            //ESTILO TITULO
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            //FILA DEL TITULO
            Row filaTitulo = sheet.createRow(9);
            //COLUMNA TITULO
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Ventas");
            //FILA INICIO , FILA FIN , COLUM , ULTIMA COLUM
            sheet.addMergedRegion(new CellRangeAddress(9, 10, 1, 3));
            //CABECERA
            String[] cabecera = new String[]{"ID VENTA", "ID EMPLEADO","CLIENTE", "FECHA DE VENTA", "MONTO"};

            //ESTILO CABECERA
            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            //FILA PARA ENCABEZADO
            Row filaEncabezados = sheet.createRow(11);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion cn = new Conexion();
            PreparedStatement ps;
            ResultSet rs;

            Connection con = (Connection) cn.getConnection();

            //fila de inicio para guardar  datos
            int numFilaDatos = 12;
            //ESTILO DATOS
            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            String sql = "SELECT id_venta,id_empleado,cliente,fechaVenta,monto FROM nueva_venta";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    CeldaDatos.setCellValue(rs.getString(a + 1));

                }
                numFilaDatos++;
            }
            //ajsute a contenido
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);

            sheet.setZoom(120);
            //genera y ruta
            String fileName = "REPORTE DE VENTAS";
            String home = System.getProperty("user.home");
            File file = new File(home + "\\Downloads\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void reporteDetalles() {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = (Sheet) book.createSheet("Ventas");

        try {
            //logo 
            InputStream logo = new FileInputStream("src/imagenes/Logo.png");
            byte[] bytes = IOUtils.toByteArray(logo);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            logo.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();
            //TAMAÑO DE IMG
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(1);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            //TAMAÑO DE IMG
            pict.resize(3, 8);

            //ESTILO TITULO
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            //FILA DEL TITULO
            Row filaTitulo = sheet.createRow(9);
            //COLUMNA TITULO
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Detalles Ventas");
            //FILA INICIO , FILA FIN , COLUM , ULTIMA COLUM
            sheet.addMergedRegion(new CellRangeAddress(9, 10, 1, 3));
            //CABECERA
            String[] cabecera = new String[]{"ID DETALLES ", "ID VENTA", "PRODUCTO", "CANTIDAD", "PRECIO DE VENTA","FECHA"};

            //ESTILO CABECERA
            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            //FILA PARA ENCABEZADO
            Row filaEncabezados = sheet.createRow(11);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion cn = new Conexion();
            PreparedStatement ps;
            ResultSet rs;

            Connection con = (Connection) cn.getConnection();

            //fila de inicio para guardar  datos
            int numFilaDatos = 12;
            //ESTILO DATOS
            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            String sql = "SELECT id_detallesVentas,id_venta,nombre_producto,cantidad,precioVenta,fechaD FROM detalles_ventas";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    CeldaDatos.setCellValue(rs.getDouble(a + 1));

                }
                numFilaDatos++;
            }
            //ajsute a contenido
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(6);

            sheet.setZoom(120);
            //genera y ruta
            String fileName = "REPORTE DE DETALLES VENTAS";
            String home = System.getProperty("user.home");
            File file = new File(home + "\\Downloads\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ReportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void abrirReporte(String nombreArchivo) {

        try {
            //DEFINIENDO PROPIEDAD FILE

            File objetoFile = new File(nombreArchivo);

            Desktop.getDesktop().open(objetoFile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
