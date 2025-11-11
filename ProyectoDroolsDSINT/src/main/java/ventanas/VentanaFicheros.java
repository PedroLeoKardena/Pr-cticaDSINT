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
            
            boolean archivoInsertado = Controlador.INSTANCE.tratarArchivo(archivoSeleccionado);
            if(!archivoInsertado) {
            	JOptionPane.showMessageDialog(null, 
                        "Este fichero ya ha sido insertado.", 
                        "Fichero duplicado", 
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
	
	
	
	
}
