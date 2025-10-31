package claseeeeee1del10h;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTablaLibro extends JFrame {

	public VentanaTablaLibro() {
		logica gestor = new logica();

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Color verdePanel = new Color(80, 150, 140);
		Color blanco = Color.WHITE;
		Color negro = Color.BLACK;
		Color suplanta = new Color(255, 140, 0);
		Color colorOg = blanco;

		JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
		panelPrincipal.setBackground(verdePanel);
		this.setContentPane(panelPrincipal);

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setBackground(verdePanel);
		panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelPrincipal.add(panel1, BorderLayout.WEST);

		JLabel vacio = new JLabel("		");

		JPanel PanelInterior = new JPanel();
		PanelInterior.setLayout(new BoxLayout(PanelInterior, BoxLayout.Y_AXIS));
		PanelInterior.setBackground(verdePanel);
		panel1.add(PanelInterior, BorderLayout.CENTER);

		JLabel ingresar = new JLabel("Prestamo Libro");
		ingresar.setForeground(blanco);
		ingresar.setFont(new Font("Oswald", Font.BOLD, 27));
		ingresar.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelInterior.add(ingresar);
		PanelInterior.add(Box.createVerticalStrut(20));

		JLabel LabelCi = new JLabel("CI");
		LabelCi.setForeground(blanco);
		JTextField textCi = new JTextField();
		textCi.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		textCi.setBackground(blanco);
		textCi.setForeground(negro);

		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setForeground(blanco);
		JTextField textNombre = new JTextField();
		textNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		textNombre.setBackground(blanco);
		textNombre.setForeground(negro);

		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setForeground(blanco);
		JTextField textApellido = new JTextField();
		textApellido.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		textApellido.setBackground(blanco);
		textApellido.setForeground(negro);

		JLabel LabelISBN = new JLabel("ISBN");
		LabelISBN.setForeground(blanco);
		JTextField textISBN = new JTextField();
		textISBN.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		textISBN.setPreferredSize(new Dimension(30, 30));
		textISBN.setBackground(blanco);
		textISBN.setForeground(negro);

		JLabel dias = new JLabel("Cantidad de dias a prestar");
		dias.setForeground(blanco);
		dias.setFont(new Font("Poppins", Font.BOLD, 14));

		SpinnerNumberModel modeloS = new SpinnerNumberModel(0, 0, 100, 1);
		JSpinner cantDias = new JSpinner(modeloS);
		cantDias.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		cantDias.setBackground(blanco);
		cantDias.setForeground(negro);

		PanelInterior.add(LabelCi);
		PanelInterior.add(textCi);
		PanelInterior.add(Box.createVerticalStrut(10));
		PanelInterior.add(LabelNombre);
		PanelInterior.add(textNombre);
		PanelInterior.add(Box.createVerticalStrut(10));
		PanelInterior.add(LabelApellido);
		PanelInterior.add(textApellido);
		PanelInterior.add(Box.createVerticalStrut(10));
		PanelInterior.add(LabelISBN);
		PanelInterior.add(textISBN);
		PanelInterior.add(Box.createVerticalStrut(10));
		PanelInterior.add(dias);
		PanelInterior.add(cantDias);
		PanelInterior.add(Box.createVerticalStrut(20));
		PanelInterior.add(vacio);

		JButton registrar = new JButton("Registrar");
		JButton actualizar = new JButton("Actualizar");
		JButton eliminar = new JButton("Eliminar");

		JButton[] botones = { registrar, actualizar, eliminar };
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

			JPanel contenedorBoton = new JPanel();
			contenedorBoton.setLayout(new BoxLayout(contenedorBoton, BoxLayout.X_AXIS));
			contenedorBoton.setBackground(verdePanel);
			contenedorBoton.add(Box.createHorizontalGlue());
			contenedorBoton.add(b);
			contenedorBoton.add(Box.createHorizontalGlue());

			PanelInterior.add(contenedorBoton);
			PanelInterior.add(Box.createVerticalStrut(15));
		}

		JButton salir = new JButton("Salir");
		salir.setBackground(colorOg);
		salir.setForeground(Color.BLACK);
		salir.setFocusPainted(false);
		salir.setContentAreaFilled(true);
		salir.setOpaque(true);
		salir.setBorderPainted(false);
		salir.setPreferredSize(new Dimension(100, 30));

		JPanel panelVolver = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelVolver.setBackground(verdePanel);
		panelVolver.add(salir);
		panel1.add(panelVolver, BorderLayout.SOUTH);

		JPanel panelBotonesArriba = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		panelBotonesArriba.setBackground(verdePanel);

		JButton prestamoCeibalita = new JButton("Prestamo Ceibalitas");
		JButton invLibros = new JButton("Inventario Libros");
		JButton invCompu = new JButton("Inventario Ceibalitas");

		JButton[] pestañas = { invLibros, prestamoCeibalita, invCompu };
		for (JButton b : pestañas) {
			b.setBackground(colorOg);
			b.setForeground(Color.BLACK);
			b.setFocusPainted(false);
			b.setContentAreaFilled(true);
			b.setOpaque(true);
			b.setBorderPainted(false);
			panelBotonesArriba.add(b);
		}

		JPanel panelTabla = new JPanel(new BorderLayout(10, 10));
		panelTabla.setBackground(verdePanel);
		panelTabla.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelPrincipal.add(panelTabla, BorderLayout.CENTER);
		panelTabla.add(panelBotonesArriba, BorderLayout.NORTH);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("CI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("ISBN");
		modelo.addColumn("Cant Dias Prestados");

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

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		registrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String Ci = textCi.getText();
				String Nombre = textNombre.getText();
				String Apellido = textApellido.getText();
				String ISBN = textISBN.getText();
				int CantDias = (int) cantDias.getValue();

				if (gestor.checkLibro(ISBN)) {
					gestor.registrarPrestamoLibro(Ci, Nombre, Apellido, ISBN, CantDias);
					gestor.listarLibroPrestamo(modelo);
				}else {
					JOptionPane.showMessageDialog(null,"No existe un libro con esa ISBN");
				}

			}
		});
		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.listarLibroPrestamo(modelo);
			}
		});
		eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccionada = tabla.getSelectedRow();
				if (seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaLibroPrestamo(dato);
					gestor.listarLibroPrestamo(modelo);
				}
			}
		});

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTablaLibro.this.dispose();
			}
		});
		prestamoCeibalita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.ventanaPrestamoCeibalita();
			}
		});
		invLibros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.VentanaInvL();
			}
		});
		invCompu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.VentanaInvC();
			}
		});
		// ---------------------------------------------------------------------------------------------------------------------------

		registrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				registrar.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				registrar.setBackground(colorOg);
			}
		});

		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				salir.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				salir.setBackground(colorOg);
			}
		});

		prestamoCeibalita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prestamoCeibalita.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				prestamoCeibalita.setBackground(colorOg);
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

		invLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				invLibros.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				invLibros.setBackground(colorOg);
			}
		});

		invCompu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				invCompu.setBackground(suplanta);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				invCompu.setBackground(colorOg);
			}
		});
	}

}
