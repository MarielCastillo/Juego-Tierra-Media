package promociones;

import java.util.List;

import atracciones.Atraccion;

public class Porcentual extends Promocion {
    private int descuento;
    
	public Porcentual(String nombre, String atraccion1, String atraccion2, String descuento, List<Atraccion> atracciones) {
		super(nombre, atraccion1, atraccion2, atracciones);
		this.descuento = Integer.parseInt(descuento);
	}

	@Override
	public double calcularCostoFinal() {
		return sumarCostos()-(sumarCostos()*(descuento/100));
	}
}
