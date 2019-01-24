package Ovelser.O7;

import java.time.LocalDate;

public class TestMedlemsArkiv {

    public static void main(String[] args) {
        MedlemsArkiv arkiv = new MedlemsArkiv();

        Personalia p1 = new Personalia("Joakim","Adolfsen","Joakim.adolfsen@gmail.com","IsErGodt");
        Personalia p2 = new Personalia("Jon","Bergquist","Jon.bergquist@hotmail.com","IsErMeh");
        Personalia p3 = new Personalia("Magnus","Brevik","Magnus.brevik@online.no","IsErStygt");

        LocalDate testdato = LocalDate.of(2019, 1, 21);

        int p1_nr = arkiv.nyMedlem(p1,testdato);
        int p2_nr = arkiv.nyMedlem(p2,testdato);
        int p3_nr = arkiv.nyMedlem(p3,testdato);
        int p4_nr = arkiv.nyMedlem(p2,testdato);

        System.out.println("Medlems Nummer:\n"+p1_nr+"\n"+p2_nr+"\n"+p3_nr+"\n"+p4_nr+"\n---");

        if (p1_nr != -1 && p2_nr != -1 && p3_nr != -1 && p4_nr == -1) {
            System.out.println("Legg til medlemer -- Test successful");
        }

        if (arkiv.registrerPoeng(p1_nr,50000) && arkiv.registrerPoeng(p2_nr,10000) &&
        arkiv.registrerPoeng(p3_nr,75000) && !arkiv.registrerPoeng(0,75000)) {
            System.out.println("Legg til poeng -- Test successful");
        }

        if (arkiv.finnPoeng(p1_nr,"IsErGodt") == 50000 && arkiv.finnPoeng(p1_nr,"") == -1) {
            System.out.println("Finn poeng -- Test successful");
        }

        if (arkiv.endrePassord(p2_nr,"IsErMeh","IsErFantastisk") && arkiv.finnPoeng(p2_nr,"IsErFantastisk") == 10000) {
            System.out.println("Endre passord -- Test successful");
        }
        System.out.println("---");

        arkiv.sjekkMedlemmer();

        System.out.println(arkiv.visMedlemmer());
    }
}
