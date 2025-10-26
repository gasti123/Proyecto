package claseeeeee1del10h;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class VentanaInvC extends JFrame {

	public VentanaInvC() {

		logica gestor = new logica();


		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		

		Color verde = new Color(80, 150, 140);
		Color blanco = new Color(248, 255, 255);
		Color negro = Color.BLACK;
		Color suplanta = new Color(254, 110, 30);

		
		Font fuenteTitulo = new Font("Oswald", Font.BOLD, 27);

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBackground(verde);
		this.setContentPane(panelPrincipal);

		JPanel panelIzquierdo = new JPanel(new BorderLayout());
		panelIzquierdo.setBackground(verde);
		panelIzquierdo.setPreferredSize(new Dimension(400, getHeight()));
		panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);

		JPanel panelInterior = new JPanel();
		panelInterior.setLayout(new BoxLayout(panelInterior, BoxLayout.Y_AXIS));
		panelInterior.setBackground(verde);
		panelInterior.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelIzquierdo.add(panelInterior, BorderLayout.CENTER);

		JLabel vacio = new JLabel("		");

		JLabel titulo = new JLabel("Inventario Ceibalitas");
		titulo.setForeground(blanco);
		titulo.setFont(fuenteTitulo);
		titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(titulo);
		panelInterior.add(Box.createVerticalStrut(20));

		JLabel labelID = new JLabel("ID");
		labelID.setFont(new Font("Poppins", Font.BOLD, 14));
		labelID.setForeground(blanco);
		labelID.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(labelID);

		JTextField textID = new JTextField();
		textID.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
		textID.setBackground(blanco);
		textID.setForeground(negro);
	
		
		panelInterior.add(textID);
		panelInterior.add(Box.createVerticalStrut(20));
		panelInterior.add(vacio);

		JButton añadir = new JButton("Añadir");
		JButton eliminar = new JButton("Eliminar");
		JButton actualizar = new JButton("Actualizar");

		JButton[] botones = { añadir, eliminar, actualizar };
		for (JButton b : botones) {
			b.setBackground(blanco);
			b.setForeground(negro);
			b.setFocusPainted(false);
			b.setContentAreaFilled(true);
			b.setOpaque(true);
			b.setBorderPainted(false);
			b.setPreferredSize(new Dimension(300, 45));
			b.setMaximumSize(new Dimension(300, 45));
			b.setAlignmentX(Component.CENTER_ALIGNMENT);

			JPanel contenedor = new JPanel();
			contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.X_AXIS));
			contenedor.setBackground(verde);
			contenedor.add(Box.createHorizontalGlue());
			contenedor.add(b);
			contenedor.add(Box.createHorizontalGlue());

			panelInterior.add(contenedor);
			panelInterior.add(Box.createVerticalStrut(15));
		}

		JButton volver = new JButton("Volver");
		volver.setBackground(blanco);
		volver.setForeground(negro);
		volver.setFocusPainted(false);
		volver.setContentAreaFilled(true);
		volver.setOpaque(true);
		volver.setBorderPainted(false);
		volver.setPreferredSize(new Dimension(100, 30));

		JPanel panelVolver = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelVolver.setBackground(verde);
		panelVolver.setBorder(new EmptyBorder(10, 20, 20, 20));
		panelVolver.add(volver);
		panelIzquierdo.add(panelVolver, BorderLayout.SOUTH);

		JPanel panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBackground(verde);
		panelTabla.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelPrincipal.add(panelTabla, BorderLayout.CENTER);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");

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

		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInvC.this.dispose();

			}
		});

		añadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = textID.getText();

				gestor.GuardarCompuInv(ID);
				gestor.ListarCompuInv(modelo);
			}
		});

		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.ListarCompuInv(modelo);
			}
		});

		eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccionada = tabla.getSelectedRow();
				if (seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaCompuInv(dato);
					gestor.ListarCompuInv(modelo);
				}
			}
		});
		// -------------------------------------------------------------------------------------------------------
		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				volver.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				volver.setBackground(blanco);
			}
		});

		actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				actualizar.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				actualizar.setBackground(blanco);
			}
		});

		añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				añadir.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				añadir.setBackground(blanco);
			}
		});

		eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				eliminar.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				eliminar.setBackground(blanco);
			}
		});


	}
}