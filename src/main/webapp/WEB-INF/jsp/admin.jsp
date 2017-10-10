<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="top.jsp" %>

<div class="adminBox">
    <h4>Dodavanje slika</h4><br>
<form method="post" action="add" enctype="multipart/form-data">
    <select name="proizvod" >
        <option value="-1">Odaberi proizvod</option>
        <option value="americki plakari">Američki plakari</option>
        <option value="aspiratori">Aspiratori</option>
        <option value="komode">Komadni namestaj</option>
        <option value="kuhinje">Kuhinje</option>
        <option value="sudopere">Sudopere</option>
    </select>
    <input type="file" name="photo" />
    <input type="submit" value="Unesi"/>
</form>
<c:if test="${uspeh==10}">
    Slika uspesno dodata!!!
</c:if>
</div>
<div class="adminBox">
    <h4>Dodavanje admina</h4><br>
    <form action="newadmin" method="post">
        <input type="text" name="username" />
        <input type="text" name="password" />
        <input type="submit" value="Dodaj" />
    </form>
</div>
<div class="adminBox">
   <h4>Brisanje slika</h4><br>
<form method="post" action="./proizvodi">
    <select name="vrsta">
        <option value="-1">Odaberi proizvod</option>
        <option value="americki plakari">Americki plakari</option>
        <option value="aspiratori">Aspiratori</option>
        <option value="komode">Komode</option>
        <option value="kuhinje">Kuhinje</option>
        <option value="sudopere">Sudopere</option>
    </select>
    <input type="submit" value="Izaberi"/>
</form>
</div>
<div class="adminBox">
    <h4>Dodavanje slika u slideshow</h4><br>
    <form method="post" action="./addslideshowpic" enctype="multipart/form-data">
        <input type="file" name="photo" />
        <input type="submit" value="Unesi"/>
    </form>
</div>
<div class="adminBox">
    <h4>Brisanje slika iz slideshow</h4><br>
    <a href="./slideshow">Slideshow</a>
</div>
<div class="adminBox">
    <h4>Izmena akcije</h4><br>
    <a href="izmena">Izmeni</a>
</div>
<div class="adminBox">
    <a href="logout">Odjava</a><br>
</div>
<%@include file="bottom.jsp" %>