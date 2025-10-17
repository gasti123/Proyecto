package claseeeeee1del10h;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class VentanaTablaLibro extends JFrame {
	
	logica gestor = new logica();
	JFrame aviso = new JFrame();
	
	public VentanaTablaLibro() {
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("CI");
		modelo.addColumn("ISBN");
		modelo.addColumn("Cant Dias Prestados");

		
		Color colorOg = new Color(248, 255, 255);
		Color suplanta = new Color(254, 110, 30);
		
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(106, 189, 169));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBackground(new Color(106, 189, 169));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.setBackground(new Color(106, 189, 169));
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(106, 189, 169));
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(106, 189, 169));
		
		JLabel LabelISBN= new JLabel("ISBN");
		JTextField textISBN = new JTextField();
		textISBN.setMaximumSize(new Dimension(200, 25));
		
		JLabel LabelCi= new JLabel("CI");
		JTextField textCi = new JTextField();
		textCi.setMaximumSize(new Dimension(200, 25));
	
		JLabel dias = new JLabel("Cantidad de dias a prestar			");
		dias.setFont(new Font("Poppins", Font.BOLD, 14));
		dias.setMaximumSize(new Dimension(180, 30));
				
		JLabel ingresar = new JLabel("Ingresar libro");
		ingresar.setFont(new Font("Oswald", Font.BOLD, 27));		
		
		JLabel vacio1 = new JLabel(" ");
		JLabel vacio2 = new JLabel(" ");
		JLabel vacio3 = new JLabel(" ");
		JLabel vacio4 = new JLabel(" ");
		JLabel vacio5 = new JLabel(" ");
		JLabel vacio6 = new JLabel(" ");
		JLabel vacio7 = new JLabel(" ");
		JLabel vacio8 = new JLabel(" ");
		
		
		JSpinner cantDias = new JSpinner();
		cantDias.setMaximumSize(new Dimension(150, 25));
		
		JButton registrar = new JButton("Registrar Préstamo");
		registrar.setBackground(colorOg);
		registrar.setOpaque(true);
		registrar.setBorderPainted(false);
		
		JButton volver = new JButton("Volver");
		volver.setBackground(colorOg);
		volver.setOpaque(true);
		volver.setBorderPainted(false);
		
		JButton prestamo = new JButton("Prestamo Ceibalita");
		prestamo.setBackground(colorOg);
		prestamo.setOpaque(true);
		prestamo.setBorderPainted(false);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.setBackground(colorOg);
		eliminar.setOpaque(true);
		eliminar.setBorderPainted(false);
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.setBackground(colorOg);
		actualizar.setOpaque(true);
		actualizar.setBorderPainted(false);
		
		JButton invLibros = new JButton("Inventario libros");
		invLibros.setBackground(colorOg);
		invLibros.setOpaque(true);
		invLibros.setBorderPainted(false);
		
		JButton invCompu = new JButton("Inventario ceibalitas");
		invCompu.setBackground(colorOg);
		invCompu.setOpaque(true);
		invCompu.setBorderPainted(false);
		
		panel4.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel1.add(ingresar);
		panel1.add(LabelCi);
		panel1.add(textCi);
		panel1.add(vacio8);
		panel1.add(LabelISBN);
		panel1.add(textISBN);
		panel1.add(dias);
		panel1.add(cantDias);	
		panel1.add(vacio7);
		panel1.add(registrar);
		panel1.add(vacio1);
		panel1.add(actualizar);
		panel1.add(vacio3);
		panel1.add(eliminar);
		panel1.add(vacio4);
		panel5.add(prestamo);
		panel1.add(vacio2);
		panel5.add(invLibros);
		panel1.add(vacio6);
		panel5.add(invCompu);
		panel1.add(vacio5);
		panel4.add(volver);
		this.add(panel1, BorderLayout.WEST);
		this.add(panel2, BorderLayout.NORTH);
		panel2.add(panel5, BorderLayout.EAST);
		this.add(panel3, BorderLayout.SOUTH);
		panel3.add(panel4, BorderLayout.WEST);
		this.add(scroll, BorderLayout.CENTER);
		
		eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccionada = tabla.getSelectedRow();
				
				if(seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaLibroPrestamo(dato);
					gestor.limpiar(modelo);
					gestor.listarL(modelo);
				}
				
				gestor.eliminar(tabla.getSelectedRow(), modelo);
			}
		});
		invLibros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.VentanaInvL()) {
				}
			}
		});
		invCompu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.VentanaInvC()) {
				}
			}
		});
		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//gestor.limpiar(modelo);
				gestor.listarL(modelo);
			}
		});
		registrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Ci = textCi.getText();
				String ISBN = textISBN.getText();
				int CantDias = (int) cantDias.getValue();
				
				gestor.registrarPrestamoLibro(Ci, ISBN, CantDias);
				gestor.limpiar(modelo);
				gestor.listarL(modelo);
			}
		});
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTablaLibro.this.dispose();
			}
		});
		prestamo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.ventanaPrestamo()) {
				}
			}
		});
		//-------------------------------------------------------------------------
		
		
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
		prestamo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prestamo.setBackground(suplanta);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prestamo.setBackground(colorOg);
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