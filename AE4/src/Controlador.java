import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	
	/*mètode: Controlador()
	Descripció: Constructor de la classe Controlador
	Paràmetres de entrada: Vista vista, Modelo mdelo
	Paràmetres de salida: String texto*/
	public Controlador(Vista vsta, Modelo mdelo) throws ParserConfigurationException, SAXException, IOException {
		modelo = mdelo;
		vista = vsta;
		initEventHandler();
	}
	
	/*mètode: initEventHandler()
	Descripció: Inicia els manejadors d'events
	Paràmetres d'entrada: no
	Paràmetres de salida: no*/
	public void initEventHandler() {
		vista.getBtnExecutar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String resultado = Modelo.ejecutarConsulta(vista.getTxtConsulta().getText());
					vista.getTextAreaResultado().setText(resultado);
				} catch (ClassNotFoundException | SQLException e) {	
					e.printStackTrace();
				}
			}
		});
		vista.getBtnAutors1950().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = "";
				List<Llibre> libros = null;
				try {
					libros = Modelo.getLibrosAutoresAntes1950();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				for(Llibre libro : libros) {
					result += "Títol: " + libro.getTitol() + " | Autor: " + libro.getAutor() + " | Any de publicació: " + libro.getAnyPubl() + "\n";
				}
				vista.getTextAreaResultado().setText(result);
			}
		});
		vista.getBtnEditoriales().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = "";
				List<String> edits = null;
				try {
					edits = Modelo.getEditorialesXXI();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				for(String edit : edits) {
					result += "Editorial: " + edit + "\n";
				}
				vista.getTextAreaResultado().setText(result);
			}
		});
	}
}
