package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertData {
    public int insertUser(int balance, int payment) {
        String sql = "INSERT INTO Users (balance, payment) VALUES (?, ?)";
        int successFlg = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, balance);
            pstmt.setInt(2, payment);
            successFlg = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return successFlg;
}
}
