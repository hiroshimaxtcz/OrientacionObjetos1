package ar.edu.unlp.objetos.uno.ejercicio25;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
public class Mascota {
	private String raza;
	private LocalDate fecha;
	private List<Servicio> miServicio;	
	private String especie;
	public Mascota(String raza, LocalDate fecha, List<Servicio> miServicio, String especie) {
		this.raza = raza;
		this.fecha = fecha;
		this.miServicio = new LinkedList<Servicio>();
		this.especie = especie;
	}
	
	public Servicio DarAltaConsulta(Medico M) {
		Consulta c= new Consulta(M,LocalDate.now());
		
		return c;
	}
	public Servicio DarAltaVacunacion(Medico M , String nombre, double costo) {
		Vacunacion v= new Vacunacion(M,nombre,costo,LocalDate.now());
		return v;
	}
	public Servicio DarAltaGuarderia(int cantDias) {
		Guarderia g= new Guarderia(cantDias,LocalDate.now(),this);
		return g;
	}
	
	public double CalcularRecaudacion(LocalDate fecha) {
		double total = miServicio.stream()
				.filter(aux ->aux.cumpleFecha(fecha))
				.mapToDouble(aux-> aux.DevolverMonto())
				.sum();
		return total;
	}
	public boolean cumple() {
		
		if(miServicio.size() >= 5) {
			return true;
			}
		else
			return false;
	}
	
}