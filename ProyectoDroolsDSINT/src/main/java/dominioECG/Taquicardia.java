package dominioECG;

public class Taquicardia extends Diagnostico{
	
	private RitmoCardiaco frecuencia;
	public Taquicardia(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	public RitmoCardiaco getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(RitmoCardiaco frecuencia) {
		this.frecuencia = frecuencia;
	}

}
