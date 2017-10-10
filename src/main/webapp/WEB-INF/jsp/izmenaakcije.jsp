<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="top.jsp" %>

<div class="adminBox">
<form method="post" action="novaakcija" enctype="multipart/form-data">
    <input type="file" name="photo" />
    <input type="submit" value="Unesi"/>
</form>
</div>
<%@include file="bottom.jsp" %>