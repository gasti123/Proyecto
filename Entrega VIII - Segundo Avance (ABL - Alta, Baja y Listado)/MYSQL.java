package claseeeeee1del10h;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class MYSQL { 
	private final String DB_URL = "jdbc:mysql://170.249.219.114/program1_equipo7?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";
	//23.111.185.242
	/*private final String DB_URL = "jdbc:mysql://localhost/bdproyecto?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "";*/
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	
	}
	
	
	public void registrarPrestamoLibros(String ci,String ISBN, int CantDias) {
		String sentencia = "INSERT INTO PrestamoLibros VALUES ('" + ci + "','" + ISBN + "','"  + CantDias + "')";
		System.out.println(sentencia);
		
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
	}
	
	public void registrarPrestamoComputadoras(String ID,String ci,String Nombre,String Apellido,int HorasPrestamos,String Grupo) {
		String sentencia = "INSERT INTO PrestamoCompus VALUES ('" + ID + "','" + ci + "','" + Nombre + "','" + Apellido + "','" + HorasPrestamos + "','" + Grupo + "')";
		System.out.println(sentencia);
		
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
	}
	
	public void GuardarLibroInvv(String ISBN,String Titulo, String Autor,String PaisOrigen) {
		String sentencia = "INSERT INTO invlibros VALUES ('" + ISBN + "','" + Titulo + "','"  + Autor + "','" + PaisOrigen + "')";
		System.out.println(sentencia);
		
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
	}
	public void GuardarCompuInvv(String ID) {
		String sentencia = "INSERT INTO invcompus VALUES ('" + ID + "')";
		System.out.println(sentencia);
		
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
	}
	
	//LISTAR LIBROS------------------------------------------------------------------------------
	
	public void listarLibros(DefaultTableModel modelo) {
        String sentencia = "SELECT* FROM PrestamoLibros";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			modelo.setRowCount(0); 
			
			while (rs.next()) {
				
				String ci = rs.getString(1);
				String ISBN = rs.getString(2);
				int CantDias = rs.getInt(3);
	
				Object[] fila = {ci,ISBN,CantDias};
				modelo.addRow(fila);
			}
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	public void listarInvLibros(DefaultTableModel modelo) {
        String sentencia = "SELECT* FROM invlibros";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			modelo.setRowCount(0); 
			
			while (rs.next()) {
				
				String ISBN = rs.getString(1);
				String Titulo = rs.getString(2);
				String Autor = rs.getString(3);
				String PaisOrigen = rs.getString(4);
				
				
				Object[] fila = {ISBN,Titulo,Autor,PaisOrigen};
				modelo.addRow(fila);
			}
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}	
	//LISTAR COMPUS------------------------------------------------------------------------------
		public void listarCompus(DefaultTableModel modelo) {
	        String sentencia = "SELECT* FROM PrestamoCompus";
			try {
				Connection conexion = getConnection();
				PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
				ResultSet rs = declaracionSQL.executeQuery();
				
				modelo.setRowCount(0); 
				
				while (rs.next()) {
					
					String ID = rs.getString(1);
					String ci = rs.getString(2);
					String Nombre = rs.getString(3);
					String Apellido = rs.getString(4);
					int HorasPrestamos = rs.getInt(5);
					String Grupo = rs.getString(6);
				
					
					Object[] fila = {ID,ci,Nombre,Apellido,HorasPrestamos,Grupo};
					modelo.addRow(fila);
				}
			}catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
			
	}
		public void listarInvCompus(DefaultTableModel modelo) {
	        String sentencia = "SELECT* FROM invcompus";
			try {
				Connection conexion = getConnection();
				PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
				ResultSet rs = declaracionSQL.executeQuery();
				
				modelo.setRowCount(0); 
				
				while (rs.next()) {
					
					String ID = rs.getString(1);
		
					Object[] fila = {ID};
					modelo.addRow(fila);
				}
			}catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
		}
		//LIBRO BORRAR---------------------------------------------------------------------------------------------------------------
		public void BorrarPrestamoLibro(String dato) {	      
	      
	      String sentencia = "DELETE FROM PrestamoLibros WHERE ci ='" + dato +"'";
	      System.out.println(sentencia);
			try {
				Connection conexion = getConnection();
				PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
				declaracionSQL.executeUpdate(); 
				
			
			}catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
		}
		
		public void BorrarInvLibro(String dato) {
		      
		      
		      String sentencia = "DELETE FROM invlibros WHERE ISBN ='" + dato +"'";
		      System.out.println(sentencia);
				try {
					Connection conexion = getConnection();
					PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
					declaracionSQL.executeUpdate(); 					
				
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		//COMPU BORRAR----------------------------------------------------------------------------------------------------------
		public void BorrarPrestamoCompu(String dato) {
		      
		      
		      String sentencia = "DELETE FROM PrestamoCompus WHERE ID ='" + dato +"'";
		      System.out.println(sentencia);
				try {
					Connection conexion = getConnection();
					PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
					declaracionSQL.executeUpdate(); 
					
				
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		
		public void BorrarInvCompu(String dato) {	      
		      
		      String sentencia = "DELETE FROM invcompus WHERE ID ='" + dato +"'";
		      System.out.println(sentencia);
				try {
					Connection conexion = getConnection();
					PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
					declaracionSQL.executeUpdate(); 
					
				
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
}
