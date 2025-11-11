package dominioECG;

import java.util.ArrayList;
import java.util.List;

public class Complejo {
	private List<Onda> ondasCompuesto = new ArrayList<Onda>();
	private RegistroECG registroAsociado;
	private int tiempoInicio;
	private int tiempoFin;
	
	public Complejo(List<Onda> ondasCompuesto, int tiempoInicio, int tiempoFin) {
		this.ondasCompuesto = ondasCompuesto;
		this.tiempoInicio = tiempoInicio;
		this.tiempoFin = tiempoFin;
	}

	public List<Onda> getOndasCompuesto() {
		return new ArrayList<>(ondasCompuesto);
	}

	public int getTiempoInicio() {
		return tiempoInicio;
	}

	public int getTiempoFin() {
		return tiempoFin;
	}
	
	public int getDuracion() {
		return tiempoFin - tiempoInicio;
	}

	public RegistroECG getRegistroAsociado() {
		return registroAsociado;
	}

	public void setRegistroAsociado(RegistroECG registroAsociado) {
		this.registroAsociado = registroAsociado;
	}
	
	
}
