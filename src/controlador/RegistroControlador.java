package controlador;

import datos.GestorUsuariosCSV;
import modelo.Usuario;
import java.util.List;

public class RegistroControlador {

    public boolean procesarRegistro(String nombre, String matricula, String contrasena) {
        GestorUsuariosCSV gestor = new GestorUsuariosCSV();
        // 2. Descargamos los usuarios y verificamos duplicados
        List<Usuario> listaActual = gestor.leerUsuarios();

        if (listaActual != null) {
            for (Usuario u : listaActual) {
                if (u.getMatricula().equals(matricula)) {
                    return false; // La matrícula existe. El 'return' expulsa al programa de este método inmediatamente.
                }
            }
        }
        Usuario nuevoUsuario = new Usuario(nombre, matricula, contrasena);
        // 2. Creamos el objeto Usuario con los datos iniciales
        gestor.guardarUsuario(nuevoUsuario);
        return true;


    }
}