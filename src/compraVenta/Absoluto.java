package compraVenta;

public class Absoluto extends Combo {
	
	private Double cantidad=0.0;

	public Absoluto(Double cant, TIPODEARTICULO tipo) {
		super(tipo);
		this.cantidad=cant;
	}

	public Double getCantidad(){
		return cantidad;
	}
	
}
