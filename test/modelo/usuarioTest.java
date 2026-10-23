package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class usuarioTest {

    @Test
    public void testCreacionYAsignacionDeDatos() {
        // 1.Usamos el constructor obligatorio de la línea 17
        Usuario usuario = new Usuario("Diego Rifo", "2024-9999", "secreta123");

        //  los setters para completar el resto del perfil
        usuario.setEdad(21);
        usuario.setPeso(75.5);
        usuario.setGenero("M");
        usuario.setNivel("AVANZADO");
        usuario.setDiasDisponibles("1,3,5");

        // 3. Verificamos que los getters devuelvan exactamente lo que guardamos
        assertEquals("Diego Rifo", usuario.getNombre(), "El nombre no coincide");
        assertEquals("2024-9999", usuario.getMatricula(), "La matrícula no coincide");
        assertEquals("secreta123", usuario.getContraseña(), "La contraseña no coincide");
        assertEquals(21, usuario.getEdad(), "La edad no coincide");
        assertEquals(75.5, usuario.getPeso(), "El peso no coincide");
        assertEquals("M", usuario.getGenero(), "El género no coincide");
        assertEquals("AVANZADO", usuario.getNivel(), "El nivel no coincide");
        assertEquals("1,3,5", usuario.getDiasDisponibles(), "Los días disponibles no coinciden");
    }
}