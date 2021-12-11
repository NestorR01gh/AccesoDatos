package es.florida.hibernate;


import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Principal {
	
	/*m�tode: main()	
	Descripci�: executa el MVC
	Par�metres d'entrada: String[] args
	Par�metres de salida: no*/
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);
	}

}