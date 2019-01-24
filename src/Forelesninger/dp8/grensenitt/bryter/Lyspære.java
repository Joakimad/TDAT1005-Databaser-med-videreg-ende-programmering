package Forelesninger.dp8.grensenitt.bryter;

import static lib.Out.out;

public class Lyspære implements Bryter {
	private final double styrke;
	
	public Lyspære(double styrke) {
		this.styrke = styrke;
	}
	
	@Override
	public void av() {
		out("Lyset er av");
	}

	@Override
	public void på() {
		out("Lyset er p�");
	}

	public double getStyrke() {
		return styrke;
	}
}
