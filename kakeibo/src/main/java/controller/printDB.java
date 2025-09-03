package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KakeiboRecord;


public class printDB {
    public List<KakeiboRecord> getTable(String username) {
        List<KakeiboRecord> list = new ArrayList<>();
        String sql = "SELECT id, username, balance, payment FROM kakeibos WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                KakeiboRecord k = new KakeiboRecord();
                k.setId(rs.getInt("id"));
                k.setUsername(rs.getString("username"));
                k.setBalance(rs.getInt("balance"));
                k.setPayment(rs.getInt("payment"));
                list.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
