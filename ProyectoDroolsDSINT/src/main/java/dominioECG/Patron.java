package dominioECG;

import java.util.ArrayList;
import java.util.List;

public class Patron {
	
	private String clasificacion;
	private String descripcion;
	private String idPatron;
	private List<Complejo> complejosPatron = new ArrayList<Complejo>();
	private List<Intervalo> intervalosPatron = new ArrayList<Intervalo>();
	
	public Patron(String clasificacion, String descripcion, String idPatron, List<Complejo> complejosPatron,
			List<Intervalo> intervalosPatron) {
		this.clasificacion = clasificacion;
		this.descripcion = descripcion;
		this.idPatron = idPatron;
		this.complejosPatron = complejosPatron;
		this.intervalosPatron = intervalosPatron;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public String getDescripcion() {
		return descripcion;
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
