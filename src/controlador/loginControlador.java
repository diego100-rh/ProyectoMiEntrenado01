package controlador;

import datos.GestorUsuariosCSV;
import modelo.Administrador;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class loginControlador {

    private final GestorUsuariosCSV gestorCSV;
    public loginControlador() {
        this.gestorCSV = new GestorUsuariosCSV();
        this.adminDisponible();
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
    private final List<Administrador> admin = new ArrayList<>();


    public void adminDisponible(){
        admin.add(new Administrador("123456789","nure67"));
        admin.add(new Administrador("21984678024","lasde12"));
        admin.add(new Administrador("123456789","meir69"));
        admin.add(new Administrador("21910067124","lia1515"));
    }

    public boolean iniciarAdmin (String matricula, String contraseña){
        for(Administrador ad: admin){
            if (ad.getMatricula().equals(matricula) && ad.getContraseña().equals(contraseña)){
                return true;

            }
        }
        return false;

    }
}