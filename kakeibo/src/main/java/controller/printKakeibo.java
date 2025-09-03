package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KakeiboRecord;

@WebServlet("/print")
public class printKakeibo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        printDB db = new printDB();
        List<KakeiboRecord> kakeiboList = db.getTable(username);

        request.setAttribute("kakeiboList", kakeiboList);
        request.setAttribute("username", username);
        request.getRequestDispatcher("/kakeibo.jsp").forward(request, response);
    }

}
