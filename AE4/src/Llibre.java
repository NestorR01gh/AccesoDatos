
public class Llibre {
	private int id = -1;
	private String titol;
	private String autor;
	private int anyNaixement;
	private int anyPublicacio;
	private String editorial;
	private int nPagines;
	
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
	public int getAnyPubl() {
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
	public int getNumPags() {
		return nPagines;
	}
	
	/*m�tode: getAnyNaixement()
	Descripci�: Retorna l'any de naixement del autor
	Par�metres d'entrada: no
	Par�metres de salida: int anyNaixement*/
	public int getAnyNaixement() {
		return anyNaixement;
	}
}