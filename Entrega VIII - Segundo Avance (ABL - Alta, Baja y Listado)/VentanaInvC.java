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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class VentanaInvC extends JFrame{
	
public VentanaInvC(){
	logica gestor = new logica();
	JFrame aviso = new JFrame();
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setLocationRelativeTo(null);
	DefaultTableModel modelo = new DefaultTableModel();
	modelo.addColumn("ID");
	
	
	JPanel panel2 = new JPanel();
	panel2.setBackground(new Color(106, 189, 169));
	JPanel panel1 = new JPanel();
	panel1.setBackground(new Color(106, 189, 169));
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	
	Color verde = new Color(106, 189, 169);
	Color colorOg = new Color(248, 255, 255);
	Color suplanta = new Color(254, 110, 30);
	
	
	JLabel vacio = new JLabel("JSJSHUIHDWUWQI");
	vacio.setForeground(verde);
	vacio.setFont(new Font("Oswald", Font.BOLD, 30));
	JLabel vacio2 = new JLabel(" ");
	JLabel vacio3 = new JLabel(" ");
	JLabel vacio4 = new JLabel(" ");
	JLabel vacio5 = new JLabel(" ");
	JLabel vacio6 = new JLabel(" ");
	
	JLabel ingresar = new JLabel("Inventario ceibalitas");
	ingresar.setFont(new Font("Oswald", Font.BOLD, 24));
	JLabel ID = new JLabel("Ingrese el ID de la ceibalita");
	
	JTextField textID = new JTextField();
	textID.setText("ID:");
	textID.setForeground(Color.GRAY);
	textID.setMaximumSize(new Dimension(200, 25));
	
	JTable tabla = new JTable(modelo);
	
	JButton Añadir = new JButton("Añadir");
	Añadir.setBackground(colorOg);
	Añadir.setOpaque(true);
	Añadir.setBorderPainted(false);
	
	JButton Eliminar = new JButton("Eliminar");
	Eliminar.setBackground(colorOg);
	Eliminar.setOpaque(true);
	Eliminar.setBorderPainted(false);
	
	JButton Actualizar = new JButton("Actualizar");
	Actualizar.setBackground(colorOg);
	Actualizar.setOpaque(true);
	Actualizar.setBorderPainted(false);
	
	JButton Volver = new JButton("Volver");
   Volver.setBackground(colorOg);
   Volver.setOpaque(true);
   Volver.setBorderPainted(false);
  
	JScrollPane scroll = new JScrollPane(tabla);
	
	panel1.setBorder(new EmptyBorder(20, 20, 20, 20));
	this.add(panel1, BorderLayout.WEST);
	this.add(panel2, BorderLayout.NORTH);
	this.add(scroll, BorderLayout.CENTER);
	panel2.add(vacio);
	panel1.add(ingresar);
	panel1.add(vacio6);
	panel1.add(ID);
	panel1.add(textID);
	panel1.add(vacio2);
	panel1.add(Añadir);
	panel1.add(vacio3);
	panel1.add(Eliminar);
	panel1.add(vacio4);
	panel1.add(Actualizar);
	panel1.add(vacio5);
	panel1.add(Volver);

	Volver.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaInvC.this.dispose();
			
		}
	});		
	
	 Añadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                String ID = textID.getText();
                            		
				gestor.GuardarCompuInv(ID);
			    gestor.limpiar(modelo);	
				gestor.ListarCompuInv(modelo);
			}
		});
	 
	 Actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.limpiar(modelo);
				gestor.ListarCompuInv(modelo);
			}
		});
	 
	 Eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccionada = tabla.getSelectedRow();
				if(seleccionada != -1) {
					String dato = (String) tabla.getValueAt(seleccionada, 0);
					gestor.BajaCompuInv(dato);
					gestor.limpiar(modelo);
					gestor.ListarCompuInv(modelo);
				}	
				gestor.eliminar(tabla.getSelectedRow(), modelo);	
			}
		});
	 //-------------------------------------------------------------------------------------------------------
	Volver.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseEntered(MouseEvent e) {
           Volver.setBackground(suplanta);
       }
       @Override
       public void mouseExited(MouseEvent e) {
           Volver.setBackground(colorOg);
       }
   });
	
	Actualizar.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseEntered(MouseEvent e) {
           Actualizar.setBackground(suplanta);
       }
       @Override
       public void mouseExited(MouseEvent e) {
           Actualizar.setBackground(colorOg);
       }
   });
	
	Añadir.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseEntered(MouseEvent e) {
           Añadir.setBackground(suplanta);
       }
       @Override
       public void mouseExited(MouseEvent e) {
           Añadir.setBackground(colorOg);
       }
   });
	
	Eliminar.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseEntered(MouseEvent e) {
           Eliminar.setBackground(suplanta);
       }
       @Override
       public void mouseExited(MouseEvent e) {
           Eliminar.setBackground(colorOg);
       }
   });
	
	
	textID.addFocusListener(new FocusAdapter() {
       @Override
       public void focusGained(FocusEvent e) {
           if (textID.getText().equals("ID:")) {
           	textID.setText("");
           	textID.setForeground(Color.BLACK);
           }
       }
       @Override
       public void focusLost(FocusEvent e) {
           if (textID.getText().isEmpty()) {
           	textID.setText("ID:");
           	textID.setForeground(Color.GRAY);
           }
       }
   });
	
}
}
