
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>