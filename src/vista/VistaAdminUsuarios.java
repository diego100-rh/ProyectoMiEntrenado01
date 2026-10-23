package vista;

import javax.swing.*;
import java.awt.*;

public class VistaAdminUsuarios extends JFrame{

    public void mostrarVentana(){
        setTitle("Menú De administración - Gestion de usuarios ");
        setSize(500, 550);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centrado

        Color negroAdmin = new Color(30, 30, 30); // Gris muy oscuro
        Color doradoAdmin = new Color(212, 175, 55); // Tono oro elegante

        //. Fondo de la ventana oscuro
        getContentPane().setBackground(negroAdmin);
        setVisible(true);
        JPanel barraSuperior = Herramientas.crearPanel(doradoAdmin, 0, 0, 500, 60);
        JLabel lblTitulo = Herramientas.crearLabels(18, "Panel de Gestion de usuarios registrados ", 120, 10, 300, 40);
        lblTitulo.setForeground(Color.BLACK); // Texto negro sobre barra dorada
        barraSuperior.add(lblTitulo);
        add(barraSuperior);
    }
}
