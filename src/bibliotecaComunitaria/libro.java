package bibliotecaComunitaria;

public class libro {
	String nombre;
	String autor;
	String categoria;
	int existencias;
	
	
	public libro(String nombre, String autor, String categoria, int existencias) {
		this.nombre = nombre;
		this.autor = autor;
		this.categoria = categoria;
		this.existencias = existencias;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getExistencias() {
		return existencias;
	}


	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	
	
	
	
	

}
