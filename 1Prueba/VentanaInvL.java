package pruebaUno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaInvL extends JFrame{
	public VentanaInvL(){
		this.setSize(500,500);
	//	this.setLayout(null);
	//	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable(modelo);
		JButton btn1 = new JButton("Añadir");
		JButton btn2 = new JButton("Eliminar");
		JScrollPane scroll = new JScrollPane(tabla);
		
	    btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
