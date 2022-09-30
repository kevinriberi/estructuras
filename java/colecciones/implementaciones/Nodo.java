package implementaciones;

/**
* La clase {@code Nodo} será utilizada en la implementación de LinkedLista.
* 
*/

public class Nodo<T> {
	private T valor;
	private Nodo<T> siguiente;
	private Nodo<T> anterior;

	public Nodo () {
		this.valor = null;
		this.siguiente = null;
		this.anterior = null;
	}

	
	public Nodo (T elem){
		this.valor = elem;
		this.siguiente = null;
		this.anterior = null;
	}

	public Nodo (T elem, Nodo<T> nodo){
		this.valor = elem;
		this.siguiente = nodo;
		nodo.anterior = this;
	}

	public T valor () {
		return this.valor;
	}

	public Nodo<T> siguiente () {
		return this.siguiente;
	}

	public Nodo<T> anterior () {
		return this.anterior;
	}

	public void siguiente (Nodo<T> nodo){
		this.siguiente = nodo;
	}

	public void anterior (Nodo<T> nodo){
		this.anterior = nodo; 
	}
}