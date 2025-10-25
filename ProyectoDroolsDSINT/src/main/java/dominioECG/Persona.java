package dominioECG;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private int edad;
	private String idPersona;
	private String nombre;
	private String sexo;
	private List<RegistroECG> registroECG;
	private boolean registrosProcesados = false;
	
	public Persona(int edad, String idPersona, String nombre, String sexo) {
		this.edad = edad;
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.sexo = sexo;
		this.registroECG = new ArrayList<RegistroECG>();
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getIdPersona() {
		return idPersona;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public List<RegistroECG> getRegistroECG() {
		return new ArrayList<RegistroECG>(registroECG);
	}
	
	public boolean isRegistrosProcesados() { 
        return registrosProcesados;
    }
	
	public void setRegistrosProcesados(boolean b) {
		this.registrosProcesados = b;
	}
	
	public void addRegistroECG(RegistroECG registroECG) {
		this.registroECG.add(registroECG);
	}
	
	
	
}
