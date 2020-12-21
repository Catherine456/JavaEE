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
                    <li><a href="controller/stutea1.do">教师课表查询</a></li>
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
<h1 class="title">班级默认课表查询</h1>
<br>
<div class="container" id="search">
    <form action="controller/stuLesson.do" method="post">
        <label>学年</label>
        <select name="year">
            <option >2018/2019</option>
            <option selected="selected">2019/2020</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label>学期</label>
        <select name="season">
            <option>1</option>
            <option selected="selected">2</option>
            <option>3</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" class="btn btn-default" value="查询">
    </form>
</div>
<br>
<div class="box-content">
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <th>班级编号</th>
            <th>班级</th>
            <th>课程编号</th>
            <th>课程名</th>
            <th>课程学时</th>
            <th>课程性质</th>
            <th>学分</th>
            <th>任课老师</th>
            <th>开课学期</th>

        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Lesson> LessonList = (ArrayList<Lesson>) session.getAttribute("LessonList");
            for(Lesson s : LessonList){
        %>
        <tr>
            <td><%=s.getCh_Cno09()%></td>
            <td><%=s.getCh_Cname09()%></td>
            <td><%=s.getCh_Lno09()%></td>
            <td><%=s.getCh_Lname09()%></td>
            <td><%=s.getCh_Lperiod09()%></td>
            <td><%=s.getCh_Ltype09()%></td>
            <td><%=s.getCh_Lcredit09()%></td>
            <td><%=s.getCh_Tname09()%></td>
            <td><%=s.getCh_Lterm09()%></td>
        </tr>
        </tbody>
        <%} %>
    </table>
</div>

</body>
</html>
