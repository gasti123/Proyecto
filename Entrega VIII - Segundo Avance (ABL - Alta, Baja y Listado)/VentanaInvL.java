package claseeeeee1del10h;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class VentanaInvL extends JFrame{
	public VentanaInvL(){
		JFrame aviso = new JFrame();
		logica gestor = new logica();
		
		this.setSize(500,500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ISBN");
		modelo.addColumn("Titulo");
		modelo.addColumn("Autor");
		modelo.addColumn("Pais Origen");
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(106, 189, 169));
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(106, 189, 169));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		Color verde = new Color(106, 189, 169);
		Color colorOg = new Color(248, 255, 255);
		Color suplanta = new Color(254, 110, 30);
		
		JLabel ingresar = new JLabel("Inventario Libros");
		ingresar.setFont(new Font("Oswald", Font.BOLD, 27));
		JLabel literatura = new JLabel("* Si es de literatura ");
		literatura.setFont(new Font("Poppins", Font.BOLD, 14));
		literatura.setMaximumSize(new Dimension(150, 30));
		JLabel literatura2 = new JLabel("llenar estos campos");
		literatura2.setFont(new Font("Poppins", Font.BOLD, 14));
		literatura2.setMaximumSize(new Dimension(150, 15));
		
		JLabel vacio = new JLabel("JSJSHUIHDWUWQI");
		vacio.setForeground(verde);
		vacio.setFont(new Font("Oswald", Font.BOLD, 30));
		JLabel vacio2 = new JLabel("JSJSHUIHDWUWQI");
		vacio2.setForeground(verde);
		vacio2.setFont(new Font("Oswald", Font.BOLD, 13));
		JLabel vacio3 = new JLabel(" ");
		JLabel vacio4 = new JLabel(" ");
		JLabel vacio5 = new JLabel(" ");
		JLabel vacio6 = new JLabel(" ");
		JLabel vacio7 = new JLabel(" ");
		JLabel vacio8 = new JLabel(" ");
		JLabel vacio9 = new JLabel(" ");
		JLabel vacio10 = new JLabel(" ");
		JLabel vacio11 = new JLabel(" ");
		
		
		
		JTable tabla = new JTable(modelo);
		JSpinner cantLibros = new JSpinner();
		cantLibros.setMaximumSize(new Dimension(150, 25));
		
		JButton añadir = new JButton("Añadir");
		añadir.setBackground(colorOg);
       añadir.setOpaque(true);
       añadir.setBorderPainted(false);
		JButton eliminar = new JButton("Eliminar");
		eliminar.setBackground(colorOg);
       eliminar.setOpaque(true);
       eliminar.setBorderPainted(false);
       JButton actualizar = new JButton("Actualizar");
       actualizar.setBackground(colorOg);
       actualizar.setOpaque(true);
       actualizar.setBorderPainted(false);
       JButton volver = new JButton("Volver");
       volver.setBackground(colorOg);
       volver.setOpaque(true);
       volver.setBorderPainted(false);
		
        JLabel LabelISBN= new JLabel("ISBN");
		JTextField textISBN = new JTextField();
		textISBN.setMaximumSize(new Dimension(200, 25));
		
		JLabel LabelTitulo= new JLabel("Titulo");
		JTextField textTitulo = new JTextField();
		textTitulo.setMaximumSize(new Dimension(200, 25));
		
		JLabel LabelAutor= new JLabel("Autor");
		JTextField textAutor = new JTextField();
		textAutor.setMaximumSize(new Dimension(200, 25));
		
		JLabel LabelPais= new JLabel("Pais");
		JTextField textPais = new JTextField();
		textPais.setMaximumSize(new Dimension(200, 25));
		
		
		JScrollPane scroll = new JScrollPane(tabla);
		
		panel1.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(panel1, BorderLayout.WEST);
		this.add(panel2, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		panel2.add(vacio);
		panel1.add(ingresar);
		panel1.add(LabelISBN);
		panel1.add(textISBN);
		panel1.add(vacio5);
		panel1.add(LabelTitulo);
		panel1.add(textTitulo);
		panel1.add(vacio6);
		panel1.add(LabelAutor);
		panel1.add(textAutor);
		panel1.add(literatura);
		panel1.add(literatura2);
		panel1.add(vacio11);
		panel1.add(LabelPais);
		panel1.add(textPais);
		panel1.add(vacio4);
		panel1.add(añadir);
		panel1.add(vacio3);
		panel1.add(eliminar);
		panel1.add(vacio9);
		panel1.add(actualizar);
		panel1.add(vacio10);
		panel1.add(volver);
		
	    añadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ISBN = textISBN.getText();
				String Titulo = textTitulo.getText();
				String Autor = textAutor.getText();
				String PaisOrigen = textPais.getText();
				
				gestor.GuardarLibroInv(ISBN, Titulo, Autor,PaisOrigen);
				gestor.limpiar(modelo);
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
				if(seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaLibroInv(dato);
					gestor.limpiar(modelo);
					gestor.listarLibInv(modelo);
				}				
				gestor.eliminar(tabla.getSelectedRow(), modelo);							
			}
		});
		
		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.listarLibInv(modelo);
			}
		});
		
		//------------------------------------------------------------------------------------------------------------------
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

