package Ovelser.O7;

import java.time.LocalDate;

public class BasicMedlem extends BonusMedlem {

    public BasicMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        super(medlNr, pers, innmeldtDato);
    }

    public BasicMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato, poeng);
    }
}
