#include <stdio.h>
#include <stdlib.h>
#include "lista_enteros.h"	


/* programa que devuelve si una lista tiene mas elementos positivos que negativos */


int main( int argc, char * argv[] )
{
    tipo_lista lista = crear( );
	
	ins( lista, 7, 0 );
	ins( lista, -3, 1 );
	ins( lista, 5, 2 );
	ins( lista, 10, 3 );
	
	// lista = [ 7, -3, 5, 10 ]

    mostrar( lista);
	printf("\n");

    if (diferencia_pos_y_neg (lista) > 0) {
        printf ("La lista tiene mas elementos positivos que negativos\n");
    } else {
        printf ("La lista NO tiene mas elementos positivos que negativos\n");
    }

    reemplazar (lista, -4, 2);
    reemplazar (lista, -8, 3);

    // lista = [ 7, -3, -4, -8]

    mostrar( lista);
	printf("\n");

    if (diferencia_pos_y_neg (lista) > 0) {
        printf ("La lista tiene mas elementos positivos que negativos\n");
    } else {
        printf ("La lista NO tiene mas elementos positivos que negativos\n");
    }

    return 0;
}

