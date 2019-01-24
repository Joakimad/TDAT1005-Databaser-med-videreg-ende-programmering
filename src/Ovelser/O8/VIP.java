package Ovelser.O8;

public class VIP extends SitteTribune {

    private String[][] tilskuer; // tabellstørrelse: antall rader * antall plasser pr rad

    public VIP(String tribunenavn, int kapasitet, int pris, int antallRader, int antallPlasser) {
        super(tribunenavn, kapasitet, pris, antallRader);
        tilskuer = new String[antallRader][antallPlasser];
    }

    @Override
    public Billett[] kjøpBilletter(int antBilletter) {
        return null;
    }

    @Override
    public Billett[] kjøpBilletter(String[] bestillere) {
        if (super.erPlass()) {
            int ledigPlass = super.getKapasitet() - finnAntallSolgteBilletter();
            if (ledigPlass <= bestillere.length) {
                return null;
            } else {
                SitteplassBillett[] solgteBill = new SitteplassBillett[bestillere.length];
                for (int i = 0; i < tilskuer.length; i++) {
                    if (finnLedigePlasser(i) >= bestillere.length) {
                        int[] seter = leggTilBilletter(bestillere, i);
                        for (int j = 0; j < bestillere.length; j++) {
                            solgteBill[i] = new SitteplassBillett(super.getTribunenavn(), super.getPris(), i, seter[j]);
                        }
                        return solgteBill;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int finnAntallSolgteBilletter() {
        int count = 0;
        for (int i = 0; i < tilskuer.length; i++) {
            for (int j = 0; j < tilskuer[i].length; j++) {
                if (tilskuer[i][j] != null) {
                    count++;
                }
            }
        }
        return super.getKapasitet() - count;
    }

    private boolean leggTilBilletter2(String[] bestillere, int rad) {
        boolean added = false;
        for (int i = 0; i < tilskuer[rad].length; i++) {
            if (tilskuer[rad][i] != null) {
                tilskuer[rad][i] = bestillere[i];
                added = true;
            }
        }
        return added;
    }

    private int[] leggTilBilletter(String[] bestillere, int rad) {
        int[] seter = new int[bestillere.length];
        for (int i = 0; i < seter.length; i++) {
            for (int j = 0; j < tilskuer[rad].length; j++) {
                if (tilskuer[rad][j] != null) {
                    tilskuer[rad][j] = bestillere[j];
                    seter[i] = j;
                }
            }
        }
        return seter;
    }

    private int finnLedigePlasser(int rad) {
        int count = 0;
        for (int i = 0; i < tilskuer[rad].length; i++) {
            if (tilskuer[rad][i] != null) {
                count++;
            }
        }
        return count;
    }
}
