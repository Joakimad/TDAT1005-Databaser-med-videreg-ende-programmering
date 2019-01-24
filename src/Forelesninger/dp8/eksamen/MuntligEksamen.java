package Forelesning.dp8.eksamen;

class MuntligEksamen extends Oppdrag {
	private final double medgåttTid; // timer

	public MuntligEksamen(int sensornr, String fag, double medgåttTid) {
		super(sensornr, fag);
		this.medgåttTid = medgåttTid;
	}

	public double getMedgåttTid() {
		return medgåttTid;
	}

	public double finnTimeforbruk() {
		return medgåttTid + FORBEREDELSE;
	}

	public String toString() {
		return "Muntlig eksamen, medg�tt tid: " + medgåttTid + " " + super.toString();
	}
}
