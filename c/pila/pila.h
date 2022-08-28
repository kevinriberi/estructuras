// Objeto de un tipo incompleto.
typedef struct estructura_pila* tipo_pila;

//Retorna una lista vacía.
tipo_pila crear( void );

// consulta si la lista es vacia
int es_vacia( tipo_pila pila );

// agrega un elemento al tope de la pila
int apilar( tipo_pila pila, void* elemento );

// accede al tope de una pila no vacía sin modificar a la misma
void* tope ( tipo_pila pila);

// Desapila y retorna el elemento en el tope de una pila no vacía
void* desapilar ( tipo_pila pila );

//Elimina todos los elementos de la pila dejándola vacía
tipo_pila vaciar ( tipo_pila pila );

//Retorna la cantidad de elementos presentes en la pila
int elementos ( tipo_pila pila );

//Funcion que imprime la pila. Los elementos que están al tope de la pila, son los que se imprimen primero
void mostrar (tipo_pila pila);

tipo_pila cambiar_tipo ( tipo_pila pila );

