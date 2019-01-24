package dp3.utvidet_forloekke;

public class Ansatt extends Person {
	private int l�nnstrinn;

	public Ansatt(long fnr, String navn, String adresse, int l�nnstrinn) {
		super(fnr, navn, adresse);
		this.l�nnstrinn = l�nnstrinn;
	}

	/**
	 * @return the l�nnstrinn
	 */
	public int getL�nnstrinn() {
		return l�nnstrinn;
	}

	/**
	 * @param l�nnstrinn the l�nnstrinn to set
	 */
	public void setL�nnstrinn(int l�nnstrinn) {
		this.l�nnstrinn = l�nnstrinn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ansatt [l�nnstrinn=" + l�nnstrinn + ", "+super.toString()+"]";
	}
}
