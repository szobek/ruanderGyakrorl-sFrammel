package ruanderGyakorlasFrammel;

public class Tanulo {
	private String nev;
	private int matek;
	private int angol;
	private int tori;
	private double atlag;
	private int id;
	
	public static boolean dialogOpened=false;
	
	public Tanulo(String nev, int matek, int angol, int tori,int id) {
		super();
		this.nev = nev;
		this.matek = matek;
		this.angol = angol;
		this.tori = tori;
		this.atlag=sumAtlag();
		this.id=id;
	}

	public Tanulo(String[] csvSor ) {
		this.nev = csvSor[0];
		this.matek = Integer.parseInt(csvSor[1]);
		this.angol = Integer.parseInt(csvSor[2]);
		this.tori = Integer.parseInt(csvSor[3]);
		this.atlag=sumAtlag();
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
	
	
	public double getAtlag() {
		return atlag;
	}

	
	
	public int getId() {
		return id;
	}

	private double sumAtlag() {
		return (matek+angol+tori)/3.0;
	}
	
}
