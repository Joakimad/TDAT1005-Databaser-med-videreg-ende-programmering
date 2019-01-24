package DangerRoom;

import java.sql.*;

public class DatabaseWrapper {

    public static void main(String[] args) throws SQLException {
        System.out.println("Starting...");

        String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/joakimad?user=joakimad&password=isAIL09r";

        try (Connection conn = DriverManager.getConnection(url);){

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Pokemon");

            while (res.next()) {
                System.out.println(res.getString("Navn"));
            }
            System.out.println("Closing...");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
