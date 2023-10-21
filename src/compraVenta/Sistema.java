package compraVenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sistema {
	
	private String nombre= "";
	private Map<Integer,Usuario> listaDeUsuarios=null;
	private List<Articulo> listaDeArticulos=null;
	private List<Combo> listaDeCombos=null;

	public Sistema(String nombre) {
		this.nombre=nombre;
		listaDeUsuarios= new TreeMap<Integer,Usuario>();
		listaDeArticulos= new ArrayList<Articulo>();
		listaDeCombos= new ArrayList<Combo>();
		generarListaDeArticulos();
		generarListaDeCombos();
	}
	
	private void generarListaDeArticulos() {
		listaDeArticulos.add(new Articulo(2001,  "Sofa chino",  452312300.0,  "Sofa chino",  5,  TIPODEARTICULO.Antiguedad));
		listaDeArticulos.add(new Articulo(2002,  "Jarron Indio",  500.0,  "Jarron Indio",  2,  TIPODEARTICULO.Antiguedad));
		listaDeArticulos.add(new Articulo(2003,  "Pincel de Picasso",  100000.0,  "Cama de Picasso",  0,  TIPODEARTICULO.Invaluable));
		listaDeArticulos.add(new Articulo(2004,  "Mesada de marmol",  654898.0,  "Mesada de marmol",  10,  TIPODEARTICULO.DeLujo));
		listaDeArticulos.add(new Articulo(2005,  "La primer birome",  4700980.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		listaDeArticulos.add(new Articulo(2006,  "Bicicleta del 1910",  14000.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		listaDeArticulos.add(new Articulo(2007,  "Guardarropas de San Martin",  9832738.0,  "producto nuevo",  1,  TIPODEARTICULO.Invaluable));
		listaDeArticulos.add(new Articulo(2008,  "Alajero de oro",  32019.0,  "producto nuevo",  25,  TIPODEARTICULO.DeLujo));
	}
	
	private void generarListaDeCombos() {
		listaDeCombos.add(new Porcentual());
		listaDeCombos.add(new Absoluto());
		listaDeCombos.add(new Absoluto());
		listaDeCombos.add(new AXB());
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

	public Articulo buscarArticulo(Integer cod) {
		
		for(Articulo actual : listaDeArticulos) {
			if(actual.getId()==cod) {
				return actual;
			}
		}
		return null;
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
	
	public ArrayList<Articulo> devolverListaArticulosPorTipo(TIPODEARTICULO tipo) {
		
		ArrayList<Articulo> listaArt = new ArrayList<Articulo>();

		for (Articulo a : listaDeArticulos) {
		    if(a.getTipoDeArticulo()==tipo) {
		    	listaArt.add(a);
		    }
		}
		return listaArt;		
		
	}
	
	public Articulo validarCriterios(ArrayList<Articulo> listaArt, Usuario user) {
		
		for (Articulo a : listaArt) {
			if(a.getCantidad()>0 && a.getPrecio()<=user.getPresupuesto() && user.buscarArticuloComprado(a.getId())==null ) {
				return a;
			}
		}
		
		return null;
	}

	public Articulo recomendarArticulo(Usuario user) {
		
		ArrayList <TIPODEARTICULO> TDA = new ArrayList <TIPODEARTICULO>();
		TDA.add(TIPODEARTICULO.Antiguedad);
		TDA.add(TIPODEARTICULO.DeLujo);
		TDA.add(TIPODEARTICULO.Exoticos);
		TDA.add(TIPODEARTICULO.Invaluable);		
		
		TDA.remove(user.getArticuloPreferido());
		
		ArrayList<Articulo> listaArt = devolverListaArticulosPorTipo(user.getArticuloPreferido());
		
		Articulo a=validarCriterios(listaArt, user);
		
		if(a!=null) {
			return a;
		}
		
		for(Integer i=0; i<TDA.size();i++) {
			listaArt = devolverListaArticulosPorTipo(TDA.get(i));
			a=validarCriterios(listaArt, user);
			if(a!=null) {
				return a;
			}
			
		}
				
		
		return null;
		
	}

}
