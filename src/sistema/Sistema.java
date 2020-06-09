package sistema;

import java.util.List;

import archivo.LeerArchivo;
import atracciones.Atraccion;
import catalogo.Catalogo;
import promociones.Promocion;
import usuario.Usuario;

public class Sistema {

	public static void main(String[] args) {
		LeerArchivo archivo = new LeerArchivo();
		archivo.leerArchivo("Archivo/in/usuario.in");
		archivo.leerArchivo("Archivo/in/atraccion.in");
		archivo.leerArchivo("Archivo/in/promocion.in");

		List<Usuario> usuarios = archivo.getUsuarios();
		List<Atraccion> atracciones = archivo.getAtracciones();
		List<Promocion> promociones = archivo.getPromociones();

		Catalogo catalogo = new Catalogo(atracciones, promociones);
		for (Usuario usuario : usuarios) {
			catalogo.ofrecerAtraccion(usuario);
			System.out.println(usuario);
		}

	}
}
