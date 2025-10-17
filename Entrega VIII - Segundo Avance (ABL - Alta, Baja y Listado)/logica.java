package claseeeeee1del10h;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class logica {
	MYSQL mysql = new MYSQL();
	
	public static void main(String[] args) {
		VentanaSesion pres1 = new VentanaSesion();
		pres1.setVisible(true);
	}
	
	public boolean ventanaPrestamo() {
		VentanaTablaPrestamo vtnAAA2 = new VentanaTablaPrestamo();
		vtnAAA2.setVisible(true);
		return false;
	}
	
	public boolean InicioSesion(String contraseña1) {		 
		String contrasena = "1234";//Despues se cambia por AlvaroFigueredo	
		if (contraseña1.length() == contrasena.length() ) {
			VentanaTablaLibro vtnAAA8 = new VentanaTablaLibro();
			vtnAAA8.setVisible(true);
		} else {
			JFrame aviso = new JFrame();
			JOptionPane.showMessageDialog(aviso, "No se pudo Iniciar Sesion");
		}
		return false;
		
	}
	
	public boolean VentanaInvL() {
		VentanaInvL vtnInventarioL = new VentanaInvL();
		vtnInventarioL.setVisible(true);
		return false;
	}
	
	public boolean VentanaInvC() {
		VentanaInvC vtnInventarioC = new VentanaInvC();
		vtnInventarioC.setVisible(true);
		return false;
	}
	
	public void limpiar(DefaultTableModel modelo) {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
	}
	
	public void eliminar(int seleccionada,DefaultTableModel modelo) {
		
	}
//LIBRO------------------------------------------------------------------------------------------------------------------------------
	public void registrarPrestamoLibro(String ci,String ISBN, int CantDias) {
		JFrame aviso = new JFrame();
		if (ci.length() < 8 || ISBN.length() < 4 || CantDias < 1) {
			JOptionPane.showMessageDialog(aviso, "No se pudo guardar correctamente");
		} else {
			 mysql.registrarPrestamoLibros(ci,ISBN,CantDias);
			 JOptionPane.showMessageDialog(aviso, "Se guardaron los datos correctamente");
		}
	}
	
	public void GuardarLibroInv(String ISBN,String Titulo, String Autor,String PaisOrigen) {
		JFrame aviso = new JFrame();
		if (ISBN.length() < 4 || Titulo.length() < 1 || Autor.length() < 1) {
			JOptionPane.showMessageDialog(aviso, "No se pudo guardar correctamente");
		} else {
			 mysql.GuardarLibroInvv(ISBN,Titulo,Autor,PaisOrigen);
			 JOptionPane.showMessageDialog(aviso, "Se guardaron los datos correctamente");
		}
	}
	//Compus----------------------------------------------------------------------------------------------------------------------------
	public void registrarPrestamoComputadora(String ID,String ci,String Nombre,String Apellido,int HorasPrestamos,String Grupo) {
		JFrame aviso = new JFrame();
		if (ID.length() < 4 || ci.length() < 8 || Nombre.length() < 1 || Apellido.length() < 1 || HorasPrestamos < 1 ) {
			JOptionPane.showMessageDialog(aviso, "No se pudo guardar correctamente");
		} else {
			 mysql.registrarPrestamoComputadoras(ID,ci,Nombre,Apellido,HorasPrestamos,Grupo);
			 JOptionPane.showMessageDialog(aviso, "Se guardaron los datos correctamente");
		}
	}
	public void GuardarCompuInv(String ID) {
		JFrame aviso = new JFrame();
		if (ID.length() < 4) {
			JOptionPane.showMessageDialog(aviso, "No se pudo guardar correctamente");
		} else {
			 mysql.GuardarCompuInvv(ID);
			 JOptionPane.showMessageDialog(aviso, "Se guardaron los datos correctamente");
		}
	}
	//LISTAR-----------------------------------------------------------------------------------------------------------------------------------
	public void listarL(DefaultTableModel modelo) {
		
		mysql.listarLibros(modelo);
		
	}
  public void listarLibInv(DefaultTableModel modelo) {
		
		mysql.listarInvLibros(modelo);
		
	}
 public void listarC(DefaultTableModel modelo) {
	
	   mysql.listarCompus(modelo);
	
}
public void ListarCompuInv(DefaultTableModel modelo) {
	
	mysql.listarInvCompus(modelo);
	
}
//BAJA------------------------------------------------------------------------------------------------------------------------------------

public void BajaLibroPrestamo(String dato) {
	mysql.BorrarPrestamoLibro(dato);
	 
}
   
   public void BajaLibroInv(String dato) {
		mysql.BorrarInvLibro(dato);
		 
	}
   
   public void BajaCompuPrestamo(String dato) {
		mysql.BorrarPrestamoCompu(dato);
		 
	}
   
   public void BajaCompuInv(String dato) {
		mysql.BorrarInvCompu(dato);
		 
	}
	
}
