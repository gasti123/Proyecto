package paquete;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTablaLibro extends JFrame {
	logica gestor = new logica();
	JFrame aviso = new JFrame();

	public VentanaTablaLibro() {
		this.setTitle("Prestamo de Libros");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ISBN");
		modelo.addColumn("Titulo");
		modelo.addColumn("Autor");
		modelo.addColumn("Cant Libros Prestados");
		modelo.addColumn(" ");
		modelo.addColumn("Codigo");
		modelo.addColumn("Pais Origen");
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);

		JPanel panel1 = new JPanel();

		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		JLabel ISBN = new JLabel("ISBN ");
		JTextField texto1 = new JTextField();
		texto1.setMaximumSize(new Dimension(150, 25));

		JLabel Titulo = new JLabel("Titulo ");
		JTextField texto2 = new JTextField();
		texto2.setMaximumSize(new Dimension(150, 25));

		JLabel Autor = new JLabel("Autor ");
		JTextField texto3 = new JTextField();
		texto3.setMaximumSize(new Dimension(150, 25));

		JLabel libros = new JLabel("Cantidad de Libros a prestar");
		JSpinner texto4 = new JSpinner();
		texto4.setMaximumSize(new Dimension(150, 25));

		JLabel texto6 = new JLabel(" ");
		JButton boton = new JButton("Registrar Préstamo");
		JButton boton2 = new JButton("Volver");
		JLabel texto7 = new JLabel("Es de literatura?");
		texto7.setMaximumSize(new Dimension(150, 25));
		JCheckBox caja = new JCheckBox();

		panel1.add(ISBN);
		panel1.add(texto1);
		panel1.add(Titulo);
		panel1.add(texto2);
		panel1.add(Autor);
		panel1.add(texto3);
		panel1.add(libros);
		panel1.add(texto4);
		panel1.add(texto7);
		panel1.add(caja);
		panel1.add(boton);
		panel1.add(texto6);
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
				VentanaTablaLibro.this.dispose();
			}
		});

		caja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.mostrarLiteratura()) {
				}
			}
		});

	}
}
