package promociones;

import java.util.ArrayList;
import java.util.List;

import atracciones.Atraccion;

public abstract class Promocion {

	private String nombre;

	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	List<Atraccion> atracciones = new ArrayList<Atraccion>();

	public Promocion(String nombre, String atraccion1, String atraccion2, List<Atraccion> atracciones) {
		this.nombre = nombre;
		this.atraccion1 = buscarAtraccion(atraccion1);
		this.atraccion2 = buscarAtraccion(atraccion2);
		this.atracciones = atracciones;

	}

	public String getNombre() {
		return nombre;
	}

	public Atraccion getAtraccion1() {
		return atraccion1;
	}

	public Atraccion getAtraccion2() {
		return atraccion2;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	protected Atraccion buscarAtraccion(String otraAtraccion) {
		Atraccion atraccionRetorno = null ;
		for (Atraccion atraccion : atracciones) {
		//	System.out.println(atraccion.getNombre());
		//	System.out.println(otraAtraccion);
			if (atraccion.getNombre().equalsIgnoreCase(otraAtraccion)) {
				atraccionRetorno = atraccion;
			}
		
		}
		return atraccionRetorno;
	}

	public double sumarCostos() {

		return atraccion1.getCosto() + atraccion2.getCosto();

	}

	public double calculartiempoFinal() {
		return atraccion1.getDuracion() +atraccion2.getDuracion();
	}

	public String devolverNombreTipo() {
		return atraccion1.getTipoAtraccion();
	}

	public boolean tieneCupo() {
		return atraccion1.getCupo() > 0 && atraccion2.getCupo() > 0;
	}

	public abstract double calcularCostoFinal();

	@Override
	public String toString() {
		return "Promocion [nombre=" + nombre + ", atraccion1=" + atraccion1 + ", atraccion2=" + atraccion2
				+ ", atracciones=" + atracciones + "]";
	}

}