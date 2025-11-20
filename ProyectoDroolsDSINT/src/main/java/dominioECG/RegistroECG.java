	package dominioECG;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroECG {
	private List<Ciclo> ciclosRegistro = new ArrayList<Ciclo>();
	private List<Onda> ondasRegistro = new ArrayList<Onda>();
	private LocalDateTime fechaRegistro;
	private List<Diagnostico> diagnosticos;
	private String idRegistro;
	private RitmoCardiaco frecuenciaCardiaca;
	
	public RegistroECG(List<Onda> ondas, String id) {
		this.ondasRegistro = ondas;
		this.ciclosRegistro = new ArrayList<Ciclo>();
		this.diagnosticos = new ArrayList<Diagnostico>();
		fechaRegistro = LocalDateTime.now();
		idRegistro = id;
	}
	
	public List<Ciclo> getCiclosRegistro() {
		return ciclosRegistro;
	}
	
	
	public List<Diagnostico> getDiagnostico() {
		return new ArrayList<>(diagnosticos);
	}
	
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	
	public String getIdRegistro() {
		return idRegistro;
	}
	
	public int getDuracion() {
		if (ciclosRegistro == null || ciclosRegistro.isEmpty()) {
		    return 0;
		}

		Ciclo primero = ciclosRegistro.get(0);
		Ciclo ultimo = ciclosRegistro.get(ciclosRegistro.size() - 1);
		int inicio = primero.getTiempoInicio();
		int fin = ultimo.getTiempoFin();

		return fin - inicio;
	}
	
	public void addDiagnostico(Diagnostico diagnosis) {
		diagnosticos.add(diagnosis);
		diagnosis.setRegistroAsociado(this);
	}
	
	public void addCiclo(Ciclo ciclo) {
		ciclosRegistro.add(ciclo);
	}
	public List<Onda> getOndasRegistro() {
		return ondasRegistro;
	}

	public RitmoCardiaco getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(RitmoCardiaco frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	
}
