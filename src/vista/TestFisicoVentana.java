import javax.swing.*;
import java.awt.*;

public class TestFisicoVentana {

    public void mostrarVentana() {
        JFrame ventana = new JFrame("Test: Conociendo mi condición física");
        ventana.setSize(400, 350);
        // Evitamos que al cerrar esta ventana se cierre todo el programa completo
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Usamos GridLayout: 6 filas, 2 columnas, y 10 píxeles de separación
        ventana.setLayout(new GridLayout(6, 2, 10, 10));

        // Fila 1
        ventana.add(new JLabel("  Edad:"));
        ventana.add(new JTextField());

        // Fila 2
        ventana.add(new JLabel("  Estatura (ej. 1.75):"));
        ventana.add(new JTextField());

        // Fila 3
        ventana.add(new JLabel("  Género (F/M):"));
        ventana.add(new JTextField());

        // Fila 4
        ventana.add(new JLabel("  Peso (kg):"));
        ventana.add(new JTextField());

        // Fila 5
        ventana.add(new JLabel("  Promedio actividad (días):"));
        ventana.add(new JTextField());

        // Fila 6 (Agregamos un botón para enviar el formulario)
        ventana.add(new JLabel("")); // Dejamos la celda izquierda vacía para que se vea ordenado
        JButton botonEvaluar = new JButton("Evaluar Condición");
        ventana.add(botonEvaluar);

        ventana.setVisible(true);
    }
}