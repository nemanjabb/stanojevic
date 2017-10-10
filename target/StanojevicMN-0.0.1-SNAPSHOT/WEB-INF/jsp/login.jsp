<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="top.jsp" %>

<form action="admin" method="post">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <input type="submit" value="log In"/>
</form>
<%@include file="bottom.jsp" %>