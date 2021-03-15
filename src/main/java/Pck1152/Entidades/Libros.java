package Pck1152.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Libros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	@NotNull
	@Size(min = 1, max = 100)
	private String titulo;
	@NotNull
	@Size(min = 1, max = 100)
	private String genero;
	@NotNull
	private String autor;
	
	public Libros(@NotNull @Size(min = 1, max = 100) String titulo, @NotNull @Size(min = 1, max = 100) String genero,
			@NotNull String autor) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
	}
	public Libros() { super(); }
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
