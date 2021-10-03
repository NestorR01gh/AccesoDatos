import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class ActEv1 {
	
	public static String getInformacio(File file) {
		/**
		    * Muestra el contenido del directorio.
		    * @param dir Dierctorio a comprobar.
		    * @return String Devuelve una cadena con la información del directorio.
		    */
		
		String info = "\n\nMostrant el contingut del directori: ";
		File[] lista = file.listFiles();
		boolean esDir;
		SimpleDateFormat sdf = new SimpleDateFormat();
		for (int i = 0; i < lista.length; i++) {
			info += "\nNom: " + lista[i].getName();
			if(lista[i].isDirectory()) {
				info += "\nEs un directori";
				esDir = true;
			} else {
				esDir = false;
				info += "\nEs un fitxer";
			}
			info += "\nÚltima modificació: " + sdf.format(lista[i].lastModified());
			if(lista[i].isHidden()) {
				info += "\nEstà ocult";
			} else {
				info += "\nNo està ocult";
			}
			if(esDir) {
				info += "\nNombre d´elements: " + lista[i].listFiles().length + "\nEspai lliure: " + lista[i].getFreeSpace() + " bytes\nEspai ocupat: " + (lista[i].getTotalSpace() - lista[i].getFreeSpace()) + " bytes\nEspai total: " + lista[i].getTotalSpace() + " bytes";
			} else {
				info += "\nGrandària: " + lista[i].length();
			}
			info += "\n\n\n";
		}
		return info;
	}
	
	public static boolean minRequisits(File dir) {
		/**
		    * Comprueba que hay al menos un subdirectorio y un fichero.
		    * @param dir Dierctorio a comprobar.
		    * @return boolean Devuelve true si se cumplen los requisitos y false si no.
		    */
		
		File[] lista = dir.listFiles();
		boolean file = false, subD = false;
		for (File item : lista) {
			if(item.isDirectory()) {
				subD = true;
			} else if(item.isFile()) {
				file = true;
			}
		}
		if(file && subD) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean minPermissos(File dir) {
		/**
		    * Comprueba que se tienen los permisos para leer y escribir.
		    * @param dir Dierctorio a comprobar.
		    * @return boolean Devuelve true si se tienen los permisos y false si no.
		    */
		
		File[] lista = dir.listFiles();
		boolean ok = true;
		for (File file : lista) {
			if(!file.canRead() || !file.canWrite()) {
				ok = false;
			}
		}
		return ok;
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String rutaDir, nom;
		File dir, fich, fichRename, nuevoDir;
		int num;
		
		System.out.print("Directori: ");
		rutaDir = br.readLine();
		dir = new File(rutaDir);
		if(dir.exists() && dir.isDirectory()) {
			if(minRequisits(dir)){
				if(minPermissos(dir)) {
					do {
						System.out.print("OPCIONS PER AL DIRECTORI " + dir.getName() + "\n==========================================\n\t1. getInformacio()\n\t2. creaCarpeta()\n\t3. creaFitxer()\n\t4. elimina()\n\t5. renomena()\n\t6. Canviar directori\n\t7. Eixir\nIntroduïx opció: ");
						num = Integer.parseInt(br.readLine());
						switch(num) {
							case 1:
								//Mostra la informació del directori especificat, dels seus fitxers i de les carpetes.
								System.out.print(getInformacio(dir));
								break;
							case 2:
								//Demana un nom de carpeta i si no existix la crea.
								System.out.print("Nom de la carpeta a crear: ");
								nom = br.readLine();
								fich = new File(dir.getAbsolutePath() + "\\" + nom);
								if(!fich.exists()) {
									fich.mkdir();
									System.out.println("Carpeta creada\n\n");
								} else {
									System.out.println("La carpeta ja existix\n\n");
								}
								break;
							case 3:
								//Demana un nom de fitxer i si no existix el crea.
								System.out.print("Nom del fitxer a crear: ");
								nom = br.readLine();
								fich = new File(dir.getAbsolutePath() + "\\" + nom);
								if(!fich.exists()) {
									fich.createNewFile();
									System.out.println("Fitxer creat\n\n");
								} else {
									System.out.println("El fitxer ja existix\n\n");
								}
								break;
							case 4:
								//Demana un nom de fitxer i si existix l'elimina.
								System.out.print("Nom del fitxer a eliminar: ");
								nom = br.readLine();
								fich = new File(dir.getAbsolutePath() + "\\" + nom);
								if(fich.exists()) {
									fich.delete();
									System.out.println("Fitxer eliminat\n\n");
								} else {
									System.out.println("El fitxer no existix\n\n");
								}
								break;
							case 5:
								//Demana un nom de fitxer i si existix el renomena amb el nom especificat més tard si no existix.
								System.out.print("Nom del fitxer a renomenar: ");
								nom = br.readLine();
								fich = new File(dir.getAbsolutePath() + "\\" + nom);
								if(fich.exists()) {
									System.out.print("Nom per a renomenar: ");
									nom = br.readLine();
									fichRename = new File(dir.getAbsolutePath() + "\\" + nom);
									if(!fichRename.exists()) {
										fich.renameTo(fichRename);
										System.out.println("Fitxer renomenat\n\n");
									} else {
										System.out.println("El fitxer ja existix\n\n");
									}
									System.out.println("Fitxer renomenat\n\n");
								} else {
									System.out.println("El fitxer no existix\n\n");
								}
								break;
							case 6:
								//Canvia el directori en el qual es realitzen les accions
								System.out.print("Directori: ");
								rutaDir = br.readLine();
								nuevoDir = new File(rutaDir);
								if(nuevoDir.exists() && nuevoDir.isDirectory()) {
									if(minRequisits(nuevoDir)){
										if(minPermissos(nuevoDir)) {
											dir = nuevoDir;
										} else {
											System.out.print("No es tenen el permissos necessaris\n\n");
										}
									} else {
										System.out.print("El directori ha de tindre almenys un subdirectori i un fitxer\n\n");
									}
								} else {
									System.out.print("El directori no existix\n\n");
								}
								break;
							case 7:
								//Termina el programa.
								System.out.print("Eixint...");
								break;
							default:
								System.out.println("Opció no vàlida\n\n");
								break;
						}
					} while(num != 7);
				} else {
					System.out.print("No es tenen el permissos necessaris");
				}
			} else {
				System.out.print("El directori ha de tindre almenys un subdirectori i un fitxer");
			}
		} else {
			System.out.print("El directori no existix");
		}
	}

}