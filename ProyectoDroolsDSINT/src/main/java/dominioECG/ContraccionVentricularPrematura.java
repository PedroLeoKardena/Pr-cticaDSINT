package dominioECG;

public class ContraccionVentricularPrematura extends Diagnostico {
	
	private int nCicloAfectado;
	public ContraccionVentricularPrematura(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	public int getnCicloAfectado() {
		return nCicloAfectado;
	}
	public void setnCicloAfectado(int nCicloAfectado) {
		this.nCicloAfectado = nCicloAfectado;
	}
	

}
