package Ovelser.O2;

import java.util.Calendar;

public class Restaurant {

    private String name;
    private int foundingYear;
    private Table table;

    //constructor. Creates table objekt based on how many tables the user inputs.
    public Restaurant(String name, int foundingYear, int amountTables) {
        this.name = name;
        this.foundingYear = foundingYear;
        table = new Table(amountTables);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    //Uses calendar to calculate how many years the restaurant has been open
    public int getAge() {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int result = currentYear-foundingYear;
        return result;
    }

    public int amountFreeTables() {
        return table.getFreeTables();
    }

    public int amountResTables() {
        return table.getReservedTables();
    }

    //checks if there are enough available tables. returns false if there isn't
    public boolean reserveTables(String name, int tablesAmount) {
        if (table.getFreeTables() >= tablesAmount) {

            table.reserve(name,tablesAmount);

            return true;
        }
        else {
            return false;
        }
    }
    //Parses the string array from the client to int and catches numberformatexception if the user inputs something other than ints
    public void clearTables(String[] tableID) {
        for (int i = 0; i < tableID.length; i++) {
            try {
                table.clearTable(Integer.parseInt(tableID[i])-1);
            }
            catch (NumberFormatException e) {

            }
        }
    }

    public int[] findReservationTables(String name) {
        String[] arr = table.getTableList();
        int[] search_res = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == name) {
                search_res[i] = i+1;
            }
        }
        return search_res;
    }

    public int findReservationsInt(String name) {
        String[] arr = table.getTableList();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == name) {
                count++;
            }
        }
        return count;
    }

    public String displayTables() {
        return table.toString();
    }

    public String[] test () {
        return table.getTableList();
    }
}
