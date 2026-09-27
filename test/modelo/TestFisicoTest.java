package modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFisicoTest {
    @Test
    public void testPuntosLagartijas_HombrePrincipiante() {
        // 1. Preparar: Instanciamos la clase original
        TestFisico testFisico = new TestFisico();

        // 2. Ejecutar: Inventamos datos de prueba (ej. 15 repeticiones, género "Masculino")
        // y llamamos al método real
        int resultadoPuntos = testFisico.puntosLagartijas(17, "M");

        // 3. Afirmar: Verificamos que los puntos devueltos sean los correctos
        // (Cambia el '1' por los puntos reales que tu compañero definió para ese rango)
        assertEquals(1, resultadoPuntos, "El cálculo de puntos para lagartijas falló");
    }

}
//ERRO CONTROLADO DE CLASIFICAION DE NIVELES