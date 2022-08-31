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
	nodo tope;
	int elementos;
    int tipo;
};

nodo crear_nodo( void* elemento ){
	nodo linkable = ( nodo ) malloc ( sizeof( struct pila_enlazada ) );

	linkable->valor = elemento;
	linkable->siguiente    = NULL;

	return linkable;
}

tipo_pila crear( void ){
	tipo_pila pila = ( tipo_pila ) malloc ( sizeof( struct estructura_pila ) );

	pila->tope = NULL;
	pila->elementos = 0;

	return pila;
}

int es_vacia( tipo_pila pila ){
	return ( pila->elementos == 0 );
}

int apilar( tipo_pila pila, void* elemento ){

    nodo linkable = crear_nodo( elemento );

    linkable->siguiente = pila->tope;
    pila->tope = linkable;

    pila->elementos = (pila->elementos) + 1;

    return 0;   
        
    }

void* tope ( tipo_pila pila){
    return pila->tope->valor;
}

void* desapilar ( tipo_pila pila ){

    nodo aux; //nodo que apuntara al elemento a desapilar
    void* elem_desapilado; //variable que guardara la direccion de memoria del elemento a desapilar

    aux = pila->tope;
    pila->tope = pila->tope->siguiente;

    elem_desapilado = aux->valor;

    //libera la memoria asignada con malloc
    free (aux);

    pila->elementos = (pila->elementos) - 1;

    return elem_desapilado;

}

tipo_pila vaciar ( tipo_pila pila ){
    
    nodo aux; //nodo auxiliar para ir apuntando a los nodos de los que se necesita liberar memoria

    while (pila->tope != NULL){
        aux = pila->tope;
        pila->tope = pila->tope->siguiente;
        free (aux);
    }

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
        mostrar_aux (pila->tope, pila->tipo);
        printf( "\n" );
    }else{
        printf( "La pila es \n" );
        mostrar_aux (pila->tope, pila->tipo);
    }
}


//funcion auxiliar que se utiliza en mostrar //
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

