package Ovelser.O4;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rom {

    private final int romnummer;
    private final int antallPersoner;
    private ArrayList<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();

    public Rom(int romnummer, int antallPersoner) {
        this.romnummer = romnummer;
        this.antallPersoner = antallPersoner;
    }

    public int getRomnummer() {
        return romnummer;
    }

    public boolean reserver(Reservasjon res) {

        //check if that time is available reservation
        for (int i = 0; i < reservasjoner.size(); i++) {
            if (reservasjoner.get(i).overlapp(res.getFraTid(), res.getTilTid())) {
                return false;
            }
        }
        reservasjoner.add(res);
        return true;
    }

    public String visReservasjoner() {
        String result = "";

        if (reservasjoner.size() == 0) {
            return "Ingen reservasjoner\n";
        }

        for (int i = 0; i < reservasjoner.size(); i++) {
            result += reservasjoner.get(i).toString() + "\n";
        }
        return result;
    }

    public static void main(String[] args) {

        Kunde k = new Kunde("Anne Hansen", "12345678");

        Reservasjon r1 = new Reservasjon(new Tidspunkt(201901161000L), new Tidspunkt(201901161200L), k);
        Reservasjon r2 = new Reservasjon(new Tidspunkt(201901161200L), new Tidspunkt(201901161300L), k);
        Reservasjon r3 = new Reservasjon(new Tidspunkt(201901161200L), new Tidspunkt(201901161300L), k);

        ArrayList<Reservasjon> testsett = new ArrayList<Reservasjon>();
        testsett.add(r1);
        testsett.add(r2);
        testsett.add(r3);

        Rom rom237 = new Rom(237,20);

        String testString = "";
        for (int i = 0; i < testsett.size(); i++) {
            if (rom237.reserver(testsett.get(i))) {
                testString += "Reservasjon vellykket";
            }
            else {
                testString += "Rommet er opptatt";
            }
            testString+="\n";
        }

        System.out.println(testString);

        if (rom237.visReservasjoner().equals("Reservasjon vellykket\nReservasjon vellykket\nRommet er opptatt\n")) {
            System.out.println("Test vellykket!");
        } else {
            System.out.println("Test feilet");
        }
    }

    public int getAntallPersoner() {
        return antallPersoner;
    }
}
