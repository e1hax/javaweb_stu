<%--
  Created by IntelliJ IDEA.
  User: e1hax
  Date: 2022-08-18
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--c:if  来完成逻辑判断，替换java  if else--%>
<c:if test="${status==1}">
    <h1>启用</h1>
</c:if>

<c:if test="${status==0}">
    <h1>禁用</h1>
</c:if>

</body>
</html>
