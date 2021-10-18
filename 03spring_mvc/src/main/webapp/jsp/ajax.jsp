<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/12
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    let userList = new Array();
    userList.push({username:"zhangsan",age:18})
    userList.push({username:"lisi",age:38})

    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/quick14",
        data:JSON.stringify(userList),
        contentType:"application/json;charset=utf8"
    })
</script>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
