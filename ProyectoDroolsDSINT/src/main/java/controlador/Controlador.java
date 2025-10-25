package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dominioECG.Ciclo;
import dominioECG.Persona;
import utilsECG.ParserECG;

public enum Controlador {
	INSTANCE;
	private Persona personaIniciada;
	
	public void tratarArchivo(File archivoEntrada) {
		// Leer archivo
        List<String> lineas = leerArchivoECG(archivoEntrada);

        // Parsear las líneas a objetos Ciclo usando la clase de utils
        List<Ciclo> ciclos = ParserECG.parsearLineas(lineas);

       //Ahora que hemos leido todos los ciclos, podemos crear las instancias necesarias.
        crearSesion(ciclos);
        
	}
	
	public void iniciarPersona(int edad, String idPersona, String nombre, String sexo){
		personaIniciada = new Persona(edad, idPersona, nombre, sexo);
	}
	
	private static void crearSesion(List<Ciclo> ciclos) {
		
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
