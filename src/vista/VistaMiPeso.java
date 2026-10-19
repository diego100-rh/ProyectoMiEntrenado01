package vista;

import javax.swing.*;

public class VistaMiPeso extends JFrame {

    private JTextField cajapeso;

    public void mostrarVentana(){

        setTitle("Contol de Peso Actual ");
        setResizable(false);
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblPeso = new JLabel("Peso actual:");
        lblPeso.setBounds(150, 200, 200, 20);
        add(lblPeso);

        cajapeso = new JTextField();
        cajapeso.setBounds(150, 220, 200, 30);
        add(cajapeso);

        JButton btnguardar = Herramientas.crearBoton("Inicio de sesión", 150, 280, 200, 40, e-> historialmensual());

        setVisible(true);
        add(btnguardar);
    }

    public void historialmensual(){
        VistaHistorialMensual historial = new VistaHistorialMensual();
        historial.mostrarhistorial();


    }
}
