import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class RegistroControlador {

    public void procesarRegistro(JFrame ventanaActual, String nombre, String matricula) {

        // 1. Evaluamos si están vacíos
        if (nombre.isEmpty() || matricula.isEmpty()) {

            JOptionPane.showMessageDialog(ventanaActual,
                    "Por favor, completa ambos campos para registrarte.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // 2. ¡Datos válidos!
            System.out.println("Registrando a: " + nombre);

            // Cerramos la ventana de registro para avanzar
            ventanaActual.dispose();

            // Más adelante aquí abriremos el Test Físico
        }
    }
}