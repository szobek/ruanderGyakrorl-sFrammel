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

	public void writeFile() {
		try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("orszagok.csv"), "UTF-8");){
			
		}catch (IOException e) {
			// TODO: handle exception
		}
		

	}
}
