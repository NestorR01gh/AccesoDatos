
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Principal {
	
	/*mètode: main()
	Descripció: Executa el programa principal
	Paràmetres d'entrada: String[] args
	Paràmetres de salida: no*/
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParserConfigurationException, SAXException {
		String nomBBDD = "biblioteca";
		if(!Modelo.existeBBDD(nomBBDD)) {
			Modelo.crearBBDD();
		}
		if(!Modelo.hayDatos()) {
			Modelo.llenarBBDD();
		}
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(vista, modelo);
	}

}
