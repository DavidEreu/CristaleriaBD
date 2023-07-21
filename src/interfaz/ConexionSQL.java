package interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionSQL {
	
	/**
	 * Obtenerconexion():
	 * 
	 * Este metodo lo que realiza es obtener la conexion a la base de datos y poder tener la correcta relacion para 
	 * utilizarla.
	 * 
	 * @return
	 */
    public static Connection Obtenerconexion() {
        
        String Url = "jdbc:sqlserver://localhost:1433;"
                + "database= cristaleria3;"
                + "user=sa;"
                + "password= 1998juanjose;"
                + "trustServerCertificate=true;";
        try {
            Connection cn = DriverManager.getConnection(Url);
            //JOptionPane.showMessageDialog(null, "Se conecto a la base de datos");
            return cn;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos" + ex);

        }
        return null;
    }
    
	public static void main(String[] args) {	
		
		Connection pruebaCn=ConexionSQL.Obtenerconexion();	
		
		if(pruebaCn != null) {		
			System.out.println("Conectado");
			System.out.println(pruebaCn);		
		}else {		
			System.out.println("Desconectado");			
		}	
	}
}
