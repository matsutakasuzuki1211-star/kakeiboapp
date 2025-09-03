<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>家計簿アプリ</title>
</head>
<body>
    <h1>ユーザ名とパスワードを入力してください</h1>
    <form action="login" method="post">
        <%
            String message = (String)request.getAttribute("message");
            if(message != null){
        %>
        <p style="color: red;"><%= message %></p>
        <%
            }

        %>
        ユーザ名：<input type="text" name="username"><br />
        パスワード：<input type="password" name="password"><br />
        <input type="submit" value="送信">
    </form>
    <br>
    <div class="center-link">
    <a href="create_account.jsp">アカウント作成</a>
    </div>
</body>
</html>