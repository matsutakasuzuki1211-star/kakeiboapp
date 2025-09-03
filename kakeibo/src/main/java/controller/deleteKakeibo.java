package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/delete")
public class deleteKakeibo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] selectedIds = request.getParameterValues("selectedIds");
        if (selectedIds != null && selectedIds.length > 0) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = DBConnection.getConnection();
                String sql = "DELETE FROM Kakeibos WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                for (String id : selectedIds) {
                    pstmt.setInt(1, Integer.parseInt(id));
                    pstmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("message", "削除に失敗しました。");
            } finally {
                try {
                    if (pstmt != null)
                        pstmt.close();
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 削除後、家計簿一覧ページへリダイレクト
        response.sendRedirect("print");
    }
}
