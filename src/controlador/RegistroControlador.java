package controlador;
import datos.GestorUsuariosCSV;
import modelo.Usuario;
import vista.VistaRegistro;
import javax.swing.JOptionPane;
import java.util.List;

public class RegistroControlador {
    private VistaRegistro vista;
    private GestorUsuariosCSV gestorCSV;

//conectamos el controlador a la ventana exacta que el usuario está usando,
// permitiéndonos cerrarla o lanzarle alertas directamente.
    public RegistroControlador(VistaRegistro vista){
        this.vista = vista;
        this.gestorCSV = new GestorUsuariosCSV();
    }
    public void procesarRegistro(String nombre, String matricula, String password,
                                 String edadStr, String alturaStr, String pesoStr, String sexo) {
        try {
            // 1. Transformar los textos a números (porque el JTextField solo entrega Strings)
            int edad = Integer.parseInt(edadStr);
            double altura = Double.parseDouble(alturaStr);
            double peso = Double.parseDouble(pesoStr);

            // 2. Crear el objeto Usuario con el modelo
            Usuario nuevoUsuario = new Usuario(nombre, matricula, password);
            nuevoUsuario.setEdad(edad);
            nuevoUsuario.setPeso(peso);
            nuevoUsuario.setGenero(sexo);
            // La altura la podemos
            // guardar
            // 3. ¡Guardar en base de datos (CSV)!
            gestorCSV.guardarUsuario(nuevoUsuario);
// CAMBIAR:
            JOptionPane.showMessageDialog(
                    vista,
                    "¡Registro exitoso! Ahora puedes iniciar sesión con tu matrícula y contraseña.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

// Cierra el registro y deja disponible la ventana de inicio.
            vista.dispose();

        } catch (NumberFormatException ex) {
            // Este catch es un escudo extra: si el usuario escribe "veinte" en lugar de "20" en la edad
            JOptionPane.showMessageDialog(vista, "Error: La edad, altura y peso deben ser números válidos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}
