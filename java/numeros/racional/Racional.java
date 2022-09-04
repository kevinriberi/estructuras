package racional;

/**
* La clase {@code Racional} representa a un número racional con los siguientes datos:
* <ul>
* 	<li>El numerador del número racional.</li>
*	<li>El denominador del número racional (el cual no puede ser 0).</li>
*	<li>Se supone que el denominador es siempre positivo</li>
* </ul>
* 
*
* @version 1.0
*/

public class Racional {

	//el numerador del número racional
	private long numerador;
	//el denominador del número racional
	private long denominador;

	/**
	* Construye un nuevo {@code Racional} con el numerador y denominador dados.
	* @param numerador : el numerador del nuevo Racional.
	* @param denominador : el denominador del nuevo Racional.
	*/
	public Racional (long numerador, long denominador){
		if (denominador != 0) {
		this.numerador = numerador;
		this.denominador = denominador;

		this.simplificar();
		}else{
			throw new ArithmeticException ( "El denominador de un número racional nunca puede ser 0 ");
		}
	}

	/**
	 * Suma un numero {@code Racional} a otro número {@code Racional}.
	 * @param sumando : el número Racional a sumar
	 */
	 public void suma ( Racional sumando){
	 	//a*d + b*c, siendo a/b this, y c/d el sumando
	 	this.numerador = (this.numerador*sumando.denominador + this.denominador*sumando.numerador);
	 	//b*d, siendo a/b this, y c/d el sumando
	 	this.denominador = this.denominador*sumando.denominador;
	 	this.simplificar();
	 }

	 /**
	 * Resta un numero {@code Racional} a otro número {@code Racional}.
	 * @param restando : el número Racional a sumar
	 */
	 public void resta ( Racional restando){
	 	//a*d + b*c, siendo a/b this, y c/d el restando
	 	this.numerador = (this.numerador*restando.denominador - this.denominador*restando.numerador);
	 	//b*d, siendo a/b this, y c/d el restando
	 	this.denominador = this.denominador*restando.denominador;
	 	this.simplificar();
	 }

	 /**
	 * Multiplica un numero {@code Racional} a otro número {@code Racional}.
	 * @param multiplicando : el número Racional que multiplica a this
	 */
	 public void multiplicar ( Racional multiplicando){
	 	//a*c, siendo a/b this, y c/d el multiplicando
	 	this.numerador = (this.numerador * multiplicando.numerador);
	 	//b*d, siendo a/b this, y c/d el multiplicando
	 	this.denominador = (this.denominador * multiplicando.denominador);
	 	this.simplificar();
	 }

	 /**
	 * Divide un numero {@code Racional} a otro número {@code Racional}.
	 * @param dividendo : el número Racional que divide a this
	 */
	 public void dividir ( Racional divisor){
	 	//a*d, siendo a/b this, y c/d el divisor
	 	this.numerador = (this.numerador * divisor.denominador);
	 	//b*c, siendo a/b this, y c/d el divisor
	 	this.denominador = (this.denominador * divisor.numerador);
	 	this.simplificar();
	 }

	 /**
	 * Devuelve el inverso aditivo de un número {@code Racional}
	 * Esta accion no recibe parámetros
	 */
	 public void inversoAditivo (){
	 	this.numerador *= -1;
	 }

	 /**
	 * Devuelve el inverso multiplicativo de un número {@code Racional}
	 * Esta accion no recibe parámetros
	 */
	 public void inversoMultiplicativo (){
	 	if (this.numerador == 0){
	 		throw new ArithmeticException ( "El 0 no tiene definido su inverso multiplicativo");
	 	}

	 	//variable local para almacenar el valor del numerador
	 	long temp = this.numerador;

	 	//tengo en cuenta si el numerador es negativo, para mantener el signo dps del cambio
	 	if (this.numerador > 0 ){
	 		this.numerador = this.denominador;
	 		this.denominador = temp;
	 	}else{
	 		this.numerador = (-1)*this.denominador;
	 		this.denominador = (-1)*temp;
	 	}
	 }

	 /**
	  * Simplifica el numerador y denominador de un {@code Racional} con el maximo comun divisor de ambos
	  * Esta accion no toma parámetros
	  */
	 public void simplificar(){
	 	//busca el maximo comun divisor de this.numerador y  this.denominador
	 	long x, y;
	 	x = this.numerador;
	 	y = this.denominador;
	 	while (x != y){
	 		if (x > y){
	 			x -= y;
	 		}else{
	 			y -= x;
	 		}
	 	}

	 	this.numerador /= x;
	 	this.denominador /= x;
	 }

	@Override
	public boolean equals(Object otro) {
		if (otro == null)
			return false;
		if (otro == this)
			return true;
		if (!(otro instanceof Racional))
			return false;
		Racional otroRacional = (Racional) otro;
		//a*d == b*c, siendo a/b this, y c/d otroRacional
		return (this.numerador*otroRacional.denominador == this.denominador*otroRacional.numerador);
	}

	@Override
	public String toString() {
		return this.numerador + "/" + this.denominador;
	}
}