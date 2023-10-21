package compraVenta;

import java.util.ArrayList;

public class AXB extends Combo {
	
	public AXB() {
		generarCombo();
	}

	private void generarCombo() {
		
		ArrayList<Articulo> listaArt = null;
		
		listaArt.add(new Articulo(2004,  "Mesada de marmol",  654898.0,  "Mesada de marmol",  10,  TIPODEARTICULO.DeLujo));
		listaArt.add(new Articulo(2008,  "Alajero de oro",  32019.0,  "producto nuevo",  25,  TIPODEARTICULO.DeLujo));
		listaArt.add(new Articulo(2008,  "Alajero de oro",  32019.0,  "producto nuevo",  25,  TIPODEARTICULO.DeLujo));
		
		setListaArticulos(listaArt);
		
		Double suma=0.0;
		for (Integer i=0; i<2; i++) {
			suma = listaArt.get(i).getPrecio();
		}
		
		setPrecioFinal(suma);
		
	}

}