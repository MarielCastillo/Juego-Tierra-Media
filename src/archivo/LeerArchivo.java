package archivo;

import atracciones.Atraccion;
import promociones.AXB;
import promociones.Absoluto;
import promociones.Porcentual;
import promociones.Promocion;
import usuario.Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
	List<Usuario> usuarios = new ArrayList<Usuario>();
	List<Atraccion> atracciones = new ArrayList<Atraccion>();
	List<Promocion> promociones = new ArrayList<Promocion>();

	@SuppressWarnings("null")
	public void leerArchivo(String archivoConRuta) {

		archivo = new File(archivoConRuta);

		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				if (archivoConRuta.equals("Archivo/in/usuario.in")) {
					String[] parts = linea.split(",");
					String nombre = parts[0];
					String tipo = parts[1];
					String monedas = parts[2];
					String tiempo = parts[3];
					Usuario usuario = new Usuario(tipo, nombre, monedas, tiempo);
					System.out.println(usuario.toString());
					usuarios.add(usuario);

				} else if (archivoConRuta.equals("Archivo/in/atraccion.in")) {
					String[] parts1 = linea.split(",");
					String nombreAtraccion = parts1[0];
					String costo = parts1[1];
					String duracion = parts1[2];
					String cupo = parts1[3];
					String tipoAtraccion = parts1[4];
					Atraccion atraccion = new Atraccion(nombreAtraccion, costo, duracion, cupo, tipoAtraccion);
					System.out.println(atraccion.toString());
					atracciones.add(atraccion);

				}
				if (archivoConRuta.equals("Archivo/in/promocion.in")) {
					String[] parts2 = linea.split(",");
					String nombrePack = parts2[0];
					String nameAtraccion1 = parts2[1];
					String nameAtraccion2 = parts2[2];
					String descuento = parts2[3];
                        
					if (nombrePack.equals("Pack aventura")) {
						Porcentual porcentual = new Porcentual(nombrePack, nameAtraccion1, nameAtraccion2, descuento,
								atracciones);
						System.out.println(porcentual.toString());
						promociones.add(porcentual);
					} else if (nombrePack.equals("Pack degustación")) {
						Absoluto absoluto = new Absoluto(nombrePack, nameAtraccion1, nameAtraccion2, descuento,
								atracciones);
						System.out.println(absoluto.toString());
						promociones.add(absoluto);
					} else {
						AXB axb = new AXB(nombrePack, nameAtraccion1, nameAtraccion2, descuento, atracciones);
						System.out.println(axb.toString());
						promociones.add(axb);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
