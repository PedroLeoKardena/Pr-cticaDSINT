package dominioECG;

public abstract class Diagnostico {
	private String descripcion;
	private String nombreDiagnostico;
	private RegistroECG registroAsociado;
	
	public Diagnostico(String descripcion, String nombreDiagnostico) {
		this.descripcion = descripcion;
		this.nombreDiagnostico = nombreDiagnostico;
	}

	public String getDescripcion() {
		return descripcion;
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
