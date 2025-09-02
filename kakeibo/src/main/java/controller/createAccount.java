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

        checkAccount checker = new checkAccount();
        if (checker.check(username)) {
            request.setAttribute("errorMessage", "ユーザ名が既に存在します。");
            request.getRequestDispatcher("/create_account.html").forward(request, response);
        } else {
            createUserData creator = new createUserData();
            int result = creator.insertUser(username, password);
            if (result > 0) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                request.getRequestDispatcher("/top.html").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "アカウントの作成に失敗しました。");
                request.getRequestDispatcher("/create_account.html").forward(request, response);
            }
        }

    }
}
