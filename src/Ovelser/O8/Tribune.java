package Ovelser.O8;

public class Tribune {

    private final String tribunenavn;
    private final int kapasitet;
    private final int pris;

    public Tribune(String tribunenavn, int kapasitet, int pris) {
        this.tribunenavn = tribunenavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }

    public int finnAntallSolgteBilletter() {
        //TODO
        return 0;
    }

    public int finnInntekt() {
        return pris*finnAntallSolgteBilletter();
    }

    public Billett[] kjøpBilletter(int antBilletter) {
        return null;
    }

    public Billett[] kjøpBilletter(String[] bestillere) {
        return null;
    }

    public int getKapasitet() {
        return kapasitet;
    }

    public String getTribunenavn() {
        return tribunenavn;
    }

    public int getPris() {
        return pris;
    }

    public boolean erPlass() {
        if (finnAntallSolgteBilletter() < kapasitet) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return tribunenavn+" "+kapasitet+" "+pris;
    }
}
