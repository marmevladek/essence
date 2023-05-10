<#import "blocks/template.ftlh" as t>
<@t.template user>
    <form method="get" action="/">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="searchWord">Поиск по объявлениям</label>
                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
        </div>
    </form>
    <hr>
    <div class="card-columns">
        <#list products as product>
            <a href="/product/${product.id}" class="product-link">
                <div class="card text-white bg-dark my-3 product" style="border-radius: 18px">

                    <img style="
                    width: 355px;
                    height: 410px;
                    border-top-left-radius: 18px;
                    border-top-right-radius: 18px" src="/images/${product.previewImageId}"
                         class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">${product.nameOfProduct}</h5>
                        <p class="card-text">${product.price} ₽</p>
                        <button class="btn btn-light my-2 my-sm-0" style="width: 100%" type="button">Добавить в корзину</button>
                    </div>
                </div>
            </a>
        <#else>
            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>
</@t.template>