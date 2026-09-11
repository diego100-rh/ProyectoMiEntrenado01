import javax.swing.*;
import java.awt.*;

public class PrimeraPantalla {

    public void mostrarVentana() {
        // 1. Configuramos la ventana base
        JFrame ventana = new JFrame("Mi Entrenador - Menú Principal");
        ventana.setSize(300, 350);
        // Esta es la única ventana que debe tener EXIT_ON_CLOSE
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dividimos la pantalla en 4 filas y 1 columna
        ventana.setLayout(new GridLayout(4, 1, 10, 20));

        // 2. Creamos los componentes
        JLabel titulo = new JLabel("MI SISTEMA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnAyuda = new JButton("¿En qué consiste?");

        JButton btnadmin = new JButton("Iniciar como Administrador");


        // 3. Conectamos los botones a tus otras clases

        btnadmin.addActionListener(e -> {
            EdicionAdmin userAdmin = new EdicionAdmin();
            userAdmin.edicionDeAdmin();
        });

        btnRegistrar.addActionListener (e -> {
            // Llama a la clase que creaste en tu imagen
            RegistroDeUsuario registro = new RegistroDeUsuario();
            registro.mostrarVentana();
        });

        btnAyuda.addActionListener(e -> {
            // Llama a tu clase instructiva
            InstrutivodeBienvenida ayuda = new InstrutivodeBienvenida();
            ayuda.mostrarVentana();
        });

        btnIniciarSesion.addActionListener(e -> {
          IniciarSesion login = new IniciarSesion();
          login.inicio();
        });

        // 4. Añadimos todo a la ventana
        ventana.add(titulo);
        ventana.add(btnIniciarSesion);
        ventana.add(btnRegistrar);
        ventana.add(btnAyuda);
        ventana.add(btnadmin);

        //Centra la ventana exactamente en medio de tu pantalla
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}