package es.florida.mongodb;

public class Llibre {
	private int id = -1;
	private String titol;
	private String autor;
	private int anyNaixement;
	private int anyPublicacio;
	private String editorial;
	private int nPagines;
	
	public Llibre() {}
	
	/*mètode: Llibre()
	Descripció: Constructor de la classe llibre
	Paràmetres d'entrada: int ident, String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag
	Paràmetres de salida: no*/
	public Llibre(int ident, String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag) {
		id = ident;
		titol = ttulo;
		autor = autr;
		anyNaixement = anyNaix;
		anyPublicacio = anyoPubl;
		editorial = edit;
		nPagines = nPag;
	}
	
	/*mètode: Llibre()
	Descripció: Constructor de la classe llibre
	Paràmetres d'entrada: String titol, String autor, int anyPublicacio
	Paràmetres de salida: no*/
	public Llibre(String titol, String autor, int anyPublicacio) {
		this.titol = titol;
		this.autor = autor;
		this.anyPublicacio = anyPublicacio;
	}
	
	/*mètode: Llibre()
	Descripció: Constructor de la classe llibre
	Paràmetres d'entrada: String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag
	Paràmetres de salida: no*/
	public Llibre(String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag) {
		titol = ttulo;
		autor = autr;
		anyNaixement = anyNaix;
		anyPublicacio = anyoPubl;
		editorial = edit;
		nPagines = nPag;
	}
	
	/*mètode: getId()
	Descripció: Retorna la id del llibre
	Paràmetres d'entrada: no
	Paràmetres de salida: int id*/
	public int getId() {
		return id;
	}
	
	/*mètode: getTitol()
	Descripció: Retorna el títol del llibre
	Paràmetres d'entrada: no
	Paràmetres de salida: String titol*/
	public String getTitol() {
		return titol;
	}

	/*mètode: getAutor()
	Descripció: Retorna l'autor del llibre
	Paràmetres d'entrada: no
	Paràmetres de salida: String autor*/
	public String getAutor() {
		return autor;
	}
	
	/*mètode: getAnyPubl()
	Descripció: Retorna l'any de publicació del llibre
	Paràmetres d'entrada: no
	Paràmetres de salida: int anyPublicacio*/
	public int getAnyPublicacio() {
		return anyPublicacio;
	}
	
	/*mètode: getEditorial()
	Descripció: Retorna la editorial del llibre
	Paràmetres d'entrada: no
	Paràmetres de salida: String editorial*/
	public String getEditorial() {
		return editorial;
	}
	
	/*mètode: getNumPags()
	Descripció: Retorna el nombre de pàgines del llibre
	Paràmetres d'entrada: no
	Paràmetres de salida: int nPagines*/
	public int getnPagines() {
		return nPagines;
	}
	
	/*mètode: getAnyNaixement()
	Descripció: Retorna l'any de naixement del autor
	Paràmetres d'entrada: no
	Paràmetres de salida: int anyNaixement*/
	public int getAnyNaixement() {
		return anyNaixement;
	}
	
	/*mètode: setId()
	Descripció: Establix la id del llibre
	Paràmetres d'entrada: int id
	Paràmetres de salida: no*/
	public void setId(int id) {
		this.id = id;
	}
	
	/*mètode: setTitol()
	Descripció: Establix el títol del llibre
	Paràmetres d'entrada: String titol
	Paràmetres de salida: no*/
	public void setTitol(String titol) {
		this.titol = titol;
	}
	
	/*mètode: setAutor()
	Descripció: Establix l'autor del llibre
	Paràmetres d'entrada: String autor
	Paràmetres de salida: no*/
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/*mètode: setAnyNaixement()
	Descripció: Establix l'any de naixement del autor
	Paràmetres d'entrada: int anyNaixement
	Paràmetres de salida: no*/
	public void setAnyNaixement(int anyNaixement) {
		this.anyNaixement = anyNaixement;
	}
	
	/*mètode: setAnyPubl()
	Descripció: Establix l'any de publicació del llibre
	Paràmetres d'entrada: int anyPublicacio
	Paràmetres de salida: no*/
	public void setAnyPublicacio(int anyPublicacio) {
		this.anyPublicacio = anyPublicacio;
	}
	
	/*mètode: setEditorial()
	Descripció: Establix la editorial del llibre
	Paràmetres d'entrada: String editorial
	Paràmetres de salida: no*/
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	/*mètode: setNumPags()
	Descripció: Establix el nombre de pàgines del llibre
	Paràmetres d'entrada: int nPagines
	Paràmetres de salida: no*/
	public void setnPagines(int nPagines) {
		this.nPagines = nPagines;
	}

}