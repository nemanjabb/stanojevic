<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="slideshow-container">
    <p:forEach items="${slide}" var="listaitem">
        <div class="slides">
            <img class="w3-animate-left" src="resources/slideshow/${listaitem.slika}">
        </div>
    </p:forEach>
</div>
<div class="slideshow-container">
    <p:forEach items="${slide}" var="listaitem">
        <div class="slides2">
            <img class="w3-animate-left" src="resources/slideshow/${listaitem.slika}">
        </div>
    </p:forEach>
</div>

<script>
var slideIndex2 = 1;
showSlides2();

function showSlides2() {
    var i;
    var slides = document.getElementsByClassName("slides");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex2++;
    if (slideIndex2> slides.length) {
        slideIndex2 = 1;
    }
    slides[slideIndex2-1].style.display = "block";
    setTimeout(showSlides2, 3000); // Change image every 3 seconds
}
</script>
<script>
var slideIndex3 = 0;
showSlides3();

function showSlides3() {
    var i;
    var slides2 = document.getElementsByClassName("slides2");
    for (i = 0; i < slides2.length; i++) {
       slides2[i].style.display = "none";  
    }
    slideIndex3++;
    if (slideIndex3> slides2.length) {
        slideIndex3 = 1;
    }
    slides2[slideIndex3-1].style.display = "block";
    setTimeout(showSlides3, 3000); // Change image every 3 seconds
}
</script>
