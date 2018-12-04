import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] arguments) {
		FileReader monFichier = null;
		BufferedReader tampon = null;
		String fichier = "Laby1.txt";// Dans le code du choix on retournera fichier

		try {
			monFichier = new FileReader(fichier);
			tampon = new BufferedReader(monFichier);
			Scanner sc = null;

			try {
				sc = new Scanner(new File(fichier));
			} catch (FileNotFoundException e) {
				System.out.println("le fichier " + fichier + "n'est pas valable");
				e.printStackTrace();
			}
			int nbl = 0;
			int nbj = 0;
			while (sc.hasNextLine()) {
				String uneligne = sc.nextLine();
				nbj = uneligne.length();
				nbl++;

			}
			
			String ligne = tampon.readLine();
			while (true) {
				
				if (ligne == null)
					break;
				
				String [][] pos=new String [nbj][nbl];
				for (int i=0;i<nbl;i++) {
					String[] parts=ligne.split("");
					for (int j=0;j<nbj;j++) {
						pos[j][i]=parts[j];
						System.out.print( pos[j][i] );}
					ligne = tampon.readLine();

					System.out.println();
				}



			}
			// Fin du while
		} catch (IOException exception) {
			exception.printStackTrace();
		} finally {
			try {
				tampon.close();
				monFichier.close();
			} catch(IOException exception1) {
				exception1.printStackTrace();
			}
		}

	} // Fin de main 
}
