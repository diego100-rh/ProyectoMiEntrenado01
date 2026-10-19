package vista;

import javax.swing.*;
import java.awt.*;

public class VistaMiFuerza extends JFrame {

    private JTextField cajaNombreEjercicio;
    private JTextField cajaSeries;

    public void mostrarVentana() {
        setTitle("Registro de Fuerza");
        setSize(500, 400);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        Color azulCampus = new Color(20, 70, 160);
        JPanel barraSuperior = Herramientas.crearPanel(azulCampus, 0, 0, 500, 60);
        JLabel lblTitulo = Herramientas.crearLabels(18, "Evolución de Fuerza", 150, 10, 200, 40);
        lblTitulo.setForeground(Color.WHITE);
        barraSuperior.add(lblTitulo);
        add(barraSuperior);


        JLabel lblNombre = Herramientas.crearLabels(14, "Nombre del ejercicio:", 150, 90, 200, 20);
        add(lblNombre);
        cajaNombreEjercicio = Herramientas.crearTexto(150, 110, 200, 30);
        add(cajaNombreEjercicio);

        JLabel lblSeries = Herramientas.crearLabels(14, "Cantidad de series:", 150, 160, 200, 20);
        add(lblSeries);
        cajaSeries = Herramientas.crearTexto(150, 180, 200, 30);
        add(cajaSeries);


        JButton btnSiguiente = Herramientas.crearBoton("Siguiente", 150, 240, 200, 40, e -> btnSiguienteAccion());
        add(btnSiguiente);

        setVisible(true);
    }

    private void btnSiguienteAccion() {
        String nombre = cajaNombreEjercicio.getText().trim();
        String seriesStr = cajaSeries.getText().trim();

        if (nombre.isEmpty() || seriesStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int cantidadSeries = Integer.parseInt(seriesStr);

            // Pasamos a la siguiente ventana enviándole los datos
            this.dispose();
            VistaMiFuerzaSeries detalle = new VistaMiFuerzaSeries(nombre, cantidadSeries);
            detalle.mostrarVentana();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Las series deben ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}