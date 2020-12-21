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
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#college").click(function(){
                $("#college1").css("display","list-item");
                $("#science").css("display","none");
                $("#college").css("color","#4a69bd");
                $("#dongtai").css("color","#333");
            });
            $("#dongtai").click(function(){
                $("#science").css("display","list-item");
                $("#college1").css("display","none");
                $("#dongtai").css("color","#4a69bd");
                $("#college").css("color","#333");
            });
        });
    </script>
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
                    <Li><a href="controller/stutea1.do">查询教师任教情况</a></Li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
<br>
<h1 class="title">查询个人信息</h1>
<br>
<div class="container" id="search">
    <div>
        <%
            stu stu0=(stu) session.getAttribute("stu");
            System.out.println( session.getAttribute("stu"));
        %>
        <div class="top">
            <div>
                <span class="la">学号</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><%=stu0.getCh_Sno09()%></span>
            </div>
            <div>
                <span class="la">姓名</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><%=stu0.getCh_Sname09()%></span>
            </div>
        </div>
    </div>
</div>
<br>
<div class="box-content" id="xinxi">
    <section id="collegenews">
        <div class="title1">
            &nbsp;<span id="college">&nbsp;基本信息</span>
            <span id="fenge">|</span>
            &nbsp;<span id="dongtai">&nbsp;学籍信息</span>
        </div>
        <div class="news" id="college1">
            <ul>
                <li>学号：<%=stu0.getCh_Sno09()%></li>
                <li>姓名：<%=stu0.getCh_Sname09()%></li>
                <li>性别：<%=stu0.getCh_Sex09()%></li>
                <li>年龄：<%=stu0.getCh_Sage09()%></li>
                <li>生源地：<%=stu0.getCh_Splace09()%></li>
            </ul>
        </div>
        <div class="news" id="science">
            <ul>
                <li>专业名称：<%=stu0.getCh_Mname09()%></li>
                <li>班级名称：<%=stu0.getCh_Cname09()%></li>
                <li>已修学分总数：<%=stu0.getCh_Scredit09()%></li>
            </ul>
        </div>
    </section>

</div>
</body>
</html>
