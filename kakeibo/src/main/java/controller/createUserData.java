package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class createUserData {
    public int insertUser(String username, String password) {
        String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
        int successFlg = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            successFlg = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return successFlg;
    }
}
