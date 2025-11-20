package ventanas;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import controlador.Controlador;

public class VentanaDirectorios {
	public VentanaDirectorios() {
        abrirExplorador();
    }
	
	public static void abrirExplorador() {
        // Crear un JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el directorio de salida");

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File directorioSeleccionado = fileChooser.getSelectedFile();
            
            Controlador.INSTANCE.establecerDirectorioSalida(directorioSeleccionado);
        }
    }
}
