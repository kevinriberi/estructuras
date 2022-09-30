package booleanos;

//TAD para boolean


public interface Booleano {
	
	public boolean esVerdadero();

	public Booleano negacion ();

	public Booleano conjuncion(Booleano b);

	public Booleano disyuncion(Booleano b);

	public Booleano implicacion(Booleano b);

	public String toString ();
}