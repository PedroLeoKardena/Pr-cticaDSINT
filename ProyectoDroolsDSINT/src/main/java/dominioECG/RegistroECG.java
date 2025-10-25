	package dominioECG;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import utilsECG.ECGUtils;

public class RegistroECG {
	private List<Ciclo> ciclosRegistro = new ArrayList<Ciclo>();
	private LocalDateTime fechaRegistro;
	private List<Diagnostico> diagnosticos;
	private String idRegistro;

	
	public RegistroECG(List<Ciclo> ciclosRegistro, String id) {
		this.ciclosRegistro = ciclosRegistro;
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
	
	public double getHeartRate() {
		return ECGUtils.getHeartRate(ciclosRegistro);
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
	
}
