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
		Racional miRacional = new Racional (3, 4);
		Racional otroRacional = new Racional (1, 2);
		System.out.println ("El resultado de sumar " + miRacional + " y " + otroRacional + " es: " + miRacional.suma(otroRacional));
		System.out.println ("El resultado de restar " + miRacional + " y " + otroRacional + " es: " + miRacional.resta(otroRacional));
		System.out.println ("El resultado de multiplicar " + miRacional + " y " + otroRacional + " es: " + miRacional.multiplicar(otroRacional));
		System.out.println ("El resultado de dividir " + miRacional + " y " + otroRacional + " es: " + miRacional.dividir(otroRacional));
		System.out.println ("El inverso aditivo de " + miRacional + " es: " + miRacional.inversoAditivo());
		System.out.println ("El inverso multiplicativo de " + miRacional + " es:" + miRacional.inversoMultiplicativo());
	}
}
