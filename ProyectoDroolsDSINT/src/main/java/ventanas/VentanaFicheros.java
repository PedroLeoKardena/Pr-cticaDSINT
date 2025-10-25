package ventanas;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controlador.Controlador;


import java.io.*;

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
            
            Controlador.INSTANCE.tratarArchivo(archivoSeleccionado);
            
        }
    }
	
	
	
	
}
