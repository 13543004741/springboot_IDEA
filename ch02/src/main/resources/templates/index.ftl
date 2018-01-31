<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <p>姓名：${name}</p>
    <p>年龄：
    <#if sex==1>
        男
    <#elseif sex==2>
        女
    <#else >
        其他
    </#if>
    </p>

<h2>其他同学：
    <#list list as obj>
        ${obj}
    </#list>
</h2>
</body>
</html>