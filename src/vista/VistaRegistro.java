package vista;

import modelo.Usuario;

import javax.swing.*;
import java.awt.*;

public class VistaRegistro extends JFrame {

    public void mostrarVentanaRegistro(){
        setTitle("Regitro de usuarios nuevos ");
        setSize(400, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        setLayout(new GridLayout(8, 1, 10, 10));

        JLabel titulo = new JLabel("Bienvenido", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo);

        add(new JLabel("Nombre:"));
        JTextField cajauser = new JTextField(20);
        add(cajauser);

        add(new JLabel("Matricula:"));
        JTextField cajamatricula = new JTextField(20);
        add(cajamatricula);


        add(new JLabel("Contraseña:"));
        JTextField cajacontraseña = new JTextField(20);
        add(cajacontraseña);

        JButton btnregistro = new JButton("Registrar");
        add(btnregistro);

        btnregistro.addActionListener(e -> {
            String textouser = cajauser.getText().trim();
            String textpassword = cajacontraseña.getText().trim();
            String textmatricula =cajamatricula.getText().trim();

            // Validar que no envíen campos vacíos
            if ( textouser.isEmpty() || textpassword.isEmpty() || textmatricula.isEmpty()) {
                JOptionPane.showMessageDialog(VistaRegistro.this, "Por favor, complete todos los campos.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }

            ///ejecutar la validacion por test

        });

        setVisible(true);


    }


}
