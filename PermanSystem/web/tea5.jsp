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
<h1 class="title">学生成绩录入</h1>
<br>
<div class="box-content" id="insert">
    <form action="controller/inputscore.do" method="post">
        <div class="br">
            <label>请输入学生学号：&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="sno" placeholder="请输入学生学号">
        </div>
        <div class="br">
            <label>请输入课程编号：&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="lno" placeholder="请输入课程编号">
        </div>
        <div class="br">
            <label>请输入分数：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="score" placeholder="请输入分数">
        </div>
        <div class="br">
            <label>请输入开课学期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="term" placeholder="请输入开课学期">
        </div>
        <input type="submit" class="btn btn-default" value="提交">
    </form>
</div>

</body>
</html>
