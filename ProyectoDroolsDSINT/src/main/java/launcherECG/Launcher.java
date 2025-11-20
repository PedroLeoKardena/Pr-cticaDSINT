package launcherECG;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import controlador.Controlador;
import ventanas.Inicio;

public class Launcher {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("No se ha proporcionado ningún parámetro. Iniciando aplicación sin ruta.");
            new Inicio();
		}else if(args.length == 1) {
			String rutaAbsoluta = args[0];
			if (rutaAbsoluta == null || rutaAbsoluta.trim().isEmpty()) {
				System.err.println("Error: El parámetro de ruta proporcionado está vacío. Iniciamos aplicación sin ruta.");
				new Inicio();
            }
			
			Path path = Path.of(rutaAbsoluta);
			if (Files.exists(path) && Files.isDirectory(path) && path.isAbsolute()) {
                System.out.println("Ruta de directorio válida recibida: " + rutaAbsoluta);
                File directorioFile = path.toFile();
                Controlador.INSTANCE.establecerDirectorioSalida(directorioFile);
                new Inicio(); 
            } else {
                System.err.println("Error: El parámetro proporcionado '" + rutaAbsoluta + "' no es una ruta absoluta a un directorio existente.\n"
                		+ "Iniciamos aplicación sin ruta.");
				new Inicio();;
            }
		}else {
            System.err.println("Error: Solo se permite un máximo de un parámetro. Se recibieron " + args.length);
        }
		return;
	}
}
