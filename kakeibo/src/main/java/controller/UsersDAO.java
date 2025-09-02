package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDAO {
    public int checkAccount(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        int successFlg = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password); // パスワードは空文字でチェック
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                successFlg = 1;
            } else {
                successFlg = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return successFlg;
    }

    public int checkUsername(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        int successFlg = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                successFlg = 1;
            } else {
                successFlg = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return successFlg;
    }

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
