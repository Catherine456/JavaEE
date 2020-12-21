<%--
  Created by IntelliJ IDEA.
  User: 落澄
  Date: 2020/6/7
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.* , com.model.*" %>
<html>
<head>
    <title>管理员</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div id="nav">
    <nav class="container">
        <ul class="nav nav-pills nav-stacked main-menu">
            <li class="nav-header"><a class="ajax-link1" href="Mmain.jsp">管理端</a></li>
            <li><a href="controller/Mstuinfo.do" class="ajax-link">学生信息</a></li>
            <li><a class="ajax-link" href="controller/Mteachinfo.do"><span>教师信息</span></a></li>
            <li><a class="ajax-link1"  href="">成绩信息</a></li>
            <li><a class="ajax-link1"  href="">开课信息</a></li>
        </ul>
    </nav>
</div>
<br>
<h1 class="title">修改教师信息</h1>
<br>
<div class="container" id="update">
    <%
        String tno=request.getParameter("tno");
        request.getSession().setAttribute("tno",tno);
        String tname=request.getParameter("tname");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String title=request.getParameter("title");
        String phone=request.getParameter("phone");
    %>
    <form action="controller/updatetea.do" method="post" >
        <div class="br">
            <label>教师编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=tno %>
        </div>
        <div class="br">
            <label>教师姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="tname" value=<%=tname %>>
        </div>
        <div class="br">
            <label>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=sex %>
        </div>
        <div class="br">
            <label>年龄：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=age %>
        </div>
        <div class="br">
            <label>职称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="title" value=<%=title %>>
        </div>
        <div class="br">
            <label>联系电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="phone" value=<%=phone %>>
        </div>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>
</body>
</html>
