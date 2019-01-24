package Forelesning.dp4.register.d;

/**
 * Klassen Utstyr er mutabel. Antall p� lager og nedre grense for bestilling kan
 * endres.
 */
class Utstyr {
	public static final int BESTILLINGSFAKTOR = 5;
	private final String betegnelse;
	private final String leverandør;
	private int påLager; // mengde p� lager
	private int nedreGrense;

	public Utstyr(String betegnelse, String leverandør, int påLager, int nedreGrense) {
		this.betegnelse = betegnelse;
		this.leverandør = leverandør;
		this.påLager = påLager;
		this.nedreGrense = nedreGrense;
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public String getLeverandør() {
		return leverandør;
	}

	public int getPåLager() {
		return påLager;
	}

	public int getNedreGrense() {
		return nedreGrense;
	}

	public void setNedreGrense(int nyNedreGrense) {
		nedreGrense = nyNedreGrense;
	}

	public int finnBestKvantum() {
		return (påLager < nedreGrense) ? BESTILLINGSFAKTOR * nedreGrense : 0;
	}

	/**
	 * Endring av lagerbeholdning. Den kan v�re positiv eller negativ. Men det er
	 * ikke mulig � ta ut mer enn det som fins p� lager. Hvis klienten pr�ver p�
	 * det, vil metoden returnere false, og intet uttak gj�res.
	 */
	public boolean endreLagerbeholdning(int endring) {
		if (påLager + endring < 0) {
			return false;
		} else {
			påLager += endring;
			return true;
		}
	}

	public String toString() {
		String resultat = "Betegnelse: " + betegnelse + ", ";
		resultat += "Leverand�r: " + leverandør + ", ";
		resultat += "P� lager: " + påLager + ", ";
		resultat += "Nedre grense: " + nedreGrense;
		return resultat;
	}
}