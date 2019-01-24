package Ovelser.O4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Klient {

    /**
     * Begynn med å registrere alle rommene.
     * Les inn noen reservasjoner.
     * Skriv ut all registrert informasjon. Bruk metodene som finner antall rom og rom gitt indeks.
     * Prøv ut metoden som finnet er rom, gitt romnummer. La brukeren skrive inn romnummeret.
     * All info om rommet, inkludert reservasjonene skal skrives ut.
     */

    public static void main(String[] args) {

        Konferansesenter konf = new Konferansesenter();

        Scanner sc = new Scanner(System.in);

        konf.nyttRom(101,1);
        konf.nyttRom(102,1);
        konf.nyttRom(201,2);
        konf.nyttRom(202,2);
        konf.nyttRom(301,3);

        Kunde k1 = new Kunde("Joakim", "12345678");
        Kunde k2 = new Kunde("Magnus", "91234567");
        Kunde k3 = new Kunde("Jon", "12345678");

        //TEST 1 reservasjon
        if (konf.reserver(new Tidspunkt(201901151000L), new Tidspunkt(201901151200L),2,k1)) {
            System.out.println("Test 1: suksess");
        }
        //TEST 2 reservasjon
        if (konf.reserver(new Tidspunkt(201901151200L), new Tidspunkt(201901151300L),3,k2)) {
            System.out.println("Test 2: suksess");
        }
        //TEST 3 overlapp fungerer
        if (!konf.reserver(new Tidspunkt(201901151200L), new Tidspunkt(201901151300L),3,k3)) {
            System.out.println("Test 3: suksess");
        }
        //TEST 4 overlapp fungerer
        if (!konf.reserver(new Tidspunkt(201901151230L), new Tidspunkt(201901151400L),3,k3)) {
            System.out.println("Test 4: suksess");
        }

        System.out.println("---\nSkriver ut alle rom:");
        System.out.println(konf.skrivUtAlleRom()+"\n---");

        System.out.println("Tester romsøk: ");
        System.out.println("Skriv inn romnummer: ");
        try {
            int num = sc.nextInt();
            System.out.println(num);
            System.out.println(konf.skrivUtRomInfo(num));
        }
        catch (InputMismatchException e) {
            System.out.println("Please input a number!");
        }
    }
}
