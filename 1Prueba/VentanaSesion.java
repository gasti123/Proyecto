package pruebaUno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VentanaSesion extends JFrame{
	logica gestor = new logica();
	public VentanaSesion() {
		JFrame aviso = new JFrame();
		this.setLayout(null);
		//this.setLayout(new FlowLayout());
		this.setSize(450, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		logica gestor = new logica();
		
		//Color verdeOs = new Color(48, 117, 100);
		
		JLabel titulo = new JLabel("Liceo Pan de Azúcar", SwingConstants.CENTER);
        titulo.setFont(new Font("Oswald", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(106, 189, 169));
   //     titulo.setBorder(new LineBorder(Color.BLACK, 3, true));
        titulo.setPreferredSize(new Dimension(200, 50));
        titulo.setBounds(-320, 0, 1000, 50);
        
        
		JLabel texto1 = new JLabel("Inicio de sesión");
		texto1.setFont(new Font("Comfortaa", Font.BOLD, 15));
		texto1.setForeground(Color.BLACK);
		texto1.setOpaque(true);
		texto1.setBackground(new Color(106, 189, 169));
		//texto1.setBorder(new LineBorder(Color.GRAY, 4, true));
		texto1.setPreferredSize(new Dimension(40, 20));
		texto1.setBounds(140, 70, 130, 40);

	/*	JLabel nombre1 = new JLabel("Usuario ");
		nombre1.setFont(new Font("Comfortaa", Font.BOLD, 16));
		nombre1.setForeground(Color.BLACK);
		nombre1.setOpaque(true);
		nombre1.setBackground(new Color(106, 189, 169));
		//nombre1.setBorder(new LineBorder(Color.GRAY, 4, true));
		nombre1.setPreferredSize(new Dimension(40, 20));
		nombre1.setBounds(160, 130, 110, 40);*/
		
		JLabel contraseña1 = new JLabel("Contraseña  ");
		contraseña1.setFont(new Font("Comfortaa", Font.BOLD, 16));
		contraseña1.setForeground(Color.BLACK);
		contraseña1.setOpaque(true);
	//	contraseña1.setBackground(new Color(106, 189, 169));
		//contraseña1.setBorder(new LineBorder(Color.GRAY, 4, true));
		contraseña1.setPreferredSize(new Dimension(40, 20));
		contraseña1.setBounds(100, 130, 110, 40);
		
//		JTextField nombre2 = new JTextField(6);
//		nombre2.setBounds(160, 180, 150, 30);

		
		JTextField contraseña2 = new JTextField(6);
		contraseña2.setBounds(100, 180, 150, 30);
		
	/*	ImageIcon imgOriginal = new ImageIcon("C:/Users/User/Documents/liceo.jpg");
        Image imgEscalada = imgOriginal.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        JLabel logo1 = new JLabel(new ImageIcon(imgEscalada));
		
		//logo1.setIcon(icono);
		logo1.setBounds(50, 50, 50, 50);
*/
		
		JButton butonRegistrar = new JButton("Iniciar Sesion");
		butonRegistrar.setBounds(140, 250, 150, 30);
		butonRegistrar.setBackground(new Color(106, 189, 169));


		this.add(titulo);
		this.add(texto1);
		this.add(contraseña1);
		this.add(contraseña2);
		//this.add(logo1);
		this.add(butonRegistrar);
		
	//	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		butonRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.siguienteVentana()) {
					
				}
			}
		});
	}
}
