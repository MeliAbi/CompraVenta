package compraVenta;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private Integer dni=null;
	private Double presupuesto=0.0;
	private TIPODEARTICULO articuloPreferido=null;
	private String nombre="";
	private List<Articulo> listaDeArticulosComprados=null;
	

	public Usuario(Integer id, String nombre, Double presupuesto, TIPODEARTICULO tda) {
		this.nombre=nombre;
		this.presupuesto=presupuesto;
		this.articuloPreferido=tda;
		this.dni=id;
		listaDeArticulosComprados=new ArrayList<Articulo>();
	}
	
	
	public Integer getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Double getPresupuesto() {
		return presupuesto;
	}
	
	public TIPODEARTICULO getArticuloPreferido() {
		return articuloPreferido;
	}
	
	public void setPresupuesto( Double a) {
		presupuesto=a;
	}
	
	public List<Articulo> getListaDeArticulosComprados(){
		return listaDeArticulosComprados;
	}
	
	public Articulo buscarArticuloComprado(Integer cod){

		for(Articulo actual : listaDeArticulosComprados) {
			if(actual.getId()==cod) {
				return actual;
			}
		}
		return null;
	}

}
