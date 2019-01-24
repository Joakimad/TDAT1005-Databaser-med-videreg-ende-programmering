package Ovelser.O3;

public class OppgaveOversikt {

    private Student[] studenter = new Student[5];
    private int antStud = 0;

    public boolean regNyStudent(String navn) {
        //Check if user already is registered.
        for (int i = 0; i < studenter.length; i++) {
            if (studenter[i] != null && studenter[i].getNavn().equals(navn)) {
                return false;
            }
        }
        //check if array if full
        if (antStud == studenter.length) {
            utvidTabellen();
        }

        //add student and increment antStud
        studenter[antStud] = new Student(navn);
        antStud++;
        return true;
    }

    private void utvidTabellen() {
        Student[] nyTab = new Student[studenter.length + 5];
        for (int i = 0; i < antStud; i++) {
            nyTab[i] = studenter[i];
        }
        studenter = nyTab;
    }

    public int finnAntOppgaver(String navn) {
        for (int i = 0; i < studenter.length; i++) {
            if (studenter[i] != null && studenter[i].getNavn() == navn) {
                return studenter[i].getAntOppg();
            }
        }
        return -1;
    }

    public int finnAntStud() {
        return antStud;
    }

    public void økAntOppg(String navn, int antall) {
        for (int i = 0; i < studenter.length; i++) {
            if (studenter[i] != null && studenter[i].getNavn() == navn) {
                studenter[i].setAntOppg(studenter[i].getAntOppg()+antall);
            }
        }
    }

    public String[] finnAlleNavn() {
        String[] navneliste = new String[studenter.length];

        int count = 0;
        for (int i = 0; i < studenter.length; i++) {
            if (studenter[i] != null) {
                navneliste[i] = studenter[i].getNavn();
            }
        }
        return navneliste;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < studenter.length; i++) {
            if (studenter[i] != null) {
                result += studenter[i].toString() + "\n";
            }
        }
        return result;
    }
}
