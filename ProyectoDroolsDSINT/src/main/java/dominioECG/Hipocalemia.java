package dominioECG;

public class Hipocalemia extends Diagnostico{

	private int nCicloAfectado;
	public Hipocalemia(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	public int getnCicloAfectado() {
		return nCicloAfectado;
	}
	public void setnCicloAfectado(int nCicloAfectado) {
		this.nCicloAfectado = nCicloAfectado;
	}
	
}
