<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/12
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form   enctype="multipart/form-data"
        method="post"
        action="${pageContext.request.contextPath}/quick21">
    名称： <input type="text" name="username"> <br>
    文件1： <input type="file" name="upload"> <br>
    文件2： <input type="file" name="upload"> <br>
    文件3： <input type="file" name="upload"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
