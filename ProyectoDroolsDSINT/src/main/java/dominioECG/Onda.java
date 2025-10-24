package dominioECG;

public abstract class Onda {
	@Override
	public String toString() {
		return "Onda [start_time=" + start_time + ", end_time=" + end_time + ", peak_amplitude=" + peak_amplitude + "]";
	}


	private int start_time;
	private int end_time;
	private double peak_amplitude;
	
	
	public Onda(int start_time, int end_time, double peak_amplitude) {
		this.start_time = start_time;
		this.end_time = end_time;
		this.peak_amplitude = peak_amplitude;
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
	
	
	
}
