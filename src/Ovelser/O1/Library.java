package Ovelser.O1;

import java.sql.*;
import java.util.Scanner;

public class Library {


    public static void main(String[] args) throws SQLException {
        System.out.println("ENTER ISBN: ");

        Scanner sc  = new Scanner(System.in);

        String isbn = "\""+sc.nextLine()+"\"";
        //String isbn = "\"0-07-241143-5\"";

        String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/joakimad?user=joakimad&password=isAIL09r";

        try (Connection conn = DriverManager.getConnection(url);){

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select forfatter, tittel from boktittel where isbn="+isbn+";");

            if (res.next()==false) {
                System.out.println("No results");
            }
            else {
                //res.next();
                String author = res.getString("forfatter");

                ResultSet res2 = stmt.executeQuery("select count(*) antall from eksemplar where isbn =" + isbn + ";");

                res2.next();
                int count = res2.getInt("antall");

                System.out.println("Author: " + author + "\nCount: " + count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}