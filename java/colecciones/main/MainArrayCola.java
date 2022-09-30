package main;

import cola.Cola;
import cola.ColaArregloFijo;

/**
* La clase {@code MainArrayCola} implementa una aplicación simple para mostrar el uso de {@code ArrayCola}.
* Esta clase no usa parámetros.
* @see cola.Cola
* @see cola.ColaArregloFijo
* @version 1.0
*/

public class MainArrayCola {

	/**
	* @param args : arguments for this main method, not used in this implementation.
	* @see Object#equals(Object)
	*/
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 4;
		Integer e = 5;
		Cola<Integer> miCola = new ColaArregloFijo<Integer> (2);
		miCola.encolar(a);
		miCola.encolar(b);
		miCola.encolar(c);
		System.out.println(miCola);
		miCola.desencolar();
		System.out.println(miCola);
		miCola.vaciar();
		System.out.println(miCola);
	}
}