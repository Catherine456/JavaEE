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
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="bootstrap.min.js"></script>
</head>
<body>
<div id="nav">
    <nav class="container">
        <ul class="nav nav-pills nav-stacked main-menu">
            <li class="nav-header"><a class="ajax-link1" href="Mmain.jsp">管理端</a></li>
            <li><a href="controller/Mstuinfo.do" class="ajax-link">学生信息</a></li>
            <li><a class="ajax-link" href="controller/Mteachinfo.do"><span>教师信息</span></a></li>
            <li><a class="ajax-link1"  href="controller/Mscoreinfo.do">成绩信息</a></li>
            <li><a class="ajax-link1"  href="">开课信息</a></li>
        </ul>
    </nav>
</div>
<br>
<h1 class="title">学生信息</h1>
<br>
<div class="container" id="search">
    <form action="controller/Mstuinfo.do" method="post">
        <input type="text" name="sno" placeholder="请输入学号">
        <input type="submit" class="btn btn-default" value="查询">
    </form>
</div>
<br>
<div class="box-content">
    <div>
        <!--    <a href="insertDP.jsp" data-placement="right" data-toggle="tooltip" class="btn btn-warning">添加部门</a> -->
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
            添加学生
        </button>
    </div>

    <br>
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>专业</th>
            <th>班级</th>
            <th>性别</th>
            <th>年龄</th>
            <th>生源地</th>
            <th>已修总学分</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<stu> stuList = (ArrayList<stu>) session.getAttribute("stuList");
            for (stu d : stuList) {
        %>
        <tr>
            <td><%=d.getCh_Sno09()%>
            </td>
            <%
                String p = "controller/deletestu.do?sno=" + d.getCh_Sno09();
                String p1 = "updatestu.jsp?sno=" + d.getCh_Sno09() + "&sname=" + d.getCh_Sname09() + "&mname=" + d.getCh_Mname09() + "&cname=" + d.getCh_Cname09() +"&sex="+ d.getCh_Sex09()+"&age="+d.getCh_Sage09()+"&place="+d.getCh_Splace09()+"&credit="+d.getCh_Scredit09();
            %>
            <td><%=d.getCh_Sname09()%>
            </td>
            <td><%=d.getCh_Mname09()%>
            </td>
            <td><%=d.getCh_Cname09()%></td>
            <td><%=d.getCh_Sex09()%></td>
            <td><%=d.getCh_Sage09()%></td>
            <td><%=d.getCh_Splace09()%></td>
            <td><%=d.getCh_Scredit09()%></td>
            <td class="center">
                <a class="btn btn-info" href=<%=p1 %>>
                    <!--       <i class="glyphicon glyphicon-edit icon-white"></i>-->
                    修改
                </a>
                <a class="btn btn-danger" href=<%=p %>>
                    <!--     <i class="glyphicon glyphicon-trash icon-white"></i> -->
                    删除
                </a>
            </td>
        </tr>
        <%} %>
        </tbody>
    </table>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加学生
                </h4>
            </div>
            <form action="controller/inputstu.do" method="post">
                <div class="modal-body">
                    <div class="br">
                        <label>学号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="sno" placeholder="请输入学号">
                    </div>
                    <div class="br">
                        <label>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="sname" placeholder="请输入姓名">
                    </div>
                    <div class="br">
                        <label>性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <spans class="controls">
                            <select  data-rel="chosen" name="sex">
                                <option class="sex">男</option>
                                <option class="sex">女</option>
                            </select>
                        </spans>
                    </div>
                    <div class="br">
                        <label>出生年月</label><input type="text" class="form-control" name="age" placeholder="请输入出生年月">
                    </div>
                    <div class="br">
                        <label>生源地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="place" placeholder="请输入生源地">
                    </div>
                    <div class="br">
                        <label>班级编号&nbsp;&nbsp;</label><input type="text" class="form-control" name="cno" placeholder="请输入班级编号">
                    </div>
                    <div class="br">
                        <label>已修总学分</label><input type="text" class="form-control" name="credit" placeholder="请输入总学分">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" value="提交">
                </div>>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
