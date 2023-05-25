package ruanderGyakorlasFrammel;

public enum Jegyek {
	ELEGTELEN("1"), ELEGSEGES("2"), KOZEPES("3"), JO("4"), KITUNO("5");
	private String szammal;
	private Jegyek(String szammal) {
		this.szammal=szammal;
	}
	
	public String toString() {
		return szammal;
	}

}
