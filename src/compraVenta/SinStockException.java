package compraVenta;

public class SinStockException extends Exception {
	
	public SinStockException (String mensaje) {
		super(mensaje);
	}
}
