package es.florida.mongodb;

public class Modelo {
	private Biblioteca biblio;
	
	public Modelo() {
		biblio = new Biblioteca();
	}
	
	/*m�tode: getBiblioteca()
	Descripci�: Retorna la biblioteca
	Par�metres d'entrada: no
	Par�metres de salida: Biblioteca biblio*/
	public Biblioteca getBiblioteca() {
		return biblio;
	}
	
}
