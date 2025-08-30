package paquete;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ventanaPrincipal extends JFrame {
	logica gestor = new logica();

	public ventanaPrincipal() {
		JFrame aviso = new JFrame();
		this.setLayout(new FlowLayout());
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		// this.setLayout(new GridLayout(2,1));

		logica gestor = new logica();
		
		JLabel texto1 = new JLabel("Bienvenido al Programa!");
		JLabel texto2 = new JLabel("Porfavor seleccione a donde desea ingresar");
		JButton libro = new JButton("Libro");
		JLabel textoInvisible1 = new JLabel(" ");
		JLabel textoInvisible2 = new JLabel(" ");
		JButton prestamo = new JButton("Prestamo ceibalita");

		JPanel panel1 = new JPanel();

		panel1.add(texto1);
		panel1.add(texto2);
		panel1.add(textoInvisible1);
		panel1.add(libro);
		panel1.add(textoInvisible2);
		panel1.add(prestamo);

		this.add(panel1);

		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		libro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.siguienteVentana()) {

				}
			}
		});

		prestamo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.ventanaPrestamo()) {
				}
			}
		});
	}
}