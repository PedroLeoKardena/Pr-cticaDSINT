package dominioECG;

public class Isquemia extends Diagnostico{
	
	private int nCicloAfectado;
	private double amplitudST;
	private double amplitudT;
	
	public Isquemia(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	
	public int getnCicloAfectado() {
		return nCicloAfectado;
	}
	public void setnCicloAfectado(int nCicloAfectado) {
		this.nCicloAfectado = nCicloAfectado;
	}
	public double getAmplitudST() {
		return amplitudST;
	}
	public void setAmplitudST(double amplitudST) {
		this.amplitudST = amplitudST;
	}
	public double getAmplitudT() {
		return amplitudT;
	}
	public void setAmplitudT(double amplitudT) {
		this.amplitudT = amplitudT;
	}
}
