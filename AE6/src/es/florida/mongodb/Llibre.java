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
	
	/*m�tode: Llibre()
	Descripci�: Constructor de la classe llibre
	Par�metres d'entrada: int ident, String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag
	Par�metres de salida: no*/
	public Llibre(int ident, String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag) {
		id = ident;
		titol = ttulo;
		autor = autr;
		anyNaixement = anyNaix;
		anyPublicacio = anyoPubl;
		editorial = edit;
		nPagines = nPag;
	}
	
	/*m�tode: Llibre()
	Descripci�: Constructor de la classe llibre
	Par�metres d'entrada: String titol, String autor, int anyPublicacio
	Par�metres de salida: no*/
	public Llibre(String titol, String autor, int anyPublicacio) {
		this.titol = titol;
		this.autor = autor;
		this.anyPublicacio = anyPublicacio;
	}
	
	/*m�tode: Llibre()
	Descripci�: Constructor de la classe llibre
	Par�metres d'entrada: String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag
	Par�metres de salida: no*/
	public Llibre(String ttulo, String autr, int anyNaix, int anyoPubl, String edit, int nPag) {
		titol = ttulo;
		autor = autr;
		anyNaixement = anyNaix;
		anyPublicacio = anyoPubl;
		editorial = edit;
		nPagines = nPag;
	}
	
	/*m�tode: getId()
	Descripci�: Retorna la id del llibre
	Par�metres d'entrada: no
	Par�metres de salida: int id*/
	public int getId() {
		return id;
	}
	
	/*m�tode: getTitol()
	Descripci�: Retorna el t�tol del llibre
	Par�metres d'entrada: no
	Par�metres de salida: String titol*/
	public String getTitol() {
		return titol;
	}

	/*m�tode: getAutor()
	Descripci�: Retorna l'autor del llibre
	Par�metres d'entrada: no
	Par�metres de salida: String autor*/
	public String getAutor() {
		return autor;
	}
	
	/*m�tode: getAnyPubl()
	Descripci�: Retorna l'any de publicaci� del llibre
	Par�metres d'entrada: no
	Par�metres de salida: int anyPublicacio*/
	public int getAnyPublicacio() {
		return anyPublicacio;
	}
	
	/*m�tode: getEditorial()
	Descripci�: Retorna la editorial del llibre
	Par�metres d'entrada: no
	Par�metres de salida: String editorial*/
	public String getEditorial() {
		return editorial;
	}
	
	/*m�tode: getNumPags()
	Descripci�: Retorna el nombre de p�gines del llibre
	Par�metres d'entrada: no
	Par�metres de salida: int nPagines*/
	public int getnPagines() {
		return nPagines;
	}
	
	/*m�tode: getAnyNaixement()
	Descripci�: Retorna l'any de naixement del autor
	Par�metres d'entrada: no
	Par�metres de salida: int anyNaixement*/
	public int getAnyNaixement() {
		return anyNaixement;
	}
	
	/*m�tode: setId()
	Descripci�: Establix la id del llibre
	Par�metres d'entrada: int id
	Par�metres de salida: no*/
	public void setId(int id) {
		this.id = id;
	}
	
	/*m�tode: setTitol()
	Descripci�: Establix el t�tol del llibre
	Par�metres d'entrada: String titol
	Par�metres de salida: no*/
	public void setTitol(String titol) {
		this.titol = titol;
	}
	
	/*m�tode: setAutor()
	Descripci�: Establix l'autor del llibre
	Par�metres d'entrada: String autor
	Par�metres de salida: no*/
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/*m�tode: setAnyNaixement()
	Descripci�: Establix l'any de naixement del autor
	Par�metres d'entrada: int anyNaixement
	Par�metres de salida: no*/
	public void setAnyNaixement(int anyNaixement) {
		this.anyNaixement = anyNaixement;
	}
	
	/*m�tode: setAnyPubl()
	Descripci�: Establix l'any de publicaci� del llibre
	Par�metres d'entrada: int anyPublicacio
	Par�metres de salida: no*/
	public void setAnyPublicacio(int anyPublicacio) {
		this.anyPublicacio = anyPublicacio;
	}
	
	/*m�tode: setEditorial()
	Descripci�: Establix la editorial del llibre
	Par�metres d'entrada: String editorial
	Par�metres de salida: no*/
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	/*m�tode: setNumPags()
	Descripci�: Establix el nombre de p�gines del llibre
	Par�metres d'entrada: int nPagines
	Par�metres de salida: no*/
	public void setnPagines(int nPagines) {
		this.nPagines = nPagines;
	}

}