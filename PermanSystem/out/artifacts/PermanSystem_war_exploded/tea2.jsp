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
<h1 class="title">教师任教情况</h1>
<br>
<div class="container" id="search">

</div>
<br>
<div class="box-content">
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <td>教师编号</td>
            <th>任课老师</th>
            <td>课程编号</td>
            <td>课程名</td>
            <th>课程学时</th>
            <th>课程性质</th>
            <th>学分</th>
            <td>开课学期</td>
            <th>班级</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Lesson> LessonList = (ArrayList<Lesson>) session.getAttribute("LessonList");
            if(LessonList!=null)
                System.out.println("收到啦");
            for(Lesson s : LessonList){
        %>
        <tr>
            <td><%=s.getCh_Tno09()%></td>
            <td><%=s.getCh_Tname09()%></td>
            <td><%=s.getCh_Lno09()%></td>
            <td><%=s.getCh_Lname09()%></td>
            <td><%=s.getCh_Lperiod09()%></td>
            <td><%=s.getCh_Ltype09()%></td>
            <td><%=s.getCh_Lcredit09()%></td>
            <td><%=s.getCh_Lterm09()%></td>
            <td><%=s.getCh_Cname09()%></td>
        </tr>
        </tbody>
        <%} %>
    </table>
</div>

</body>
</html>
