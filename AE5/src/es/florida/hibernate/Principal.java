package es.florida.hibernate;


import java.io.IOException;
import java.util.ArrayList;

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
		Controlador controlador = new Controlador(vista, modelo);
	}

}