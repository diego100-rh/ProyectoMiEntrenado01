package vista;
import javax.swing.*;
import java.awt.*;

public class LoginAdminVentana extends JFrame {

    private JButton btnRevisarUsuario;
    private JButton btnEditarEjercicio;
    private JButton btnCerrarSesion;

    public void menuAdmin (){
        setTitle("Menú De administracion - Campus Fit");
        setSize(500, 550); // Mantenemos el estándar de "Talla M"
        setResizable(false);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);


        btnRevisarUsuario = Herramientas.crearBoton("Mi Progreso", 150, 260, 200, 40, e -> btnbtnRevisarUsuarioAccion());
        btnEditarEjercicio= Herramientas.crearBoton("Gestor de Rutinas", 150, 320, 200, 40, e -> btnEditarEjercicioAccion());
        btnCerrarSesion = Herramientas.crearBoton("Cerrar Sesión", 150, 380, 200, 40, e -> btnCerrarSesionAccion());

        add(btnRevisarUsuario);
        add(btnEditarEjercicio);
        add(btnCerrarSesion);

        setVisible(true);

    }
    public void btnbtnRevisarUsuarioAccion (){

    }

    public void btnEditarEjercicioAccion(){

    }

    public void btnCerrarSesionAccion(){}
}
