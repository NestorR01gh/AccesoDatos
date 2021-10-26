import java.util.ArrayList;
import java.util.List;

public class Modelo {
	private Biblioteca biblio;
	
	public Modelo(String ficheroXML) {
		biblio = new Biblioteca(ficheroXML);
	}
	
	public Biblioteca getBiblioteca() {
		return biblio;
	}
	
}
