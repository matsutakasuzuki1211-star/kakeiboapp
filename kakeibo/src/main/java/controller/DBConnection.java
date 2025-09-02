package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost/javadb?serverTimezone=Asia/Tokyo";
    private static final String USER = "javaclient";
    private static final String PASSWORD = "javapass";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
