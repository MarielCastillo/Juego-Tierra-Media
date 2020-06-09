package promociones;

import java.util.List;

import atracciones.Atraccion;

public class AXB extends Promocion {
	private Atraccion atraccion3;

	public AXB(String nombre, String atraccion1, String atraccion2, String atraccion3, List<Atraccion> atracciones) {
		super(nombre, atraccion1, atraccion2, atracciones);
		this.atraccion3 = buscarAtraccion(atraccion3);
	}

	@Override
	public double calculartiempoFinal() {

		return atraccion1.getDuracion() + atraccion2.getDuracion()
				+ atraccion3.getDuracion();
	}

	@Override
	public double calcularCostoFinal() {
		return sumarCostos();
	}

	@Override
	public boolean tieneCupo() {
		return atraccion1.getCupo() > 0 && atraccion2.getCupo() > 0
				&& atraccion3.getCupo() > 0;
	}

}
