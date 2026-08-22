import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JFrame;

// Esta clase firma el contrato para ser un vigía
public class BotonDeIngreso implements ActionListener {

    // 1. ATRIBUTOS (Las cajas vacías para guardar las herramientas)
    private JFrame ventanaPrincipal;
    private JTextField cajaDelNombre;
    private JTextField cajaDeLaMatricula;

    // 2. CONSTRUCTOR (Recibe las herramientas desde la otra clase)
    public BotonDeIngreso(JFrame ventana, JTextField cajaNombre, JTextField cajaMatricula) {
        this.ventanaPrincipal = ventana;
        this.cajaDelNombre = cajaNombre;
        this.cajaDeLaMatricula = cajaMatricula;
    }

    // 3. LA ACCIÓN
    @Override
    public void actionPerformed(ActionEvent e) {

        // Ahora sí podemos extraer el texto porque tenemos el control de las cajas
        String textoNombre = cajaDelNombre.getText().trim();
        String textoMatricula = cajaDeLaMatricula.getText().trim();

        // LLAMAMOS AL CEREBRO (Tu controlador)
        RegistroControlador controlador = new RegistroControlador();
        controlador.procesarRegistro(ventanaPrincipal, textoNombre, textoMatricula);
    }
}