package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

<<<<<<< HEAD

=======
>>>>>>> 4d8f0b9f48ffae2943e9a9a6901678f37117b53f
@WebServlet("/login")
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // パラメータの取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        User user = new User(username, password);
        session.setAttribute("user", user);

        checkAccount chk = new checkAccount();
        boolean checkAccount = chk.check_login(username, password);


        //あった場合top.htmlに遷移,なかった場合エラーメッセージを表示してそのまま
        if(checkAccount){
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        }else{
            String message = "ユーザ名またはパスワードが正しくありません";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
