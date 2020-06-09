package usuario;


public class Usuario {
    private int presupuesto;
    private int tiempoDisponible;
    private String gustoAtraccion;
    private String nombre;

    public Usuario(String tipoDeAtraccion, String nombre, String presupuesto, String tiempoDisponible) {
        this.presupuesto = Integer.parseInt(presupuesto);
        this.tiempoDisponible = Integer.parseInt(tiempoDisponible);
        this.gustoAtraccion = tipoDeAtraccion;
        this.nombre = nombre;
    }

	public Integer getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(int tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public String getGustoAtraccion() {
		return gustoAtraccion;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"presupuesto= " + presupuesto +
				", tiempoDisponible= " + tiempoDisponible +
				", gustoAtraccion= '" + gustoAtraccion + '\'' +
				", nombre= '" + nombre + '\'' +
				'}';
	}
}