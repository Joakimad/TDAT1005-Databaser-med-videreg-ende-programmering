package DangerRoom.Eksamen_2018;

import java.io.*;
import static javax.swing.JOptionPane.*;

public class Klient {

    public static void main(String[] args) {
        String filnavn = "soppregister.ser";
        Soppregister register = lesRegFraFil(filnavn);

        if (register == null) {
            // metode som opppretter ett tomt register
            register = new Soppregister();
        }

        String[] muligheter = {"List alle", "List matsopper", "Legg til ny", "Søk", "Avslutt"};
        final int LIST_ALLE = 0;
        final int LIST_MATSOPPER = 1;
        final int REG_SOPP = 2;
        final int SOK = 3;
        final int AVSLUTT = 4;

        int valg = showOptionDialog(null, "Velg", "Eksamen des 2018", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);

        while (valg != AVSLUTT) {
            switch (valg) {
                case LIST_ALLE:
                    /*Anta at koden eksisterer*/
                    break;
                case LIST_MATSOPPER:
                    /*Anta at koden eksisterer*/
                    break;
                case REG_SOPP:
                    String navn = showInputDialog("Soppart: ");
                    String beskrivelse = showInputDialog("Beskrivelse: ");

                    //Usikker på hvordan ConfirmDialog håndterer denne delen.
                    //Poenget er at boolean skal bli satt til true hvis brukeren
                    //sier ja eller false hvis brukeren sier nei.
                    boolean giftig;
                    int reply = showConfirmDialog(null, "Giftig?", "", YES_NO_OPTION);
                    if (reply == YES_OPTION) {
                        giftig = true;
                    }
                    else {
                        giftig = false;
                    }
                    Soppart o = new Soppart(navn, beskrivelse, giftig);

                    //Vi gjør all sjekkingen i nySoppart metoden.
                    register.nySoppart(o);
                    break;
                case SOK:
                    String sokeStreng = showInputDialog("Søk i registeret: ");
                    String msg = register.søkEtterTekst(sokeStreng);

                    showMessageDialog(null, msg, "Søkeresultat", INFORMATION_MESSAGE);
                    break;
                default:
                    break;
            }
            valg = showOptionDialog(null, "Velg", "Eksamen des 2018", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
        }
        //skrivRegTilfil(filnavn, register);
    }

    private void skrivRegTilfil(String filnavn, Soppregister register) {
        //Antar at koden eksisterer.
    }

    private static Soppregister lesRegFraFil(String filnavn) {
        try {
            FileReader fr = new FileReader(filnavn);
            BufferedReader reader = new BufferedReader(fr);

            //Lager en ny tom soppregister
            Soppregister input = new Soppregister();

            String line;
            //Så lenge det er linjer i dokumentet. Del opp linjene og lag et soppart objekt av hver linje. Vi antar her at de forskjellige variablene til objektet er skillet med tegnet '|'.
            while ((line = reader.readLine()) != null) {
                String[] inputArr = line.split("|");
                String navn = inputArr[0];
                String beskrivelse = inputArr[1];
                boolean giftig;
                if (inputArr[2] == "true") {
                     giftig = true;
                }
                else {
                    giftig = false;
                }
                Soppart o = new Soppart(navn, beskrivelse, giftig);
                input.nySoppart(o);
            }
            reader.close();
            return input;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Noe gikk galt under lesing av fil");
        }
        return null;
    }
}

