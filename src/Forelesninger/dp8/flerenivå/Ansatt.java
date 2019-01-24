package Forelesninger.dp8.flerenivå;


public class Ansatt extends Person {
	private double lønn;
	
	public Ansatt(String navn) {
		super(navn);		
	}
	
	

	public double getLønn() {
		return lønn;
	}

	public void setLønn(double lønn) {
		this.lønn = lønn;
	}


	@Override
	public String toString() {
		return "[Ansatt: l�nn=" + lønn + ", " + super.toString() + "]";
	}
}
