package es.florida.hibernate;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.xml.sax.SAXException;

public class Biblioteca {
	
	/*mètode: mostrarTots()	
	Descripció: torna un string amb l'id i el títol de cada llibre de la biblioteca
	Paràmetres d'entrada: no
	Paràmetres de salida: List<Llibre> libros*/
	public String mostrarTots() throws ParserConfigurationException, SAXException, IOException{
		List<Llibre> libros = recuperarTots();
		String text = "";
		for(Llibre libro : libros) {
			text += "ID: " + libro.getId() + " | Títol: " + libro.getTitol() + "\n";
		}
		return text;
	}
	
	/*mètode: recuperarLlibre()
	Descripció: torna un llibre a partir d'una id
	Paràmetres d'entrada: int iden
	Paràmetres de salida: Llibre libro*/
	public static Llibre recuperarLlibre(int iden) {
		Llibre libro = null;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		libro = session.get(Llibre.class, iden);
		session.getTransaction().commit();
		session.close();
		return libro;
	}
	
	/*mètode: mostrarLlibre()
	Descripció: torna un string amb el atributs del llibre especificat
	Paràmetres d'entrada: Llibre libro
	Paràmetres de salida: String text*/
	public static String mostrarLlibre(Llibre libro) {
		String text = "";
		text += "Id: " + libro.getId() + "\n";
		text += "Títol: " + libro.getTitol() + "\n";
		text += "Autor: " + libro.getAutor() + "\n";
		text += "Any publicació: " + libro.getAnyPublicacio() + "\n";
		if(libro.getAnyNaixement() == 0) {
			text += "Any naixement: NULL\n";
		} else {
			text += "Any naixement: " + libro.getAnyNaixement() + "\n";
		}
		text += "Editorial: " + libro.getEditorial() + "\n";
		text += "Nombre pàgines: " + libro.getnPagines();
		return text;
	}
	
	/*mètode: recuperarTots()
	Descripció: torna una llista de tots els llibres de la biblioteca
	Paràmetres d'entrada: no
	Paràmetres de salida: List<Llibre> libros*/
	public static List<Llibre> recuperarTots() throws ParserConfigurationException, SAXException, IOException{
		List<Llibre> libros = new ArrayList<Llibre>();
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		libros = session.createQuery("FROM Llibre").list();
		session.getTransaction().commit();
		session.close();
		return libros;
	}
	
	/*mètode: crearLlibre()
	Descripció: Crea un llibre a partir d'un objecte llibre i torna la id, si el llibre especificat no porta id la assigna automàticament
	Paràmetres d'entrada: Llibre lbr
	Paràmetres de salida: int id*/
	public static int crearLlibre(Llibre lbr) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		List<Llibre> libros;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Serializable id = session.save(lbr);
		session.getTransaction().commit();
		session.close();
		libros = recuperarTots();
		return libros.get(libros.size()-1).getId();
	}
	
	
	/*mètode: borrarLlibre()
	Descripció: Borra el llibre relacionat amb la id especificada
	Paràmetres d'entrada: int ident
	Paràmetres de salida: no*/
	public static void borrarLlibre(int ident) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Llibre lbr = new Llibre();
		lbr.setId(ident);
		session.delete(lbr);
		session.getTransaction().commit();
		session.close();
	}
	
	/*mètode: actualitzaLlibre()
	Descripció: Actualitza al fitxer el Llibre especificat
	Paràmetres d'entrada: Llibre libroNuevo
	Paràmetres de salida: no*/
	public static void actualitzaLlibre(Llibre libroNuevo) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(libroNuevo);
		session.getTransaction().commit();
		session.close();
	}
}
