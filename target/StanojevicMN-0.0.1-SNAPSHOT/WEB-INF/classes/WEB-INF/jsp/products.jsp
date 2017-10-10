<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="top.jsp" %>

<c:if test="${lista!=null}">
<form method="post" action="remove">
<c:forEach items="${lista}" var="item">
    <div id="product">
        <img class="pic" src="resources/${item.proizvod}/${item.slika}"/>
        <input type="checkbox" value="${item.id}" name="checked"/>  
    </div>
</c:forEach>
    <input type="submit" value="Izbrisi"/>
</form>
</c:if>


<c:if test="${slideshow!=null}">
<form method="post" action="./removeslideshowpic">
<c:forEach items="${slideshow}" var="item">
    <div id="product">
        <img class="pic" src="resources/slideshow/${item.slika}"/>
        <input type="checkbox" value="${item.id}" name="checked"/>  
    </div>
</c:forEach>
    <input type="submit" value="Izbrisi"/>
</form>
</c:if>
<%@include file="bottom.jsp" %>
