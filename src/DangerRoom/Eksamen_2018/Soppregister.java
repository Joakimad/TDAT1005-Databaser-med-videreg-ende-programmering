package DangerRoom.Eksamen_2018;

import DangerRoom.Eksamen_2018.Soppart;

public class Soppregister {

    public Soppart[] register;
    private int antallReg;
    private final int START_STORRELSE = 10;
    private final int UTVID_STORRELSE = 10;

    public Soppregister() {
        register = new Soppart[START_STORRELSE];
        antallReg = 0;
    }

    public boolean nySoppart(Soppart o) {
        //Søk gjennom register for å sjekke om soppart allerede er registrert
        for (int i = 0; i < register.length; i++) {
            if (register[i].equals(o)) {
                //Returner false fordi Sopparten er allerede registrert
                return false;
            }
        }
        //Sjekk om registeret er fullt
        if (registerErFullt()) {
            utvidRegister();
        }
        //antallReg vil vise til den første ledige plassen i array. Etter å ha oppdater array inkrementerer vi antallReg.
        antallReg++;
        return true;
    }

    //Metode som sjekker om antall registrerte elementer har nådd lik størrelsen på arrayey vårt.
    private boolean registerErFullt() {
        if (antallReg == register.length) {
            return true;
        }
        else {
            return false;
        }
    }

    //Metode som utvider arrayet med 10.
    private void utvidRegister() {
        int lengde = register.length;
        Soppart[] temp = new Soppart[lengde + UTVID_STORRELSE];
        for (int i = 0; i < lengde; i++) {
            //Bruker dyp kopiering.
            temp[i] = register[i];
        }
        register = temp;
    }

    public Soppart[] listeMatSopper() {
        //Lager en kopi av register og kopierer over matsoppene.
        //Et problem her er at vi kan få en lang liste med tomme elementer.
        Soppart[] Matsopper = new Soppart[register.length];
        for (int i = 0; i < register.length; i++) {
            if (register[i].getGiftig() == false) {
                //Bruker dyp kopiering.
                Matsopper[i] = register[i];
            }
        }
        return Matsopper;
    }

    public String listOppSopparter() {
        String result = "Alle registrerte Sopparter (Navn Beskrivelse Spiselig):\n";
        for (int i = 0; i < register.length; i++) {
            //Vi skriver bare ut delene av array som har data.
            if (register[i] != null) {
                result += (i + 1) + ": " + register[i].getNavn() + " | " + register[i].getBeskrivelse();
                //Skriver forskjellig resultat avhengig av om giftig er satt til true eller false.
                if (register[i].getGiftig()) {
                    result += " Giftig.\n";
                } else {
                    result += " Matsopp.\n";
                }
            }
        }
        return result;
    }

    public String søkEtterTekst(String sokestreng) {
        String result = "Søkeresultat: \n";
        int antallTreff = 0;
        for (int i = 0; i < register.length; i++) {
            //Bruker søke metoden vi lagde tidligere. Hvis den returnerer true legger vi til i stringen.
            if (register[i].sokBeskrivelse(sokestreng)) {
                result += "Treff funnet: " + register[i].getNavn() + "\n";
                antallTreff++;
            }
        }
        //Sjekker om vi fikk noen treff slik at vi kan gi brukeren nøyaktig informasjon.
        if (antallTreff == 0) {
            result += "Ingen treff";
        } else {
            result += antallTreff + " treff funnet";
        }
        return result;
    }
}
