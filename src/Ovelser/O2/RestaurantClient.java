package Ovelser.O2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RestaurantClient {

    public static void main(String[] args) throws IOException {

        Restaurant res = new Restaurant("Joakim's", 2014, 10);

        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int option = 0;

        do {
            System.out.println("Menu:\n1. Reserve Table(s)\n2. Find Reservation\n3. Clear Tables\n4. Info\n5. Exit");

            option = Integer.parseInt(reader.readLine());
            //sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Input amount of tables to register:");

                    //int tablesAmount = sc.nextInt();
                    int tablesAmount = Integer.parseInt(reader.readLine());

                    System.out.println("Input name to register tables to:");

                    //String name_res = sc.nextLine();
                    String name_res= reader.readLine();
                    //String name_res = "joakim";
                    System.out.println(name_res);

                    if (res.reserveTables(name_res, tablesAmount)) {
                        System.out.println("Tables reserved");
                    } else {
                        System.out.println("Not enough tables available");
                    }
                    break;
                case 2:
                    System.out.println("Input name to search for: ");

                    //String name_search = sc.nextLine();
                    String name_search = reader.readLine();
                    //String name_search = "joakim";
                    System.out.println(name_search);

                    int[] search_results = res.findReservationTables(name_search);
                    System.out.println(res.findReservationsInt(name_search)+" results!");
                    for (int i = 0; i < search_results.length; i++) {
                        if (search_results[i] != 0) {
                            System.out.println("Table: "+search_results[i]+" - "+name_search);
                        }
                    }
                    System.out.println("---");
                    break;
                case 3:
                    System.out.println("Enter tables to clear (seperated by space)");
                    String input = sc.nextLine();
                    String[] tableID = input.split(" ");
                    res.clearTables(tableID);
                    break;
                case 4:
                    System.out.println("\n" + res.getName());
                    System.out.println("Best restaurant the last " + res.getAge() + " years");
                    System.out.println("10 tables - " + res.amountFreeTables() + " free, " + res.amountResTables() + " reserved");
                    System.out.println(res.displayTables());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                case 6:
                    String[] arr = res.test();
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]+"!");
                    }
                    break;
            }
        } while (option != 5);
    }
}