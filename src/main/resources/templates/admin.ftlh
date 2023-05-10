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
</@t.template>
