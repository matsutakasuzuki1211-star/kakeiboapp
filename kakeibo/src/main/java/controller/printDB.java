package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KakeiboRecord;


public class printDB {
    public ArrayList<KakeiboRecord> getTable(String username){
    String sql = "SELECT username, balance, payment FROM kakeibos WHERE username = ?";
    ArrayList<KakeiboRecord> list = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, username);
        var rs = pstmt.executeQuery();
        while(rs.next()){
            list.add(new KakeiboRecord(
                rs.getString("username"),
                rs.getInt("balance"),
                rs.getInt("payment")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
}
