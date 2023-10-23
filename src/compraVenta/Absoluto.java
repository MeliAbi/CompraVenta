package compraVenta;

public class Absoluto extends Combo {
	
	private Double descuento = 30000.0;
	
	public Absoluto() {
		generarCombo();
		this.tipo=TIPODEARTICULO.Invaluable;
	}

	private void generarCombo() {
		
		listaArticulos.add(new Articulo(2003,  "Pincel de Picasso",  50000.0,  "Cama de Picasso",  1,  TIPODEARTICULO.Invaluable));
		listaArticulos.add(new Articulo(2007,  "Guardarropas de San Martin",  67989.0,  "producto nuevo",  1,  TIPODEARTICULO.Invaluable));
		
		Double suma=0.0;
		for (Articulo actual : listaArticulos) {
			suma = actual.getPrecio();
		}
		
		suma = suma - descuento;
		setPrecioFinal(suma);
		
	}
	
}
