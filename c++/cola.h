#ifnded COLA_H
#define COLA_H
#include <iostream>

using namespace std;
/*Especificación de una cola */

class Cola{
    private:
        int[100] valor;
        int cantidad;

    public:
    //Constructor por defecto
    Cola();

    //Destructor
    ~Point();

    // Getters
    int[100] getValor();
    int getCantidad();

    //Setters
    void setGetValor (int[100] valor);
    void setCantidad (int);
};

#endif // COLA_H