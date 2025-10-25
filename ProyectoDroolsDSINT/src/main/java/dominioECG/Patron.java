package dominioECG;

import java.util.ArrayList;
import java.util.List;

public class Patron {
	
	private String clasificación;
	private String descripción;
	private String idPatron;
	private List<Complejo> complejosPatron = new ArrayList<Complejo>();
	private List<Intervalo> intervalosPatron = new ArrayList<Intervalo>();
	
	public Patron(String clasificación, String descripción, String idPatron, List<Complejo> complejosPatron,
			List<Intervalo> intervalosPatron) {
		this.clasificación = clasificación;
		this.descripción = descripción;
		this.idPatron = idPatron;
		this.complejosPatron = complejosPatron;
		this.intervalosPatron = intervalosPatron;
	}

	public String getClasificación() {
		return clasificación;
	}

	public String getDescripción() {
		return descripción;
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
