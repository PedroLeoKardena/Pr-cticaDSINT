package dominioECG;

public class IAM extends Diagnostico{
	
	private int nCicloAfectado;
	private double amplitudQRS;
	private double amplitudT;
	public IAM(String descripcion, String nombreDiagnostico) {
		super(descripcion, nombreDiagnostico);
	}
	public int getnCicloAfectado() {
		return nCicloAfectado;
	}
	public void setnCicloAfectado(int nCicloAfectado) {
		this.nCicloAfectado = nCicloAfectado;
	}
	public double getAmplitudQRS() {
		return amplitudQRS;
	}
	public void setAmplitudQRS(double amplitudQRS) {
		this.amplitudQRS = amplitudQRS;
	}
	public double getAmplitudT() {
		return amplitudT;
	}
	public void setAmplitudT(double amplitudT) {
		this.amplitudT = amplitudT;
	}

}
