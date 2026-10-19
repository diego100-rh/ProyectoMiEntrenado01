package vista;

import controlador.loginControlador;
import datos.GestorAdmins;

import javax.swing.*;
import java.awt.*;

public class VistaInicioDeSesion extends JFrame {
    private JTextField cajamatricula;
    private JTextField cajacontraseña;

    public void mostrarVentaSesion() {
        setTitle("Iniciando Sesión ¡Hola de nuevo!");
        setSize(500, 500);
        setResizable(false);
        setLayout(null); // Apagamos el organizador
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE); // Fondo limpio

        JLabel titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(150, 40, 200, 30);
        add(titulo);

        // Opcional: Agregar el logo aquí (y: 80, alto: 100) para que no quede tan vacío arriba


        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(150, 200, 200, 20);
        add(lblMatricula);

        cajamatricula = new JTextField();
        cajamatricula.setBounds(150, 220, 200, 30);
        add(cajamatricula);


        JLabel lblContra = new JLabel("Contraseña:");
        lblContra.setBounds(150, 270, 200, 20);
        add(lblContra);

        // JPasswordField en lugar de JTextField para que salgan asteriscos
        cajacontraseña = new JPasswordField();
        cajacontraseña.setBounds(150, 290, 200, 30);
        add(cajacontraseña);

        JButton btnconfirmar = new JButton("Confirmar");
        btnconfirmar.setBounds(150, 360, 200, 40);
        add(btnconfirmar);

        btnconfirmar.addActionListener(e -> {
            String textpassword = cajacontraseña.getText().trim();
            String textmatricula = cajamatricula.getText().trim();

            //revicion
            if (textpassword.isEmpty() || textmatricula.isEmpty()) {
                JOptionPane.showMessageDialog(VistaInicioDeSesion.this, "Por favor, complete todos los campos.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Aquí conectaremos el LoginControlador en el siguiente paso
            GestorAdmins admins = new GestorAdmins();
            //  ========================================================================== SOLO DE PRUEBA
             boolean acceso = admins.validarCredenciales(textmatricula, textpassword);
             if (acceso) {
                 this.dispose(); // cerrar la ventana de login actual
                 VistaMenuGym menuGym = new VistaMenuGym();
                  menuGym.mostrarVentanaGym();
             } else {
                 JOptionPane.showMessageDialog(VistaInicioDeSesion.this, "Error: incicio sesion fallido.", "Error de usuario", JOptionPane.ERROR_MESSAGE);
             }
//          //  ========================================================================== SOLO DE PRUEBA
//
        });

        setVisible(true);
    }


}
