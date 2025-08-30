package paquete;

public class logica {

	public boolean mostrarLiteratura() {
		vtnLiteratura vtnB1 = new vtnLiteratura();
		vtnB1.setVisible(true);
		return false;
	}

	public static void main(String[] args) {
		VentanaSesion pres1 = new VentanaSesion();
		pres1.setVisible(true);
	}

	public boolean iniciarSesion() {

		ventanaPrincipal vtnA1 = new ventanaPrincipal();
		vtnA1.setVisible(true);
		return false;

	}

	public boolean ventanaPrestamo() {
		VentanaTablaPrestamo vtnAAA2 = new VentanaTablaPrestamo();
		vtnAAA2.setVisible(true);
		return false;

	}

	public boolean siguienteVentana() {
		VentanaTablaLibro vtnAAA8 = new VentanaTablaLibro();
		vtnAAA8.setVisible(true);
		return false;

	}
	public boolean mostrarGrupo() {
		ventanaGrupo ventamita = new ventanaGrupo();
		ventamita.setVisible(true);
		return false;
	}
}
