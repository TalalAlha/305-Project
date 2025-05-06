package db;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
        public static void main( String[] args ) throws SQLException {
            DatabaseConnection d=DatabaseConnection.getInstance();
            Connection SQL=d.getConnection();
            System.out.println(SQL);
        }

}
