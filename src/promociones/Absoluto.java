package promociones;

import atracciones.Atraccion;

import java.util.List;

public class Absoluto extends Promocion {
	private int descuento;

	public Absoluto(String nombre, String atraccion1, String atraccion2, String descuento, List<Atraccion> atracciones) {
		super(nombre, atraccion1, atraccion2, atracciones);
		this.descuento = Integer.parseInt(descuento);
	}

	@Override
	public double calcularCostoFinal() {
		return descuento;
	}
	
	
}