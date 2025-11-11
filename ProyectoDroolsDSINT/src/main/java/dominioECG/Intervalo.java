package dominioECG;

public class Intervalo {
	private int tiempoInicio;
	private int tiempoFin;
	private TipoIntervalo tipoIntervalo;
	private RegistroECG registroPertenece;
	
	public Intervalo(int tiempoInicio, int tiempoFin, TipoIntervalo tipo) {
		this.tiempoInicio = tiempoInicio;
		this.tiempoFin = tiempoFin;
		this.tipoIntervalo = tipo;
	}
	
	public int getTiempoInicio() {
		return tiempoInicio;
	}
	
	public int getTiempoFin() {
		return tiempoFin;
	}
	
	public TipoIntervalo getTipoIntervalo() {
		return tipoIntervalo;
	}
	
	public int getDuracion() {
		return tiempoFin-tiempoInicio;
	}

	public RegistroECG getRegistroPertenece() {
		return registroPertenece;
	}

	public void setRegistroPertenece(RegistroECG registroPertenece) {
		this.registroPertenece = registroPertenece;
	}
}
