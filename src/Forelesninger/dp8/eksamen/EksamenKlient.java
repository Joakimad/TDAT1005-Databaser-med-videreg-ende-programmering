package Forelesning.dp8.eksamen;

import static lib.Out.*;

public class EksamenKlient {

	public static void main(String[] args) {
		Oppdrag oppdrag = new Oppdrag(12, "LO172D"); // egentlig meningsl�st, kun for testing
		out("Timeforbruk: " + oppdrag.finnTimeforbruk());

		MuntligEksamen muntlig = new MuntligEksamen(10, "LX456D", 15.5);
		out("Pr�ver metoder arvet fra Oppdrag: Sensornr: " + muntlig.getSensornr() + ", fagkode: " + muntlig.getFag());
		out("Pr�ver redefinert metode for timeforbruk: " + muntlig.finnTimeforbruk());

		out("Pr�ver toString() p� de to objektene: ");
		out(oppdrag.toString());
		out(muntlig.toString());
		
	
		Prosjektoppgave prosj = new Prosjektoppgave(10, "BO803D", 5);
		out(prosj.toString());		
	}

}
