package dominioECG;

public class Ciclo {
	private int cycle_number;
	private OndaP waveP;
	private OndaQ waveQ;
	private OndaR waveR;
	private OndaS waveS;
	private OndaT waveT;
	
	
	@Override
	public String toString() {
		return "Ciclo [cycle_number=" + cycle_number + ", waveP=" + waveP + ", waveQ=" + waveQ + ", waveR=" + waveR
				+ ", waveS=" + waveS + ", waveT=" + waveT + "]";
	}
	public Ciclo(int cycle_number, OndaP waveP, OndaQ waveQ, OndaR waveR, OndaS waveS, OndaT waveT) {
		super();
		this.cycle_number = cycle_number;
		this.waveP = waveP;
		this.waveQ = waveQ;
		this.waveR = waveR;
		this.waveS = waveS;
		this.waveT = waveT;
	}
	public int getCycle_number() {
		return cycle_number;
	}
	public OndaP getWaveP() {
		return waveP;
	}
	public OndaQ getWaveQ() {
		return waveQ;
	}
	public OndaR getWaveR() {
		return waveR;
	}
	public OndaS getWaveS() {
		return waveS;
	}
	public OndaT getWaveT() {
		return waveT;
	}
	
	
}
