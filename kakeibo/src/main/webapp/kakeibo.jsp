<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList,model.KakeiboRecord" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>家計簿アプリ</title>
</head>

<body>

    

    <jsp:include page="header.jsp">
        <jsp:param name="username" value="${sessionScope.username}" />
    </jsp:include>

    <h1>${sessionScope.username}さんの家計簿</h1>
    <table border="1">
        <tr>
            <th>ユーザー名</th>
            <th>残高</th>
            <th>支出</th>
        </tr>
        <%
ArrayList<model.KakeiboRecord> kakeiboList = (ArrayList<model.KakeiboRecord>) request.getAttribute("kakeiboList");
for (model.KakeiboRecord record : kakeiboList) {
%>
<tr>
    <td><%= record.username %></td>
    <td><%= record.balance %></td>
    <td><%= record.payment %></td>
</tr>
<%
}
%>
    </table>
</body>

</html>