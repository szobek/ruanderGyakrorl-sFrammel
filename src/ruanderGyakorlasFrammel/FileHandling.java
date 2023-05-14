package ruanderGyakorlasFrammel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileHandling {

	public static void readFile(String file, String delimiter, List<Tanulo> lista) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));) {

			br.readLine();
			while (br.ready()) {
				lista.add(new Tanulo(br.readLine().split(delimiter)));
			}

		} catch (UnsupportedEncodingException e) {
			System.out.println("Rossz fájl kódolás");
		} catch (FileNotFoundException e) {
			System.out.println("Nincs ilyen fájl!!");
		} catch (IOException e) {
			System.out.println("I/O hiba");
		}

	}

	public static void writeFile(String file, String delimiter, List<Tanulo> lista, JFrame frame) {
		try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");){
			String header = "Név"+delimiter+"Matek"+delimiter+"Angol"+delimiter+"Töri \n";
			writer.write(header);
			for(int i=0;i<lista.size();i++) {
				String sor = lista.get(i).getNev()+delimiter+Integer.valueOf(lista.get(i).getMatek())+delimiter+Integer.valueOf(lista.get(i).getAngol())+delimiter+Integer.valueOf(lista.get(i).getTori())+"\n";
				writer.write(sor);
			}
			JOptionPane.showMessageDialog(frame, "Fájlírás kész van");
		}catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "I/O hiba van");
		}
		

	}
}
