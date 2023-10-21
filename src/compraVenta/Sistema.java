package compraVenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sistema {
	
	private String nombre= "";
	private Map<Integer,Usuario> listaDeUsuarios=null;
	private Map<Integer,Articulo> listaDeArticulos=null;
	private List<Combo> listaDeCombos=null;

	public Sistema(String nombre) {
		this.nombre=nombre;
		listaDeUsuarios= new TreeMap<Integer,Usuario>();
		listaDeArticulos= new TreeMap<Integer,Articulo>();
		listaDeCombos= new ArrayList<Combo>();
		generarListaDeArticulos();
		generarListaDeCombos();
	}
	
	private void generarListaDeArticulos() {
		listaDeArticulos.put(2001, new Articulo(2001,  "Sofa chino",  4500.0,  "Sofa chino",  5,  TIPODEARTICULO.Antiguedad));
		listaDeArticulos.put(2002, new Articulo(2002,  "Jarron Indio",  50000.0,  "Jarron Indio",  2,  TIPODEARTICULO.Antiguedad));
		listaDeArticulos.put(2003, new Articulo(2003,  "Pincel de Picasso",  100000.0,  "Cama de Picasso",  1,  TIPODEARTICULO.Invaluable));
		listaDeArticulos.put(2004, new Articulo(2004,  "Mesada de marmol",  654898.0,  "Mesada de marmol",  10,  TIPODEARTICULO.DeLujo));
		listaDeArticulos.put(2005, new Articulo(2005,  "La primer birome",  4700980.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		listaDeArticulos.put(2006, new Articulo(2006,  "Bicicleta del 1910",  14000.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		listaDeArticulos.put(2007, new Articulo(2007,  "Guardarropas de San Martin",  9807536.0,  "producto nuevo",  1,  TIPODEARTICULO.Invaluable));
		listaDeArticulos.put(2008, new Articulo(2008,  "Alajero de oro",  32019.0,  "producto nuevo",  25,  TIPODEARTICULO.DeLujo));
	}
	
	private void generarListaDeCombos() {
		listaDeCombos.add(new Porcentual(30,TIPODEARTICULO.DeLujo));
		listaDeCombos.add(new Absoluto(15000.0,TIPODEARTICULO.Invaluable));
		listaDeCombos.add(new Absoluto(5000.0,TIPODEARTICULO.Exoticos));
		listaDeCombos.add(new AXB(3,TIPODEARTICULO.Antiguedad));
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
	
	public Combo buscarCombo(TIPODEARTICULO tipo) {
		
		for(Combo actual : listaDeCombos) {
			if(actual.getTipo()==tipo) {
				return actual;
			}
		}
		return null;
				
	}

	public void procesarCompra(Integer dni, Integer codArt) throws CreditosInsuficientesException, SinStockException {

		Articulo art =buscarArticulo(codArt);
		Usuario user =buscarUsuario(dni);
		
		if(art.getPrecio()<=user.getPresupuesto()) {
			if(art.getCantidad()>0) {
				Integer i = buscarArticulo(codArt).getCantidad();
				i--;
				buscarArticulo(codArt).setCantidad(i);
				buscarUsuario(dni).setPresupuesto(user.getPresupuesto()-art.getPrecio());
			}else {
				throw new SinStockException("No hay stock del articulo " + art.getNombre());
			}

		}else {
			throw new CreditosInsuficientesException("Creditos insuficientes");
		}
		
	}

}
