package compraVenta;


public class Porcentual extends Combo {
	
	private Double porcentaje = 0.3;
	
	public Porcentual() {
		generarCombo();
		this.tipo=TIPODEARTICULO.Exoticos;
	}

	private void generarCombo() {
		
		listaArticulos.add(new Articulo(2005,  "La primer birome",  14000.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		listaArticulos.add(new Articulo(2006,  "Bicicleta del 1910",  14000.0,  "producto nuevo",  1,  TIPODEARTICULO.Exoticos));
		
		Double suma=0.0;
		for (Articulo actual : listaArticulos) {
			suma = actual.getPrecio();
		}
		
		suma = suma-(suma*porcentaje);
		setPrecioFinal(suma);
		
	}

}
