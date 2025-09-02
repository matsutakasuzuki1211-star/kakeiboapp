package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertData {
    public int insertKakeibo(String username, int balance, int payment) {
        String sql = "INSERT INTO kakeibos (username, balance, payment) VALUES (?, ?, ?)";
        int successFlg = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, balance);
            pstmt.setInt(3, payment);
            successFlg = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return successFlg;
    }
}
