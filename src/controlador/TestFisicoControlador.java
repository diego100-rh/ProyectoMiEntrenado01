package controlador;

import datos.GestorUsuariosCSV;
import modelo.TestFisico;
import modelo.Usuario;

/**
 * Coordina la validación y el guardado del test físico inicial.
 * Comprueba si el usuario tiene un nivel reconocido antes de acceder a su rutina.
 */

public class TestFisicoControlador {

    private final Usuario usuario;
    private final TestFisico test = new TestFisico();
    private final GestorUsuariosCSV gestor = new GestorUsuariosCSV();

    // Vincula el test con el usuario que inició sesión.

    public TestFisicoControlador(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Debe existir un usuario con sesión iniciada."
            );
        }

        this.usuario = usuario;
    }

    // Solo considera completo el test si existe un nivel reconocido.
    public boolean tieneTestRealizado() {
        String nivel = usuario.getNivel();

        if (nivel == null || nivel.isBlank()) {
            return false;
        }

        try {
            TestFisico.Nivel.valueOf(nivel);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    // Valida las respuestas, calcula el nivel y guarda el resultado.
    public TestFisico.Nivel completarTest(
            String lagartijasTexto,
            String sentadillasTexto,
            String abdominalesTexto) {

        int lagartijas = convertirRepeticiones(lagartijasTexto);
        int sentadillas = convertirRepeticiones(sentadillasTexto);
        int abdominales = convertirRepeticiones(abdominalesTexto);

        String genero = usuario.getGenero();

        if (!"M".equals(genero) && !"F".equals(genero)) {
            throw new IllegalArgumentException(
                    "El usuario debe tener registrado su sexo como M o F."
            );
        }

        TestFisico.Nivel nivel = test.calcularNivel(
                lagartijas, sentadillas, abdominales, genero
        );

        String nivelAnterior = usuario.getNivel();
        usuario.setNivel(nivel.name());

        try {
            gestor.actualizarUsuario(usuario);
        } catch (RuntimeException ex) {
            // Si falla el guardado, no dejamos el test aprobado en memoria.
            usuario.setNivel(nivelAnterior);
            throw ex;
        }

        return nivel;
    }

    // Convierte el texto a un número entero y rechaza valores negativos.

    private int convertirRepeticiones(String texto) {
        int repeticiones;

        try {
            repeticiones = Integer.parseInt(texto.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(
                    "Completa todos los campos con números enteros."
            );
        }

        if (repeticiones < 0) {
            throw new IllegalArgumentException(
                    "Las repeticiones no pueden ser negativas."
            );
        }

        return repeticiones;
    }
}