package es.florida.mongodb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Controlador {
	private Modelo modelo;
	private Vista vista;

	public Controlador(Vista vsta, Modelo mdelo) throws ParserConfigurationException, SAXException, IOException {
		modelo = mdelo;
		vista = vsta;
		initEventHandler();
		vista.getTextAreaLibros().setText(modelo.getBiblioteca().mostrarTots());
	}

	/*
	 * mètode: borrarCampos() 
	 * Descripció: Esborra el text dels camps especificats
	 * Paràmetres d'entrada: no 
	 * Paràmetres de salida: no
	 */
	private void borrarCampos() {
		vista.getTxtAnyNaix().setText("");
		vista.getTxtTitol().setText("");
		vista.getTxtAutor().setText("");
		vista.getTxtAnyPubl().setText("");
		vista.getTxtEditorial().setText("");
		vista.getTxtNumPags().setText("");
		vista.getTxtId2().setText("");
	}

	/*
	 * mètode: initEventHandler() 
	 * Descripció: Inicia els manejadors d'events
	 * Paràmetres d'entrada: no 
	 * Paràmetres de salida: no
	 */
	public void initEventHandler() {
		vista.getBtnMostrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Biblioteca.recuperarLlibre(Integer.parseInt(vista.getTextFieldId().getText())) != null) {
						vista.getTextAreaMostrarLibro().setText(Biblioteca.mostrarLlibre(
								Biblioteca.recuperarLlibre(Integer.parseInt(vista.getTextFieldId().getText()))));
					} else {
						vista.getTextAreaMostrarLibro().setText("El llibre no existix");
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		});
		vista.getBtnBorrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Biblioteca.recuperarLlibre(Integer.parseInt(vista.getTextFieldId().getText())) == null) {
						vista.getTextAreaMostrarLibro().setText("El llibre no existix");
					} else {
						Biblioteca.borrarLlibre(Integer.parseInt(vista.getTextFieldId().getText()));
						vista.getTextAreaLibros().setText(modelo.getBiblioteca().mostrarTots());
					}
				} catch (NumberFormatException | ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				} catch (TransformerException e) {
					e.printStackTrace();
				}
			}
		});
		vista.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int anyNaix = Integer.parseInt(vista.getTxtAnyNaix().getText());
					String titulo = vista.getTxtTitol().getText();
					String autor = vista.getTxtAutor().getText();
					int anyPubl = Integer.parseInt(vista.getTxtAnyPubl().getText());
					String edit = vista.getTxtEditorial().getText();
					int pags = Integer.parseInt(vista.getTxtNumPags().getText());
					Llibre libro = new Llibre(titulo, autor, anyNaix, anyPubl, edit, pags);
					Biblioteca.crearLlibre(libro);
					vista.getTextAreaLibros().setText(modelo.getBiblioteca().mostrarTots());
					borrarCampos();
				} catch (NumberFormatException | ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				} catch (TransformerException e) {
					e.printStackTrace();
				}
			}
		});
		vista.getBtnActualitzar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id = Integer.parseInt(vista.getTxtId2().getText());
					String titulo = vista.getTxtTitol().getText();
					String autor = vista.getTxtAutor().getText();
					int anyNaix = Integer.parseInt(vista.getTxtAnyNaix().getText());
					int anyPubl = Integer.parseInt(vista.getTxtAnyPubl().getText());
					String edit = vista.getTxtEditorial().getText();
					int pags = Integer.parseInt(vista.getTxtNumPags().getText());
					Llibre libro = new Llibre(id, titulo, autor, anyNaix, anyPubl, edit, pags);
					Biblioteca.actualitzaLlibre(libro);
					vista.getTextAreaLibros().setText(modelo.getBiblioteca().mostrarTots());
					borrarCampos();
				} catch (NumberFormatException | ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				} catch (TransformerException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
