package compraVenta;

import java.util.ArrayList;
import java.util.List;

public class Combo {
	
	private List<Articulo> listaArticulos=null;
	private Double precioFinal =0.0;

	public Combo() {
		listaArticulos=new ArrayList <Articulo>();
	}
	
	
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	
	public Double aplicarCombo() {
		
		return 0.0;
	}
	
	public void setListaArticulos(ArrayList <Articulo> a) {
		listaArticulos.addAll(a);
	}
	
	public Double getPrecioFinal() {
		return precioFinal;
	}
	
	public void setPrecioFinal(Double p) {
		precioFinal=p;
	}
	

}
