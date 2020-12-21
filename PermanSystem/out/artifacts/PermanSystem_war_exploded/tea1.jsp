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
<h1 class="title">教师个人信息</h1>
<br>
<div class="container" id="search">
    <div>
        <%
            teacher teacher0=(teacher) session.getAttribute("teacher");
        %>
        <%--   <%=stu0.getCh_Sno09()%> --%>
        <div class="top">
            <div>
                <span class="la">教师编号</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><%=teacher0.getCh_Tno09()%></span>
            </div>
            <div>
                <span class="la">姓名</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><%=teacher0.getCh_Tname09()%></span>
            </div>

        </div>
    </div>
</div>
<br>
<div class="box-content">
    <section id="collegenews">
        <div class="title1">
            &nbsp;<span id="college">&nbsp;基本信息</span>
            <span id="fenge">|</span>
            &nbsp;<span id="dongtai">&nbsp;更多信息</span>
        </div>
        <div class="news" id="college1">
            <ul>
                <li>教师编号：<%=teacher0.getCh_Tno09()%></li>
                <li>姓名：<%=teacher0.getCh_Tname09()%></li>
                <li>性别：<%=teacher0.getCh_Tsex09()%></li>
                <li>年龄：<%=teacher0.getCh_Tage09()%></li>
            </ul>
        </div>
        <div class="news" id="science">
            <ul>
                <li>职称：<%=teacher0.getCh_Ttitle09()%></li>
                <li>联系电话：<%=teacher0.getCh_Tphone09()%></li>
            <%--    <li>专业名称：<%=stu0.getCh_Mname09()%></li>
                <li>班级名称：<%=stu0.getCh_Cname09()%></li>
                <li>已修学分总数：<%=stu0.getCh_Scredit09()%></li> --%>
            </ul>
        </div>
    </section>
</div>

</body>
</html>
