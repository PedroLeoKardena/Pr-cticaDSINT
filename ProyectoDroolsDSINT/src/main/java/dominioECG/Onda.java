package dominioECG;

public abstract class Onda {

	private int start_time;
	private int end_time;
	private double peak_amplitude;
	private RegistroECG registroPertenece;
	private Ciclo cicloPertenece;
	
	public Onda(int start_time, int end_time, double peak_amplitude) {
		this.start_time = start_time;
		this.end_time = end_time;
		this.peak_amplitude = peak_amplitude;
		cicloPertenece = null;
	}
	
	public int getStart_time() {
		return start_time;
	}
		
	public int getEnd_time() {
		return end_time;
	}
	
	public double getPeak_amplitude() {
		return peak_amplitude;
	}
	
	public int getDuration() {
		return end_time - start_time;
	}

	@Override
	public String toString() {
		return "Onda [start_time=" + start_time + ", end_time=" + end_time + ", peak_amplitude=" + peak_amplitude + "]";
	}

	public RegistroECG getRegistroPertenece() {
		return registroPertenece;
	}

	public void setRegistroPertenece(RegistroECG registroPertenece) {
		this.registroPertenece = registroPertenece;
	}

	public Ciclo getCicloPertenece() {
		return cicloPertenece;
	}

	public void setCicloPertenece(Ciclo cicloPertenece) {
		this.cicloPertenece = cicloPertenece;
	}
	
	
	
}
