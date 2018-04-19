<#macro html title>
<html>
<head>
    <@bootstrap.cssAndJs/>
    <@slyak.js url="/webjars/jquery-migrate/jquery-migrate.min.js"/>
    <@slyak.css url="/webjars/font-awesome/web-fonts-with-css/css/fontawesome-all.css"/>
    <@slyak.css url="/css/main.css"/>
</head>
<body>
    <@bootstrap.navbar brand="ITASM" menu=[
    {'title':'项目','url':'/'},
    {'title':'全局设置','url':'/global'},
    {'title':'使用帮助','url':'/help'}
    ]/>
<div class="container-fluid p-0">
    <div class="bg-white">
        <#nested />
    </div>
</div>
</body>
</html>
</#macro>

<#macro titleLine title btnCreate={}>
<div class="title-line">
    <div class="title-line-main">
        <h1>${title}</h1>
        <#if btnCreate.title??>
            <a class="btn btn-sm btn-primary ml-3"
               href="<@slyak.query url="${btnCreate.url}"/>">${btnCreate.title}</a>
        </#if>
    </div>
</div>
</#macro>

<#macro main title btnCreate={}>
    <@html title=title>
        <@titleLine title=title btnCreate=btnCreate/>
    <div class="main">
        <#nested />
    </div>
    </@html>
</#macro>


<#macro leftRight left right title btnCreate={}>
    <@html title=title>
    <div class="layout-l-r">
        <div class="main-left">
        ${left}
        </div>
        <div class="main-right">
            <@titleLine title=title btnCreate=btnCreate/>
            <div class="container pt-4">
            ${right}
            </div>
        </div>
    </div>
    </@html>
</#macro>