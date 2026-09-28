package datos;

import java.io.*;

public class GestorRutinasCSV {
    private final String RUTA_ARCHIVO = "rutinas.csv";
    private final String DELIMITADOR = ";";

    public void guardarRutina(String matricula, String rutinaCompleta) {
        // Reemplazamos saltos de línea para que todo quepa
        String rutinaParaCSV = rutinaCompleta.replace("\n", "@@");

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            escritor.write(matricula + DELIMITADOR + rutinaParaCSV);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la rutina: " + e.getMessage());
        }
    }

    public String leerRutina(String matricula) {
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(DELIMITADOR);
                if (datos[0].equals(matricula)) {
                    // Restauramos los saltos de línea para que se vea bien en consola
                    return datos[1].replace("@@", "\n");
                }
            }
        } catch (IOException e) {
            // Si el archivo no existe, retornamos null
        }
        return null;
    }
}
