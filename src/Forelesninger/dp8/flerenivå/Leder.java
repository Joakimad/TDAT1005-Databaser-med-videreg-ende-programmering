package Forelesninger.dp8.flerenivå;


public class Leder extends Ansatt {
	private String tittel;
	
	public Leder(String navn, double lønn, String tittel) {
		super(navn);
		super.setLønn(lønn);
		this.tittel = tittel;
	}

	@Override
	public String toString() {
		return "[Leder: tittel=" + tittel + ", " + super.toString() + "]";
	}

}
