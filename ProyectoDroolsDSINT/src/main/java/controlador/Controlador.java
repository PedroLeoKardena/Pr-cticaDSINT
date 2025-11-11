package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import dominioECG.Onda;
import dominioECG.Persona;
import dominioECG.RegistroECG;
import utilsECG.ParserECG;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public enum Controlador {
	INSTANCE;
	private Set<String> ficherosCargados = new HashSet<>();
	private Persona personaIniciada;
	private static final int NUMERO_CHAR = 5;
	
	public boolean tratarArchivo(File archivoEntrada) {
		
		String nombre = archivoEntrada.getName();
		if(ficherosCargados.add(nombre)) {
			// Leer archivo
	        List<String> lineas = leerArchivoECG(archivoEntrada);

	        // Parsear las l�neas a objetos Ciclo usando la clase de utils
	        List<Onda> ondas = ParserECG.parsearLineas(lineas);
	        
	        String idRegistro = generarIdAleatorio(NUMERO_CHAR);
			RegistroECG registroECG = new RegistroECG(ondas, idRegistro);
			for (Onda onda : ondas) {
				onda.setRegistroPertenece(registroECG);
			}
			personaIniciada.addRegistroECG(registroECG);
			return true;
		}else {
			return false;
		}

		
        
	}
	
	public void iniciarPersona(int edad, String idPersona, String nombre, String sexo){
		personaIniciada = new Persona(edad, idPersona, nombre, sexo);
	}
	
	public void crearSesion() {
		//Creamos la sesi�n con la persona.
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		
		KieSession kSession = kContainer.newKieSession("ECGSesionStateful1");
		AtomicInteger contador = new AtomicInteger(0); // Inicializa el contador a 0

		// Enlaza la variable Java con la global declarada en el DRL
		kSession.setGlobal("cicloContador", contador);
		kSession.insert(personaIniciada);
		/*int total = 0;
		int fired;

		do {
		    fired = kSession.fireAllRules();
		    total += fired;
		} while (fired > 0);

		System.out.println("Total de reglas disparadas: " + total);
		*/
		int num = kSession.fireAllRules();
		
		System.out.println("Todas Reglas posibles ejecutadas.\nNumero de Reglas ejecutadas: "+num);
		
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
	
	public static String generarIdAleatorio(int longitud) {
	    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < longitud; i++) {
	        int indice = random.nextInt(caracteres.length());
	        sb.append(caracteres.charAt(indice));
	    }

	    return sb.toString();
	}
}
