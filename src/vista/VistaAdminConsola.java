package vista;
import java.util.Scanner;
import datos.GestorUsuariosJSON;
public class VistaAdminConsola {
    public void panelDeAdministracion(){
        Scanner lec = new Scanner(System.in);
        GestorUsuariosJSON revisar = new GestorUsuariosJSON();

        int op =0;

        do {
            System.out.println("\n1. Listar todos los clientes\n" +
                    "2. Ver ficha física de un cliente\n" +
                    "3. Asignar nueva rutina a cliente\n" +
                    "4. Eliminar un cliente\n" +
                    "5. Cerrar sesión");

            System.out.print("\nElige una opción: ");
            op = lec.nextInt();
            lec.nextLine();

            switch (op){
                case 1:
                    System.out.println("Listando clientes... ");
                    revisar.leerUsuarios();
                    break;

                case 2:
                    break;

                case 3:
                    break;
                case 4:
                    break;

                case 5:
                    break;
            }



        }while (op!=5);
        lec.close();

    }
}
