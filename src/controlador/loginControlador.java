package controlador;

import datos.GestorUsuariosCSV;
import modelo.Usuario;

public class loginControlador {

    private final GestorUsuariosCSV gestorCSV;

    public loginControlador() {
        this.gestorCSV = new GestorUsuariosCSV();
    }

    // Busca al usuario cuyas credenciales coincidan.
    // Devuelve null si la matrícula o la contraseña son incorrectas.
    public Usuario iniciarSesion(String matricula, String contraseña) {
        for (Usuario usuario : gestorCSV.leerUsuarios()) {
            if (usuario.getMatricula().equals(matricula)
                    && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }

        return null;
    }
}