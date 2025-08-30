package paquete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaSesion extends JFrame {
	logica gestor = new logica();

	public VentanaSesion() {
		JFrame aviso = new JFrame();

		this.setTitle("Iniciar Sesión");
		this.setLayout(new FlowLayout());
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		// Logica gestor = new Logica();

		JLabel nombre1 = new JLabel("Nombre : ");
		JLabel contraseña1 = new JLabel("Contraseña : ");

		JTextField nombre2 = new JTextField(6);
		nombre2.setMaximumSize(new Dimension(150, 25));
		JPasswordField contraseña2 = new JPasswordField(6);
		contraseña2.setMaximumSize(new Dimension(150, 25));
		JButton butonRegistrar = new JButton("Iniciar Sesion");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));

		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		nombre1.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombre2.setAlignmentX(Component.CENTER_ALIGNMENT);
		contraseña1.setAlignmentX(Component.CENTER_ALIGNMENT);
		contraseña2.setAlignmentX(Component.CENTER_ALIGNMENT);
		butonRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel1.add(nombre1);
		panel1.add(Box.createVerticalStrut(5));
		panel1.add(nombre2);
		panel1.add(Box.createVerticalStrut(10));
		panel1.add(contraseña1);
		panel1.add(Box.createVerticalStrut(5));
		panel1.add(contraseña2);
		panel1.add(Box.createVerticalStrut(15));
		panel1.add(butonRegistrar);

		JLabel LiceoLogo1 = new JLabel(logo);
		LiceoLogo1.setIcon(logo);
		Image img = logo.getImage();
		Image imgRedimensionada = img.getScaledInstance(280, 160, Image.SCALE_SMOOTH);
		logo.setImage(imgRedimensionada);

		JLabel LiceoLogo = new JLabel();
		LiceoLogo.setIcon(logo);
		LiceoLogo.setHorizontalAlignment(SwingConstants.CENTER);
		LiceoLogo.setVerticalAlignment(SwingConstants.CENTER);

		panel2.setBackground(new Color(0, 128, 115));

		panel2.setLayout(new BorderLayout());
		panel2.add(LiceoLogo, BorderLayout.CENTER);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
		split.setDividerLocation(300);

		split.setOneTouchExpandable(false);
		split.setEnabled(false);

		this.setLayout(new BorderLayout());
		this.add(split, BorderLayout.CENTER);

		butonRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gestor.iniciarSesion()) {

				}
			}
		});
	}
}
