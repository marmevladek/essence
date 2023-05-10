<#import "blocks/template.ftlh" as t>
<@t.template user>
    `<h1 style="text-align: center">Панель администратора</h1><hr>
    <div style="text-align: center; margin-bottom: 10px">
        <button style="width: 30%" class="btn btn-dark" onclick="window.location.href = '/admin/product/add'">Добавить товар</button>
        <button style="width: 30%" class="btn btn-dark" onclick="window.location.href = '/admin/createManufacturer'">Добавить производителя</button>
        <button style="width: 30%" class="btn btn-dark" onclick="window.location.href = '/admin/createAdmin'">Добавить администратора</button>
    </div>
    <div style="text-align: center">
        <button style="width: 30%" class="btn btn-dark" onclick="window.location.href = '/admin/products'">Посмотреть список товаров</button>
        <button style="width: 30%" class="btn btn-dark" onclick="window.location.href = '/admin/manufacturers'">Посмотреть список производителей</button>
        <button style="width: 30%" class="btn btn-dark" onclick="window.location.href = '/admin/users'">Посмотреть список пользователей</button>
    </div>

<#--    <table class="table table-hover table-dark">-->
<#--        <tr>-->
<#--            <th scope="col">Email</th>-->
<#--            <th scope="col">Номер телефона</th>-->
<#--            <th scope="col">Активность</th>-->
<#--            <th scope="col">Роли</th>-->
<#--            <th scope="col">Бан</th>-->
<#--            <th scope="col">Редактирование</th>-->
<#--            <th scope="col">Подробная информация</th>-->
<#--        </tr>-->
<#--        <#list users as user>-->
<#--            <tr>-->
<#--                <th>${user.email}</th>-->
<#--                <th>${user.phoneNumber}</th>-->
<#--                <th><#if user.active>true<#else>false</#if></th>-->
<#--                <th><#list user.roles as role>${role}</#list></th>-->
<#--                <th>-->
<#--                    <form action="/admin/user/ban/${user.id}" method="post">-->
<#--                        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--                        <input type="submit" class="btn btn-light" value="Бан">-->
<#--                    </form>-->
<#--                </th>-->
<#--                <th><a href="/admin/user/edit/${user.id}">Редактировние</a></th>-->
<#--                <th><a href="/user/${user.id}">Подробная информация</a></th>-->
<#--            </tr>-->
<#--        <#else>-->
<#--            <h3>Пользователей нет</h3>-->
<#--        </#list>-->
<#--    </table>-->
</@t.template>
<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <title>ESSENCE</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>ESSENCE</h1><hr>-->
<#--<h4>Панель администратора</h4><hr>-->
<#--<#list manufacturers as manufacturer>-->
<#--    <div>-->
<#--        <p><b><a href="http://${manufacturer.linkOfficial}/">${manufacturer.linkOfficial}</a></b></p>-->
<#--    </div>-->
<#--</#list>-->
<#--<hr>-->
<#--<a href="/admin/product/add"><input type="submit" value="Добавить товар"></a><br><br>-->
<#--<a href="/admin/createAdmin"><input type="submit" value="Добавить админа"></a><br><br>-->
<#--<a href="/admin/createManufacturer"><input type="submit" value="Добавить производителя"></a><br><br>-->
<#--</body>-->
<#--</html>-->