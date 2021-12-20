package es.florida.mongodb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class Biblioteca {

	/*
	 * mètode: mostrarTots() Descripció: torna un string amb l'id i el títol de cada
	 * llibre de la biblioteca Paràmetres d'entrada: no Paràmetres de salida:
	 * List<Llibre> libros
	 */
	public String mostrarTots() throws ParserConfigurationException, SAXException, IOException {
		List<Llibre> libros = recuperarTots();
		String text = "";
		for (Llibre libro : libros) {
			text += "ID: " + libro.getId() + " | Títol: " + libro.getTitol() + "\n";
		}
		return text;
	}

	/*
	 * mètode: recuperarLlibre() Descripció: torna un llibre a partir d'una id
	 * Paràmetres d'entrada: int iden Paràmetres de salida: Llibre libro
	 */
	public static Llibre recuperarLlibre(int iden) {
		Llibre libro = null;
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");

		Bson query = eq("Id", iden);
		MongoCursor<Document> cursor = coleccion.find(query).iterator();
		if (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			libro = new Llibre(obj.getInt("Id"), obj.getString("Titol"), obj.getString("Autor"),
					obj.getInt("Any_naixement"), obj.getInt("Any_publicacio"), obj.getString("Editorial"),
					obj.getInt("Nombre_pagines"));
		}
		mongoClient.close();

		return libro;
	}

	/*
	 * mètode: mostrarLlibre() Descripció: torna un string amb el atributs del
	 * llibre especificat Paràmetres d'entrada: Llibre libro Paràmetres de salida:
	 * String text
	 */
	public static String mostrarLlibre(Llibre libro) {
		String text = "";
		text += "Id: " + libro.getId() + "\n";
		text += "Títol: " + libro.getTitol() + "\n";
		text += "Autor: " + libro.getAutor() + "\n";
		text += "Any publicació: " + libro.getAnyPublicacio() + "\n";
		if (libro.getAnyNaixement() == 0) {
			text += "Any naixement: NULL\n";
		} else {
			text += "Any naixement: " + libro.getAnyNaixement() + "\n";
		}
		text += "Editorial: " + libro.getEditorial() + "\n";
		text += "Nombre pàgines: " + libro.getnPagines();
		return text;
	}

	/*
	 * mètode: recuperarTots() Descripció: torna una llista de tots els llibres de
	 * la biblioteca Paràmetres d'entrada: no Paràmetres de salida: List<Llibre>
	 * libros
	 */
	public static List<Llibre> recuperarTots() throws ParserConfigurationException, SAXException, IOException {
		List<Llibre> libros = new ArrayList<Llibre>();
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");

		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			libros.add(new Llibre(obj.getInt("Id"), obj.getString("Titol"), obj.getString("Autor"),
					obj.getInt("Any_naixement"), obj.getInt("Any_publicacio"), obj.getString("Editorial"),
					obj.getInt("Nombre_pagines")));
		}
		mongoClient.close();
		return libros;
	}
	
	
	/*
	 * mètode: getUltimaId() Descripció: torna l'última id de la biblioteca
	 * Paràmetres d'entrada: no 
	 * Paràmetres de salida: int id
	 */
	private static int getUltimaId() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		
		int id = 1;
		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			id = obj.getInt("Id");
		}
		mongoClient.close();
		
		return id;
	}

	/*
	 * mètode: crearLlibre() Descripció: Crea un llibre a partir d'un objecte llibre
	 * i torna la id, si el llibre especificat no porta id la assigna automàticament
	 * Paràmetres d'entrada: Llibre lbr Paràmetres de salida: int id
	 */
	public static int crearLlibre(Llibre lbr)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");

		Document doc = new Document();
		doc.append("Id", getUltimaId() + 1);
		doc.append("Titol", lbr.getTitol());
		doc.append("Autor", lbr.getAutor());
		doc.append("Any_naixement", lbr.getAnyNaixement());
		doc.append("Any_publicacio", lbr.getAnyPublicacio());
		doc.append("Editorial", lbr.getEditorial());
		doc.append("Nombre_pagines", lbr.getnPagines());
		coleccion.insertOne(doc);
		mongoClient.close();

		return getUltimaId();
	}

	/*
	 * mètode: borrarLlibre() Descripció: Borra el llibre relacionat amb la id
	 * especificada Paràmetres d'entrada: int ident Paràmetres de salida: no
	 */
	public static void borrarLlibre(int ident)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");

		coleccion.deleteOne(eq("Id", ident));
		
		mongoClient.close();
	}

	/*
	 * mètode: actualitzaLlibre() Descripció: Actualitza al fitxer el Llibre
	 * especificat Paràmetres d'entrada: Llibre libroNuevo Paràmetres de salida: no
	 */
	public static void actualitzaLlibre(Llibre libroNuevo)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");

		coleccion.updateOne(eq("Id", libroNuevo.getId()), new Document("$set", new Document("Titol", libroNuevo.getTitol())));
		coleccion.updateOne(eq("Id", libroNuevo.getId()), new Document("$set", new Document("Autor", libroNuevo.getAutor())));
		coleccion.updateOne(eq("Id", libroNuevo.getId()), new Document("$set", new Document("Any_naixement", libroNuevo.getAnyNaixement())));
		coleccion.updateOne(eq("Id", libroNuevo.getId()), new Document("$set", new Document("Any_publicacio", libroNuevo.getAnyPublicacio())));
		coleccion.updateOne(eq("Id", libroNuevo.getId()), new Document("$set", new Document("Editorial", libroNuevo.getEditorial())));
		coleccion.updateOne(eq("Id", libroNuevo.getId()), new Document("$set", new Document("Nombre_pagines", libroNuevo.getnPagines())));
		mongoClient.close();
	}
}














