#include <stdio.h>
#include <stdlib.h>
#include "pila.h"	

/* ejemplo para manipular pilas */

int main( int argc, char * argv[] )
{

int a = 8;
int b = 5;
int c = 3;
int d = 9;


  tipo_pila pila = crear( );

  apilar (pila, &a);
  apilar (pila, &b);
  apilar (pila, &c);
  apilar (pila, &d);

  // pila [ 8, 5, 3, 9]
  
  mostrar (pila);
 
  desapilar(pila);

  // pila [8, 5, 3]

  mostrar (pila);
  
  vaciar (pila);

  // pila []

  cambiar_tipo (pila);

  char m = 'r';
  char n = 'p';

  apilar (pila, &m);
  apilar (pila, &n);

  mostrar (pila);

  return 0;
}


