package Ovelser.O4;

import java.util.ArrayList;

public class Konferansesenter {

    /**
     * Reserver rom, gitt tidspunkt fra og til, antall personer samt navn og telefonnummer til kunden.
     * (Her skal romnummer ikke være parameter, metoden skal selv finne et rom som er ledig og med plass til det oppgitte antallet personer.)
     * Registrer et nytt rom med romnummer og størrelse (ikke tillatt dersom rom med dette nummer fins fra før)
     * Finn antall rom
     * Finn et bestemt rom, gitt indeks
     * Finn et bestemt rom, gitt romnr
     */

    private ArrayList<Rom> romListe = new ArrayList<Rom>();

    public boolean nyttRom(int romnummer,int antallPersoner) {
        for (int i = 0; i < romListe.size(); i++) {
            if (romListe.get(i).getRomnummer() == romnummer) {
                return false;
            }
        }
        romListe.add(new Rom(romnummer,antallPersoner));
        return true;
    }

    public int finnAntRom() {
        return romListe.size();
    }

    public Rom finnRomMedRomnummer(int romnummer) {
        for (int i = 0; i < romListe.size(); i++) {
            if (romListe.get(i).getRomnummer() == romnummer) {
                return romListe.get(i);
            }
        }
        return null;
    }

    public Rom finnRomMedIndeks(int indeks) {
        return romListe.get(indeks);
    }

    public ArrayList<Rom> finnRomMedAntallPers(int antallPers) {
        ArrayList<Rom> passendeRom = new ArrayList<Rom>();
        for (int i = 0; i < romListe.size(); i++) {
            if (romListe.get(i).getAntallPersoner() >= antallPers) {
                passendeRom.add(romListe.get(i));
            }
        }
        return passendeRom;
    }

    public String skrivUtAlleRom() {

        int antallRom = finnAntRom();
        String result = "";

        for (int i = 0; i < antallRom; i++) {
            result += "Rom: " + romListe.get(i).getRomnummer() + "\n\t" + romListe.get(i).visReservasjoner();
        }
        return result;
    }

    public String skrivUtRomInfo(int romnummer) {
        String result = "";

        if (finnRomMedRomnummer(romnummer) == null) {
            return "Ikke et rom!";
        }
        else {
            int antallRom = finnAntRom();
            result += "Rom: " + romnummer + "\n\t" + finnRomMedRomnummer(romnummer).visReservasjoner();

            return result;
        }
    }

    public boolean reserver (Tidspunkt fra, Tidspunkt til, int antallPersoner, Kunde k) {
        Reservasjon res = new Reservasjon(fra, til, k);

        ArrayList<Rom> passendeRom = finnRomMedAntallPers(antallPersoner);
        for (int i = 0; i < passendeRom.size(); i++) {
            if (passendeRom.get(i).reserver(res)) {
                return true;
            }
        }
        return false;
    }
}
