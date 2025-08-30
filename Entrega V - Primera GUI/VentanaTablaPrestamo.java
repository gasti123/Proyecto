package paquete;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTablaPrestamo extends JFrame {
	logica gestor = new logica();
	JFrame aviso = new JFrame();

	public VentanaTablaPrestamo() {
		this.setTitle("Préstamo de Computadoras");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("CI");
		modelo.addColumn("Cantidad de equipos a prestar");
		modelo.addColumn("A que grupo pertenece el estudiante");
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);

		JPanel panel1 = new JPanel();

		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		JLabel nombre = new JLabel("Nombre ");
		JTextField texto1 = new JTextField();
		texto1.setMaximumSize(new Dimension(150, 25));

		JLabel apellido = new JLabel("Apellido ");
		JTextField texto2 = new JTextField();
		texto2.setMaximumSize(new Dimension(150, 25));

		JLabel Ci = new JLabel("CI ");
		JTextField texto3 = new JTextField();
		texto3.setMaximumSize(new Dimension(150, 25));

		JLabel prestamo = new JLabel("Dias del prestamo ");
		JTextField texto4 = new JTextField();
		texto4.setMaximumSize(new Dimension(150, 25));

		JLabel compu = new JLabel("Cantidad de equipos a prestar");
		JSpinner texto5 = new JSpinner();
		texto5.setMaximumSize(new Dimension(150, 25));

		JLabel texto6 = new JLabel("Es un estudiante ?");
		texto6.setMaximumSize(new Dimension(150, 25));
		JCheckBox caja = new JCheckBox();

		JLabel texto7 = new JLabel(" ");
		JButton boton = new JButton("Registrar Préstamo");
		JButton boton2 = new JButton("Volver");
		panel1.add(nombre);
		panel1.add(texto1);
		panel1.add(apellido);
		panel1.add(texto2);
		panel1.add(Ci);
		panel1.add(texto3);
		panel1.add(prestamo);
		panel1.add(texto4);
		panel1.add(compu);
		panel1.add(texto5);
		panel1.add(texto6);
		panel1.add(caja);
		panel1.add(boton);
		panel1.add(texto7);
		panel1.add(boton2);
		this.add(panel1, BorderLayout.WEST);
		this.add(scroll, BorderLayout.CENTER);

		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(aviso, "Datos Guardados!");

			}
		});
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTablaPrestamo.this.dispose();
			}
		});
		caja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.mostrarGrupo()) {
				}
			}
		});

	}
}
