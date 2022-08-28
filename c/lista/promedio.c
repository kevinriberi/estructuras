#include <stdio.h>
#include <stdlib.h>
#include "lista_enteros.h"	

/* calculo de promedios de alumnos */


int main( int argc, char * argv[] )
{
    tipo_lista lista = crear( );
	
	ins( lista, 9, 0 );
	ins( lista, 2, 1 );
	ins( lista, 7, 2 );
	ins( lista, 8, 3 );
	
	// lista = [ 9, 2, 7, 8 ]

	printf (" La siguiente lista = ");

	mostrar ( lista );
	printf ("\n");

	printf ("con aplazos tiene un promedio de %.2f, y sin aplazos tiene un promedio de %.2f\n", promedio_con_aplazos (lista), promedio_sin_aplazos(lista));


    return 0;
}