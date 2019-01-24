package Ovelser.O7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MedlemsArkiv {

    private ArrayList<BonusMedlem> medlemmer = new ArrayList<BonusMedlem>();

    public int finnPoeng(int medlNr, String passord) {
        for (int i = 0; i < medlemmer.size(); i++) {
            if (medlemmer.get(i).getMedlNr() == medlNr && medlemmer.get(i).getPers().okPassord(passord)) {
                return medlemmer.get(i).getPoeng();
            }
        }
        return -1;
    }

    public boolean registrerPoeng(int medlNr, int poeng) {
        int indeks = finnIndeks(medlNr);
        if (indeks != -1) {
            if (medlemmer.get(indeks).getMedlNr() == medlNr) {
                medlemmer.get(indeks).registrerPoeng(poeng);
                return true;
            }
        }
        return false;
    }

    public int nyMedlem(Personalia pers, LocalDate innmeldt) {
        int medlNr = finnLedigNr();

        for (int i = 0; i < medlemmer.size(); i++) {
            if (medlemmer.get(i).getPers() == pers) {
                return -1;
            }
        }
        BasicMedlem nyttMedlem = new BasicMedlem(medlNr, pers, innmeldt);
        medlemmer.add(nyttMedlem);
        return medlNr;
    }

    private int finnLedigNr() {
        boolean foundNumber = false;
        int num = 0;
        while (foundNumber == false) {
            Random rdm = new Random();
            num = rdm.nextInt(500);
            for (int i = 0; i < medlemmer.size(); i++) {
                if (medlemmer.get(i).getMedlNr() == num) {
                    continue;
                }
            }
            foundNumber = true;
        }
        return num;
    }

    public void sjekkMedlemmer() {
        for (int i = 0; i < medlemmer.size(); i++) {
            if (medlemmer.get(i) instanceof BasicMedlem) {
                if (medlemmer.get(i).getPoeng() >= 75000) {
                    BonusMedlem etter = oppgrader(medlemmer.get(i), 2);
                    medlemmer.set(i, etter);
                } else if (medlemmer.get(i).getPoeng() >= 25000) {
                    BonusMedlem etter = oppgrader(medlemmer.get(i), 1);
                    medlemmer.set(i, etter);
                }
            }
            if (medlemmer.get(i) instanceof SilverMedlem) {
                if (medlemmer.get(i).getPoeng() >= 75000) {
                    BonusMedlem etter = oppgrader(medlemmer.get(i), 2);
                    medlemmer.set(i, etter);
                }

            }
        }
    }

    private BonusMedlem oppgrader(BonusMedlem før, int level) {
        if (level == 1) {
            SilverMedlem etter = new SilverMedlem(før.getMedlNr(), før.getPers(), før.getInnmeldtDato(), før.getPoeng());
            return etter;
        }
        if (level == 2) {
            GoldMedlem etter = new GoldMedlem(før.getMedlNr(), før.getPers(), før.getInnmeldtDato(), før.getPoeng());
            return etter;
        }
        return null;
    }

    public String visMedlemmer() {
        String result = "";
        for (int i = 0; i < medlemmer.size(); i++) {
            result += medlemmer.get(i).getPers().visInfo() + "\n" + medlemmer.get(i).visInfo() + "\n---\n";
        }
        return result;
    }

    public boolean endrePassord(int medlNr,String gammelt, String nytt) {
        int indeks = finnIndeks(medlNr);
        if (indeks != -1) {
            if (medlemmer.get(indeks).getPers().endrePassord(gammelt,nytt)) {
                return true;
            }
        }
        return false;
    }

    private int finnIndeks(int medlNr) {
        for (int i = 0; i < medlemmer.size(); i++) {
            if (medlemmer.get(i).getMedlNr() == medlNr) {
                return i;
            }
        }
        return -1;
    }
}

