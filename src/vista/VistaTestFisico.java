package vista;

import controlador.TestFisicoControlador;
import modelo.TestFisico;

import javax.swing.*;
import java.awt.*;

public class VistaTestFisico extends JDialog {

    private final TestFisicoControlador controlador;

    private final JTextField cajaLagartijas = new JTextField();
    private final JTextField cajaSentadillas = new JTextField();
    private final JTextField cajaAbdominales = new JTextField();

    public VistaTestFisico(
            JFrame ventanaPadre,
            TestFisicoControlador controlador) {

        super(ventanaPadre, "Test físico inicial", true);
        this.controlador = controlador;

        construirVentana();
    }

    private void construirVentana() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel contenido = new JPanel(new BorderLayout(15, 20));
        contenido.setBackground(Color.WHITE);
        contenido.setBorder(
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );
        setContentPane(contenido);

        JPanel encabezado = new JPanel(new GridLayout(2, 1, 0, 10));
        encabezado.setOpaque(false);

        JLabel titulo = new JLabel(
                "Test físico inicial", SwingConstants.CENTER
        );
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(20, 70, 160));

        JLabel instrucciones = new JLabel(
                "Completa el test para acceder a tu rutina.",
                SwingConstants.CENTER
        );

        encabezado.add(titulo);
        encabezado.add(instrucciones);
        contenido.add(encabezado, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridLayout(3, 2, 12, 15));
        formulario.setOpaque(false);

        formulario.add(new JLabel("Repeticiones de lagartijas:"));
        formulario.add(cajaLagartijas);

        formulario.add(new JLabel("Repeticiones de sentadillas:"));
        formulario.add(cajaSentadillas);

        formulario.add(new JLabel("Repeticiones de abdominales:"));
        formulario.add(cajaAbdominales);

        contenido.add(formulario, BorderLayout.CENTER);

        JButton btnCompletar = new JButton("Completar test");
        btnCompletar.addActionListener(e -> completarTest());

        contenido.add(btnCompletar, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnCompletar);

        pack();
        setLocationRelativeTo(getOwner());
    }

    private void completarTest() {
        try {
            TestFisico.Nivel nivel = controlador.completarTest(
                    cajaLagartijas.getText(),
                    cajaSentadillas.getText(),
                    cajaAbdominales.getText()
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Test completado. Tu nivel es: " + nivel,
                    "Resultado del test",
                    JOptionPane.INFORMATION_MESSAGE
            );

            dispose();

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Revisa los datos",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error al guardar",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}