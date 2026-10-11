package vista;

import javax.swing.*;
import java.awt.*;

public class VistaInicioDeSesion extends JFrame {
    private JTextField cajamatricula;
    private JTextField cajacontraseña;

    public void mostrarventaSesion(){

        setTitle("Iniciando Sesion ¡Hola Denuevo! ");
        setSize(400, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cajamatricula = new JTextField(20);
        add(cajamatricula);

        cajacontraseña = new JTextField(20);
        add(cajacontraseña);

        setVisible(true);

        JButton btnconfirmar= new JButton("confirmar");
        add(btnconfirmar);

        btnconfirmar.addActionListener(e -> {
            String textpassword = cajacontraseña.getText().trim();
            String textmatricula =cajamatricula.getText().trim();

            // Validar que no envíen campos vacíos
            if ( textpassword.isEmpty() || textmatricula.isEmpty()) {
                JOptionPane.showMessageDialog(VistaInicioDeSesion.this, "Por favor, complete todos los campos.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } /// SI LOS CAMPOS ESTAN COMPLETOS SEDEBE REVISAR EN EL CSV SI ESTA EL USARIO GUARDADO


        });

    }
    public String getMatriculaIngresada() {
        return cajamatricula.getText().trim();
    }

    public String getContrasenaIngresada() {
        return cajacontraseña.getText().trim();
    }
}
