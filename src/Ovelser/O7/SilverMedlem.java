package Ovelser.O7;

import java.time.LocalDate;

public class SilverMedlem extends BonusMedlem{

    public SilverMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        super(medlNr, pers, innmeldtDato);
    }

    public SilverMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato, poeng);
    }

    @Override
    public void registrerPoeng(int poeng) {
        int sum = (int)(poeng * 1.2);
        super.registrerPoeng(sum);
    }
}
