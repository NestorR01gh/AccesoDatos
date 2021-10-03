import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		Vista vista = new Vista();
		Modelo modelo = new Modelo(new File("texto.txt"));
		Controlador controlador = new Controlador(vista, modelo);
	}

}
