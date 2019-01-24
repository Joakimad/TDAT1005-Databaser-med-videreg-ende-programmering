package Ovelser.O8;

public class SitteTribune extends Tribune {

    private int [] antOpptatt;  // tabellstørrelse: antall rader

    public SitteTribune(String tribunenavn, int kapasitet, int pris, int antallRader) {
        super(tribunenavn, kapasitet, pris);
        antOpptatt = new int[antallRader];
    }

    @Override
    public int finnAntallSolgteBilletter() {
        int opptatt = 0;
        for (int i = 0; i < antOpptatt.length; i++) {
            opptatt += antOpptatt[i];
        }
        return opptatt;
    }

    @Override
    public Billett[] kjøpBilletter(int antBilletter) {
        if (finnAntallSolgteBilletter() <= super.getKapasitet()) {
            StåplassBillett[] solgteBill = new StåplassBillett[super.getKapasitet()];
            for (int i = 0; i < antBilletter; i++) {
                solgteBill[i] = new StåplassBillett(super.getTribunenavn(), super.getPris());
            }
            return solgteBill;
        }
        return null;
    }

    @Override
    public Billett[] kjøpBilletter(String[] bestillere) {
        int antBilletter = bestillere.length;
        return kjøpBilletter(antBilletter);
    }
}
