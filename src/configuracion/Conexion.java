
package configuracion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

   public static Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chosita", "root", "");
            System.out.println("se conecto");

        } catch (Exception e) {
            System.out.println("no se conecto");
        }
        return cn;
    }
    public static void main(String[] args) {
        
         getConnection();
        
        
    }
    
}
