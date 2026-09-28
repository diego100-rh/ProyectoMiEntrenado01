package modelo;

import datos.GestorUsuariosCSV;
import modelo.Usuario;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GestorUsuariosCSVTest {

    @Test
    public void testGuardarYLeerUsuario() {
        // 1. Instanciamos el gestor y creamos una matrícula de relleno
        GestorUsuariosCSV gestor = new GestorUsuariosCSV();
        String matriculaUnica = "TEST-" + System.currentTimeMillis();

        Usuario usuarioPrueba = new Usuario("Estudiante Prueba", matriculaUnica, "clave123");
        usuarioPrueba.setEdad(20);
        usuarioPrueba.setPeso(70.5);
        usuarioPrueba.setGenero("M");
        usuarioPrueba.setNivel("PRINCIPIANTE");
        usuarioPrueba.setDiasDisponibles("1,2,3,4");

        // 2.Guardamos el usuario en el CSV y leemos el archivo completo
        gestor.guardarUsuario(usuarioPrueba);
        List<Usuario> listaUsuarios = gestor.leerUsuarios();

        // 3.Buscamos nuestro usuario fantasma iterando la lista
        boolean usuarioEncontrado = false;

        for (Usuario u : listaUsuarios) {
            if (u.getMatricula().equals(matriculaUnica)) {
                usuarioEncontrado = true;
                // Verificamos que los datos no se hayan mezclado de columna al leer
                assertEquals("Estudiante Prueba", u.getNombre(), "El nombre no se guardó/leyó bien");
                assertEquals("PRINCIPIANTE", u.getNivel(), "El nivel no se guardó/leyó bien");
                break;
            }
        }

        assertTrue(usuarioEncontrado, "El usuario guardado no apareció al volver a leer el CSV");
    }
}