package booleanos;

import booleanos.Booleano;

//implementacioń de la interfaz Booleano

public class BooleanoParidad implements Booleano {
	

	//atributos
	private int valor;

	//constructores

	public BooleanoParidad () {

	}

	public boolean esVerdadero(){
		return this.valor % 2 == 0;
	}

	public BooleanoParidad (int valor){
		this.valor = valor;
	}

	public Booleano negacion(){
		res = new BooleanoParidad (this.valor + 1);

		return res;
	}

	public Booleano conjuncion (Booleano b){
		BooleanoParidad boolConcreto;

		if (b instanceof BooleanoParidad) {
			boolConcreto = (BooleanoParidad) b;
		}
		else {
			boolConcreto = (b.esVerdadero()? new BooleanoParidad (1) : new BooleanoParidad (0));
		}

		return (new BooleanoParidad (this.valor * boolConcreto.valor));
	}

	//implementar mas adelante
	public Booleano disyuncion (Booleano b) {
		BooleanoParidad res = new BooleanoParidad ();

		return res;
	}

	//implementar implicacion
	public Booleano implicacion (Booleano b) {
	
	}

	public String toString (){
		if (this.valor % 2 == 0){
			return "Verdadero";
		}else{
			return "Falso";
		}
	}

}