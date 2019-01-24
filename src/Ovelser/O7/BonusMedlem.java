package Ovelser.O7;

import java.time.LocalDate;

public class BonusMedlem {

    /**
     * finnKvalPoeng() skal returnere antall poeng som kan kvalifisere til oppgradering av medlemskapet til sølv eller gull.
     * Dersom innmeldingsdatoen  ligger mindre enn 365 dager bak i tid i forhold til datoen som sendes inn som argument, returneres antall poeng.
     * Hvis det er mer enn ett år siden kunden meldte seg inn, returneres 0 poeng.
     * Du kan finne differansen mellom to objekter av klasse LocalDate på denne måten:
     *
     *   int dagerMellom = Period.between(date1, date2).getDays();
     *
     * okPassord() tar et passord som argument, og returnerer true dersom det er ok.
     *
     * registrerPoeng() skal ta antall poeng som argument og registrere disse i henhold til reglene foran.
     * (Du skal ikke tenke på oppgradering til gull- og sølvmedlemskap her.)
     */

    private final int medlNr;
    private final Personalia pers;
    private final LocalDate innmeldtDato;
    private int poeng = 0;

    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
    }

    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
        this.poeng = poeng;
    }

    public int finnKvalPoeng(LocalDate now) {
        LocalDate deadline = innmeldtDato.plusDays(365);
        if (now.isAfter(deadline)) {
            return 0;

        }
        else {
            return poeng;
        }
    }

    public void registrerPoeng(int poeng) {
        this.poeng += poeng;
    }

    public int getMedlNr() {
        return medlNr;
    }

    public LocalDate getInnmeldtDato() {
        return innmeldtDato;
    }

    public int getPoeng() {
        return poeng;
    }

    public Personalia getPers() {
        return pers;
    }

    public String visInfo() {
        String result = "Nr: "+medlNr+"\n"+poeng+" poeng";
        if (this instanceof BasicMedlem) {
            result += "\nStatus: Basic";
        }
        else if (this instanceof SilverMedlem) {
            result += "\nStatus: Silver";
        }
        else if (this instanceof GoldMedlem) {
            result += "\nStatus: Gold";
        }
        return result;
    }
}
