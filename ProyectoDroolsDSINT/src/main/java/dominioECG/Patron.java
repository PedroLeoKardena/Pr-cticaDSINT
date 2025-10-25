package dominioECG;

import java.util.ArrayList;
import java.util.List;

public class Patron {
	
	private String clasificaci�n;
	private String descripci�n;
	private String idPatron;
	private List<Complejo> complejosPatron = new ArrayList<Complejo>();
	private List<Intervalo> intervalosPatron = new ArrayList<Intervalo>();
	
	public Patron(String clasificaci�n, String descripci�n, String idPatron, List<Complejo> complejosPatron,
			List<Intervalo> intervalosPatron) {
		this.clasificaci�n = clasificaci�n;
		this.descripci�n = descripci�n;
		this.idPatron = idPatron;
		this.complejosPatron = complejosPatron;
		this.intervalosPatron = intervalosPatron;
	}

	public String getClasificaci�n() {
		return clasificaci�n;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public String getIdPatron() {
		return idPatron;
	}

	public List<Complejo> getComplejosPatron() {
		return complejosPatron;
	}

	public List<Intervalo> getIntervalosPatron() {
		return intervalosPatron;
	}
	
}
