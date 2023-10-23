package compraVenta;


public class AXB extends Combo {
	
	public AXB() {
		generarCombo();
		this.tipo=TIPODEARTICULO.DeLujo;
	}

	private void generarCombo() {
		
		listaArticulos.add(new Articulo(2004,  "Mesada de marmol",  654898.0,  "Mesada de marmol",  10,  TIPODEARTICULO.DeLujo));
		listaArticulos.add(new Articulo(2008,  "Alajero de oro",  32019.0,  "producto nuevo",  25,  TIPODEARTICULO.DeLujo));
		listaArticulos.add(new Articulo(2008,  "Alajero de oro",  32019.0,  "producto nuevo",  25,  TIPODEARTICULO.DeLujo));
		
		
		Double suma=0.0;
		for (Integer i=0; i<2; i++) {
			suma = listaArticulos.get(i).getPrecio();
		}
		
		setPrecioFinal(suma);
		
	}

}