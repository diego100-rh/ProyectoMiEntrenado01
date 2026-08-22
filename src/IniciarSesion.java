import javax.swing.*;
import java.awt.*;

public class IniciarSesion {
    public void MostrarVentana(){
        JFrame ventana = new JFrame("Bienvenido de nuevo");
        ventana.setSize(350, 300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        JLabel labelMatricula = new JLabel("Matricula:");
        JTextField cajaMatricula = new JTextField(20);

        JButton botonIngresar = new JButton("Ingresar");




    }


}
