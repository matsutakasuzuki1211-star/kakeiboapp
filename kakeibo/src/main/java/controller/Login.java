package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/login")
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // パラメータの取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        // DBに接続してユーザ名からアカウントが存在しているか確認
        checkLogin chk = new checkLogin();
        boolean checkAccount = chk.exitAcount(username, password);

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
