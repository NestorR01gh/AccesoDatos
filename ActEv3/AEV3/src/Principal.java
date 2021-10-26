import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Principal {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		String fichero = "xml.xml";
		Vista vista = new Vista();
		Modelo modelo = new Modelo(fichero);
		Controlador controlador = new Controlador(vista, modelo);
	}

}