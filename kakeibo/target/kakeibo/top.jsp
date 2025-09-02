<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<html>

<head>
    <meta charset="UTF-8">
    <title>家計簿アプリ</title>
</head>

<body>
    <%
    String username = request.getParameter("username");
    %>

    <jsp:include page="header.jsp">
    <jsp:param name= "username" value= <%=username>>
    </jsp:include>

    <h1>ようこそ　家計簿アプリへ</h1>
    <form action="register" method="post">
        預金残高：<input type="text" name="balance"><br />
        今月の支払い：<input type="test" name="payment"><br />
        <input type="submit" value="送信">
    </form>
</body>

</html>