package vista;

import javax.swing.*;

public class vistaInstructivoAyuda extends JFrame{
    public void mostrarVentana() {
        setTitle("Instructivo de Ayuda ");
        setSize(400, 450); // Ancho de 400px y alto de 450px
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ///DISPOSE cierra solo esta ventana, no todo el programa
        JTextField text = Herramientas.crearTexto(100,100,200,35);

        setVisible(true);


    }
}
