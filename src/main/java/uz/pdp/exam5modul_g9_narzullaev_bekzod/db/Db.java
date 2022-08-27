package uz.pdp.exam5modul_g9_narzullaev_bekzod.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

    public static Connection getConnection(){

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/exam",
                    "postgres",
                    "root123"
            );
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
