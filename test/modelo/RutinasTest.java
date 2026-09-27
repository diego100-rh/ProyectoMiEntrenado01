package modelo;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RutinasTest {

    @Test
    public void testFormatearEjercicio() {
        // 1. Preparar: Instanciamos la clase que vamos a probar
        Rutinas rutinas = new Rutinas();

        // 2. Ejecutar: Llamamos al método pasándole datos ficticios
        String resultado = rutinas.formatearEjercicio("Press Banca", 4);

        // 3. Afirmar: Verificamos que el texto generado sea correcto
        // Usamos assertTrue para confirmar que contiene las partes clave,
        // evitando que la prueba falle por un espacio extra o falta de tilde.
        assertTrue(resultado.contains("Press Banca - 4 series x 8-10 repeticiones"));
        assertTrue(resultado.contains("(elije un peso donde las últimas repeticiones te cuesten)"));
    }

    @Test
    public void testElegirEjerciciosRandom_CantidadCorrecta() {
        // 1. Preparar
        Rutinas rutinas = new Rutinas();
        List<String> sombreroDePrueba = List.of("A", "B", "C", "D", "E");
        int cantidadPedida = 3;

        // 2. Ejecutar
        List<String> resultadosElegidos = rutinas.elegirEjerciciosRandom(sombreroDePrueba, cantidadPedida);

        // 3. Afirmar
        // Verificamos que nos haya devuelto exactamente 3 ejercicios
        assertEquals(cantidadPedida, resultadosElegidos.size(), "El método no devolvió la cantidad solicitada");

        // Verificamos que no haya devuelto listas vacías
        assertFalse(resultadosElegidos.isEmpty());
    }
}