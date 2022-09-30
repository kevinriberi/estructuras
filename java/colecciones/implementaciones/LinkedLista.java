package implementaciones;


import lista.Lista;

/**
* Implementación de la interface {@code Lista} mediante listas enlazadas
* 
*/

public class LinkedLista<T> implements Lista<T> {
	private Nodo<T> cabeza;
	private int cantidad;

	public LinkedLista () {
		this.cabeza = null;
		this.cantidad = 0;
	}

	public LinkedLista (Nodo<T> nodo){
		this.cabeza = nodo;
		this.cantidad = 1;
	}

	/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/

	@SuppressWarnings ("unchecked")
	public boolean agregar(T elem){
		Nodo<T> nuevoNodo = (Nodo<T>) new Nodo (elem);

		if (this.cabeza == null){
			this.cabeza = nuevoNodo;
			this.cantidad++; 
			return true;
			}

		Nodo<T> cursor = this.cabeza;

		//avanzo el cursor hasta llevarlo al último elemento
		
		for (int i = 0; i < (this.cantidad - 1); i++){
			cursor = cursor.siguiente();
		}

		cursor.siguiente(nuevoNodo);
		this.cantidad ++;
		

		return true;
	}

	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/

	@SuppressWarnings ("unchecked")
	public boolean agregarTodos(Lista<T> otraLista){

		Nodo<T> cursor = this.cabeza;
		LinkedLista<T> otra = (LinkedLista<T>) otraLista; 

		//avanzo el cursor hasta llevarlo al último elemento
		
		for (int i = 0; i < (this.cantidad - 1); i++){
			cursor = cursor.siguiente();
		}

		cursor.siguiente (otra.cabeza);
		this.cantidad += otra.cantidad;
		

		return true;
	}

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/

	@SuppressWarnings ("unchecked")
	public boolean insertar(T elem, int indice){
		if (indice < 0 || indice > this.cantidad){
			throw new IndexOutOfBoundsException ();
		}

		Nodo<T> cursor = this.cabeza;

		//avanzo el cursor hasta llevarlo al elemento anterior del indice
		
		for (int i = 0; i < (indice - 1); i++){
			cursor = cursor.siguiente();
		}

		Nodo<T> nuevoNodo = (Nodo<T>) new Nodo (elem, cursor.siguiente());

		cursor.siguiente(nuevoNodo);
		this.cantidad++;

		return true;
	}

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	@SuppressWarnings ("unchecked")
	public T eliminar(int indice){
		Nodo<T> cursor = this.cabeza;

		//avanzo el cursor hasta llevarlo al elemento anterior del indice
		
		for (int i = 0; i < (indice - 1); i++){
			cursor = cursor.siguiente();
		}

		
		Nodo<T> aux = (Nodo<T>) new Nodo ();
		aux = cursor.siguiente();

		cursor.siguiente((cursor.siguiente()).siguiente());
		this.cantidad--;

		return aux.valor();
	}

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	@SuppressWarnings ("unchecked")
	public T obtener(int indice){
		Nodo<T> cursor = this.cabeza;

		//avanzo el cursor hasta llevarlo al elemento correspondiente al indice
		
		for (int i = 0; i <= (indice - 1); i++){
			cursor = cursor.siguiente();
		}

		return cursor.valor();
	}

	/**
	* Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
	* Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
	* @param desdeInd el índice inferior, inclusivo
	* @param hastaInd el índice superior, exclusivo
	* @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
	* @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
	* @see #elementos() 
	*/

	//CREO QUE EN ESTE METODO DEBERÍA HACER UNA COPIA DE LA LISTA PARA NO MANDARME MACANAS
	@SuppressWarnings ("unchecked")
	public Lista<T> subLista(int desdeInd, int hastaInd){
		LinkedLista resultado = new LinkedLista (); 

		if (desdeInd < 0 || hastaInd > this.cantidad){
			throw new IndexOutOfBoundsException();
		}

		Nodo<T> cursor = this.cabeza;
		int i = 0;

		//avanzo el cursor hasta llevarlo al elemento correspondiente al indice
		
		for (i=0; i <= (desdeInd - 1); i++){
			cursor = cursor.siguiente();
		}

		//la cabeza de mi nueva sublista se corresponde con el elemento en la posicion i

		resultado.cabeza = new Nodo (cursor.valor(), cursor.siguiente());
		resultado.cantidad = 1;

		//Nodo<T> cursor2 = resultado.cabeza;


		//voy generando mi sublista hasta que llegue a hastaInd

		for (int j = desdeInd; j < (hastaInd-1); j++){
			cursor = cursor.siguiente();
			resultado.agregar(cursor.valor());
		}

		return resultado;
	}

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/

	@SuppressWarnings ("unchecked")
	public boolean contiene(T elem){
		Nodo<T> cursor = (Nodo<T>) new Nodo (this.cabeza);

		while (!(cursor.valor().equals(elem) && cursor.siguiente() != null)){
			cursor = cursor.siguiente();
		}
		return cursor != null;
	}


	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar(){
		this.cabeza = null;
		this.cantidad = 0;
	}

	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos(){
		return this.cantidad;
	}

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia(){
		return this.cabeza == null;
	}

	/**
	* Invariante de clase.
	* @return {@code true} sii la lista satisface su invariante de clase
	*/
	public boolean repOK(){
		return true;
	}

	/**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@SuppressWarnings ("unchecked")
	@Override
	public String toString(){
		if (this.esVacia()){
			return "[]";
		}


		String resultado = "[";
		Nodo<T> cursor = this.cabeza;

		while (cursor.siguiente() != null){
			resultado += cursor.valor().toString() + ", ";
			cursor = cursor.siguiente();
		}
			resultado += cursor.valor().toString() + "]";

		return resultado;
	}

	/**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	@Override
	public boolean equals(Object otro){
		return true;
	}

}