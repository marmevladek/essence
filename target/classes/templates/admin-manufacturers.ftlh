<#import "blocks/template.ftlh" as t>
<@t.template user>
    `<h1 style="text-align: center">Панель администратора</h1><hr>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Индекс производителя</th>
            <th scope="col">Название</th>
            <th scope="col">Сайт</th>
            <th scope="col">-\-</th>
        </tr>
        <#list manufacturers as manufacturer>
            <tr>
                <th>${manufacturer.id}</th>
                <th>${manufacturer.nameOfManufacturer}</th>
                <th>${manufacturer.linkOfficial}</th>
                <th>
                    <form action="/admin/manufacturer/delete/${manufacturer.id}" method="post">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Товаров нет</h3>
        </#list>
    </table>
</@t.template>