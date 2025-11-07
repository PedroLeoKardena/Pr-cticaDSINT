package dominioECG;

import java.util.ArrayList;
import java.util.List;

public class Ciclo {

	private int cycle_number;
	private OndaP waveP;
	private OndaQ waveQ;
	private OndaR waveR;
	private OndaS waveS;
	private OndaT waveT;
	private RegistroECG registroPertenece;
	
	//Un ciclo tiene varios complejos e intervalos.
	private List<Complejo> complejos;
	private List<Intervalo> intervalos;
	
	public Ciclo() {
		this.waveP = null;
		this.waveQ = null;
		this.waveR = null;
		this.waveS = null;
		this.waveT = null;
		complejos = new ArrayList<Complejo>();
		intervalos = new ArrayList<Intervalo>();
	}
	
	public void setCycle_number(int cycle_number) {
		this.cycle_number = cycle_number;
	}

	public void setWaveP(OndaP waveP) {
		this.waveP = waveP;
	}

	public void setWaveQ(OndaQ waveQ) {
		this.waveQ = waveQ;
	}

	public void setWaveR(OndaR waveR) {
		this.waveR = waveR;
	}

	public void setWaveS(OndaS waveS) {
		this.waveS = waveS;
	}

	public void setWaveT(OndaT waveT) {
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
	
	public List<Complejo> getComplejos(){
		return new ArrayList<>(complejos);
	}
	
	public List<Intervalo> getIntervalos(){
		return new ArrayList<>(intervalos);
	}
	
	public void addComplejo(Complejo comp) {
		complejos.add(comp);
	}
	
	public void addIntervalo(Intervalo inter) {
		intervalos.add(inter);
	}
	
	public int getTiempoInicio() {
		return this.waveP.getStart_time();
	}
	
	public int getTiempoFin() {
		return this.waveT.getEnd_time();
	}
	
	@Override
	public String toString() {
		return "Ciclo [cycle_number=" + cycle_number + ", waveP=" + waveP + ", waveQ=" + waveQ + ", waveR=" + waveR
				+ ", waveS=" + waveS + ", waveT=" + waveT + ", complejos=" + complejos + ", intervalos=" + intervalos
				+ "]";
	}

	public RegistroECG getRegistroPertenece() {
		return registroPertenece;
	}

	public void setRegistroPertenece(RegistroECG registroPertenece) {
		this.registroPertenece = registroPertenece;
	}
}
