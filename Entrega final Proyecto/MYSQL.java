package claseeeeee1del10h;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MYSQL {
	// SERVIDOR-------------------
	/*
	 * private final String DB_URL =
	 * "jdbc:mysql://170.249.219.114/program1_equipo7?useSSL=false"; private final
	 * String DB_USER = "program1_estudiantes"; private final String DB_PASS =
	 * "estudiantesarrayanes";
	 */

	// ip vieja:23.111.185.242
	// ip nueva:170.249.219.114

	// LOCAL---------------------
	private final String DB_URL = "jdbc:mysql://localhost/program1_equipo7?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	}
//check-----------------------------------------
	public boolean chequearExisteLibro(String isbn) {
		boolean resultado = false;
		String sentencia = "SELECT * FROM invlibros WHERE Isbn = " + isbn;
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			if (rs.next()) {
			
				resultado = true;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		return resultado;
	}

	public boolean chequearExisteCompus(String ID) {
		boolean resultado = false;
		String sentencia = "SELECT * FROM invcompus WHERE ID = " + ID;
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			if (rs.next()) {
			
				resultado = true;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		return resultado;
	}
	
	
	public void registrarPrestamoLibros(String ISBN, String ci, String Nombre, String Apellido, int CantDias) {
		String sentencia = "INSERT INTO PrestamoLibros VALUES ('" + ISBN + "','"  + ci + "','"+ Nombre + "','" + Apellido + "','" + CantDias + "')";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

			JOptionPane.showMessageDialog(null, "Se almacenaron los datos correctamente!");
		} catch (SQLException ex) {
		//	JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void GuardarLibroInvv(String ISBN, String Titulo, String Autor, String PaisOrigen) {
		String sentencia = "INSERT INTO invlibros VALUES ('" + ISBN + "','" + Titulo + "','" + Autor + "','"
				+ PaisOrigen + "')";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

			JOptionPane.showMessageDialog(null, "Se almacenaron los datos correctamente!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	// ---------------------------------------------------------------------------------
	public void registrarPrestamoComputadoras(String ci, String Nombre, String Apellido, String ID,
			int CantHorasPrestamos, String Grupo) {
		String sentencia = "INSERT INTO PrestamoCompus VALUES ('" + ci + "','" + Nombre + "','" + Apellido + "','" + ID
				+ "','" + CantHorasPrestamos + "','" + Grupo + "')";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se almacenaron los datos correctamente!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void GuardarCompuInvv(String ID) {
		String sentencia = "INSERT INTO invcompus VALUES ('" + ID + "')";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se almacenaron los datos correctamente!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	// LISTAR
	// LIBROS------------------------------------------------------------------------------

	public void listarLibros(DefaultTableModel modelo) {
		String sentencia = "SELECT* FROM PrestamoLibros";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0);

			while (rs.next()) {
				String ISBN = rs.getString(1);
				String ci = rs.getString(2);
				String Nombre = rs.getString(3);
				String Apellido = rs.getString(4);
				int CantDias = rs.getInt(5);

				Object[] fila = { ISBN,ci, Nombre, Apellido, CantDias };
				modelo.addRow(fila);
			}
		} catch (SQLException ex) {
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

				Object[] fila = { ISBN, Titulo, Autor, PaisOrigen };
				modelo.addRow(fila);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	// LISTAR
	// COMPUS------------------------------------------------------------------------------
	public void listarCompus(DefaultTableModel modelo) {
		String sentencia = "SELECT* FROM PrestamoCompus";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0);

			while (rs.next()) {
				String ci = rs.getString(1);
				String Nombre = rs.getString(2);
				String Apellido = rs.getString(3);
				String ID = rs.getString(4);
				int HorasPrestamos = rs.getInt(5);
				String Grupo = rs.getString(6);

				Object[] fila = { ci, Nombre, Apellido, ID, HorasPrestamos, Grupo };
				modelo.addRow(fila);
			}
		} catch (SQLException ex) {
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

				Object[] fila = { ID };
				modelo.addRow(fila);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	// LIBRO
	// BORRAR---------------------------------------------------------------------------------------------------------------
	public void BorrarPrestamoLibro(String dato) {

		String sentencia = "DELETE FROM PrestamoLibros WHERE isbn ='" + dato + "'";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Elimino correctamente!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void BorrarInvLibro(String dato) {

		String sentencia = "DELETE FROM invlibros WHERE ISBN ='" + dato + "'";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Elimino correctamente!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	// COMPU
	// BORRAR----------------------------------------------------------------------------------------------------------
	public void BorrarPrestamoCompu(String dato) {

		String sentencia = "DELETE FROM PrestamoCompus WHERE ci ='" + dato + "'";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Elimino correctamente!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void BorrarInvCompu(String dato) {

		String sentencia = "DELETE FROM invcompus WHERE ID ='" + dato + "'";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Elimino correctamente!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

}
