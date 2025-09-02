<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
</head>

<body>
    <h1>ユーザ名とパスワードを入力してください</h1>
    <%
            String message = (String)request.getAttribute("message");
            if(message != null){
        %>
        <p style="color: red;"><%= message %></p>
        <%
            }

        %>
    <form action="create" method="post">
        ユーザ名：<input type="text" name="username"><br />
        パスワード：<input type="password" name="password"><br />
        <input type="submit" value="登録">
    </form>
</body>

</html>