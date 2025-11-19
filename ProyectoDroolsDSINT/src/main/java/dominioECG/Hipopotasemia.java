package dominioECG;

public class Hipopotasemia extends Diagnostico{

	private int nCicloAfectado;
	public Hipopotasemia(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	public int getnCicloAfectado() {
		return nCicloAfectado;
	}
	public void setnCicloAfectado(int nCicloAfectado) {
		this.nCicloAfectado = nCicloAfectado;
	}
	
}