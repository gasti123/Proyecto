package claseeeeee1del10h;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class VentanaTablaCompu extends JFrame {

	public VentanaTablaCompu() {

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

		JPanel panelInterior = new JPanel();
		panelInterior.setLayout(new BoxLayout(panelInterior, BoxLayout.Y_AXIS));
		panelInterior.setBackground(verdePanel);
		panel1.add(panelInterior, BorderLayout.CENTER);

		JLabel ingresar = new JLabel("Prestamo Ceibalita");
		ingresar.setForeground(blanco);
		ingresar.setFont(new Font("Oswald", Font.BOLD, 27));
		ingresar.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInterior.add(ingresar);
		panelInterior.add(Box.createVerticalStrut(20));

		JLabel LabelCi = new JLabel("CI");
		LabelCi.setForeground(blanco);
		JTextField textCi = new JTextField();
		textCi.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		textCi.setPreferredSize(new Dimension(30, 30));
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

		JLabel LabelID = new JLabel("ID");
		LabelID.setForeground(blanco);
		JTextField textID = new JTextField();
		textID.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		textID.setBackground(blanco);
		textID.setForeground(negro);

		JLabel LabelCantHoras = new JLabel("Cantidad de horas a prestar");
		LabelCantHoras.setForeground(blanco);
		LabelCantHoras.setFont(new Font("Poppins", Font.BOLD, 14));

		SpinnerNumberModel modeloS = new SpinnerNumberModel(0, 0, 100, 1);
		JSpinner SpinnerCantHoras = new JSpinner(modeloS);
		SpinnerCantHoras.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		SpinnerCantHoras.setBackground(blanco);
		SpinnerCantHoras.setForeground(negro);

		JLabel LabelGrupo = new JLabel("Grupo");
		LabelGrupo.setForeground(blanco);
		JTextField textGrupo = new JTextField();
		textGrupo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		textGrupo.setPreferredSize(new Dimension(30, 30));
		textGrupo.setBackground(blanco);
		textGrupo.setForeground(negro);

		JLabel info1 = new JLabel("* Si es un Estudiante completar este campo");
		info1.setForeground(blanco);
		info1.setAlignmentX(Component.LEFT_ALIGNMENT);

		panelInterior.add(LabelCi);
		panelInterior.add(textCi);
		panelInterior.add(Box.createVerticalStrut(10));
		panelInterior.add(LabelNombre);
		panelInterior.add(textNombre);
		panelInterior.add(Box.createVerticalStrut(10));
		panelInterior.add(LabelApellido);
		panelInterior.add(textApellido);
		panelInterior.add(Box.createVerticalStrut(10));
		panelInterior.add(LabelID);
		panelInterior.add(textID);
		panelInterior.add(Box.createVerticalStrut(10));
		panelInterior.add(LabelCantHoras);
		panelInterior.add(SpinnerCantHoras);
		panelInterior.add(Box.createVerticalStrut(10));
		panelInterior.add(info1);
		panelInterior.add(Box.createVerticalStrut(10));
		panelInterior.add(LabelGrupo);
		panelInterior.add(textGrupo);
		panelInterior.add(Box.createVerticalStrut(20));
		panelInterior.add(vacio);

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

			panelInterior.add(contenedorBoton);
			panelInterior.add(Box.createVerticalStrut(15));
		}

		JButton volver = new JButton("Volver");
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
		panel1.add(panelVolver, BorderLayout.SOUTH);

		JPanel panelBotonesArriba = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		panelBotonesArriba.setBackground(verdePanel);

		JPanel panelTabla = new JPanel(new BorderLayout(10, 10));
		panelTabla.setBackground(verdePanel);
		panelTabla.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelPrincipal.add(panelTabla, BorderLayout.CENTER);
		panelTabla.add(panelBotonesArriba, BorderLayout.NORTH);

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("CI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("ID");
		modelo.addColumn("Cant Horas Prestadas");
		modelo.addColumn("Grupo");

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

				String ci = textCi.getText();
				String Nombre = textNombre.getText();
				String Apellido = textApellido.getText();
				String ID = textID.getText();
				int CantHorasPrestamos = (int) SpinnerCantHoras.getValue();
				String Grupo = textGrupo.getText();
				
				if (gestor.checkCompus(ID)) {
					gestor.registrarPrestamoComputadora(ci, Nombre, Apellido, ID, CantHorasPrestamos,Grupo);
					gestor.listarCompuPrestamo(modelo);
				}else {
					JOptionPane.showMessageDialog(null,"No existe un libro con esa ISBN");
				}
			}
		});

		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTablaCompu.this.dispose();
			}
		});

		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.listarCompuPrestamo(modelo);
			}
		});

		eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccionada = tabla.getSelectedRow();
				if (seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaCompuPrestamo(dato);
					gestor.listarCompuPrestamo(modelo);
				}
			}
		});

		// -------------------------------------------------------------------------------------------------------------
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

	}
}
