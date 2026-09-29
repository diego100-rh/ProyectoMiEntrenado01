package vista;
import javax.swing.*;
public class VistaLogin extends JFrame {

    public VistaLogin(){
        setTitle("Campus-Fit ");
        setSize(400, 450); // Ancho de 400px y alto de 450px
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //MATAR AL APRETAR LA X
        setLayout(null);//desactivar organizador automatico
        setLocationRelativeTo(null);//aparecer en el centro de la pantalla
        //TITULO
        JLabel lblTitulo = Herramientas.crearLabels(18,"Bienvenido a tu gym personal :) ",60,30,300,40);
        // Botones (basados en diagrama: Inicio, Registro y Ayuda)
        JButton btnInicio = Herramientas.crearBoton("Inicio de sesión", 100, 120, 200, 40, null);
        JButton btnRegistro = Herramientas.crearBoton("Registro", 100, 180, 200, 40, null);//null por ahora
        JButton btnAyuda = Herramientas.crearBoton("Instructivo de ayuda", 100, 240, 200, 40, e -> btnInstructivo());


        add(lblTitulo);
        add(btnInicio);
        add(btnRegistro);
        add(btnAyuda);

        // Encender
        setVisible(true);

    }
    public void btnInstructivo(){
       vistaInstructivoAyuda btnAyuda = new vistaInstructivoAyuda();
       btnAyuda.mostrarVentana();
    }

}
