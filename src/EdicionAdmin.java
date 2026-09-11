import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EdicionAdmin {

    public void edicionDeAdmin(){
        JFrame ventana = new JFrame("Menu de Edicion-Revicion");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ventana.setLayout(new GridLayout(4, 1));

        JLabel titulo = new JLabel("Adimitracion", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        ventana.add(titulo, BorderLayout.NORTH);

        JTextField cajaContraseña = new JTextField(20);
        JLabel labelMatricula = new JLabel("Matrícula:");
        JLabel labelContraaseña = new JLabel("Contraseña:");
        JTextField cajaMatricula = new JTextField(20);

        JButton botonIngresar = new JButton("Ingresar");
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Solo extraemos el texto
                String textoNombre = cajaContraseña.getText().trim();
                String textoMatricula = cajaMatricula.getText().trim();

                // 2. DELEGAMOS LA RESPONSABILIDAD
                RegistroControlador controlador = new RegistroControlador();
                controlador.procesarRegistro(ventana, textoNombre, textoMatricula);
            }
        });

        ventana.setSize(350, 300);

        ventana.add(labelContraaseña);
        ventana.add(labelMatricula);
        ventana.add(cajaMatricula);
        ventana.add(cajaContraseña);
        ventana.add(botonIngresar);
        ventana.setVisible(true);
    }
}
