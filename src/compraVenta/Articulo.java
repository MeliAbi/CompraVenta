package compraVenta;

public class Articulo {

	private String nombre="";
	private Integer id=null;
	private Double precio=0.0;
	private String descripcion="";
	private Integer cantidad=0;
	private TIPODEARTICULO tipoDeArticulo=null;

	public Articulo(Integer id, String nombre, Double precio, String desc, Integer cant, TIPODEARTICULO tda) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.descripcion=desc;
		this.cantidad=cant;
		this.tipoDeArticulo=tda;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public TIPODEARTICULO getTipoDeArticulo() {
		return tipoDeArticulo;
	}

	public void setCantidad(Integer c) {
		cantidad=c;
	}
	
	public void setPrecio(Double p) {
		precio=p;
	}
	
	public String toString() {
		return "ID: " + id + "\n" +
				"Nombre: " + nombre + "\n" + 
				"Tipo: " + tipoDeArticulo;
	}
	
}
