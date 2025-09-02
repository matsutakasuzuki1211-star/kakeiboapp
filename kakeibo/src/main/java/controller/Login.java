package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.*;

import model.to.User;

@WebServlet("/login")
public class Login extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //パラメータの取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        User user = new User(username, password);
        session.setAttribute("user", user);
        String url = "jdbc:mysql://localhost/aaaa";
        
        //データベースに接続
        try(Connection con = DriverManager.getConnection(
            url,
            "ssjclient", "sdsd"
        )){
        //データベースに問い合わせしてあるかないかを確認

        boolean checkAccount = false;

        //あった場合top.htmlに遷移,なかった場合エラーメッセージを表示してそのまま
        if(checkAccount){
            request.getRequestDispatcher("/top.html").forward(request, response);
        }else{
            String message = "ユーザ名またはパスワードが正しくありません";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login.html").forward(request, response);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

        

        //データベースの切断



    }
    
}
