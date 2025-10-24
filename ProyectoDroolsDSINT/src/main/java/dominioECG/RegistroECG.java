package dominioECG;

import java.util.List;

import utilsECG.ECGUtils;

public class RegistroECG {
	private List<Ciclo> ciclosRegistro;
	private Patron patronAsociado;
	
	
	public RegistroECG(List<Ciclo> ciclosRegistro) {
		this.ciclosRegistro = ciclosRegistro;
	}
	
	public List<Ciclo> getCiclosRegistro() {
		return ciclosRegistro;
	}
	public Patron getPatronAsociado() {
		return patronAsociado;
	}
	
	public double getHeartRate() {
		return ECGUtils.getHeartRate(ciclosRegistro);
	}
	
}
