package claseeeeee1del10h;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class logica {
	MYSQL mysql = new MYSQL();
	//-------------------------------------VENTANAS------------------------------------
	public static void main(String[] args) {
		VentanaSesion VentanaInicio = new VentanaSesion();
		VentanaInicio.setVisible(true);
	}
	
	public boolean ventanaPrestamoCeibalita() {
		VentanaTablaCompu vtnTablaCompu = new VentanaTablaCompu();
		vtnTablaCompu.setVisible(true);
		return false;
	}
	
	public boolean InicioSesion(String contraseña1) {		 
		String contrasena = "AlvaroFigueredo";	
		if (contraseña1.equals(contrasena)) {
			VentanaTablaLibro vtnTablaLibro = new VentanaTablaLibro();
			vtnTablaLibro.setVisible(true);
		} else {
			JFrame aviso = new JFrame();
			JOptionPane.showMessageDialog(aviso, "No se pudo Iniciar Sesión");
		}
		return false;	
	}
	
	public boolean VentanaInvL() {
		VentanaInvL vtnInvL = new VentanaInvL();
		vtnInvL.setVisible(true);
		return false;
	}
	
	public boolean VentanaInvC() {
		VentanaInvC vtnInvC = new VentanaInvC();
		vtnInvC.setVisible(true);
		return false;
	}
	
	//---------------------------FUNCIONES-----------------------------------------------
	
//LIBRO------------------------------------------------------------------------------------------------------------------------------
	public void registrarPrestamoLibro(int ci,String Nombre,String Apellido,String ISBN, int CantDias) {
		if (ci < 8 || Nombre.length() < 1 ||  Apellido.length() < 1 ||  ISBN.length() < 17 || CantDias < 1) {
			JOptionPane.showMessageDialog(null, "No fue posible guardar la informacion correctamente");
		} else {
			 mysql.registrarPrestamoLibros(ci,Nombre,Apellido,ISBN,CantDias);
			 
		}
	}
	
	public void GuardarLibroInv(String ISBN,String Titulo, String Autor,String PaisOrigen) {
		if (ISBN.length() < 17 || Titulo.length() < 1 || Autor.length() < 1) {
			JOptionPane.showMessageDialog(null, "No fue posible guardar la informacion correctamente");
		} else {
			 mysql.GuardarLibroInvv(ISBN,Titulo,Autor,PaisOrigen);
		}
	}
	//Compus----------------------------------------------------------------------------------------------------------------------------
	//parametros
	public void registrarPrestamoComputadora(int ci,String Nombre,String Apellido,String ID,int CantHorasPrestamos,String Grupo) {
		if (ci < 8 || Nombre.length() < 1 || Apellido.length() < 1 || ID.length() < 4 || CantHorasPrestamos < 1 ) {
			JOptionPane.showMessageDialog(null, "No fue posible guardar la informacion correctamente");
		} else {
			 mysql.registrarPrestamoComputadoras(ci,Nombre,Apellido,ID,CantHorasPrestamos,Grupo);
			
		}
	}
	public void GuardarCompuInv(String ID) {
		if (ID.length() < 4) {
			JOptionPane.showMessageDialog(null, "No fue posible guardar la informacion correctamente");
		} else {
			 mysql.GuardarCompuInvv(ID);
		}
	}
	//LISTAR-----------------------------------------------------------------------------------------------------------------------------------
	public void listarLibroPrestamo(DefaultTableModel modelo) {
		
		mysql.listarLibros(modelo);
		
	}
  public void listarLibInv(DefaultTableModel modelo) {
		
		mysql.listarInvLibros(modelo);
		
	}
 public void listarCompuPrestamo(DefaultTableModel modelo) {
	
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
