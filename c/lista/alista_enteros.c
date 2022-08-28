#include <stdio.h>
#include <stdlib.h>
#include "lista_enteros.h"

/*
	Implementacion de lista de enteros 
	usando la estructura de arreglos 
 */

/* Constante que me define el tamaño máximo del arreglo */
#define NMax 1000


/* estructura_lista es la implementacion del tipo_lista 
 declarado en lista_enteros.h.
*/
struct estructura_lista{
	int valor[NMax];
	int elementos;
};

tipo_lista crear( void ){

    tipo_lista lista = ( tipo_lista ) malloc ( sizeof( struct estructura_lista ) );

    lista->elementos = 0;

	return lista;
}

int es_vacia( tipo_lista lista ){
	return ( lista->elementos == 0 );
}

tipo_lista agregar( tipo_lista lista, int elemento ){

	/* agregar al comienzo es un caso particular de la funcion ins en posicion 0*/

	ins (lista, elemento, 0);

	return lista;
}

int ins( tipo_lista lista, int elemento, int posicion){
    if ( posicion < 0 || posicion > lista->elementos ){
		return -1;
	}

	/*"hago lugar" corriendo todos los elementos que estan despues del elemento a insertar*/
    for (int i = lista->elementos; i > posicion; i--){
        lista->valor[i] = lista->valor[i-1];
    }

	/* inserto el elemento pasado como parámetro */
    lista->valor[posicion] = elemento;

    /* incrementa el numero de elementos de la lista */
	lista->elementos = (lista->elementos) + 1;

	return 0;
}

tipo_lista fin( tipo_lista lista, int elemento ){
	ins( lista, elemento, lista->elementos );

	return lista;
}

int eliminar_comienzo( tipo_lista lista ){

	if ( es_vacia( lista ) ){
		return -1;
	}

	/* caso particular de eliminar en la posicion 0 */
	eliminar (lista, 0);

	return 0;
}

int eliminar( tipo_lista lista, int posicion){
	if ( posicion < 0 || posicion >= lista->elementos ){
		return -1;
	};

	/* no seria necesario este if */
	if ( es_vacia( lista ) ){
		return -1;
	}

	/*desplazo todos los elementos que siguen al elemento a eliminar un lugar a la izquierda */
    for (int i = posicion; i < lista->elementos; i++){
        lista->valor[i] = lista->valor[i+1];
    }

	/* decremento el numero de elementos de la lista */
	lista->elementos = (lista->elementos) - 1;

	return 0;
}

int obtener( tipo_lista lista, int posicion ){

	return lista->valor[posicion];
}

tipo_lista reversa( tipo_lista lista ){
	tipo_lista resultado = crear();

	for ( int i = 0; i < lista->elementos ; i++ ){
		agregar( resultado, obtener( lista, i ));
	};

	return resultado;
}

tipo_lista concat( tipo_lista ini, tipo_lista cola ){
	tipo_lista resultado = crear();

	for ( int i = 0; i < ini->elementos ; i++ ){
		fin( resultado, obtener( ini, i ));
	};

	for ( int i = 0; i < cola->elementos ; i++ ){
		fin( resultado, obtener( cola, i ));
	};

	return resultado;
}

tipo_lista sub( tipo_lista lista, int c, int f ){
	tipo_lista resultado = crear();

	for ( int i = c; i < f ; i++ ){
		fin( resultado, obtener( lista, i ));
	};

	return resultado;
}

tipo_lista copia( tipo_lista lista ){
	return sub( lista, 0, lista->elementos );
}

int cabeza( tipo_lista lista ){
	return lista->valor[0];
}

tipo_lista cola( tipo_lista lista ){
	return sub( lista, 1, lista->elementos );
}

void mostrar( tipo_lista lista ){
	printf( "[ " );

	for ( int i = 0; i < lista->elementos; i++ ){
		printf( "%i ", obtener( lista, i ) );
	};

	printf( "]" );
}

//reemplaza el valor en la posicion por elem. Si se puede reemplazar devuelve 0, si no -1
int reemplazar ( tipo_lista lista, int elemento, int posicion){
	if ( posicion < 0 || posicion >= lista->elementos ){
		return -1;
	}

	/*guardo el valor que voy a sobreescribir para devolverlo por el return*/
    int valor_previo = lista->valor[posicion];

    lista->valor[posicion] = elemento;

	return valor_previo;
}

//intercambia el valor de dos posiciones en una lista
int intercambiar ( tipo_lista lista, int pos1, int pos2){
	if ( (pos1 < 0 || pos1 >= lista->elementos) || (pos2 < 0 || pos2 >= lista->elementos) ){
		return -1;
	}

	/* guardo el valor de las dos posiciones para no sobreescribir y acceder más "limpio" cuando llamo a reemplazar */
	int valor_pos1 = obtener (lista, pos1);
	int valor_pos2 = obtener (lista, pos2);

	reemplazar (lista, valor_pos2, pos1);
	reemplazar (lista, valor_pos1, pos2);
	return 0;
}

/* de aca en mas son funciones para resolver el resto de incisos de la practica */

//funcion que cuenta la diferencia entre elementos positivos y negativos de una lista
int diferencia_pos_y_neg ( tipo_lista lista){
	int contador;
    contador = 0;

    for (int i = 0; i < lista->elementos; i++){
        if (obtener (lista, i) >= 0) {
            contador++;
        }else{
            contador--;
        }
        
    }

    return contador;
}

float promedio_con_aplazos (tipo_lista lista){

	if ( es_vacia( lista ) ){
		return -1;
	}

	int sumatoria;
	sumatoria = 0;

	for (int i = 0; i < lista->elementos; i++){
		sumatoria += obtener (lista, i);
	}

	return sumatoria / lista->elementos;
}

float promedio_sin_aplazos (tipo_lista lista){

	if ( es_vacia( lista ) ){
		return -1;
	}

	int sumatoria;sumatoria = 0;
	int cant_aprobados; cant_aprobados = 0;

	for (int i = 0; i < lista->elementos; i++){
		int valor_actual = obtener (lista, i);
		if (valor_actual >= 5) {
			sumatoria += valor_actual;
			cant_aprobados++;
		}
	}

	if ( ! cant_aprobados){
		return -1;
	}

	return sumatoria/cant_aprobados;
	
}