<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="top.jsp" %>

<c:forEach items="${lista}" var="item">
    <div id="akcija">
        <img src="resources/akcije/${item}"/>
    </div>
        <div style="clear: both"></div>
</c:forEach>
<div style="clear: both"></div>
<%@include file="bottom.jsp" %>