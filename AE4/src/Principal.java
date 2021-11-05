
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Principal {
	
	/*m�tode: main()
	Descripci�: Executa el programa principal
	Par�metres d'entrada: String[] args
	Par�metres de salida: no*/
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
