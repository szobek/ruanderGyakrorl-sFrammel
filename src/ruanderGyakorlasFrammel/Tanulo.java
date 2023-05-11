package ruanderGyakorlasFrammel;

public class Tanulo {
	private String nev;
	private int matek;
	private int angol;
	private int tori;
	
	public Tanulo(String[] csvSor ) {
		this.nev = csvSor[0];
		this.matek = Integer.parseInt(csvSor[1]);
		this.angol = Integer.parseInt(csvSor[2]);
		this.tori = Integer.parseInt(csvSor[3]);
	}
	
	public Tanulo(String nev, int matek, int angol, int tori) {
		this.nev = nev;
		this.matek = matek;
		this.angol = angol;
		this.tori = tori;
	}
	public String getNev() {
		return nev;
	}
	public int getMatek() {
		return matek;
	}
	public int getAngol() {
		return angol;
	}
	public int getTori() {
		return tori;
	}

	
	
}
