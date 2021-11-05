import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Modelo {
	
	/*m�tode: ejecutarConsulta()
	Descripci�: Executa la consulta especificada, si es un SELECT mostra un text amb el 
		contingut i si es altra consulta mostra un text de verificaci� si s�ha executat
	Par�metres d'entrada: String consulta
	Par�metres de salida: String texto*/
	public static String ejecutarConsulta(String consulta) throws ClassNotFoundException, SQLException {
		if(consulta.split(" ")[0].toUpperCase().equals("SELECT")) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			String texto = "";
			
			while(rs.next()) {
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					texto += rs.getMetaData().getColumnLabel(i) + ": " + rs.getString(i) + " | ";
				}
				texto = texto.substring(0, texto.length()-2);
				texto += "\n";
			}
			return texto;
		} else {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.executeUpdate();
			return "S�ha executat la consulta '" + consulta + "'";
		}
	}
	
	/*m�tode: getEditorialesXXI()
	Descripci�: Retorna una llista amb les editorials que hajen publicat alemnys un llibre al segle 21
	Par�metres d'entrada: no
	Par�metres de salida: List<String> editoriales*/
	public static List<String> getEditorialesXXI() throws ClassNotFoundException, SQLException{
		List<String> editoriales = new ArrayList<String>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT DISTINCT editorial FROM llibres WHERE anyPubl >= 2000;");
		
		while(rs.next()) {
			editoriales.add(rs.getString(1));
		}
		return editoriales;
	}
	
	/*m�tode: getLibrosAutoresAntes1950()
	Descripci�: Retorna una llista de llibres (titol, nom del autor l'any de publicaci�) del autors nascuts abans del 1950 
	Par�metres d'entrada: no
	Par�metres de salida: List<Llibres> libros*/
	public static List<Llibre> getLibrosAutoresAntes1950() throws ClassNotFoundException, SQLException{
		List<Llibre> libros = new ArrayList<Llibre>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT titol, autor, anyPubl FROM llibres WHERE anyNaix < 1950;");
		
		while(rs.next()) {
			libros.add(new Llibre(rs.getString(1), rs.getString(2), rs.getInt(3)));
		}
		return libros;
	}
	
	/*m�tode: existeBBDD()
	Descripci�: Retorna 'true' si existix y 'false' si no 
	Par�metres d'entrada: String BBDD
	Par�metres de salida: boolean*/
	public static boolean existeBBDD(String BBDD) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BBDD,"root","");
			return true;
		} catch(Exception e) {
			
		}
		return false;
	}
	
	/*m�tode: crearBBDD()
	Descripci�: Crea la base de dades biblioteca y la taula llibres
	Par�metres d'entrada: no
	Par�metres de salida: no*/
	public static void crearBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
		PreparedStatement psCrear = con.prepareStatement("CREATE DATABASE IF NOT EXISTS `biblioteca` DEFAULT CHARSET=utf8");
		psCrear.executeUpdate();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
		psCrear = con.prepareStatement("CREATE TABLE IF NOT EXISTS `llibres`(\r\n"
				+ "id INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "titol VARCHAR(50) NOT NULL,\r\n"
				+ "autor VARCHAR(20),\r\n"
				+ "anyNaix INT,\r\n"
				+ "anyPubl INT,\r\n"
				+ "editorial VARCHAR(20),\r\n"
				+ "nomPagines INT,\r\n"
				+ "PRIMARY KEY (id));");
		psCrear.executeUpdate();
	}
	
	/*m�tode: llenarBBDD()
	Descripci�: Introduix les dades del .csv a la taula 'llibres'
	Par�metres d'entrada: no
	Par�metres de salida: no*/
	public static void llenarBBDD() throws IOException, ClassNotFoundException, SQLException {
		File csv = new File("./src/llibres.csv");
		BufferedReader br = new BufferedReader(new FileReader(csv));
		String linea;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
		
		br.readLine();
		while((linea = br.readLine()) != null) {
			List<String> campos = Arrays.asList(linea.split(";"));
			for(int i = 0; i < campos.size(); i++) {
				if(campos.get(i).equals("")) {
					campos.set(i, "NULL");
				}
			}
			PreparedStatement psIns = con.prepareStatement("INSERT INTO llibres VALUES (NULL, ?, ?, ?, ?, ?, ?)");
			psIns.setString(1, campos.get(0));
			psIns.setString(2, campos.get(1));
			if(campos.get(2) == "NULL") {
				psIns.setNull(3, 0);
			} else {
				psIns.setInt(3, Integer.parseInt(campos.get(2)));
			}
			if(campos.get(3) == "NULL") {
				psIns.setNull(4, 0);
			} else {
				psIns.setInt(4, Integer.parseInt(campos.get(3)));
			}
			psIns.setString(5, campos.get(4));
			if(campos.get(5) == "NULL") {
				psIns.setNull(6, 0);
			} else {
				psIns.setInt(6, Integer.parseInt(campos.get(5)));
			}
			psIns.executeUpdate();
		}
	}
	
	/*m�tode: hayDatos()
	Descripci�: Retorna 'true' si hi ha entrades a la taula llibre y 'false' si no
	Par�metres d'entrada: no
	Par�metres de salida: boolean*/
	public static boolean hayDatos() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM llibres");
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
}
