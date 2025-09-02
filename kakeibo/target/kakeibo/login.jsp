<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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
    <a href="create_account.html">アカウント作成</a>
</body>
</html>