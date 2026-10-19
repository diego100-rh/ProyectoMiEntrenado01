package vista;

import controlador.RutinaControlador;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaGestorRutina extends JFrame {

    private final RutinaControlador controlador;
    private final List<JCheckBox> casillasDias = new ArrayList<>();

    private JTextArea areaRutina;
    private JButton btnGenerar;
    private JLabel lblEstado;

    public VistaGestorRutina(Usuario usuario) {
        controlador = new RutinaControlador(usuario);
    }

    public void mostrarventa() {
        setTitle("Mi rutina - Campus-Fit");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contenido = new JPanel(new BorderLayout(12, 12));
        contenido.setBackground(Color.WHITE);
        contenido.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );
        setContentPane(contenido);

        // Encabezado y selección de días.
        JPanel superior = new JPanel(new BorderLayout(10, 12));
        superior.setOpaque(false);

        JLabel titulo = new JLabel(
                "Mi rutina semanal", SwingConstants.CENTER
        );
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(20, 70, 160));
        superior.add(titulo, BorderLayout.NORTH);

        JPanel panelDias = new JPanel(new GridLayout(2, 4, 8, 8));
        panelDias.setOpaque(false);
        panelDias.setBorder(
                BorderFactory.createTitledBorder(
                        "Selecciona cuatro días para entrenar"
                )
        );

        String[] nombresDias = {
                "Lunes", "Martes", "Miércoles", "Jueves",
                "Viernes", "Sábado", "Domingo"
        };

        for (String nombre : nombresDias) {
            JCheckBox casilla = new JCheckBox(nombre);
            casilla.setOpaque(false);
            casillasDias.add(casilla);
            panelDias.add(casilla);
        }

        superior.add(panelDias, BorderLayout.CENTER);

        btnGenerar = new JButton("Generar y guardar rutina");
        btnGenerar.addActionListener(e -> generarRutina());
        superior.add(btnGenerar, BorderLayout.SOUTH);

        contenido.add(superior, BorderLayout.NORTH);

        // Muestra la rutina y permite desplazarse por su contenido.
        areaRutina = new JTextArea();
        areaRutina.setEditable(false);
        areaRutina.setLineWrap(true);
        areaRutina.setWrapStyleWord(true);
        areaRutina.setFont(new Font("Arial", Font.PLAIN, 14));
        areaRutina.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(areaRutina);
        scroll.setPreferredSize(new Dimension(580, 320));
        scroll.setBorder(
                BorderFactory.createTitledBorder("Rutina asignada")
        );
        contenido.add(scroll, BorderLayout.CENTER);

        JPanel inferior = new JPanel(new BorderLayout(10, 10));
        inferior.setOpaque(false);

        lblEstado = new JLabel(" ");
        inferior.add(lblEstado, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        inferior.add(btnCerrar, BorderLayout.EAST);

        contenido.add(inferior, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        cargarRutina();
    }

    // Al abrir la ventana, recupera la rutina que ya estaba guardada.
    private void cargarRutina() {
        try {
            String rutina = controlador.obtenerRutina();

            if (rutina == null || rutina.isBlank()) {
                areaRutina.setText(
                        "Todavía no tienes una rutina asignada.\n\n"
                                + "Selecciona cuatro días y pulsa "
                                + "\"Generar y guardar rutina\".\n\n"
                                + "En orden semanal se asignarán: "
                                + "pecho, espalda, brazo y pierna."
                );
                lblEstado.setText("Selecciona tus días disponibles.");
            } else {
                mostrarRutina(rutina);
            }

        } catch (IllegalStateException ex) {
            btnGenerar.setEnabled(false);
            lblEstado.setText("No se pudo cargar la rutina.");

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error de lectura",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Recoge los días marcados y delega la generación al controlador.
    private void generarRutina() {
        List<Integer> diasElegidos = new ArrayList<>();

        for (int i = 0; i < casillasDias.size(); i++) {
            if (casillasDias.get(i).isSelected()) {
                diasElegidos.add(i + 1);
            }
        }

        try {
            String rutina =
                    controlador.generarYGuardarRutina(diasElegidos);

            mostrarRutina(rutina);

            JOptionPane.showMessageDialog(
                    this,
                    "Tu rutina se guardó correctamente.",
                    "Rutina creada",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Revisa tu selección",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Presenta la rutina y evita generar otra al pulsar nuevamente.
    private void mostrarRutina(String rutina) {
        areaRutina.setText(rutina);
        areaRutina.setCaretPosition(0);

        btnGenerar.setEnabled(false);

        for (JCheckBox casilla : casillasDias) {
            casilla.setEnabled(false);
        }

        lblEstado.setText("Mostrando tu rutina guardada.");
    }
}