package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/register")
public class registerInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int balance = Integer.parseInt(request.getParameter("balance"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        

        HttpSession session = request.getSession();
        session.setAttribute("balance", balance);
        session.setAttribute("payment", payment);

        insertData inserter = new insertData();
        int result = inserter.insertKakeibo((String)session.getAttribute("username"),balance, payment);
        if (result > 0) {
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "情報の登録に失敗しました。");
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        }
    }
}
