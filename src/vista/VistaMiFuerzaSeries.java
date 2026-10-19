package vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaMiFuerzaSeries extends JFrame {

    private String nombreEjercicio;
    private int cantidadSeries;

    // Usamos listas para guardar las cajas generadas dinámicamente y poder leerlas después
    private List<JTextField> cajasPesos = new ArrayList<>();
    private List<JTextField> cajasReps = new ArrayList<>();

    // El constructor recibe los datos de la ventana anterior
    public VistaMiFuerzaSeries(String nombreEjercicio, int cantidadSeries) {
        this.nombreEjercicio = nombreEjercicio;
        this.cantidadSeries = cantidadSeries;
    }

    public void mostrarVentana() {
        setTitle("Detalle de Series");

        int altoVentana = 200 + (cantidadSeries * 50) + 100;
        setSize(500, altoVentana);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // Barra Superior
        Color azulCampus = new Color(20, 70, 160);
        JPanel barraSuperior = Herramientas.crearPanel(azulCampus, 0, 0, 500, 60);
        JLabel lblTitulo = Herramientas.crearLabels(18, nombreEjercicio.toUpperCase(), 150, 10, 200, 40);
        lblTitulo.setForeground(Color.WHITE);
        barraSuperior.add(lblTitulo);
        add(barraSuperior);

        //  Genera las filas según el número ingresado
        int posicionYBase = 90; // Donde empieza la primera fila

        for (int i = 0; i < cantidadSeries; i++) {
            int yActual = posicionYBase + (i * 50); // Cada fila baja 50 píxeles

            // Etiqueta "Serie 1", "Serie 2", etc.
            JLabel lblSerie = Herramientas.crearLabels(14, "Serie " + (i + 1) + ":", 50, yActual, 70, 20);
            add(lblSerie);


            JLabel lblPeso = Herramientas.crearLabels(12, "Peso (kg):", 130, yActual, 60, 20);
            add(lblPeso);
            JTextField cajaPeso = Herramientas.crearTexto(190, yActual, 60, 30);
            cajasPesos.add(cajaPeso); // Guardamos la caja en la lista
            add(cajaPeso);

            // Repeticiones
            JLabel lblReps = Herramientas.crearLabels(12, "Reps:", 270, yActual, 40, 20);
            add(lblReps);
            JTextField cajaReps = Herramientas.crearTexto(310, yActual, 60, 30);
            cajasReps.add(cajaReps);
            add(cajaReps);
        }

        // El botón "Guardar" se pone abajo de la última fila generada
        int botonY = posicionYBase + (cantidadSeries * 50) + 20;
        JButton btnGuardar = Herramientas.crearBoton("Guardar en JSON", 150, botonY, 200, 40, e -> btnGuardarAccion());
        add(btnGuardar);

        setVisible(true);
    }

    private void btnGuardarAccion() {
        //  Así se leen los datos dinámicos a futuro
        System.out.println("Guardando datos de: " + nombreEjercicio);
        for (int i = 0; i < cantidadSeries; i++) {
            String peso = cajasPesos.get(i).getText();
            String reps = cajasReps.get(i).getText();
            System.out.println("Serie " + (i+1) + " -> Peso: " + peso + " | Reps: " + reps);
        }

        // Aquí se conectará el controlador JSON
        JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
}