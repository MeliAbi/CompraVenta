package compraVenta;

import java.util.Map;
import java.util.TreeMap;

public class Sistema {
	
	private String nombre= "";
	private Map<Integer,Usuario> listaDeUsuarios=null;
	private Map<Integer,Articulo> listaDeArticulos=null;

	public Sistema(String nombre) {
		this.nombre=nombre;
		listaDeUsuarios= new TreeMap<Integer,Usuario>();
		listaDeArticulos= new TreeMap<Integer,Articulo>();
		generarListaDeArticulos();
	}
	
	private void generarListaDeArticulos() {
		listaDeArticulos.put(2001, new Articulo(2001,  "Sofa chino",  4500.0,  "Sofa chino",  5,  TIPODEARTICULO.Antiguedad));
		listaDeArticulos.put(2002, new Articulo(2002,  "Jarron Indio",  50000.0,  "Jarron Indio",  2,  TIPODEARTICULO.Antiguedad));
		listaDeArticulos.put(2003, new Articulo(2003,  "Cama de Picasso",  1000000.0,  "Cama de Picasso",  1,  TIPODEARTICULO.Invaluable));
		listaDeArticulos.put(2004, new Articulo(2004,  "Mesada de marmol",  654898.0,  "Mesada de marmol",  10,  TIPODEARTICULO.DeLujo));
		listaDeArticulos.put(2005, new Articulo(2005,  "La primer birome",  4700980.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		listaDeArticulos.put(2006, new Articulo(2006,  "Bicicleta del 1910",  14000.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		listaDeArticulos.put(2007, new Articulo(2007,  "Guardarropas de San Martin",  9807536.0,  "producto nuevo",  1,  TIPODEARTICULO.Invaluable));
		listaDeArticulos.put(2008, new Articulo(2008,  "Alajero de oro",  32019.0,  "producto nuevo",  25,  TIPODEARTICULO.DeLujo));
	}

	public String getNombre() {
		return nombre;
	}

	public void registrarUsuario(Usuario usuario) {
		listaDeUsuarios.put(usuario.getDni(), usuario);
	}

	public Usuario buscarUsuario(Integer i) {
		return listaDeUsuarios.get(i);
	}

	public Articulo buscarArticulo(Integer i) {
		return listaDeArticulos.get(i);
	}

}
