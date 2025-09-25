package pruebaUno;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class vtnLiteratura extends JFrame{
	public vtnLiteratura() {
		JFrame aviso = new JFrame();
		this.setLayout(new FlowLayout());
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
	    this.setLayout(new GridLayout(2,1));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JLabel lblCodigo = new JLabel("Ingresa el código: ");
		JLabel lblPais = new JLabel("Ingresa su país de origen: ");
		
		JTextField txfCodigo = new JTextField(6);
		txfCodigo.setMaximumSize(new Dimension(300, 25));
		JTextField txfPais = new JTextField(6);
		txfPais.setMaximumSize(new Dimension(300, 25));
		
		JButton btnGuardar = new JButton("Guardar");
		
	    this.add(panel1);
	    panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	    panel1.add(lblCodigo);
	    panel1.add(txfCodigo);
	    panel1.add(lblPais);
	    panel1.add(txfPais);
	  
	    this.add(panel2);
	    panel2.add(btnGuardar);
    
	    btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			JOptionPane.showMessageDialog(aviso, "Datos Guardados!");
				
			
			}
		});
		
	
}

}
