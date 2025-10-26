package claseeeeee1del10h;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaSesion extends JFrame {
    logica gestor = new logica(); // lógica para validar la contraseña

    public VentanaSesion() {
        // 🔹 Configuración básica de la ventana
        this.setSize(450, 400);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centrar en pantalla

        // 🔹 Crear un JLayeredPane para manejar capas visuales
        JLayeredPane capas = new JLayeredPane();
        capas.setBounds(0, 0, 450, 400);
        capas.setLayout(null);
        this.setContentPane(capas); // Usar como contenido principal

        // 🔹 Cargar imagen de fondo y escalarla al tamaño de la ventana
        ImageIcon fondoOriginal = new ImageIcon("src/claseeeeee1del10h/FondoLIceo.png");
        Image imagenEscalada = fondoOriginal.getImage().getScaledInstance(450, 400, Image.SCALE_SMOOTH);
        JLabel fondo = new JLabel(new ImageIcon(imagenEscalada));
        fondo.setBounds(0, 0, 450, 400);
        capas.add(fondo, Integer.valueOf(0)); // Capa 0 = fondo

        // 🔹 Título superior
        JLabel titulo = new JLabel("Liceo Pan de Azúcar", SwingConstants.CENTER);
        titulo.setFont(new Font("Oswald", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(106, 189, 169));
        titulo.setBounds(0, 0, 450, 50);
        capas.add(titulo, Integer.valueOf(1)); // Capa 1 = encima del fondo

        // 🔹 Panel central pequeño para contener los campos de login
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(null); // Posicionamiento manual
        panelCentral.setBackground(new Color(255, 255, 255, 200)); // Blanco semitransparente
        panelCentral.setBounds(100, 100, 250, 200); // Centrado en la ventana
        capas.add(panelCentral, Integer.valueOf(2)); // Capa 2 = encima del fondo y título

        // 🔹 Etiqueta "Inicio de sesión"
        JLabel inicioSesion = new JLabel("¡Bienvenido!", SwingConstants.CENTER);
        inicioSesion.setFont(new Font("Comfortaa", Font.BOLD, 16));
        inicioSesion.setOpaque(false);
        inicioSesion.setBounds(25, 10, 200, 30);
        panelCentral.add(inicioSesion);

        // 🔹 Etiqueta "Contraseña"
        JLabel textoContraseña = new JLabel("Contraseña:");
        textoContraseña.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        textoContraseña.setBounds(25, 50, 200, 25);
        panelCentral.add(textoContraseña);

        // 🔹 Campo de contraseña
        JPasswordField contraseña = new JPasswordField();
        contraseña.setBounds(25, 80, 200, 25);
        panelCentral.add(contraseña);

        // 🔹 Botón "Iniciar sesión"
        JButton botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.setBounds(50, 130, 150, 30);
        botonIniciarSesion.setBackground(new Color(106, 189, 169));
        panelCentral.add(botonIniciarSesion);
        getRootPane().setDefaultButton(botonIniciarSesion);
        // 🔹 Acción del botón
        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Convertir la contraseña a String de forma segura
                String clave = new String(contraseña.getPassword());

                // Validar con tu clase lógica
                if (gestor.InicioSesion(clave)) {
                    JOptionPane.showMessageDialog(null, "Contraseña correcta");
                    // Aquí podrías abrir otra ventana si querés
                } 
                    
                
            }
        });
    }
}