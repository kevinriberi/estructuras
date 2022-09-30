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
	 public Racional suma ( Racional sumando){
	 	Racional resultado = new Racional (1,1);


	 	//a*d + b*c, siendo a/b this, y c/d el sumando
	 	resultado.numerador = (this.numerador*sumando.denominador + this.denominador*sumando.numerador);
	 	//b*d, siendo a/b this, y c/d el sumando
	 	resultado.denominador = this.denominador*sumando.denominador;

	 	resultado.simplificar();

	 	return resultado;
	 }

	 /**
	 * Resta un numero {@code Racional} a otro número {@code Racional}.
	 * @param restando : el número Racional a sumar
	 */
	 public Racional resta ( Racional restando){
	 	Racional resultado = new Racional (1,1);


	 	//a*d + b*c, siendo a/b this, y c/d el restando
	 	resultado.numerador = (this.numerador*restando.denominador - this.denominador*restando.numerador);
	 	//b*d, siendo a/b this, y c/d el restando
	 	resultado.denominador = this.denominador*restando.denominador;
	 	resultado.simplificar();

	 	return resultado;
	 }

	 /**
	 * Multiplica un numero {@code Racional} a otro número {@code Racional}.
	 * @param multiplicando : el número Racional que multiplica a this
	 */
	 public Racional multiplicar ( Racional multiplicando){
	 	Racional resultado = new Racional (1,1);


	 	//a*c, siendo a/b this, y c/d el multiplicando
	 	resultado.numerador = (this.numerador * multiplicando.numerador);
	 	//b*d, siendo a/b this, y c/d el multiplicando
	 	resultado.denominador = (this.denominador * multiplicando.denominador);
	 	resultado.simplificar();

	 	return resultado;
	 }

	 /**
	 * Divide un numero {@code Racional} a otro número {@code Racional}.
	 * @param dividendo : el número Racional que divide a this
	 */
	 public Racional dividir ( Racional divisor){
	 	Racional resultado = new Racional (1,1);


	 	//a*d, siendo a/b this, y c/d el divisor
	 	resultado.numerador = (this.numerador * divisor.denominador);
	 	//b*c, siendo a/b this, y c/d el divisor
	 	resultado.denominador = (this.denominador * divisor.numerador);
	 	resultado.simplificar();

	 	return resultado;
	 }

	 /**
	 * Devuelve el inverso aditivo de un número {@code Racional}
	 * Esta accion no recibe parámetros
	 */
	 public Racional inversoAditivo (){
	 	Racional resultado = new Racional (1,1);

	 	resultado.numerador = (-1)*this.numerador;
	 	resultado.denominador = this.denominador;

	 	return resultado;
	 }

	 /**
	 * Devuelve el inverso multiplicativo de un número {@code Racional}
	 * Esta accion no recibe parámetros
	 */
	 public Racional inversoMultiplicativo (){
	 	Racional resultado = new Racional (1,1);

	 	if (this.numerador == 0){
	 		throw new ArithmeticException ( "El 0 no tiene definido su inverso multiplicativo");
	 	}

	 	//tengo en cuenta si el numerador es negativo, para mantener el signo dps del cambio
	 	if (this.numerador > 0 ){
	 		resultado.numerador = this.denominador;
	 		resultado.denominador = this.numerador;
	 	}else{
	 		resultado.numerador = (-1)*this.denominador;
	 		resultado.denominador = (-1)*this.numerador;
	 	}

	 	return resultado;
	 }

	 /**
	  * Simplifica el numerador y denominador de un {@code Racional} con el maximo comun divisor de ambos
	  * Esta accion no toma parámetros
	  */
	 private void simplificar(){
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