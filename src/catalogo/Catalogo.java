package catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import atracciones.Atraccion;
import promociones.Promocion;
import usuario.Usuario;

public class Catalogo {

	private List<Atraccion> atracciones = new ArrayList<Atraccion>();
	private List<Promocion> promociones = new ArrayList<Promocion>();

	public Catalogo(List<Atraccion> atracciones, List<Promocion> promociones) {
		this.atracciones = atracciones;
		this.promociones = promociones;
	}

	private List<Promocion> sugerirPromocion(Usuario usuario) {
		List<Promocion> sugerencia = new ArrayList<Promocion>();

		for (Promocion promocion : promociones) {
			if (usuario.getGustoAtraccion().equalsIgnoreCase(promocion.devolverNombreTipo())
					&& usuario.getPresupuesto() >= promocion.calcularCostoFinal()
					&& usuario.getTiempoDisponible() >= promocion.calculartiempoFinal() && promocion.tieneCupo()) {
				sugerencia.add(promocion);
			}
		}

		return sugerencia;
	}

	private List<Atraccion> sugerirAtracciones(Usuario usuario) {
		List<Atraccion> sugerencia = new ArrayList<Atraccion>();

		for (Atraccion atraccion : atracciones) {
			if (atraccionDistonible(usuario, atraccion)) {
				sugerencia.add(atraccion);
			}
		}

		return sugerencia;
	}

	private boolean atraccionDistonible(Usuario usuario, Atraccion atraccion) {
		return atraccion.getTipoAtraccion().equals(usuario.getGustoAtraccion()) && atraccion.getCupo() >= 1
				&& atraccion.getCosto() <= usuario.getPresupuesto()
				&& atraccion.getDuracion() <= usuario.getTiempoDisponible();
	}

	public List<Atraccion> ofrecerAtraccion(Usuario usuario) {
		List<Promocion> promocionesFiltradas = sugerirPromocion(usuario);
		List<Atraccion> atraccionesFiltradas = sugerirAtracciones(usuario);
		List<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
		List<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();
		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();

		for (Promocion promocion : promocionesFiltradas) {

			@SuppressWarnings("resource")
			Scanner entrada = new Scanner(System.in);
			boolean teclaIncorrecta = true;

			while (teclaIncorrecta) {

				System.out
						.println("Desea visitar " + promocion.getNombre() + promocion.devolverNombreTipo() + " (s/n)");
				String decision = entrada.nextLine();

				if (this.validar(decision)) {
					promocionesAceptadas.add(promocion);
					teclaIncorrecta = false;

				}
			}
		}

		for (Atraccion atraccion : atraccionesFiltradas) {

			@SuppressWarnings("resource")
			Scanner entrada1 = new Scanner(System.in);
			boolean teclaIncorrecta = true;

			while (teclaIncorrecta) {

				System.out.println("Desea visitar " + atraccion.getNombre() + atraccion.getTipoAtraccion() + " (s/n)");
				String decision = entrada1.nextLine();

				if (this.validar(decision)) {
					atraccionesAceptadas.add(atraccion);
					teclaIncorrecta = false;
				}
			}
		}

		todasLasAtracciones.add((Atraccion) atraccionesAceptadas);
		todasLasAtracciones.add((Atraccion) promocionesAceptadas);

		return todasLasAtracciones;

	}

	public boolean validar(String entrada) {

		if (Character.toUpperCase(entrada.charAt(0)) == 'S' || Character.toUpperCase(entrada.charAt(0)) == 'N') {
			return true;
		} else {
			System.out.println("Valor no permitido, volver a ingresar");
			return false;
		}

	}
}
