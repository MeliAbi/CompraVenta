package compraVenta;

import java.util.ArrayList;
import java.util.List;

public class Combo {
	
	protected List<Articulo> listaArticulos=null;
	protected Double precioFinal =0.0;
	protected TIPODEARTICULO tipo=null;

	public Combo() {
		listaArticulos=new ArrayList <Articulo>();
	}
	
	
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	
	public Double aplicarCombo() {
		
		return 0.0;
	}
	
	public Double getPrecioFinal() {
		return precioFinal;
	}
	
	public TIPODEARTICULO getTipo() {
		return tipo;
	}
	
	public void setPrecioFinal(Double p) {
		precioFinal=p;
	}
	

}
