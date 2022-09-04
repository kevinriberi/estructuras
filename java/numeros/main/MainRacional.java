package main;

import racional.Racional;

/**
* La clase {@code MainRacional} implementa una aplicación simple para mostrar el uso de {@code Racional}.
* Esta clase no usa parámetros.
* @see numeros.Racional
* @version 1.0
*/

public class MainRacional{

	/**
	* Experimenta con {@code Racional}, sumar, restar y comprobar si dos racionales son iguales.
	* @param args : arguments for this main method, not used in this implementation.
	*/
	public static void main(String[] args) {
		Racional miRacional = new Racional (6, 8);
		Racional otroRacional = new Racional (1, 2);
		System.out.println(miRacional);
		System.out.println(otroRacional);
		miRacional.suma(otroRacional);
		System.out.println(miRacional);
		miRacional.resta(otroRacional);
		System.out.println(miRacional);
		Racional nuevo = new Racional (3, 4);
		System.out.println("12/16 es igual a 3/4??" + miRacional.equals(nuevo));
		miRacional.multiplicar(nuevo);
		System.out.println(miRacional);
		nuevo.dividir(otroRacional);
		System.out.println(nuevo);
		nuevo.inversoAditivo();
		System.out.println(nuevo);
		nuevo.inversoMultiplicativo();
		System.out.println(nuevo);

	}
}
