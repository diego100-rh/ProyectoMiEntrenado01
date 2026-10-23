package datos;

import java.io.*;
/**
 * Guarda y recupera las rutinas en rutinas.csv.
 * Cada rutina se identifica mediante la matrícula del usuario.
 */

public class GestorRutinasCSV {
    private final String RUTA_ARCHIVO = "rutinas.csv";
    private final String DELIMITADOR = ";";

    // Añade una rutina al CSV y reemplaza los saltos de línea por @@.
    public void guardarRutina(String matricula, String rutinaCompleta) {
        // Reemplazamos saltos de línea para que todo quepa
        String rutinaParaCSV = rutinaCompleta.replace("\n", "@@");

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            escritor.write(matricula + DELIMITADOR + rutinaParaCSV);
            escritor.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo guardar la rutina.", e);
        }
    }

    // Recupera la primera rutina de la matrícula indicada.
   // Restaura los saltos de línea y devuelve null si no encuentra una rutina.
    public String leerRutina(String matricula) {
        try (BufferedReader lector =
                     new BufferedReader(new FileReader(RUTA_ARCHIVO))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(DELIMITADOR, 2);

                if (datos.length == 2 && datos[0].equals(matricula)) {
                    return datos[1].replace("@@", "\n");
                }
            }

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer la rutina.", e);
        }

        return null;
    }
}
