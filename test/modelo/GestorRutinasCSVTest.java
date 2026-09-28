package modelo;

import datos.GestorRutinasCSV;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorRutinasCSVTest {

    @Test
    public void testGuardarYLeerRutina_ReemplazoDeSaltosDeLinea() {
        // 1. Preparar: Creamos una matrícula única usando el reloj del sistema
        // para no chocar con las matrículas reales de la base de datos.
        GestorRutinasCSV gestor = new GestorRutinasCSV();
        String matriculaPrueba = "TEST-" + System.currentTimeMillis();

        // Creamos una rutina ficticia que contenga varios saltos de línea (\n)
        String rutinaOriginal = "Lunes: Pecho\nMartes: Espalda\nMiércoles: Pierna";

        // 2. Ejecutar: Guardamos la rutina en el CSV y la volvemos a leer inmediatamente
        gestor.guardarRutina(matriculaPrueba, rutinaOriginal);
        String rutinaRecuperada = gestor.leerRutina(matriculaPrueba);

        // 3. Afirmar:
        // Primero verificamos que el método no haya devuelto null
        assertNotNull(rutinaRecuperada, "La rutina recuperada no debería ser nula");

        // Verificamos que la lógica de transformar "@@" de vuelta a "\n" funcionó perfecto
        assertEquals(rutinaOriginal, rutinaRecuperada, "El texto recuperado no coincide con el original");
    }

    @Test
    public void testLeerRutina_MatriculaInexistente() {
        // 1. Preparar
        GestorRutinasCSV gestor = new GestorRutinasCSV();
        String matriculaFalsa = "FALSA-9999";

        // 2. Ejecutar
        String resultado = gestor.leerRutina(matriculaFalsa);

        // 3. Afirmar: La línea 34 del código original indica que si no encuentra nada o falla, retorna null
        assertNull(resultado, "Debe retornar null si la matrícula no existe en el CSV");
    }
}  ///manejo completado sin errores