<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="/resources/style2.css" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stanojević</title>
    </head>
    <body>
	<jsp:include page="dropdown.jsp" />
        <div id="wrapper">
            <div id="header">
                <div style="clear: both"></div>
                <%@include file="slideshow.jsp" %>
                <div id="header1">
                </div>
                <div style="clear: both"></div>
                <a href="../" >
                    <div id="header2">
                    </div> 
                </a>
                <div style="clear: both"></div>
                <div id="header3">
                    <a href="komadninamestaj"><div class="menuItem"><b>KOMADNI NAMEŠTAJ</b></div></a>
                    <div class="menuItem" id="dropdown">
                            <div class="dropbtn" onmouseover="myFunction()" onmouseout="myFunction()"><b>KUHINJE</b></div>
                            <div id="myDropdown" class="dropdown-content">
                                <a href="kuhinje" onmouseover="myFunction()" onmouseout="myFunction()">KUHINJE</a>
                                <a href="sudopere" onmouseover="myFunction()" onmouseout="myFunction()">SUDOPERE</a>
                                <a href="aspiratori" onmouseover="myFunction()" onmouseout="myFunction()">ASPIRATORI</a>
                            </div>
                    </div>
                    <a href="americkiplakari"><div class="menuItem"><b>AMERIČKI PLAKARI</b></div></a>
                    <a href="akcije"><div class="menuItem"><b>AKCIJE</b></div></a>
                    <a href="boje"><div class="menuItem"><b>BOJE</b></div></a>
                <div style="clear: both"></div>
                </div>
                <div style="clear: both"></div>
            </div>
        <div id="content">