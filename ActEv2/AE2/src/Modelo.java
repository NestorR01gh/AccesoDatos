import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JOptionPane;


public class Modelo {
	private File file;
	private File modFile;
	
	public Modelo(File archivo) {
		file = archivo;
	}
	
	public File getArch() {
		return file;
	}
	
	public File getModArch() {
		return modFile;
	}
	
	public String getText(File fich) throws IOException, InterruptedException {
		String texto = "";
		try {
			FileReader fr = null;
		    BufferedReader br = null;
		    String linea;
	        fr = new FileReader (fich);
	        br = new BufferedReader(fr);
	        while((linea = br.readLine())!=null) {
	            if (texto == "") {
					texto += linea;
				} else {
					texto += "\n" + linea;
				}
	        }
	        br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return texto;
	}
	
	public Integer getRepetidos(String palabra) {
		Integer cantRep = 0;
		try {
			String texto = getText(file);
			for(String word : texto.split(" ")) {
				if(palabra.equals(word)) {
					cantRep++;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return cantRep;
	}
	
	public void reemplazar(String oldW, String newW) {
        String texto = null;
        File fich = null;
        try
        {
        	fich = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - 4) + "_reemplazo.txt");
        	modFile = fich;
        	texto = getText(file);
        	if(fich.exists()) {
        		fich.delete();
        		fich.createNewFile();
        	} else {
        		fich.createNewFile();
        	}
        	oldW = " " + oldW + " ";
        	newW = " " + newW + " ";
            texto = texto.replace(oldW, newW);
            Files.write(Paths.get(modFile.getAbsolutePath()), texto.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
	}
}