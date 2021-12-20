package es.florida.mongodb;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Principal {
	
	/*mètode: main()	
	Descripció: executa el MVC
	Paràmetres d'entrada: String[] args
	Paràmetres de salida: no*/
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(vista, modelo);
	}

}