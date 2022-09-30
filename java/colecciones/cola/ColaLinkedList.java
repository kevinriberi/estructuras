package cola;

import java.util.Collection;
import implementaciones.Nodo;

/**
* Implementación basada en listas enlazadas de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
* @see colecciones.implementaciones.Nodo
*/
public class ColaLinkedList<T> implements Cola<T> {

	//nodos doblememente enlazados, uno apunta al inicio de la cola y otro al ultimo
	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int cantidad;

	/**
	* Construye una nueva cola vacía 
	*/

	public ColaLinkedList () {
		primero = null;
		ultimo = null;
		cantidad = 0;
	}

	//creacion de una cola a partir de un nodo
	public ColaLinkedList (Nodo<T> nodo){
		primero = nodo;
		ultimo = nodo;
		cantidad++;
	}

	/**
	* Permite evaluar si la cola no tiene elementos.
	* @return {@code true} sii la cola no tiene elementos
	*/
	public boolean esVacia(){
		return cantidad == 0;
	}


	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	public boolean encolar(T elem){
		Nodo<T> nuevoNodo = new Nodo<T> (elem);

		//si la lista esta vacia, el primero y ultimo seran el mismo nodo
		if (this.esVacia()){
			this.primero = nuevoNodo;
			this.ultimo = nuevoNodo;
			this.cantidad++;

			return true;
		}

		//si la lista ya contiene al menos un elemento, hay que insertar en la ultima posicion
		nuevoNodo.anterior(this.ultimo);
		this.ultimo.siguiente(nuevoNodo);

		//reacomodo al nuevoNodo para que sea el ultimo de la cola

		this.ultimo = nuevoNodo;
		this.cantidad++;

		return true;
	}


	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T desencolar(){
		if (this.esVacia()){
			throw new IllegalStateException ("La cola esta vacia. Imposible desencolar.");
		}

		if (this.cantidad == 1){
			//mantengo una referencia al elemento a desapilar
			T elem_desencolado = this.primero.valor();

			this.primero = null;
			this.ultimo = null;
			this.cantidad--;

			return elem_desencolado;
		}

		//mantengo una referencia al elemento a desapilar
		T elem_desencolado = this.primero.valor();

		//hago las reasignaciones de nodos correspondientes
		this.primero = this.primero.siguiente();
		this.primero.anterior(null);
		this.cantidad--;

		return elem_desencolado;
	}

	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T primero(){
		if (this.esVacia()){
			throw new IllegalStateException ("La cola esta vacia. Imposible acceder al primer elemento");
		}

		return this.primero.valor();
	}

	/**
	* Remueve todos los elementos en la cola.
	*/
	public void vaciar(){
		//desreferencio a todos los nodos
		this.primero = null;
		this.ultimo = null;
		this.cantidad = 0;
	}

	/**
	* @return cantidad de elementos en la cola.
	*/
	public int elementos(){
		return this.cantidad;
	}

	/**
	* Invariante de clase.
	* @return {@code true} sii la cola satisface su invariante de clase
	*/
	public boolean repOK(){
		return true;
	}

	@Override
	public String toString(){
		if (this.esVacia()){
			return "[]";
		}

		String resultado = "[";
		Nodo<T> cursor = this.primero;

		while (cursor != this.ultimo){
			resultado += cursor.valor().toString() + ", ";
			cursor = cursor.siguiente();
		}

		resultado += cursor.valor().toString() + "]";

		return resultado;
	}

	@Override
	public boolean equals(Object other){
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Cola))
			return false;
		Cola otraCola = (Cola) other;
		if (otraCola.elementos() != this.cantidad)
			return false;
		for (int i = 0; i < this.cantidad; i++){
			if (!(this.desencolar().equals(otraCola.desencolar() )))
				return false;
		}

		return true;
	}

}