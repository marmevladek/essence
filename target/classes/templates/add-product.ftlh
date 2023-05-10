<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Мои товары</h1>
    <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новый товар
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/admin/product/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="productName">Название товара</label>
                <input type="text" required class="form-control"
                       id="productName" name="nameOfProduct">
            </div>
            <div class="form-group">
                <label for="description">Описание товара</label>
                <textarea required class="form-control" id="description" name="description"></textarea>
            </div>
            <div class="form-group">
                <label for="manufacturers">Производитель</label>
                <select id="manufacturers" required name="manufacturer" class="form-control">
                    <option value="">Город не выбран</option>
                    <#list manufacturers as manufacturer>
                        <option value="${manufacturer.id}">${manufacturer.nameOfManufacturer}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="price">Цена товара</label>
                <div class="input-group mb-3">
                    <input type="number" required class="form-control" id="price" name="price">
                    <div class="input-group-append">
                        <span class="input-group-text">₽</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input required type="file" name="file1" id="file1">
                    <label class="custom-file-label" for="file1">Первая фотография к товару</label>
                </div>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file2" id="file2">
                    <label class="custom-file-label" for="file2">Вторая фотография к товару</label>
                </div>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file3" id="file3">
                    <label class="custom-file-label" for="file3">Третья фотография к товару</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
    </div>
</@t.template>
<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <title>ESSENCE</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>ESSENCE</h1><hr>-->
<#--<h4>Панель администратора</h4><hr>-->
<#--<h3>Создать новый товар</h3>-->
<#--<form action="/admin/product/add" method="post" enctype="multipart/form-data">-->
<#--    Название товара: <input type="text" name="nameOfProduct"/><br><br>-->
<#--    Описание товара: <input type="text" name="description"/><br><br>-->
<#--    Производитель:  <select name="manufacturer"><br>-->
<#--                    <#list manufacturers as manufacturer>-->
<#--                        <option value="${manufacturer.id}">${manufacturer.nameOfManufacturer}</option>-->
<#--                    </#list>-->
<#--                    </select>-->
<#--    Цена: <input type="number" name="price"/><br><br>-->
<#--    Превью фотография: <input type="file" name="file1"/><br><br>-->
<#--    Вторая фотография: <input type="file" name="file2"/><br><br>-->
<#--    Третья фотография: <input type="file" name="file3"/><br><br>-->
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--    <input type="submit" value="Добавить товар"/>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->