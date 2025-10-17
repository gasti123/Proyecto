package claseeeeee1del10h;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;       
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class VentanaTablaPrestamo extends JFrame{
	
	public VentanaTablaPrestamo() {
		logica gestor = new logica();
		JFrame aviso = new JFrame();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Color colorOg = new Color(248, 255, 255);
		Color suplanta = new Color(254, 110, 30);
		
		DefaultTableModel modelo = new DefaultTableModel();
	
		modelo.addColumn("ID");
		modelo.addColumn("CI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Cant de horas");
     	modelo.addColumn("Grupo del estudiante");
		
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(106, 189, 169));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(106, 189, 169));
		
		JLabel IndiqueeEstudiante = new JLabel("* Si es un estudiante indique");
		IndiqueeEstudiante.setMaximumSize(new Dimension(200, 25));
		JLabel IndiqueeEstudiante2 = new JLabel(" el grupo al que pertenece");
		IndiqueeEstudiante2.setMaximumSize(new Dimension(200, 25));
		JLabel ingresar = new JLabel("Prestamo ceibalitas");
		ingresar.setFont(new Font("Oswald", Font.BOLD, 24));
		
		JLabel vacio = new JLabel("		 ");
		JLabel vacio1 = new JLabel(" ");
		JLabel vacio2 = new JLabel(" ");
		JLabel vacio3 = new JLabel(" ");
		JLabel vacio4 = new JLabel(" ");
		JLabel vacio5 = new JLabel(" ");
		JLabel vacio6 = new JLabel(" ");
		JLabel vacio7 = new JLabel(" ");
		JLabel vacio8 = new JLabel(" ");
		JLabel vacio9 = new JLabel(" ");
				
		
		JLabel LabelId= new JLabel("ID");
		JTextField textID = new JTextField();
		textID.setMaximumSize(new Dimension(200, 25));
		
		JLabel LabelCi = new JLabel("CI");
		JTextField textCi = new JTextField();
		textCi.setMaximumSize(new Dimension(200, 25));
		
		JLabel LabelNombre= new JLabel("Nombre");
		JTextField textNombre = new JTextField();
		textNombre.setMaximumSize(new Dimension(200, 25));
		
		JLabel LabelApellido= new JLabel("Apellido");
		JTextField textApellido = new JTextField();
		textApellido.setMaximumSize(new Dimension(200, 25));	
		
		
		JLabel LabelHorasPrestamo = new JLabel("Horas a Prestar");
		JSpinner textHoraPrestamo = new JSpinner();
		textHoraPrestamo.setMaximumSize(new Dimension(150, 25));		

		JLabel LabelGrupo = new JLabel("Grupo");
		JTextField textGrupo = new JTextField();
		textGrupo.setMaximumSize(new Dimension(200, 25));
		
		
		JButton registrar = new JButton("Registrar Préstamo");
		registrar.setBackground(colorOg);
		registrar.setOpaque(true);
		registrar.setBorderPainted(false);
		
		JButton volver = new JButton("Volver");
		volver.setBackground(colorOg);
		volver.setOpaque(true);
		volver.setBorderPainted(false);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.setBackground(colorOg);
		eliminar.setOpaque(true);
		eliminar.setBorderPainted(false);
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.setBackground(colorOg);
		actualizar.setOpaque(true);
		actualizar.setBorderPainted(false);
		
		panel1.setBorder(new EmptyBorder(20,20,20,20));
		panel1.add(ingresar);
		panel1.add(vacio6);
		
		panel1.add(LabelId);
		panel1.add(textID);
		
		panel1.add(vacio1);
		
		panel1.add(LabelCi);
		panel1.add(textCi);
		panel1.add(vacio9);
		panel1.add(LabelNombre);
		panel1.add(textNombre);		
		panel1.add(vacio7);	
		
		panel1.add(LabelApellido);
		panel1.add(textApellido);
		panel1.add(vacio8);	
		
		panel1.add(LabelHorasPrestamo);
		panel1.add(textHoraPrestamo);
		
			
		panel1.add(IndiqueeEstudiante);
		panel1.add(IndiqueeEstudiante2);
		
		panel1.add(LabelGrupo);
		panel1.add(textGrupo);
		panel1.add(vacio5);
		
		panel1.add(registrar);
		panel1.add(vacio2);
		panel1.add(actualizar);
		panel1.add(vacio4);
		panel1.add(eliminar);
		panel1.add(vacio3);
		panel1.add(volver);
		this.add(panel2,BorderLayout.NORTH);
		this.add(panel1, BorderLayout.WEST);
		this.add(scroll, BorderLayout.CENTER);
		panel2.add(vacio);
		
		
		
		
		registrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = textID.getText();
				String ci = textCi.getText();
				String Nombre = textNombre.getText();
				String Apellido = textApellido.getText();				
				int HorasPrestamos = (int) textHoraPrestamo.getValue();
				String Grupo = textGrupo.getText();		
				gestor.registrarPrestamoComputadora(ID,ci,Nombre,Apellido,HorasPrestamos,Grupo);
				gestor.limpiar(modelo);
				gestor.listarC(modelo);
			}
		});
		
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTablaPrestamo.this.dispose();
			}
		});
		
		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.limpiar(modelo);
				gestor.listarC(modelo);
			}
		});
		
	eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccionada = tabla.getSelectedRow();
				if(seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaCompuPrestamo(dato);
					gestor.limpiar(modelo);
					gestor.listarC(modelo);
				}				
				gestor.eliminar(tabla.getSelectedRow(), modelo);	
			}
		});
		
		
		//-------------------------------------------------------------------------------------------------------------
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


