package vista;

import javax.swing.*;

public class VistaProgresoGym extends JFrame {

    public void mostrarventa(){
        setTitle("Bienvenido a mi Progreso ");
        setResizable(false);
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JButton btnmipeso = Herramientas.crearBoton("Registro mi peso", 150, 280, 200, 40, e-> btnmipeso());
        JButton btnevoFuerza = Herramientas.crearBoton("Registrar evolucion de mi fuerza", 150, 340, 200, 40,e-> btnevoFuerza() );

        add(btnevoFuerza);
        add(btnmipeso);



        setVisible(true);
    }

    public void btnmipeso(){
        VistaMiPeso btnmipeso = new VistaMiPeso();
        btnmipeso.mostrarVentana();


    }
    public void btnevoFuerza(){
        VistaMiFuerza btnFuerza =new VistaMiFuerza();
        btnFuerza.mostrarVentana();

    }
}
