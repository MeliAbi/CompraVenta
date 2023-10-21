package compraVenta;

public class Usuario {

	private Integer dni=null;
	private Double presupuesto=0.0;
	private TIPODEARTICULO articuloPreferido=null;
	private String nombre="";

	public Usuario(Integer id, String nombre, Double presupuesto, TIPODEARTICULO tda) {
		this.nombre=nombre;
		this.presupuesto=presupuesto;
		this.articuloPreferido=tda;
		this.dni=id;
	}
	
	
	public Integer getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Double getPresupuesto() {
		return presupuesto;
	}
	
	public TIPODEARTICULO getArticuloPreferido() {
		return articuloPreferido;
	}
	
	public void setPresupuesto( Double a) {
		presupuesto=a;
	}

}
