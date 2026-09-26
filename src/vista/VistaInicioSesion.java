package vista;

import datos.GestorUsuariosCSV;
import modelo.Usuario;
import java.util.List;
import java.util.Scanner;

public class VistaInicioSesion {
    GestorUsuariosCSV revisar = new GestorUsuariosCSV();

    public void inicioSesion (Scanner sc){
        System.out.print("Ingrese su matrícula: ");
        String matLogin = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraLogin = sc.nextLine();

        // 2. Traemos la lista del CSV y preparamos la bandera
        List<Usuario> listaClientes = revisar.leerUsuarios();
        boolean clienteEncontrado = false;

// 3. Recorremos la lista buscando coincidencias
        if (listaClientes != null) {
            for (Usuario cliente : listaClientes) {

                // Comparamos usando .equals() por ser cadenas de texto
                if (cliente.getMatricula().equals(matLogin) && cliente.getContraseña().equals(contraLogin)) {
                    System.out.println("¡Bienvenido de vuelta, " + cliente.getNombre() + "!");
                    clienteEncontrado = true;

                    if (cliente.getEdad() == 0 || cliente.getPeso() == 0.0 || cliente.getGenero() == null) {
                        System.out.println("\n[Alerta] Tu perfil físico está incompleto. Necesitamos más datos.");

                        VistaCompletarPerfil vistaPerfil = new VistaCompletarPerfil();
                        vistaPerfil.pedirDatosFisicos(cliente, sc);

                    } else {
                        System.out.println("\n[Aviso] Tu perfil físico está completo. (Redirigiendo al Dashboard...)");
                    }

                    // TODO: Aquí más adelante llamaremos a la vista del perfil del cliente
                    // Ejemplo: vistaDashboardCliente.mostrar();

                    break; // Cortamos el bucle, ya no necesitamos seguir buscando
                }
            }
        }
        if (!clienteEncontrado) {
            System.out.println("\nError: Matrícula o contraseña incorrecta. Intente de nuevo.");
        }
    }
}
