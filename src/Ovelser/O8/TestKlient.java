package Ovelser.O8;

public class TestKlient {

    public static void main(String[] args) {

        StåTribune t1 = new StåTribune("A1", 60, 50);
        StåTribune t2 = new StåTribune("A2", 40, 75);
        SitteTribune t3 = new SitteTribune("B1", 40, 100, 5);
        SitteTribune t4 = new SitteTribune("B2", 30, 125, 5);
        VIP t5 = new VIP("C1", 15, 200, 5, 6);

        Tribune[] tribuner = {t1, t2, t3, t4, t5};

        for (int i = 0; i < tribuner.length; i++) {
            System.out.println(tribuner[i].toString());
        }
        System.out.println("---");


        //TEST 1: BESTILLE BILLETTER - STÅPLASS
        if (t1.kjøpBilletter(10) != null) {
            System.out.println("ye");
        }

        Billett[] billetter = t1.kjøpBilletter(4);

//        if (t1.kjøpBilletter(51) == null) {
//            System.out.print("ye");
//        }
        System.out.println(t1.finnAntallSolgteBilletter());
        if (t1.finnAntallSolgteBilletter() == 10) {
            System.out.println("ye");
        }

        String[] bestillere = {"Joakim", "Magnus", "Jon", "Tore"};

        for (int i = 0; i < billetter.length; i++) {
            System.out.println(billetter[i].toString());
        }


        //Billett[] kjøpt = t5.kjøpBilletter(bestillere);

        //Billett[] kjøpt = t3.kjøpBilletter(5);

    }
}
