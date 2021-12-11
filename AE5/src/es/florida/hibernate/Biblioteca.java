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
	
	/*m�tode: mostrarTots()	
	Descripci�: torna un string amb l'id i el t�tol de cada llibre de la biblioteca
	Par�metres d'entrada: no
	Par�metres de salida: List<Llibre> libros*/
	public String mostrarTots() throws ParserConfigurationException, SAXException, IOException{
		List<Llibre> libros = recuperarTots();
		String text = "";
		for(Llibre libro : libros) {
			text += "ID: " + libro.getId() + " | T�tol: " + libro.getTitol() + "\n";
		}
		return text;
	}
	
	/*m�tode: recuperarLlibre()
	Descripci�: torna un llibre a partir d'una id
	Par�metres d'entrada: int iden
	Par�metres de salida: Llibre libro*/
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
	
	/*m�tode: mostrarLlibre()
	Descripci�: torna un string amb el atributs del llibre especificat
	Par�metres d'entrada: Llibre libro
	Par�metres de salida: String text*/
	public static String mostrarLlibre(Llibre libro) {
		String text = "";
		text += "Id: " + libro.getId() + "\n";
		text += "T�tol: " + libro.getTitol() + "\n";
		text += "Autor: " + libro.getAutor() + "\n";
		text += "Any publicaci�: " + libro.getAnyPublicacio() + "\n";
		if(libro.getAnyNaixement() == 0) {
			text += "Any naixement: NULL\n";
		} else {
			text += "Any naixement: " + libro.getAnyNaixement() + "\n";
		}
		text += "Editorial: " + libro.getEditorial() + "\n";
		text += "Nombre p�gines: " + libro.getnPagines();
		return text;
	}
	
	/*m�tode: recuperarTots()
	Descripci�: torna una llista de tots els llibres de la biblioteca
	Par�metres d'entrada: no
	Par�metres de salida: List<Llibre> libros*/
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
	
	/*m�tode: crearLlibre()
	Descripci�: Crea un llibre a partir d'un objecte llibre i torna la id, si el llibre especificat no porta id la assigna autom�ticament
	Par�metres d'entrada: Llibre lbr
	Par�metres de salida: int id*/
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
	
	
	/*m�tode: borrarLlibre()
	Descripci�: Borra el llibre relacionat amb la id especificada
	Par�metres d'entrada: int ident
	Par�metres de salida: no*/
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
	
	/*m�tode: actualitzaLlibre()
	Descripci�: Actualitza al fitxer el Llibre especificat
	Par�metres d'entrada: Llibre libroNuevo
	Par�metres de salida: no*/
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
