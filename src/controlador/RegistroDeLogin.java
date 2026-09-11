
import vista.MenudeInicioDeSesion;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class RegistroDeLogin {

   public void procesarLogin(JFrame ventanaActual, String matricula) {

    if (matricula.isEmpty()) {

        JOptionPane.showMessageDialog(ventanaActual,
                "Por favor, ingresa tu matrícula para iniciar sesión.",
                "Campo vacío",
                JOptionPane.ERROR_MESSAGE);

    } else {

        // ¡Los datos son válidos!
        System.out.println("Iniciando sesión con matrícula: " + matricula);

        // Cerramos la ventana de login
        ventanaActual.dispose();
        // 2. que inicie la ventana "dependiente"
        MenudeInicioDeSesion dashboard = new MenudeInicioDeSesion();
        dashboard.mostrarVentana();

        // Aquí luego validaremos si la matrícula existe en el sistema
    }
}
}