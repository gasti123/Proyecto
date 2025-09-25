package pruebaUno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaTablaLibro extends JFrame{
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
		modelo.addColumn("Cant Dias Prestados");
		modelo.addColumn("Codigo");
		modelo.addColumn("Pais Origen");
		
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(106, 189, 169));
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(106, 189, 169));
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
		JLabel libros = new JLabel("Cantidad de Libros a prestar         ");
		JSpinner texto4 = new JSpinner();
		texto4.setMaximumSize(new Dimension(150, 25));
		JLabel texto6 = new JLabel(" ");
		JLabel texto7 = new JLabel("Es de literatura?");
		texto7.setMaximumSize(new Dimension(150, 25));
		JLabel bienvenido = new JLabel("Bienvenido al Programa!");
		bienvenido.setFont(new Font("Oswald", Font.BOLD, 30));
		JLabel texto8 = new JLabel(" ");
		JLabel texto9 = new JLabel(" ");
		
		JButton boton = new JButton("Registrar Préstamo");
		JButton boton2 = new JButton("Volver");
		JButton prestamo = new JButton("Prestamo Ceibalita");
		
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
		panel1.add(prestamo);
		panel1.add(texto8);
		panel1.add(boton2);
		this.add(panel1, BorderLayout.WEST);
		this.add(panel2, BorderLayout.NORTH);
		panel2.add(bienvenido);
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
		prestamo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.ventanaPrestamo()) {
				}
			}
		});
	
	}

}
