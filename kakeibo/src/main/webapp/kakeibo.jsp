<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>家計簿アプリ</title>
</head>

<body>

    

    <jsp:include page="header.jsp">
        <jsp:param name="username" value="${username}" />
    </jsp:include>

    <h1>${username}さんの家計簿</h1>
    <table border="1">
        <tr>
            <th>ユーザー名</th>
            <th>残高</th>
            <th>支出</th>
        </tr>
        <c:forEach var="k" items="${kakeiboList}">
            <tr>
                <td>${k.username}</td>
                <td>${k.balance}</td>
                <td>${k.payment}</td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>