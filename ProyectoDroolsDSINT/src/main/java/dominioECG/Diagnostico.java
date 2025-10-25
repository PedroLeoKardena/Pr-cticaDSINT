package dominioECG;

public abstract class Diagnostico {
	private String descripci�n;
	private String nombreDiagnostico;
	private RegistroECG registroAsociado;
	
	public Diagnostico(String descripci�n, String nombreDiagnostico) {
		this.descripci�n = descripci�n;
		this.nombreDiagnostico = nombreDiagnostico;
	}

	public String getDescripci�n() {
		return descripci�n;
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
