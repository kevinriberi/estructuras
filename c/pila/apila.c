#include <stdio.h>
#include <stdlib.h>
#include "pila.h"


/*
	Implementacion de pila polimorfica
	usando la estructura de arreglos
 */


/* Constante que me define el tamaño máximo del arreglo */
#define NMax 20


/* estructura_lista es la implementacion del tipo_lista 
 declarado en lista_enteros.h.
*/
struct estructura_pila{
    void* ptrPila[NMax];
	int elementos;
    int tipo; //0 corresponde a enteros y 1 a char

};

tipo_pila crear( void ){

    tipo_pila pila = ( tipo_pila ) malloc ( sizeof( struct estructura_pila ) );

    pila->elementos = 0;

    pila->tipo = 0;

	return pila;
}

int es_vacia( tipo_pila pila ){
	return ( pila->elementos == 0 );
}

int esta_llena( tipo_pila pila ){
    return ( pila->elementos == NMax );
}

int apilar( tipo_pila pila, void* elemento ){
    if ( esta_llena (pila) ){
        return -1;
    }

    pila->ptrPila[pila->elementos] = elemento;

    pila->elementos = (pila->elementos) + 1;

    return 0;
}

void* tope ( tipo_pila pila){
    return pila->ptrPila[pila->elementos -1];
}


void* desapilar ( tipo_pila pila ){
    pila->elementos = (pila->elementos) - 1;

    return pila->ptrPila[pila->elementos];

}

tipo_pila vaciar ( tipo_pila pila ){
    pila->elementos = 0;

    return pila;
}

int elementos ( tipo_pila pila ){
    return pila->elementos;
}

//Funcion que imprime la pila. Los elementos que están al tope de la pila, son los que se imprimen primero
//por ahora solo andaria para mostrar una pila de enteros, hay que resolver el tema del casteo para que puedan mostrar tambien caracteres
void mostrar (tipo_pila pila){
   
    if (pila->tipo == 0){
            printf( "La pila es \n" );

        for ( int i = (pila->elementos - 1); i >= 0; i-- ){
            printf( "%d", *(int *)(pila->ptrPila[i]) );           
            printf ("\n");
            
        }
    }else{
        printf( "La pila es \n" );

        for ( int i = (pila->elementos - 1); i >= 0; i-- ){
            printf( "%c", *(char *)(pila->ptrPila[i]) );           
            printf ("\n");
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
