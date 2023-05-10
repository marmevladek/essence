<#import "blocks/template.ftlh" as t>
<@t.template user>
    `<h1 style="text-align: center">Панель администратора</h1><hr>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Индекс товара</th>
            <th scope="col">Название товара</th>
            <th scope="col">Описание</th>
            <th scope="col">Цена</th>
<#--            <th scope="col">Производитель</th>-->
            <th scope="col">Дата добавления</th>
            <th scope="col">-\-</th>
        </tr>
        <#list products as product>
            <tr>
                <th>${product.id}</th>
                <th>${product.nameOfProduct}</th>
                <th>${product.description}</th>
                <th>${product.price}</th>
                <th>${product.dateOfAdded}</th>
                <th>
                    <form action="/admin/products/delete/${product.id}" method="post">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Товаров нет</h3>
        </#list>
    </table>
</@t.template>