package controlador;
import datos.GestorUsuariosCSV;
import modelo.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

public class AdminUsuariosControlador {
    private GestorUsuariosCSV gestorCSV;

    public AdminUsuariosControlador(){

        this.gestorCSV = new GestorUsuariosCSV();
    }
    // 1. Método REVISAR (Read)
    // El controlador pide los datos al Gestor y se los entrega a la Vista
    public List<Usuario> obtenerTodosLosUsuarios() {
        return gestorCSV.leerUsuarios();
    }

    // --- ACCIÓN 2: ELIMINAR ---
    // Devuelve un 'boolean' (true si lo logró, false si falló)
    public boolean eliminarUsuario(String matricula) {
        List<Usuario> usuarios = gestorCSV.leerUsuarios();
        boolean encontrado = false;

        // busca el usuario por matrícula y lo removemos de la lista en memoria
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getMatricula().equals(matricula)) {
                usuarios.remove(i);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            // AQUÍ FALTA ALGO EN EL GESTOR:
            // Necesitaremos crear un método en GestorUsuariosCSV que sobreescriba el archivo
            // gestorCSV.guardarListaCompletaCSV(usuarios);
            return true;
        }
        return false;
    }
}
