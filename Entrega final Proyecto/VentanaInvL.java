package claseeeeee1del10h;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class VentanaInvL extends JFrame {

	public VentanaInvL() {
		logica gestor = new logica();

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		Color verdePanel = new Color(80, 150, 140);
		Color blanco = new Color(248, 255, 255);
		Color negro = Color.BLACK;
		Color suplanta = new Color(254, 110, 30);
		Color colorOg = blanco;

		JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
		panelPrincipal.setBackground(verdePanel);
		this.setContentPane(panelPrincipal);

		JPanel panelInterior = new JPanel();
		panelInterior.setLayout(new BoxLayout(panelInterior, BoxLayout.Y_AXIS));
		panelInterior.setBackground(verdePanel);
		panelInterior.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelInterior.setPreferredSize(new Dimension(400, getHeight()));
		panelPrincipal.add(panelInterior, BorderLayout.WEST);

		JLabel titulo = new JLabel("Inventario Libros");
		titulo.setForeground(blanco);
		titulo.setFont(new Font("Oswald", Font.BOLD, 27));
		titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(titulo);
		panelInterior.add(Box.createVerticalStrut(20));

		JLabel labelISBN = new JLabel("ISBN");
		labelISBN.setForeground(blanco);
		labelISBN.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(labelISBN);

		JTextField textISBN = new JTextField();
		textISBN.setPreferredSize(new Dimension(300, 35));
		textISBN.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
		textISBN.setBackground(blanco);
		textISBN.setForeground(negro);
		textISBN.setFont(new Font("Poppins", Font.PLAIN, 14));
		panelInterior.add(textISBN);
		panelInterior.add(Box.createVerticalStrut(10));

		JLabel labelTitulo = new JLabel("Titulo");
		labelTitulo.setForeground(blanco);
		labelTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(labelTitulo);

		JTextField textTitulo = new JTextField();
		textTitulo.setPreferredSize(new Dimension(300, 35));
		textTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
		textTitulo.setBackground(blanco);
		textTitulo.setForeground(negro);
		textTitulo.setFont(new Font("Poppins", Font.PLAIN, 14));
		panelInterior.add(textTitulo);
		panelInterior.add(Box.createVerticalStrut(10));

		JLabel labelAutor = new JLabel("Autor");
		labelAutor.setForeground(blanco);
		labelAutor.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(labelAutor);

		JTextField textAutor = new JTextField();
		textAutor.setPreferredSize(new Dimension(300, 35));
		textAutor.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
		textAutor.setBackground(blanco);
		textAutor.setForeground(negro);
		textAutor.setFont(new Font("Poppins", Font.PLAIN, 14));
		panelInterior.add(textAutor);
		panelInterior.add(Box.createVerticalStrut(10));

		JLabel info1 = new JLabel("* Si es de Literatura completar este campos");
		info1.setForeground(blanco);
		info1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(info1);
		panelInterior.add(Box.createVerticalStrut(10));

		JLabel labelPais = new JLabel("Pais de origen");
		labelPais.setForeground(blanco);
		labelPais.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(labelPais);

		JTextField textPais = new JTextField();
		textPais.setPreferredSize(new Dimension(300, 35));
		textPais.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
		textPais.setBackground(blanco);
		textPais.setForeground(negro);
		textPais.setFont(new Font("Poppins", Font.PLAIN, 14));
		panelInterior.add(textPais);
		panelInterior.add(Box.createVerticalStrut(20));

		JButton añadir = new JButton("Añadir");
		JButton eliminar = new JButton("Eliminar");
		JButton actualizar = new JButton("Actualizar");
		JButton volver = new JButton("Volver");

		JButton[] botones = { añadir, eliminar, actualizar };
		for (JButton b : botones) {
			b.setBackground(colorOg);
			b.setForeground(Color.BLACK);
			b.setFocusPainted(false);
			b.setContentAreaFilled(true);
			b.setOpaque(true);
			b.setBorderPainted(false);
			b.setPreferredSize(new Dimension(300, 45));
			b.setMaximumSize(new Dimension(300, 45));
			b.setAlignmentX(Component.CENTER_ALIGNMENT);

			JPanel contenedor = new JPanel();
			contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.X_AXIS));
			contenedor.setBackground(verdePanel);
			contenedor.add(Box.createHorizontalGlue());
			contenedor.add(b);
			contenedor.add(Box.createHorizontalGlue());

			panelInterior.add(contenedor);
			panelInterior.add(Box.createVerticalStrut(15));
		}

		volver.setBackground(colorOg);
		volver.setForeground(Color.BLACK);
		volver.setFocusPainted(false);
		volver.setContentAreaFilled(true);
		volver.setOpaque(true);
		volver.setBorderPainted(false);
		volver.setPreferredSize(new Dimension(100, 30));

		JPanel panelVolver = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelVolver.setBackground(verdePanel);
		panelVolver.add(volver);
		panelInterior.add(Box.createVerticalStrut(20));
		panelInterior.add(panelVolver);

		JPanel panelTabla = new JPanel(new BorderLayout(10, 10));
		panelTabla.setBackground(verdePanel);
		panelTabla.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelPrincipal.add(panelTabla, BorderLayout.CENTER);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ISBN");
		modelo.addColumn("Titulo");
		modelo.addColumn("Autor");
		modelo.addColumn("Pais Origen");

		JTable tabla = new JTable(modelo);
		tabla.setBackground(blanco);
		tabla.setForeground(negro);
		tabla.setGridColor(Color.GRAY);
		tabla.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setResizable(false);
		}
		tabla.setFont(new Font("Arial", Font.PLAIN, 14));
		tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));

		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		panelTabla.add(scroll, BorderLayout.CENTER);

		añadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ISBN = textISBN.getText();
				String Titulo = textTitulo.getText();
				String Autor = textAutor.getText();
				String PaisOrigen = textPais.getText();

				gestor.GuardarLibroInv(ISBN, Titulo, Autor, PaisOrigen);
				gestor.listarLibInv(modelo);
			}
		});

		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInvL.this.dispose();

			}
		});

		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccionada = tabla.getSelectedRow();
				if (seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaLibroInv(dato);
					gestor.listarLibInv(modelo);
				}

			}
		});

		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.listarLibInv(modelo);
			}
		});

		// ------------------------------------------------------------------------------------------------------------------
		añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				añadir.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				añadir.setBackground(colorOg);
			}
		});

		eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				eliminar.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				eliminar.setBackground(colorOg);
			}
		});

		actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				actualizar.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				actualizar.setBackground(colorOg);
			}
		});

		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				volver.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				volver.setBackground(colorOg);
			}
		});

	}
}