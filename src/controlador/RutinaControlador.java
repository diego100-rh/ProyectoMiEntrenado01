package controlador;

import datos.GestorRutinasCSV;
import modelo.PlanSemanal;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
/**
 * Coordina la consulta y creación de la rutina del usuario.
 * Valida los días elegidos y delega la generación y el guardado.
 */

public class RutinaControlador {

    private final Usuario usuario;
    private final PlanSemanal planSemanal;
    private final GestorRutinasCSV gestor;

    // Vincula el controlador con el usuario que inició sesión.

    public RutinaControlador(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Debe existir un usuario con sesión iniciada."
            );
        }

        this.usuario = usuario;
        this.planSemanal = new PlanSemanal();
        this.gestor = new GestorRutinasCSV();
    }

    // Recupera la rutina asignada al usuario autenticado.
    public String obtenerRutina() {
        return gestor.leerRutina(usuario.getMatricula());
    }

    // Genera y guarda la primera rutina del usuario.
    public String generarYGuardarRutina(List<Integer> dias) {
        validarDias(dias);

        String rutinaExistente = obtenerRutina();

        if (rutinaExistente != null && !rutinaExistente.isBlank()) {
            throw new IllegalArgumentException(
                    "Ya tienes una rutina guardada."
            );
        }

        // Ordena los días sin modificar la lista recibida.
        List<Integer> diasOrdenados = new ArrayList<>(dias);
        Collections.sort(diasOrdenados);

        String rutina = planSemanal.generaPlan(diasOrdenados);

        gestor.guardarRutina(usuario.getMatricula(), rutina);

        return rutina;
    }

    // Comprueba cantidad, rango y ausencia de días repetidos.
    private void validarDias(List<Integer> dias) {
        if (dias == null || dias.size() != 4) {
            throw new IllegalArgumentException(
                    "Debes seleccionar exactamente cuatro días."
            );
        }

        for (Integer dia : dias) {
            if (dia == null || dia < 1 || dia > 7) {
                throw new IllegalArgumentException(
                        "Los días deben estar entre lunes y domingo."
                );
            }
        }

        if (new HashSet<>(dias).size() != 4) {
            throw new IllegalArgumentException(
                    "Los cuatro días deben ser distintos."
            );
        }
    }
}