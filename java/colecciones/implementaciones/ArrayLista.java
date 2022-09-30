package implementaciones;

import lista.Lista;

/**
* Implementación de la interface {@code Lista} mediante arreglos.
* 
*/

public class ArrayLista<T> implements Lista<T> {

	/**
	* La capacidad por defecto de un nuevo Arreglo.
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 50;

	//el arreglo interno de elementos.
	private Object[] elementos;
	//la cantidad actual de elementos almacenados.
	private int cantidad;
	
	/**
	* Construye un nuevo {@code ArrayLista<T>} usando una capacidad de {@value #CAPACIDAD_POR_DEFECTO}.
	*/

	public ArrayLista() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye un nuevo {@code ArrayLista<T>} con una capacidad dada.
	* @param capacidad : la capacidad del nuevo {@code ArrayLista<T>}.
	*/
	public ArrayLista(int capacidad) {
		this.elementos = new Object [capacidad];
		this.cantidad = 0;
	}

	/**
	* Método que permite acceder a un elemento del arreglo, haciendo el casteo correspondiente
	*/
	@SuppressWarnings ("unchecked")
	private T elementos (int indice){
		return (T) this.elementos[indice];
	}


	/**
	* Permite evaluar si la lista esta llena.
	* Este método es equivalente a:
	* @return {@code true} sii la lista ocupa todos los elementos del arreglo
	*/
	public boolean estaLleno(){
		return cantidad == elementos.length;
	}


	/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem){
		if (this.estaLleno()){
			return false;
		}

		this.elementos[cantidad] = elem;

		this.cantidad++;

		return true;
	}
	 
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista){

		//primero chequeo que todos los elementos de otra Lista puedan ser agregados a this
		if (this.cantidad + otraLista.elementos() > this.elementos.length){
			return false;
		}else{
			for (int i = 0; i < otraLista.elementos(); i++){
				this.elementos[this.cantidad + i] = otraLista.obtener(i);
			}

			this.cantidad += otraLista.elementos();
		}


		return true;
	}

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice){
		if (this.estaLleno()){
			//aca va false o una exception??
			return false;
		}

		if (indice < 0 || indice > this.cantidad){
			throw new IndexOutOfBoundsException ();
		}

		//corro todos los elementos que van a estar dps del elemento a agregar un lugar a la derecha
		for (int i = this.cantidad; i > indice; i--){
			this.elementos[i] = this.elementos[i-1];
		}

		this.elementos[indice] = elem;
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
	public T eliminar(int indice){

		if (indice < 0 || indice >= this.cantidad){
			throw new IndexOutOfBoundsException ();
		}

		//corro todos los elementos que estan dps del elemento a eliminar, un lugar a la izquierda
		for (int i = indice; i < this.cantidad; i++){
			this.elementos[i] = this.elementos[i+1];
		}

		this.cantidad--;

		//devuelvo el elemento eliminado a partir del método que realiza el casteo
		return this.elementos(indice);
	}

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice){
		if (indice < 0 || indice >= this.cantidad){
			throw new IndexOutOfBoundsException ();
		}

		return this.elementos(indice);
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

	@SuppressWarnings ("unchecked")
	public Lista<T> subLista(int desdeInd, int hastaInd){

		Lista resultado = new ArrayLista (hastaInd - desdeInd); 

		if (desdeInd < 0 || hastaInd > this.cantidad){
			throw new IndexOutOfBoundsException();
		}
		
		for (int i = desdeInd; i < hastaInd; i++){
			resultado.agregar(this.elementos(i));
		}

		return resultado;
	}

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	public boolean contiene(T elem){

		int i = 0;

		while (i <= this.cantidad && !(this.elementos(i).equals(elem))){
			i++;
		}

		if (i <= this.cantidad){
			return true;
		}else{
			return false;
		}
	}

	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar(){
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
		return this.cantidad == 0;
	}

	/**
	* Invariante de clase.
	* @return {@code true} sii la lista satisface su invariante de clase
	*/
	public boolean repOK(){
		boolean resultado = true;
		
		for (int i = 0; i < this.cantidad; i++){
			resultado = resultado && this.elementos(i) instanceof T;
		}

		return resultado;
	}

	/**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@Override
	public String toString(){
		if (this.cantidad == 0){
			return "[]";
		}

		int i;
		String resultado = "[";

		for (i = 0; i < (this.cantidad - 1); i++){
			resultado += this.elementos(i).toString() + ", ";
		}

		//al último elemento lo tengo que mostrar "distinto", realizando el cierre de corchete en lugar de la coma.
		resultado += this.elementos(i).toString() + "]";

		return resultado;
	}

	/**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	@Override
	public boolean equals(Object otro){
		if (otro == null)
			return false;
		if (otro == this)
			return true;
		if (!(otro instanceof Lista))
			return false;
		Lista otraLista = (Lista) otro;
		if (otraCola.elementos() != this.elementos)
			return false;
		for (int i = 0; i < this.elementos; i++){
			if (!(this.arreglo(i).equals(otraCola.obtener(i))))
				return false;
		}

		return true;

	}
}