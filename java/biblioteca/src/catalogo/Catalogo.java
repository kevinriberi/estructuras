package catalogo;

import datos.Libro;

/**
* La clase {@code Catalogo} representa un catálogo de libros ({@code Libro}) implementado sobre un arreglo.
* Los métodos principales ofrecidos por esta clase son:
* <ul>
* 	<li>Agregar un nuevo Libro al catálogo.</li>
*	<li>Buscar un Libro por su título</li>
* </ul>
* Esta implementación no realiza ningún tipo de verificación, específicamente:
* <ul>
*	<li>No verifica que un Libro agregado sea no nulo ({@code null}).</li>
*	<li>No verifica que la capacidad para crear un nuevo Catalogo sea mayor o igual a {@code 1}.</li>
* </ul>
* @see Libro
* @version 1.0
*/
public class Catalogo {

	/**
	* La capacidad por defecto de un nuevo Catalogo.
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 3;

	//el arreglo interno de libros.
	private Libro[] libros;
	//la cantidad actual de libros almacenados.
	private int nroLibros;
	
	/**
	* Construye un nuevo {@code Catalogo} usando una capacidad de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public Catalogo() {
		this(CAPACIDAD_POR_DEFECTO);
	}
	
	/**
	* Construye un nuevo {@code Catalogo} con una capacidad dada.
	* @param capacidad : la capacidad del nuevo {@code Catalogo}.
	*/
	public Catalogo(int capacidad) {
		libros = new Libro[capacidad];
		nroLibros = 0;
	}

	/**
	* Retorna {@code true} si este {@code Catalogo} no tiene más capacidad para almacenar libros.
	* @return {@code true} sii no hay capacidad disponible.
	*/
	public boolean estaLleno() {
		return nroLibros == this.libros.length;
	}
	
	/**
	* Agrega un nuevo {@code Libro} a este {@code Catalogo} si el mismo no se encuentra lleno.
	* @param libro : el nuevo {@code Libro} a agregar.
	* @return {@code true} sii el {@code Libro} pudo ser agregado, es decir, {@code estaLleno()} retornó {@code false} previamente a llamar a este método.
	* @see #estaLleno()
	*/
	public boolean agregarLibro(Libro libro) {
		if (this.estaLleno()){
			return false;
		}

		this.libros[nroLibros] = libro;
		nroLibros++;
		return true;
	}
	
	/**
	* Busca un {@code Libro} de acuerdo a un título dado.
	* @param titulo : el título del {@code Libro} a buscar.
	* @return un libro {@code l} que pertenece a este {@code Catalogo} sii {@code l.titulo().equals(titulo)}, {@code null} en caso contrario.
	*/

	public Libro buscarPorTitulo(String titulo) {

		int i = 0;

		while (i < nroLibros && !(this.libros[i].titulo().equals(titulo))){
			i++;
		}

		if (i < nroLibros){
			return this.libros[i];
		}else{
			throw new UnsupportedOperationException ("No se encontró el libro");
		}
	}


	@Override
	public String toString() {
		String resultado = "";

		for (int i = 0; i < this.nroLibros; i++){
					resultado += this.libros[i].toString() + "\n";
				}; 

		return resultado;

	}

}
