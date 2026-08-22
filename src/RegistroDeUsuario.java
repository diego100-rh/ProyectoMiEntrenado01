import javax.swing.*;
import java.awt.*;

public class RegistroDeUsuario {

    public void mostrarVentana() {
        JFrame ventana = new JFrame("Registro de Usuario");
        ventana.setSize(350, 300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField cajaNombre = new JTextField(20);

        JLabel labelMatricula = new JLabel("Matrícula:");
        JTextField cajaMatricula = new JTextField(20);

        JButton botonIngresar = new JButton("Ingresos");

        // VIGÍA DEL BOTÓN
        botonIngresar.addActionListener(e -> {

            // 1. Extraemos el texto
            String textoNombre = cajaNombre.getText().trim();
            String textoMatricula = cajaMatricula.getText().trim();

            // 2. Llamamos al cerebro (Controlador) y le pasamos los datos
            RegistroControlador controlador = new RegistroControlador();
            controlador.procesarRegistro(ventana, textoNombre, textoMatricula);
        });

        // Pegamos las piezas a la ventana
        ventana.add(labelNombre);
        ventana.add(cajaNombre);
        ventana.add(labelMatricula);
        ventana.add(cajaMatricula);
        ventana.add(botonIngresar);

        ventana.setVisible(true);
    }
}