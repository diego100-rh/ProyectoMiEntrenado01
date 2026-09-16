package vista;
import controlador.RegistroControlador;
import datos.GestorAmins;

import java.util.Scanner;

public class VistaConsola {

    public void iniciar (){
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
            if (op) {
                boolean esValidoAdmin = admin.validarCredenciales(mat, contra);
                if (esValidoAdmin){
                    System.out.println("¡Bienvenido Administrador " + nombre + "!");
                    esValido = true;
                }else{
                    System.out.println("Error: Administrador no dectectado.");
                }
            } else {
                gestor.procesarRegistro(nombre, mat, contra);
                System.out.println("Binvendido usuario: " +nombre);
                esValido = true;
            }
        }while (!esValido);
    }
}

