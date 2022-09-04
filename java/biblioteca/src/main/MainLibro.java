package main;

import datos.Libro;

/**
* La clase {@code MainLibro} implementa una aplicación simple para mostrar el uso de {@code Libro}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see datos.Libro
* @version 1.0
*/
public class MainLibro {

	/**
	* Experimenta con libros, sus métodos y la diferencia entre usar {@code equals()} y {@code ==}.
	* @param args : arguments for this main method, not used in this implementation.
	* @see Object#equals(Object)
	*/
	public static void main(String[] args) {
		Libro libro1 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro2 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro3 = new Libro("Isaac Asimov", "The Naked Sun", 47);
		Libro libro4 = new Libro("Gabriel García Marquez", "100 años de soledad", 496);
		Libro libro5 = new Libro("Yuval Noah Harari", "Sapiens: De Animales a Dioses", 496);
		Libro libro6 = new Libro("George Orwell", "1984", 352);
		Libro libro7 = new Libro("George Orwell", "1984", 352);
		System.out.println(libro1 + " y " + libro2 + "\nSon iguales usando equals? " + (libro1.equals(libro2)));
		System.out.println(libro1 + " y " + libro2 + "\nSon iguales usando ==? " + (libro1 == libro2));
		System.out.println(libro1 + " y " + libro3 + "\nSon iguales usando equals? " + (libro1.equals(libro3)));
		System.out.println(libro1 + " y " + libro3 + "\nSon iguales usando ==? " + (libro1 == libro3));
		System.out.println(libro4 + " y " + libro5 + "\nSon iguales usando equals ? " + (libro4.equals(libro5)));
		System.out.println(libro6 + " y " + libro7 + "\nSon iguales usando equals ? " + (libro6.equals(libro7)));
		System.out.println(libro6 + " y " + libro7 + "\nSon iguales usando ==? " + (libro6==libro7));
		//TODO: realice más pruebas
	} 

}
