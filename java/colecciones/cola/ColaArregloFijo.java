package cola;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public <T>ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	/**
	* Permite evaluar si la cola no tiene elementos.
	* @return {@code true} sii la cola no tiene elementos
	*/
	@Override
	public boolean esVacia() {
		return elementos == 0;	
	}

	@Override
	public int elementos() {
		return elementos;
	}

	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	@Override
	public boolean encolar(T elem) {
		if (elementos == this.arreglo.length){
			//returno una expecion o false?
			//throw new IllegalStateException ("La cola esta llena. No se pueden encolar elementos");
			return false;
		}

		arreglo[elementos++] = elem;	

		return true;
	}

	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	@Override
	public T desencolar() {
		if (this.esVacia())
			throw new IllegalStateException ("La cola esta vacia. No se puede desencolar");

		T elem_desapilado = this.elemento(0);

		for (int i = 0; i < (elementos-1); i++)
			arreglo[i] = arreglo[i+1];

		//decremento en 1 la cantidad de elementos
		elementos--;

		return elem_desapilado;
	}

	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	@Override
	public T primero() {
		if (this.esVacia())
			throw new IllegalStateException ("La pila esta vacia. Es imposible mostrar el primer elemento");

		return this.elemento(0);
	}

	/**
	* Remueve todos los elementos en la cola.
	*/
	@Override
	public void vaciar() {
		elementos = 0;	
	}

	@Override
	public boolean repOK() {
		return true;	
	}

	@Override
	public String toString() {
		if (this.esVacia())
			return "[]";

		String resultado = "[";

		for (int i = 0; i < (elementos-1); i++)
			resultado += arreglo[i] + ", ";

		resultado += arreglo[elementos-1] + "]";
		return resultado;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Cola))
			return false;
		Cola otraCola = (Cola) other;
		if (otraCola.elementos() != this.elementos)
			return false;
		for (int i = 0; i < this.elementos; i++){
			if (!(this.elemento(i).equals(otraCola.primero())))
				return false;
			otraCola.desencolar();
		}

		return true;	
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	private T elemento(int index) {
        	return (T) arreglo[index];
    	}

}
