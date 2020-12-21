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
    <title>学生端</title>
    <link rel="stylesheet" href="index.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="bootstrap.min.js"></script>
</head>
<body>
<div id="nav">
    <nav class="container">
        <ul class="nav nav-pills nav-stacked main-menu">
            <li class="nav-header"><a class="ajax-link1" href="main.jsp">学生端</a></li>
            <li><a class="ajax-link" href=""><span>学生信息查询</span></a>
                <ul>
                    <li><a href="stu1.jsp">查询个人信息</a></li>
                    <li><a href="controller/stusearchscore.do">学生成绩查询</a></li>
                </ul>
            </li>
            <li><a class="ajax-link1"  href="">课程课表查询</a>
                <ul>
                    <li><a href="controller/stuLesson.do">班级默认课表查询</a></li>
                    <li><a href="controller/stutea.do">教师课表查询</a></li>
                </ul>
            </li>
            <li><a href="" class="ajax-link">教师信息查询</a>
                <ul>
                    <li><a href="controller/teainfo.do">查询教师信息</a></li>
                    <Li><a href="controller/stutea.do">查询教师任教情况</a></Li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
<br>
<h1 class="title">教师信息查询</h1>
<br>
<div class="container" id="search">
    <form action="controller/teainfo.do" method="post">
        <input type="text" name="Tno" placeholder="请输入教师编号">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" class="btn btn-default" value="查询">
    </form>
</div>
<br>
<div class="box-content">
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <td>教师编号</td>
            <th>任课老师</th>
            <td>性别</td>
            <td>年龄</td>
            <th>职称</th>
            <th>电话</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<teacher> teacherList = (ArrayList<teacher>) session.getAttribute("teacherList");
            if(teacherList!=null)
                System.out.println("收到啦");
            for(teacher s : teacherList){
        %>
        <tr>
            <td><%=s.getCh_Tno09()%></td>
            <td><%=s.getCh_Tname09()%></td>
            <td><%=s.getCh_Tsex09()%></td>
            <td><%=s.getCh_Tage09()%></td>
            <td><%=s.getCh_Ttitle09()%></td>
            <td><%=s.getCh_Tphone09()%></td>
        </tr>
        </tbody>
        <%} %>
    </table>
</div>

</body>
</html>
