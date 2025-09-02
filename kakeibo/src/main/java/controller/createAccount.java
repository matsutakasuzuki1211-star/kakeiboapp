package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/create")
public class createAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsersDAO dao = new UsersDAO();
        int result = dao.checkUsername(username);
        if (result == 1) {
            request.setAttribute("message", "ユーザ名が既に存在します。");
            request.getRequestDispatcher("/create_account.jsp").forward(request, response);
        } else {
            int createCheck = dao.insertUser(username, password);
            if (createCheck == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "アカウントの作成に失敗しました。");
                request.getRequestDispatcher("/create_account.jsp").forward(request, response);
            }
        }

    }
}
