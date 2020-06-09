package atracciones;

public class Atraccion {
	private String nombre;
	private int cupo;
	private int costo;
	private double duracion;
	private String tipoAtraccion;
	
	public Atraccion(String nombre, String costo, String duracion,String cupo, String tipoAtraccion) {
		this.nombre = nombre;
		this.cupo = Integer.parseInt(cupo);
		this.costo = Integer.parseInt(costo);
		this.duracion = Double.parseDouble(duracion);
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getCosto() {
		return costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}

	@Override
	public String toString() {
		return "Atraccion{" +
				"nombre= '" + nombre + '\'' +
				", cupo= " + cupo +
				", costo= " + costo +
				", duracion= " + duracion +
				", tipoAtraccion= '" + tipoAtraccion + '\'' +
				'}';
	}
}
