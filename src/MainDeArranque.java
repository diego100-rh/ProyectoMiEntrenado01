import datos.GestorUsuariosJSON;
import controlador.RegistroControlador;
import java.util.Scanner;
import datos.GestorAmins;

public class MainDeArranque {
    public static void main(String[] args) {
        // 1. Instanciamos el gestor de datos
        RegistroControlador gestor = new RegistroControlador();
        GestorAmins admin = new GestorAmins();

        Scanner es = new Scanner(System.in);
        boolean esValido = false;

        do {
            System.out.println("--- MENÚ DEL GIMNASIO ---");

            System.out.println("Ingrese su Nombre:");
            String nombre = es.nextLine();

            System.out.println("Ingrese su matrícula:");
            String mat = es.nextLine();

            System.out.println("Ingrese su contraseña:");
            String contra = es.nextLine();

            if (nombre.isEmpty() || mat.isEmpty() || contra.isEmpty()) {
                System.out.println("Error: Ningún campo puede estar vacío.");
                continue; // Repite el bucle sin cambiar esValido
            }

            System.out.println("Acceder como admin? (s/n):");
            boolean op = es.nextLine().trim().equalsIgnoreCase("s");
            if (op){
                String credenciales = admin.validarCredenciales(mat,contra);
                if ("Acceso permitido".equals(credenciales)){ //equals para validar el dato return"veridico"
                    System.out.println("¡Bienvenido Administrador " + nombre + "!");
                    esValido = true; // Rompemos el bucle porque entró con éxito
                } else {
                    System.out.println("Error: Matrícula o contraseña incorrecta.");
                    // No cambiamos esValido, así el bucle se repite y le vuelve a pedir los datos
                }
            }else{
                gestor.procesarRegistro(nombre, mat, contra);
                System.out.println("¡Bienvenido! Entrando al sistema...");
                esValido = true;

            }

        }while (!esValido);
    }
}