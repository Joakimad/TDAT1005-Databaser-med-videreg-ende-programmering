package Ovelser.O8;

public class StåTribune extends Tribune {

    private int antSolgteBilletter;

    public StåTribune(String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn, kapasitet, pris);
    }

    @Override
    public int finnAntallSolgteBilletter() {
        return antSolgteBilletter;
    }

    @Override
    public Billett[] kjøpBilletter(int antBilletter) {
        if (finnLedigePlasser() <= super.getKapasitet()) {
            StåplassBillett[] solgteBill = new StåplassBillett[antBilletter];
            for (int i = 0; i < antBilletter; i++) {
                solgteBill[i] = new StåplassBillett(super.getTribunenavn(), super.getPris());
                antSolgteBilletter++;
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

    private int finnLedigePlasser() {
        return super.getKapasitet()-antSolgteBilletter;
    }
}

