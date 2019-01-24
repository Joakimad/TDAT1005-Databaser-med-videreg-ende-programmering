package Ovelser.O7;

import java.time.LocalDate;

public class GoldMedlem extends BonusMedlem{
    public GoldMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        super(medlNr, pers, innmeldtDato);
    }

    public GoldMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato, poeng);
    }

    @Override
    public void registrerPoeng(int poeng) {
        int sum = (int)(poeng * 1.5);
        super.registrerPoeng(sum);
    }
}
