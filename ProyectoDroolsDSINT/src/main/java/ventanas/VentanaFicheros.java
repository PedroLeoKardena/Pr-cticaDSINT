package ventanas;

import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import dominioECG.Ciclo;
import utilsECG.ParserECG;

import java.io.*;
import java.util.ArrayList;

public class VentanaFicheros {
	public VentanaFicheros() {
        abrirExplorador();
    }
	
	public static void abrirExplorador() {
        // Crear un JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un fichero .ecg");

        // Filtrar ficheros .ecg
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos ECG (.ecg)", "ecg");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            
            // Leer archivo
            List<String> lineas = leerArchivoECG(archivoSeleccionado);

            // Parsear las líneas a objetos Ciclo usando la clase de utils
            List<Ciclo> ciclos = ParserECG.parsearLineas(lineas);

            // Aquí puedes hacer lo que necesites con la lista de ciclos
            System.out.println("Se han creado " + ciclos.size() + " ciclos.");
            for (Ciclo ciclo : ciclos) {
                System.out.println(ciclo); // suponiendo que Ciclo tiene toString implementado
            }
        }
    }
	
	private static List<String> leerArchivoECG(File archivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }
	
	
}
