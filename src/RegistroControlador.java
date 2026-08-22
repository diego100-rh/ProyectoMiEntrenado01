import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class RegistroControlador {

    //lógica de validación
    public void procesarRegistro(JFrame ventanaActual, String nombre, String matricula) {

        // 1. Evaluamos la lógica pura
        if (nombre.isEmpty() || matricula.isEmpty()) {

            // Lanzamos el error
            JOptionPane.showMessageDialog(ventanaActual,
                    "Por favor, completa ambos campos para registrarte.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);

        } else {

            // 2. ¡Los datos son válidos!
            System.out.println("Registrando a: " + nombre);

            // Cerramos la ventana de registro
            ventanaActual.dispose();

            // Aquí en el futuro llamaremos a la siguiente ventana
            TestFisicoVentana test = new TestFisicoVentana();
            test.mostrarVentana();
            // test.mostrarVentana();
        }
    }
}

