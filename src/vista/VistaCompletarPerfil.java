package vista;

import modelo.Usuario;
import java.util.Scanner;

public class VistaCompletarPerfil {

    // Recibimos al Usuario específico que acaba de iniciar sesión y el Scanner abierto
    public void pedirDatosFisicos(Usuario usuarioLogueado, Scanner sc) {
        System.out.println("\n--- COMPLETAR PERFIL FÍSICO ---");

        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        System.out.print("Ingrese su peso en KG (ej. 70,5): ");
        double peso = sc.nextDouble();

        sc.nextLine();

        System.out.print("Ingrese su género (M/F): ");
        String genero = sc.nextLine();


        // Actualizamos el objeto en memoria
        usuarioLogueado.setEdad(edad);
        usuarioLogueado.setPeso(peso);
        usuarioLogueado.setGenero(genero);

        datos.GestorUsuariosCSV gestor = new datos.GestorUsuariosCSV();
        gestor.actualizarUsuario(usuarioLogueado);

        System.out.println("\n¡Datos físicos registrados exitosamente en tu perfil, " + usuarioLogueado.getNombre() + "!");

    }
}