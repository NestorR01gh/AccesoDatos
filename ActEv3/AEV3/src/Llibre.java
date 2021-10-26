import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Llibre implements Comparable<Llibre> {
	private int id = -1;
	private String titol;
	private String autor;
	private int anyPublicacio;
	private String editorial;
	private int nPagines;
	
	public Llibre(int ident, String ttulo, String autr, int anyoPubl, String edit, int nPag) {
		id = ident;
		titol = ttulo;
		autor = autr;
		anyPublicacio = anyoPubl;
		editorial = edit;
		nPagines = nPag;
	}
	
	public Llibre(String ttulo, String autr, int anyoPubl, String edit, int nPag) {
		titol = ttulo;
		autor = autr;
		anyPublicacio = anyoPubl;
		editorial = edit;
		nPagines = nPag;
	}
	
	/*mètode: compareTo()
	Descripció: Implementa la possibilitat d'ordenar la llista de llibres a partir de la id mitjançant Collections.sort()
	Paràmetres d'entrada: Llibre l
	Paràmetres de salida: int*/
	@Override
    public int compareTo(Llibre l) {
        if (id < l.getId()) {
            return -1;
        }
        if (id > l.getId()) {
            return 1;
        }
        return 0;
    }
	
	public int getId() {
		return id;
	}
	
	public String getTitol() {
		return titol;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getAnyPubl() {
		return anyPublicacio;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public int getNumPags() {
		return nPagines;
	}
	
}