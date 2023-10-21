package compraVenta;

public class AXB extends Combo {
	
	private Integer cantidad=0;

	public AXB(Integer cantidad, TIPODEARTICULO tipo) {
		super(tipo);
		this.cantidad=cantidad;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}

}