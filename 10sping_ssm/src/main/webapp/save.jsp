<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/15
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加账户信息表单</h1>
    <form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
        账户名称： <input type="text" name="name"> <br>
        金额： <input type="text" name="money"> <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
