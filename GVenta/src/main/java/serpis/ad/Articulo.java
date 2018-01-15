package serpis.ad;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
public class Articulo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long categoria;
	private String nombre;
	private BigDecimal precio;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getCategoria() {
		return categoria;
	}
	public void setCategoria(long categoria) {
		this.categoria = categoria;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s %s€ Categoria %s", id, nombre, precio, categoria);

	}

	
}