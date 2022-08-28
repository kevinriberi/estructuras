#include <stdio.h>
#include <stdlib.h>
#include "pila.h"


/*
	Implementacion de pila polimorfica
	usando la estructura de nodos (listas linkables)
 */

typedef struct pila_enlazada* nodo;

struct pila_enlazada{
	void* valor;
	struct pila_enlazada *siguiente;
};

/* estructura_pila es la implementacion del tipo_pila 
 declarado en pila.h.
*/

struct estructura_pila{
	nodo cabeza;
    nodo penultimo;
    nodo ultimo;
    int tipo;
	int elementos;
};

void mostrar_aux (nodo lista, int tipo); //funcion auxiliar 

nodo crear_nodo( void* elemento ){
	nodo linkable = ( nodo ) malloc ( sizeof( struct pila_enlazada ) );

	linkable->valor = elemento;
	linkable->siguiente    = NULL;

	return linkable;
}

tipo_pila crear( void ){
	tipo_pila pila = ( tipo_pila ) malloc ( sizeof( struct estructura_pila ) );

	pila->cabeza = NULL;
    pila->penultimo = NULL;
    pila->ultimo = NULL;
	pila->elementos = 0;
    pila->tipo = 0;

	return pila;
}

int es_vacia( tipo_pila pila ){
	return ( pila->elementos == 0 );
}

int apilar( tipo_pila pila, void* elemento ){

    //cuando es vacia se realiza insercion a la cabeza
    if ( es_vacia (pila) ) {
        nodo linkable = crear_nodo( elemento );

        linkable->siguiente = NULL;
        pila->cabeza = linkable;
        pila->ultimo = linkable;

        pila->elementos = (pila->elementos) + 1;

        return 0;   
        
    }

    //cuando no es vacia, se inserta desde el ultimo elemento
    nodo linkable = crear_nodo( elemento );

	linkable->siguiente = NULL;
    pila->ultimo->siguiente = linkable;
    pila->penultimo = pila->ultimo;
	pila->ultimo = linkable;

	pila->elementos = (pila->elementos) + 1;

    return 0;
}

void* tope ( tipo_pila pila){
    return pila->ultimo->valor;
}

void* desapilar ( tipo_pila pila ){

    nodo cursor; 
    nodo aux; //nodo que apuntara al elemento a desapilar
    void* elem_desapilado; //variable que guardara la direccion de memoria del elemento a desapilar

    cursor = pila->cabeza;

    //ciclo para localizar al nuevo penultimo de la pila

    for (int i = 0; pila->elementos - i > 2; i++ ){
        cursor = cursor->siguiente;
    }

    aux = pila->ultimo;

    pila->ultimo = pila->penultimo;
    pila->ultimo->siguiente = NULL;

    pila->penultimo = cursor;

    elem_desapilado = aux->valor;
    //libera la memoria asignada con malloc
    free (aux);

    pila->elementos = (pila->elementos) - 1;

    return elem_desapilado;

}

tipo_pila vaciar ( tipo_pila pila ){
    
    nodo cursor;

    for (int i=0; i < pila->elementos; i++){
        cursor = pila->cabeza;
        pila->cabeza = pila->cabeza->siguiente;
        free (cursor);
    } 

    pila->penultimo = NULL;
    pila->ultimo = NULL;

    pila->elementos = 0;

    return pila;
}

int elementos ( tipo_pila pila ){
    return pila->elementos;
}

/* para imprimir los elementos desde el ultimo hasta el primero, debo imprimir con recursion en aumento*/
void mostrar (tipo_pila pila){

    if (pila->tipo == 0){
        printf( "La pila es \n" );
        mostrar_aux (pila->cabeza, pila->tipo);
        printf( "\n" );
    }else{
        printf( "La pila es \n" );
        mostrar_aux (pila->cabeza, pila->tipo);
    }
}

void mostrar_aux (nodo lista, int tipo){
    if (tipo == 0){
        if (lista != NULL){
                mostrar_aux (lista->siguiente, tipo);
                printf( "%d\n", *(int *)(lista->valor) ); 
            }
    }else{
        if (lista != NULL){
                mostrar_aux (lista->siguiente, tipo);
                printf( "%c\n", *(char *)(lista->valor) ); 
            }
    }
}

tipo_pila cambiar_tipo (tipo_pila pila){
    if (pila->tipo == 0){
        pila->tipo = 1;
    } else{
        pila->tipo = 0;
    }
}