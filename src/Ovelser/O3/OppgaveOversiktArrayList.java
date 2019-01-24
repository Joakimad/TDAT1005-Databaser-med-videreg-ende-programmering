package Ovelser.O3;

import java.util.ArrayList;

public class OppgaveOversiktArrayList {

    private ArrayList<Student> studenter = new ArrayList<Student>();
    private int antStud = 0;

    public boolean regNyStudent(String navn) {
        //Check if user already is registered.

        for (int i = 0; i < studenter.size(); i++) {
            if (studenter.get(i).getNavn().equals(navn)) {
                return false;
            }
        }

        //add student and increment antStud
        studenter.add(new Student(navn));
        antStud++;
        return true;
    }

    public int finnAntOppgaver(String navn) {
        for (int i = 0; i < studenter.size(); i++) {
            if (studenter.get(i).getNavn() == navn) {
                return studenter.get(i).getAntOppg();
            }
        }
        return -1;
    }

    public int finnAntStud() {
        return antStud;
    }

    public void økAntOppg(String navn, int antall) {
        for (int i = 0; i < studenter.size(); i++) {
            if (studenter.get(i).getNavn() == navn) {
                studenter.get(i).setAntOppg(studenter.get(i).getAntOppg() + antall);
            }
        }
    }

    public String[] finnAlleNavn() {
        String[] navneliste = new String[studenter.size()];

        for (int i = 0; i < studenter.size(); i++) {
            navneliste[i] = studenter.get(i).getNavn();
        }
        return navneliste;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < studenter.size(); i++) {
            result += studenter.get(i).toString() + "\n";
        }
        return result;
    }
}