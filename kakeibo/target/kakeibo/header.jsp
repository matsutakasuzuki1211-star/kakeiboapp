<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String username = request.getParameter("username");
%>

<div style="background-color: #ccc; padding: 10px;">
    <h3><%= username != null ? username : "ゲスト" %> のページ</h3>
</div>