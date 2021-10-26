import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Biblioteca {
	private static String fichero;
	
	public Biblioteca(String ficheroXML) {
	fichero = ficheroXML;
	}
	
	/*m�tode: mostrarTots()
	Descripci�: torna un string amb l'id i el t�tol de cada llibre de la biblioteca
	Par�metres d'entrada: no
	Par�metres de salida: List<Llibre> libros*/
	public String mostrarTots() throws ParserConfigurationException, SAXException, IOException{
		List<Llibre> libros = recuperarTots();
		String text = "";
		for(Llibre libro : libros) {
			text += "ID: " + libro.getId() + " | T�tol: " + libro.getTitol() + "\n";
		}
		return text;
	}
	
	/*m�tode: recuperarLlibre()
	Descripci�: torna un llibre a partir d'una id
	Par�metres d'entrada: int iden
	Par�metres de salida: Llibre libro*/
	public static Llibre recuperarLlibre(int iden) throws ParserConfigurationException, SAXException, IOException {
		Llibre libro = null;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = dBuilder.parse(new File(fichero));
		NodeList nodeList = doc.getElementsByTagName("libro");
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element libroElement = (Element) node;
				if(Integer.parseInt(libroElement.getAttribute("id")) == iden) {
					String titulo = libroElement.getElementsByTagName("titulo").item(0).getTextContent();
					String autor = libroElement.getElementsByTagName("autor").item(0).getTextContent();
					int anyoPubl = Integer.parseInt(libroElement.getElementsByTagName("anyoPublicacion").item(0).getTextContent());
					String edit = libroElement.getElementsByTagName("editorial").item(0).getTextContent();
					int nPag = Integer.parseInt(libroElement.getElementsByTagName("nPaginas").item(0).getTextContent());
					libro = new Llibre(iden, titulo, autor, anyoPubl, edit, nPag);
				}
			}
		}
		return libro;
	}
	
	/*m�tode: mostrarLlibre()
	Descripci�: torna un string amb el atributs del llibre especificat
	Par�metres d'entrada: Llibre libro
	Par�metres de salida: String text*/
	public static String mostrarLlibre(Llibre libro) {
		String text = "";
		text += "Id: " + libro.getId() + "\n";
		text += "T�tol: " + libro.getTitol() + "\n";
		text += "Autor: " + libro.getAutor() + "\n";
		text += "Any publicaci�: " + libro.getAnyPubl() + "\n";
		text += "Editorial: " + libro.getEditorial() + "\n";
		text += "Nombre p�gines: " + libro.getNumPags();
		return text;
	}
	
	/*m�tode: recuperarTots()
	Descripci�: torna una llista de tots els llibres de la biblioteca
	Par�metres d'entrada: no
	Par�metres de salida: List<Llibre> libros*/
	public static List<Llibre> recuperarTots() throws ParserConfigurationException, SAXException, IOException{
		List<Llibre> libros = new ArrayList<Llibre>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = dBuilder.parse(new File(fichero));
		NodeList nodeList = doc.getElementsByTagName("libro");
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element libroElement = (Element) node;
				int iden = Integer.parseInt(libroElement.getAttribute("id"));
				String titulo = libroElement.getElementsByTagName("titulo").item(0).getTextContent();
				String autor = libroElement.getElementsByTagName("autor").item(0).getTextContent();
				int anyoPubl = Integer.parseInt(libroElement.getElementsByTagName("anyoPublicacion").item(0).getTextContent());
				String edit = libroElement.getElementsByTagName("editorial").item(0).getTextContent();
				int nPag = Integer.parseInt(libroElement.getElementsByTagName("nPaginas").item(0).getTextContent());
				libros.add(new Llibre(iden, titulo, autor, anyoPubl, edit, nPag));
			}
		}
		return libros;
	}

	/*m�tode: getSigId()
	Descripci�: torna la pr�xima id per a crear un nou llibre
	Par�metres d'entrada: no
	Par�metres de salida: List<Llibre> libros*/
	private static int getSigId() throws ParserConfigurationException, SAXException, IOException {
		int id;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = dBuilder.parse(new File(fichero));
		NodeList nodeList = doc.getElementsByTagName("libro");
		Element libro = (Element) nodeList.item(nodeList.getLength()-1);
		id = Integer.parseInt(libro.getAttribute("id")) + 1;
		return id;
	}
	
	/*m�tode: crearLlibre()
	Descripci�: Crea un llibre a partir d'un objecte llibre i torna la id, si el llibre especificat no porta id la assigna autom�ticament
	Par�metres d'entrada: Llibre lbr
	Par�metres de salida: List<Llibre> libros*/
	public static int crearLlibre(Llibre lbr) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		List<Llibre> libros = recuperarTots();
		libros.add(lbr);
		Collections.sort(libros);
		DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
		int id = -1;
		DocumentBuilder build = dFact.newDocumentBuilder();
		org.w3c.dom.Document doc = build.newDocument();
		Element raiz = doc.createElement("libros");
		doc.appendChild(raiz);
		for(Llibre libro : libros) {
			Element elementLib = doc.createElement("libro");
			if(libro.getId() == -1) {
				id = getSigId();
				elementLib.setAttribute("id",String.valueOf(id));
			} else {
				elementLib.setAttribute("id",String.valueOf(libro.getId()));
			}
			raiz.appendChild(elementLib);
			Element titulo = doc.createElement("titulo");
			titulo.appendChild(doc.createTextNode(libro.getTitol()));
			elementLib.appendChild(titulo);
			Element autor = doc.createElement("autor");
			autor.appendChild(doc.createTextNode(libro.getAutor()));
			elementLib.appendChild(autor);
			Element anyo = doc.createElement("anyoPublicacion");
			anyo.appendChild(doc.createTextNode(String.valueOf(libro.getAnyPubl())));
			elementLib.appendChild(anyo);
			Element editorial = doc.createElement("editorial");
			editorial.appendChild(doc.createTextNode(libro.getEditorial()));
			elementLib.appendChild(editorial);
			Element nPag = doc.createElement("nPaginas");
			nPag.appendChild(doc.createTextNode(String.valueOf(libro.getNumPags())));
			elementLib.appendChild(nPag);
		}
        escriure(doc);
		return id;
	}
	
	/*m�tode: escriure()
	Descripci�: Escriu el contingut del XML al fitxer
	Par�metres d'entrada: org.w3c.dom.Document doc
	Par�metres de salida: no*/
	private static void escriure(org.w3c.dom.Document doc) throws IOException, TransformerException {

		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer = tranFactory.newTransformer();
		aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		FileWriter fw = new FileWriter(fichero);
		StreamResult result = new StreamResult(fw);
		aTransformer.transform(source, result);
		fw.close();
	}
	
	/*m�tode: borrarLlibre()
	Descripci�: Borra el llibre relacionat amb la id especificada
	Par�metres d'entrada: int ident
	Par�metres de salida: no*/
	public static void borrarLlibre(int ident) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		List<Llibre> libros = recuperarTots();
		DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = dFact.newDocumentBuilder();
		org.w3c.dom.Document doc = build.newDocument();
		Element raiz = doc.createElement("libros");
		doc.appendChild(raiz);
		for(Llibre libro : libros) {
			if(libro.getId() != ident) {
				Element elementLib = doc.createElement("libro");
				elementLib.setAttribute("id",String.valueOf(libro.getId()));
				raiz.appendChild(elementLib);
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(libro.getTitol()));
				elementLib.appendChild(titulo);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(libro.getAutor()));
				elementLib.appendChild(autor);
				Element anyo = doc.createElement("anyoPublicacion");
				anyo.appendChild(doc.createTextNode(String.valueOf(libro.getAnyPubl())));
				elementLib.appendChild(anyo);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(libro.getEditorial()));
				elementLib.appendChild(editorial);
				Element nPag = doc.createElement("nPaginas");
				nPag.appendChild(doc.createTextNode(String.valueOf(libro.getNumPags())));
				elementLib.appendChild(nPag);
			}
		}
		escriure(doc);
	}
	
	/*m�tode: actualitzaLlibre()
	Descripci�: Actualitza al fitxer el Llibre especificat
	Par�metres d'entrada: Llibre libroNuevo
	Par�metres de salida: no*/
	public static void actualitzaLlibre(Llibre libroNuevo) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		List<Llibre> libros = recuperarTots();
		DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = dFact.newDocumentBuilder();
		org.w3c.dom.Document doc = build.newDocument();
		Element raiz = doc.createElement("libros");
		doc.appendChild(raiz);
		for(Llibre libroXML : libros) {
			if(libroXML.getId() == libroNuevo.getId()) {
				Element elementLib = doc.createElement("libro");
				elementLib.setAttribute("id",String.valueOf(libroNuevo.getId()));
				raiz.appendChild(elementLib);
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(libroNuevo.getTitol()));
				elementLib.appendChild(titulo);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(libroNuevo.getAutor()));
				elementLib.appendChild(autor);
				Element anyo = doc.createElement("anyoPublicacion");
				anyo.appendChild(doc.createTextNode(String.valueOf(libroNuevo.getAnyPubl())));
				elementLib.appendChild(anyo);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(libroNuevo.getEditorial()));
				elementLib.appendChild(editorial);
				Element nPag = doc.createElement("nPaginas");
				nPag.appendChild(doc.createTextNode(String.valueOf(libroNuevo.getNumPags())));
				elementLib.appendChild(nPag);
			} else {
				Element elementLib = doc.createElement("libro");
				elementLib.setAttribute("id",String.valueOf(libroXML.getId()));
				raiz.appendChild(elementLib);
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(libroXML.getTitol()));
				elementLib.appendChild(titulo);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(libroXML.getAutor()));
				elementLib.appendChild(autor);
				Element anyo = doc.createElement("anyoPublicacion");
				anyo.appendChild(doc.createTextNode(String.valueOf(libroXML.getAnyPubl())));
				elementLib.appendChild(anyo);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(libroXML.getEditorial()));
				elementLib.appendChild(editorial);
				Element nPag = doc.createElement("nPaginas");
				nPag.appendChild(doc.createTextNode(String.valueOf(libroXML.getNumPags())));
				elementLib.appendChild(nPag);
			}
		}
		escriure(doc);
	}
}
