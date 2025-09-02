<%
    String username = request.getParameter("username");
%>

<div style="background-color: #ccc; padding: 10px;">
    <h3>こんにちは、<%= username != null ? username : "ゲスト" %> さん</h3>
</div>