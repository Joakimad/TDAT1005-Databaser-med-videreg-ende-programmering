package Ovelser.O2;

public class Table {

    /**
     * Finn antall ledige bord
     * Finn antall bord opptatt
     * Frigi bord som er ryddet
     * Reserver bord
     */

    private String[] tableList;

    public Table(int antallBord) {
        tableList = new String[antallBord];
    }

    public int getFreeTables() {
        int free = 0;
        for (int i = 0; i < tableList.length; i++) {
            if (tableList[i] == null) {
                free++;
            }
        }
        return free;
    }

    public int getReservedTables() {
        int res = 0;
        for (int i = 0; i < tableList.length; i++) {
            if (tableList[i] != null) {
                res++;
            }
        }
        return res;
    }

    public void clearTable(int tableNumber) {
        tableList[tableNumber] = null;
    }

    public void reserve(String name, int tablesAmount) {
        int reservations = tablesAmount;

        for (int i = 0; i < tableList.length; i++) {
            if (reservations > 0) {
                if (tableList[i] == null) {
                    tableList[i] = name;
                    reservations--;
                }
            }
        }
    }

    public String[] getTableList() {
        return tableList;
    }

    public String toString() {
        String result = "Tables:\n";
        for (int i = 0; i < tableList.length; i++) {
            result += i+1+". "+tableList[i]+"\n";
        }
        result += "---";
        return result;
    }
}