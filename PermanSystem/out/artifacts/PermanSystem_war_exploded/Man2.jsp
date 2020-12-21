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
<h1 class="title">教师信息</h1>
<br>
<div class="container" id="search">
    <form action="controller/Mteachinfo.do" method="post">
        <input type="text" name="tno" placeholder="请输入教师编号">
        <input type="submit" class="btn btn-default" value="查询">
    </form>
</div>
<br>
<div class="box-content">
    <div>
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
            添加教师
        </button>
    </div>

    <br>
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <th>教师编号</th>
            <th>教师姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>职称</th>
            <th>联系电话</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<teacher> teacherList = (ArrayList<teacher>) session.getAttribute("teacherList");
            for (teacher d : teacherList) {
        %>
        <tr>
            <td><%=d.getCh_Tno09()%>
            </td>
            <%
                String p = "controller/deletetea.do?tno=" + d.getCh_Tno09();
                String p1 = "updatetea.jsp?tno=" + d.getCh_Tno09() + "&tname=" + d.getCh_Tname09() + "&sex=" + d.getCh_Tsex09() + "&age=" + d.getCh_Tage09() +"&title="+ d.getCh_Ttitle09()+"&phone="+d.getCh_Tphone09();
            %>
            <td><%=d.getCh_Tname09()%>
            </td>
            <td><%=d.getCh_Tsex09()%>
            </td>
            <td><%=d.getCh_Tage09()%></td>
            <td><%=d.getCh_Ttitle09()%></td>
            <td><%=d.getCh_Tphone09()%></td>
            <td class="center">
                <a class="btn btn-info" href=<%=p1 %>>
                    修改
                </a>
                <a class="btn btn-danger" href=<%=p %>>
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
                    添加教师
                </h4>
            </div>
            <form action=" controller/inputtea.do " method="post">
                <div class="modal-body">
                    <div class="br">
                        <label>教师编号&nbsp;&nbsp;</label><input type="text" class="form-control" name="tno" placeholder="请输入教师编号">
                    </div>
                    <div class="br">
                        <label>教师姓名&nbsp;&nbsp;</label><input type="text" class="form-control" name="tname" placeholder="请输入教师姓名">
                    </div>
                    <div class="br">
                        <label>性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <spans class="controls">
                            <select  data-rel="chosen" name="sex">
                                <option class="sex">男</option>
                                <option class="sex">女</option>
                            </select>
                        </spans>
                    </div>
                    <div class="br">
                        <label>出生年月&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="age" placeholder="请输入出生年月">
                    </div>
                    <div class="br">
                        <label>职称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <spans class="controls">
                            <select  data-rel="chosen" name="title">
                                <option>讲师</option>
                                <option>副教授</option>
                                <option>教授</option>
                            </select>
                        </spans>
                    </div>
                    <div class="br">
                        <label>联系电话&nbsp;&nbsp;</label><input type="text" class="form-control" name="phone" placeholder="请输入联系电话">
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
