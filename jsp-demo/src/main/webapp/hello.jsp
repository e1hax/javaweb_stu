<%--
  Created by IntelliJ IDEA.
  User: e1hax
  Date: 2022-08-18
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>hello jsp</h1>

<%
    System.out.println("hello,jsp");
    int i = 3;
%>

<%="hello"%>

<%!
    void show(){}
    String name = "zhangsan";
%>


</body>
</html>
