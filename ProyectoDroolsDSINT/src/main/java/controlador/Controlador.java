package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import dominioECG.Diagnostico;
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
	//La clave es el id del Registro, el valor el nombre del fichero
	private Map<String,String> mapaRegistroNombre = new HashMap<>(); 
	private Persona personaIniciada;
	private static final int NUMERO_CHAR = 5;
	private static File directorioSalida = null;
	
	public boolean tratarArchivo(File archivoEntrada) {
		
		String nombre = archivoEntrada.getName();
		if(ficherosCargados.add(nombre)) {
			// Leer archivo
	        List<String> lineas = leerArchivoECG(archivoEntrada);

	        // Parsear las lineas a objetos Ciclo usando la clase de utils
	        List<Onda> ondas = ParserECG.parsearLineas(lineas);
	        
	        String idRegistro = generarIdAleatorio(NUMERO_CHAR);
			RegistroECG registroECG = new RegistroECG(ondas, idRegistro);
			for (Onda onda : ondas) {
				onda.setRegistroPertenece(registroECG);
			}
			personaIniciada.addRegistroECG(registroECG);
			mapaRegistroNombre.put(idRegistro, nombre);
			return true;
		}else {
			return false;
		}

		
        
	}
	
	public void iniciarPersona(int edad, String idPersona, String nombre, String sexo){
		personaIniciada = new Persona(edad, idPersona, nombre, sexo);
	}
	
	public void crearSesion() {
		//Creamos la sesion con la persona.
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		
		KieSession kSession = kContainer.newKieSession("ECGSesionStateful1");
		AtomicInteger contador = new AtomicInteger(0); // Inicializa el contador a 0

		// Enlaza la variable Java con la global declarada en el DRL
		kSession.setGlobal("cicloContador", contador);
		kSession.insert(personaIniciada);
		kSession.getAgenda().getAgendaGroup("Reglas-Inicio").setFocus();
		int num = kSession.fireAllRules();
		
		System.out.println("Todas Reglas posibles ejecutadas.\nNumero de Reglas ejecutadas: "+num);
		generarSalida();
		
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
	
	public boolean establecerDirectorioSalida(File dir) {
        if(directorioSalida == null && dir != null) {
        	directorioSalida = dir;
        	System.out.println("Directorio de salida escrito por primera vez: " + directorioSalida.getAbsolutePath());
        	return true;
        }else if(directorioSalida != null && dir != null) {
        	directorioSalida=dir;
        	System.out.println("Directorio de salida sobreescrito: " + directorioSalida.getAbsolutePath());
        	return true;
        }else {
        	return false;
        }
	}
	
	public boolean establecidoDirectorioSalida() {
		return directorioSalida != null;
	}
	
	private void generarSalida() {
		String timestamp = String.valueOf(System.currentTimeMillis());
		File ficheroGlobal = new File(directorioSalida, "todo.salida_" + timestamp + ".txt");
		List<RegistroECG> registros = this.personaIniciada.getRegistroECG();
		
		String infoComun = new String("Cálculo de la frecuencia cardíaca:\n"
				+ "	            Hemos calculado el ritmo cardíaco mediante el promedio de la duración de los intervalos RR.\n"
				+ "	            Esta metodología está basada en la referencia: https://www.ijrte.org/portfolio-item/d72941111422\n"
				+ "\n"
				+ "	            Sobre los ciclos cardíacos:\n"
				+ "	            Solo se consideran los ciclos completos, es decir, aquellos que contienen todas las ondas PQRST.\n"
				+ "	            Los ciclos incompletos no se tienen en cuenta.");
		 // Escribimos el fichero global
	    try (BufferedWriter writerGlobal = new BufferedWriter(new FileWriter(ficheroGlobal))) {

	        writerGlobal.write(infoComun);
	        writerGlobal.write("\n--------------------------------------------\n\n");

	        // Recorremos cada registro para escribir también la parte global específica
	        for (RegistroECG registro : registros) {
	            String id = registro.getIdRegistro();
	            String nombreFichero = mapaRegistroNombre.getOrDefault(id, "desconocido");
	        	double frecuencia = registro.getFrecuenciaCardiaca().getValor();
	        	int numCiclos = registro.getCiclosRegistro().size();
	            int duracionRegistro = registro.getDuracion();

	            writerGlobal.write("Registro: " + id + " (fichero original: " + nombreFichero + ")\n");
	            writerGlobal.write("Frecuencia cardíaca obtenida: " + frecuencia + " bpm\n");
	            writerGlobal.write("Número de ciclos completos: " + numCiclos + "\n");
	            writerGlobal.write("Duración Registro: " + duracionRegistro + "\n");

	            writerGlobal.write("Diagnósticos:\n");
	            for (Diagnostico diag : registro.getDiagnostico()) {
	                writerGlobal.write(diag.getDescripcion() + "\n");
	            }

	            writerGlobal.write("\n--------------------------------------------\n\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    //Registros individuales
	    for (RegistroECG registro : registros) {

	        String id = registro.getIdRegistro();
	        String nombreFichero = mapaRegistroNombre.getOrDefault(id, "desconocido");

	        File ficheroSalidaRegistro = new File(
	                directorioSalida,
	                nombreFichero + ".salida_" + timestamp + ".txt"
	        );
	        
	        double frecuencia = registro.getFrecuenciaCardiaca().getValor();
        	int numCiclos = registro.getCiclosRegistro().size();
        	
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroSalidaRegistro))) {

	            // Parte específica para cada registro
	            writer.write("Cálculo de la frecuencia cardiaca:\n");
	            writer.write("La frecuencia cardíaca se obtiene calculando el promedio de la duración de los intervalos RR, ");
	            writer.write("siguiendo la metodología descrita en la referencia: https://www.ijrte.org/portfolio-item/d72941111422.\n");
	            writer.write("Frecuencia cardíaca obtenida: " + frecuencia + " bpm\n\n");

	            writer.write("Ciclos cardíacos:\n");
	            writer.write("Solo se consideran los ciclos completos que contienen todas las ondas PQRST. ");
	            writer.write("Los ciclos incompletos no se tienen en cuenta.\n");
	            writer.write("Número de ciclos completos: " + numCiclos + "\n\n");

	            writer.write("Diagnósticos detectados:\n");
	            for (Diagnostico diag : registro.getDiagnostico()) {
	                writer.write(" - " + diag.getDescripcion() + "\n");
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }        
	}
}
