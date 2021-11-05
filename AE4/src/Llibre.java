
public class Llibre {
	private int id = -1;
	private String titol;
	private String autor;
	private int anyNaixement;
	private int anyPublicacio;
	private String editorial;
	private int nPagines;
	
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
	public int getAnyPubl() {
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
	public int getNumPags() {
		return nPagines;
	}
	
	/*mètode: getAnyNaixement()
	Descripció: Retorna l'any de naixement del autor
	Paràmetres d'entrada: no
	Paràmetres de salida: int anyNaixement*/
	public int getAnyNaixement() {
		return anyNaixement;
	}
}