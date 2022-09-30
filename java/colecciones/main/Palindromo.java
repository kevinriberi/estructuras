package main;

import cola.Cola;
import cola.ColaArregloFijo;
import cola.ColaLinkedList;

/**
* La clase {@code Palindromo} implementa una aplicación simple para evaluar si una secuencia de caracteres es un palíndromo, utilizando el TAD {@code Cola}.
* Esta clase usa parámetros que representan los símbolos para evaluar el balance.
* @see colecciones.pila.Pila
*/
public class Palindromo {
	/**
	* Dada una secuencia de símbolos (paréntesis, corchetes, y llaves), se deben imprimir {@code True} ó {@code False} si la secuencia es un palindromo o no respectivamente, utilizando el TAD {@code Cola}.
	* Ejemplo de uso: 
	* <ul>
	* 	<li>Al ejecutar <pre>java main.Palindromo neuquen</pre>, se debe imprimir {@code True}.</li>
	* 	<li>Al ejecutar <pre>java main.Palindromo cordoba</pre>, se debe imprimir {@code False}.</li>
	* </ul>
	* @param args : los símbolos a analizar.
	*/

	private static String convertirCaracteres (String[] args){
		String resultado = "";
		for (int i = 0; i < args.length; i++){
			resultado += args[i].toLowerCase().replace(" ","").replace(".","").replace(",","");
		}

		return resultado;
	}

	private static void cargarPalabra (String entrada, Cola<Character> cola){
		for (int i = 0; i < entrada.length(); i++){
			cola.encolar(entrada.charAt(i));
		}
	}

	private static boolean esPalindromo (String entrada, Cola<Character> cola){
		boolean resultado = true;

		for (int i = entrada.length() - 1; i >= 0; i--){
			resultado &= entrada.charAt(i) == cola.desencolar();
		}

		return resultado;
	}

	public static void main(String[] args) {
		String entradaModificada = convertirCaracteres(args);
		//System.out.println(args[0].length());
		Cola<Character> miCola = new ColaLinkedList<Character> ();
		cargarPalabra(entradaModificada, miCola);
		System.out.println(esPalindromo(entradaModificada, miCola));
	}

}