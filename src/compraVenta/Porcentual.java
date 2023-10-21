package compraVenta;

public class Porcentual extends Combo {
	
	private Integer porcentaje=0;

	public Porcentual(Integer porcentaje, TIPODEARTICULO tipo) {
		super(tipo);
		this.porcentaje=porcentaje;
	}
	
	public Integer getPorcentaje() {
		return porcentaje;
	}

}
