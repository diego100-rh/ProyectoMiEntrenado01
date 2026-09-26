package vista;

import modelo.TestFisico;
import modelo.Usuario;
import java.util.Scanner;

public class VistaTest {

    public void iniciarTest(Usuario cliente, Scanner sc) {
        System.out.println("\n--- Test físico inicial ---");

        System.out.print("Repeticiones de lagartijas: ");
        int lagartijas = Integer.parseInt(sc.nextLine());

        System.out.print("Repeticiones de sentadillas: ");
        int sentadillas = Integer.parseInt(sc.nextLine());

        System.out.print("Repeticiones de abdominales: ");
        int abdominales = Integer.parseInt(sc.nextLine());

        TestFisico test = new TestFisico();
        TestFisico.Nivel nivel = test.calcularNivel(lagartijas, sentadillas, abdominales, cliente.getGenero());

        cliente.setNivel(nivel);

        System.out.println("\n¡Test completado! Tu nivel es: " + nivel);
    }
}