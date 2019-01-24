package DangerRoom;

public class PracticeMakesPerfect {

    public static void main(String[] args) {

        String passord = "joakimjoakim1";

        if (!passord.matches(".*\\d+.*")) {
            System.out.println("ikke bra nok");
        }
        else {
            System.out.println("bra pass, bro");
        }

    }
}