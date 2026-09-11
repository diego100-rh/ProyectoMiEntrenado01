import javax.swing.*;
import java.awt.*;

public class InstrutivodeBienvenida {
    public void mostrarVentana() {
        JFrame ventana = new JFrame("¿En que consiste nuestro sistema");
        ventana.setSize(300, 250);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // BorderLayout organiza en Norte, Sur, Este, Oeste y Centro
        ventana.setLayout(new BorderLayout(10, 10));

        // 1. El Título (Lo ponemos al Norte)
        JLabel titulo = new JLabel("¿En qué consiste?", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        ventana.add(titulo, BorderLayout.NORTH);

        // 2. El Texto (Lo ponemos al Centro)
        // Le ponemos tu texto de relleno por ahora jaja
        JTextArea textoExplicativo = new JTextArea("\n  Este sistema te ayudará a calcular\n  tu IMC y recomendarte una rutina.\n\n  Llena los datos con cuidado.");
        textoExplicativo.setEditable(false); // Bloqueamos la edición para que el usuario solo pueda leer
        textoExplicativo.setBackground(ventana.getBackground()); // Para que el fondo se funda con la ventana

        ventana.add(textoExplicativo, BorderLayout.CENTER);

        ventana.setVisible(true);
    }
}
