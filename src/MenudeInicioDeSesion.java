import javax.swing.*;
import java.awt.*;

public class MenudeInicioDeSesion {

    public void mostrarVentana() {
        JFrame ventana = new JFrame("Panel de Control - Mi Entrenador");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si cierra esto, se apaga el programa

        ventana.setLayout(new GridLayout(4, 1, 10, 15)); // 4 filas

        JLabel titulo = new JLabel("¿Qué quieres hacer hoy?", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        // Los botones de tu boceto
        JButton btnRetomar = new JButton("Retomar rutina");
        JButton btnNueva = new JButton("Nueva rutina");
        JButton btnHistorial = new JButton("Historial");

        ventana.add(titulo);
        ventana.add(btnRetomar);
        ventana.add(btnNueva);
        ventana.add(btnHistorial);

        // Centramos la ventana en la pantalla
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}

