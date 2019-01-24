package DangerRoom.Eksamen_2018;

public class Soppart {

    private String navn;
    private String beskrivelse;
    private boolean giftig;

    //Tar inn variabler
    public Soppart(String navn, String beskrivelse, boolean giftig) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.giftig = giftig;
    }

    //Tar inn ett Soppart objekt
    public Soppart(Soppart o) {
        navn = o.getNavn();
        beskrivelse = o.getBeskrivelse();
        giftig = o.getGiftig();
    }

    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public boolean getGiftig() {
        return giftig;
    }

    public boolean equals(Soppart o) {
        //Sjekker om det er samme objekt

        //Sjekker om objektene har samme navn
        if (navn == o.getNavn()) {
            return true;
        }
        //Hvis ikke returner false
        else {
            return false;
        }
    }

    public boolean sokBeskrivelse(String sokestreng) {
        //Bruker indexOf for å lete etter forekomster av sokestrengen. indexOf returnerer -1 hvis det ikke er funnet.
        if (beskrivelse.indexOf(sokestreng) != -1) {
            return true;
        } else {
            return false;
        }
    }
}

