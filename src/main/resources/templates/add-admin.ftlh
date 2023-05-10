<!DOCTYPE html>
<html>
<head>
    <title>ESSENCE</title>
</head>
<body>
<h1>ESSENCE</h1><hr>
<h4>Панель администратора</h4><hr>
<h3>Добавить нового администратора</h3>
<form action="/admin/createAdmin" method="post">
    Имя пользователя: <input type="text" name="name"><br><br>
    Эл. почта: <input type="email" name="email"><br><br>
    Номер телефона: <input type="text" name="phoneNumber"><br><br>
    Город: <input type="text" name="city">
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить">
</form>
<#if errorMessage??>
    <h2 style="color:red">${errorMessage}</h2>
</#if>
</body>
</html>