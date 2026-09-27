package vista;

import modelo.PlanSemanal;
import modelo.Usuario;
import java.util.Scanner;

public class VistaDashboardUsuario {

    public void mostrarDashboard(Usuario usuarioLogueado, Scanner sc) {
        int opcion = 0;
        boolean cerrarSesion = false;

        do {
            System.out.println("\n==================================");
            System.out.println("   DASHBOARD - " + usuarioLogueado.getNombre().toUpperCase());
            System.out.println("   Nivel Físico: " + usuarioLogueado.getNivel());
            System.out.println("==================================");
            System.out.println("1. Ver mi perfil físico");
            System.out.println("2. Armar / Ver mi Plan Semanal");
            System.out.println("3. Cerrar sesión");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0; //un error controlado si escriben letras
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- MI PERFIL ---");
                    System.out.println("Matrícula: " + usuarioLogueado.getMatricula());
                    System.out.println("Edad: " + usuarioLogueado.getEdad() + " años");
                    System.out.println("Peso: " + usuarioLogueado.getPeso() + " kg");
                    System.out.println("Género: " + usuarioLogueado.getGenero());
                    break;
                case 2:
                    System.out.println("\n--- MI PLAN DE ENTRENAMIENTO ---");
                    // Aquí llamamos a tu clase existente que pide los días y arma la rutina
                    PlanSemanal plan = new PlanSemanal();
                    plan.generaPlan();
                    break;
                case 3:
                    System.out.println("\nCerrando sesión. ¡Sigue entrenando duro, " + usuarioLogueado.getNombre() + "!");
                    cerrarSesion = true;
                    break;
                default:
                    System.out.println("Error: Opción no válida. Intenta nuevamente.");
            }

        } while (!cerrarSesion);
    }
}