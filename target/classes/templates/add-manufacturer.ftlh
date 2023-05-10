<!DOCTYPE html>
<html>
<head>
    <title>ESSENCE</title>
</head>
<body>
<h1>ESSENCE</h1><hr>
<h4>Панель администратора</h4><hr>
<h3>Добавить нового производителя</h3>
<form action="/admin/createManufacturer" method="post">
    Имя производителя: <input type="text" name="nameOfManufacturer"><br><br>
    Ссылка: <input type="text" name="linkOfficial"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить">
</form>
<#if errorMessage??>
    <h2 style="color:red">${errorMessage}</h2>
</#if>
</body>
</html>