package dominioECG;

public abstract class Diagnostico {
	private String descripción;
	private String nombreDiagnostico;
	private RegistroECG registroAsociado;
	
	public Diagnostico(String descripción, String nombreDiagnostico) {
		this.descripción = descripción;
		this.nombreDiagnostico = nombreDiagnostico;
	}

	public String getDescripción() {
		return descripción;
	}
	
	public String getNombreDiagnostico() {
		return nombreDiagnostico;
	}
	
	public RegistroECG getRegistroECG() {
		return registroAsociado;
	}
	
	public void setRegistroAsociado(RegistroECG r) {
		this.registroAsociado = r;
	}
	
	
}
