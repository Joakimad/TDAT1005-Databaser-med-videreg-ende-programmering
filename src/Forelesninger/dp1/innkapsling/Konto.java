package Forelesning.dp1.innkapsling;

public class Konto {

	private final long kontonr;
	private final String navn;
	private long saldo;

	public Konto(long kontonr, String navn, long saldo) {
		this.kontonr = kontonr;
		this.navn = navn;
		this.saldo = saldo;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public long getKontonr() {
		return kontonr;
	}

	public String getNavn() {
		return navn;
	}

	public boolean utf�rTransaksjon(double bel�p) {
		int bel�p�re = regnOmTil�re(bel�p);
		if (saldo + bel�p�re >= 0) {
			saldo += bel�p�re;
			return true;
		} else {
			return false;
		}

	}

	private int regnOmTil�re(double bel�p) {
		return (int) (bel�p * 100);
	}
}
