package main;

import lista.Lista;
import implementaciones.LinkedLista;

/**
* La clase {@code MainArrayLista} implementa una aplicación simple para mostrar el uso de {@code ArrayLista}.
* Esta clase no usa parámetros.
* @see lista.Lista
* @see implementaciones.LinkedLista
* @version 1.0
*/

@SuppressWarnings ("unchecked")
public class MainLinkedLista {

	/**
	* @param args : arguments for this main method, not used in this implementation.
	* @see Object#equals(Object)
	*/
	public static void main(String[] args) {
		Integer a = 5;
		Integer b = 7;
		Integer c = 9;
		Integer d = 3;
		Integer e = 9;
		LinkedLista<Integer> miLista = new LinkedLista();
		LinkedLista<Integer> otraLista = new LinkedLista();
		miLista.agregar(a);
		miLista.agregar(b);
		otraLista.agregar(a);
		otraLista.agregar(b);
		otraLista.agregar(c);
		otraLista.insertar(d, 1);
		System.out.println(otraLista.elementos());
		otraLista.eliminar(2);
		System.out.println(otraLista);
		miLista.eliminar(1);
		miLista.insertar(d,1);
		miLista.insertar(e,2);
		System.out.println(miLista);
		System.out.println(miLista.equals(otraLista));
		miLista.agregarTodos(otraLista);
		System.out.println(miLista);
		LinkedLista <Integer> auxLista = (LinkedLista <Integer>) miLista.subLista(0,4);
		System.out.println(auxLista);
		auxLista.vaciar();
		System.out.println(auxLista);
		System.out.println(miLista.obtener(2));
		System.out.println(otraLista.obtener(0));

	} 

}