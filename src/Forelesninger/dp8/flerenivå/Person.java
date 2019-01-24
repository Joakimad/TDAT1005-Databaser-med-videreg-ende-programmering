package Forelesninger.dp8.flerenivå;

public class Person {
	private final String navn;
	
	public String getNavn() {
		return navn;
	}

	public Person(String navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return "[Person: navn=" + getNavn()+ "]";
	}
}
