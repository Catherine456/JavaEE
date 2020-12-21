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
    <title>教师端</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div id="nav">
    <nav class="container">
        <ul class="nav nav-pills nav-stacked main-menu">
            <li class="nav-header"><a class="ajax-link1" href="Tmain.jsp">教师端</a></li>
            <li><a href="" class="ajax-link">教师信息查询</a>
                <ul>
                    <li><a href="tea1.jsp">教师个人信息</a></li>
                    <Li><a href="controller/teatu.do">查询教师任教情况</a></Li>
                </ul>
            </li>
            <li><a class="ajax-link" href=""><span>学生成绩查询</span></a>
                <ul>
                    <li><a href="controller/teasearchscore.do">查询学生成绩</a></li>
                    <li><a href="controller/steaavgscore.do">课程平均分</a></li>
                </ul>
            </li>
            <li><a class="ajax-link1"  href="">更新学生成绩</a>
                <ul>
                    <li><a href="tea5.jsp">学生成绩录入</a></li>
                    <li><a href="controller/update.do">修改学生成绩</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
<br>
<h1 class="title">修改学生成绩</h1>
<br>
<div class="container" id="update">
    <%
        String sno=request.getParameter("sno");
        request.getSession().setAttribute("sno",sno);
        String lno=request.getParameter("lno");
        request.getSession().setAttribute("lno",lno);
        String score=request.getParameter("score");
        String term=request.getParameter("term");
        request.getSession().setAttribute("term",term);
        String tno=request.getParameter("tno");
    %>
    <form action="controller/update.do" method="post" >
        <div class="br">
            <label>学号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=sno %>
        </div>
        <div class="br">
            <label>课程号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=lno %>
        </div>
        <div class="br">
            <label>分数：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="score" value=<%=score %>>
        </div>
        <div class="br">
            <label>开课学期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=term %>
        </div>
        <div class="br">
            <label>教师编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tno %>
        </div>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>

</body>
</html>
