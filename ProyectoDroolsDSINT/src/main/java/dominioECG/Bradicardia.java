package dominioECG;

public class Bradicardia extends Diagnostico{
	private RitmoCardiaco frecuencia;
	public Bradicardia(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	public RitmoCardiaco getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(RitmoCardiaco frecuencia) {
		this.frecuencia = frecuencia;
	}

}
