package Forelesning.dp4.register.c;

import static lib.Out.out;

public class RegisterKlient {
	
	private static void initialiserRegister(Register mittRegister) {
		Utstyr[] uTab = new Utstyr[5];
		uTab[0] = new Utstyr("blyant", "Kontor AS", 5, 15);
		uTab[1] = new Utstyr("binders", "Kontor AS", 30, 5);
		uTab[2] = new Utstyr("skriveblokk", "Kontor AS", 20, 5);
		uTab[3] = new Utstyr("viskel�r", "Kontor AS", 40, 10);
		uTab[4] = new Utstyr("penn", "Kontor AS", 200, 50);

		for (int i = 0; i < uTab.length; i++) {
			if (mittRegister.regNyttUtstyr(uTab[i])) {
				out("Registrering ok");
			} else {
				out("Registrering ikke ok");
			}
		}		
	}

	public static void main(String[] args) {
		Register mittRegister = new Register();

		
		initialiserRegister(mittRegister);

		int resultat = mittRegister.endreLagerbeholdning("blyant", -10);
		
		String melding;
		if (resultat == Register.OK) {
		  melding = "Endring utf�rt";
		} else if (resultat == Register.UGYLDIG_BETEGNELSE) {
		  melding = "Endring ikke utf�rt. Ugyldig utstyrsbetegnelse.";
		} else {
		  melding = "Endring ikke utf�rt. Ikke nok p� lager.";
		}
		javax.swing.JOptionPane.showMessageDialog(null, melding);		
	}
}
