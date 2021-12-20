package es.florida.mongodb;

public class Modelo {
	private Biblioteca biblio;
	
	public Modelo() {
		biblio = new Biblioteca();
	}
	
	/*mètode: getBiblioteca()
	Descripció: Retorna la biblioteca
	Paràmetres d'entrada: no
	Paràmetres de salida: Biblioteca biblio*/
	public Biblioteca getBiblioteca() {
		return biblio;
	}
	
}
