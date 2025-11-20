package dominioECG;

public class Hipocalcemia extends Diagnostico{

	private int nCicloAfectado;
	public Hipocalcemia(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	public int getnCicloAfectado() {
		return nCicloAfectado;
	}
	public void setnCicloAfectado(int nCicloAfectado) {
		this.nCicloAfectado = nCicloAfectado;
	}
	
}
