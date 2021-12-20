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
	 * m�tode: mostrarTots() Descripci�: torna un string amb l'id i el t�tol de cada
	 * llibre de la biblioteca Par�metres d'entrada: no Par�metres de salida:
	 * List<Llibre> libros
	 */
	public String mostrarTots() throws ParserConfigurationException, SAXException, IOException {
		List<Llibre> libros = recuperarTots();
		String text = "";
		for (Llibre libro : libros) {
			text += "ID: " + libro.getId() + " | T�tol: " + libro.getTitol() + "\n";
		}
		return text;
	}

	/*
	 * m�tode: recuperarLlibre() Descripci�: torna un llibre a partir d'una id
	 * Par�metres d'entrada: int iden Par�metres de salida: Llibre libro
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
	 * m�tode: mostrarLlibre() Descripci�: torna un string amb el atributs del
	 * llibre especificat Par�metres d'entrada: Llibre libro Par�metres de salida:
	 * String text
	 */
	public static String mostrarLlibre(Llibre libro) {
		String text = "";
		text += "Id: " + libro.getId() + "\n";
		text += "T�tol: " + libro.getTitol() + "\n";
		text += "Autor: " + libro.getAutor() + "\n";
		text += "Any publicaci�: " + libro.getAnyPublicacio() + "\n";
		if (libro.getAnyNaixement() == 0) {
			text += "Any naixement: NULL\n";
		} else {
			text += "Any naixement: " + libro.getAnyNaixement() + "\n";
		}
		text += "Editorial: " + libro.getEditorial() + "\n";
		text += "Nombre p�gines: " + libro.getnPagines();
		return text;
	}

	/*
	 * m�tode: recuperarTots() Descripci�: torna una llista de tots els llibres de
	 * la biblioteca Par�metres d'entrada: no Par�metres de salida: List<Llibre>
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
	 * m�tode: getUltimaId() Descripci�: torna l'�ltima id de la biblioteca
	 * Par�metres d'entrada: no 
	 * Par�metres de salida: int id
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
	 * m�tode: crearLlibre() Descripci�: Crea un llibre a partir d'un objecte llibre
	 * i torna la id, si el llibre especificat no porta id la assigna autom�ticament
	 * Par�metres d'entrada: Llibre lbr Par�metres de salida: int id
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
	 * m�tode: borrarLlibre() Descripci�: Borra el llibre relacionat amb la id
	 * especificada Par�metres d'entrada: int ident Par�metres de salida: no
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
	 * m�tode: actualitzaLlibre() Descripci�: Actualitza al fitxer el Llibre
	 * especificat Par�metres d'entrada: Llibre libroNuevo Par�metres de salida: no
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














