
<%@include file="top.jsp" %>

<div style="clear: both"></div>
<div id="category">
    <h3>Komode</h3>
</div>
<div id="category">
    <h3>TV Komode</h3>
</div>
<div id="category">
    <h3>Predsoblja</h3>
</div>
<div id="category">
    <h3>Radni sto</h3>
</div>
<div id="category">
    <h3>Ormari</h3>
</div>
<div id="category">
    <h3>Kreveti</h3>
</div>

<div style="clear: both"></div>
<c:forEach items="${lista}" var="item" varStatus="loop">
    <a onclick="currentSlide(${loop.index+1})">    
        <img class="pic" src="resources/${item.proizvod}/${item.slika}"/>
    </a>
</c:forEach>

<div style="clear: both"></div>

<c:if test="${lista!=null}">
<div id="slideshow" style="width: 600px">
    
<c:forEach items="${lista}" var="item">
    <img class="mySlides2" src="resources/${item.proizvod}/${item.slika}"/>
    <a id="left" onclick="plusSlides(-1)">&#10094;</a>
    <a id="right" onclick="plusSlides(+1)">&#10095;</a>
</c:forEach>

</div>
</c:if>
<%@include file="script.jsp" %>
<%@include file="bottom.jsp" %>