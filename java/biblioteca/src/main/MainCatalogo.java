package main;

import datos.Libro;
import catalogo.Catalogo;

/**
* La clase {@code MainCatalogo} implementa una aplicación simple para mostrar el uso de {@code Catalogo} junto con {@code Libro}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see catalogo.Catalogo
* @see datos.Libro
* @version 1.0
*/
public class MainCatalogo {

	/**
	* Experimenta con {@code Catalogo}, agregar libros, buscar, y mostrar el {@code Catalogo}.
	* @param args : arguments for this main method, not used in this implementation.
	*/
	public static void main(String[] args) {
		Libro libro1 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro2 = new Libro("Isaac Asimov", "The Naked Sun", 47);
		Libro libro3 = new Libro("Gabriel García Marquez", "100 años de soledad", 496);
		Libro libro4 = new Libro("Yuval Noah Harari", "Sapiens: De Animales a Dioses", 496);
		Libro libro5 = new Libro("George Orwell", "1984", 352);
		Catalogo catalogo = new Catalogo();
		catalogo.agregarLibro(libro1);
		catalogo.agregarLibro(libro2);
		catalogo.agregarLibro(libro3);
		catalogo.agregarLibro(libro4);
		catalogo.agregarLibro(libro5);

		System.out.println("Catalogo:\n" + catalogo);


		Libro libroEncontrado = catalogo.buscarPorTitulo(libro1.titulo());
		System.out.println(libroEncontrado);
		libroEncontrado = catalogo.buscarPorTitulo("El principito");
		System.out.println(libroEncontrado);
	} 

}
