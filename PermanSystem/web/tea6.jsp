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
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="bootstrap.min.js"></script>
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
<div class="container" id="search">

</div>
<br>
<%!SLT x;%>
<div class="box-content" id="into">
        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
            <thead>
            <tr>
                <th>学号</th>
                <th>课程号</th>
                <th>分数</th>
                <th>开课学期</th>
                <th>教师号</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<SLT> sltlist = (ArrayList<SLT>) session.getAttribute("sltlist");

                for (SLT s : sltlist) {
            %>
            <tr>
                <td><%=s.getCh_Sno09()%></td>
                <%
                    x=s;
                    String p1 = "update.jsp?sno=" +s.getCh_Sno09() + "&lno=" + s.getCh_Lno09() + "&term=" + s.getCh_Lterm09()+"&score="+s.getCh_Score09()+"&tno="+s.getCh_Tno09() ;
                %>
                <td><%=s.getCh_Lno09()%></td>
                <td><%=s.getCh_Score09()%></td>
                <td><%=s.getCh_Lterm09()%></td>
                <td><%=s.getCh_Tno09()%></td>
                <td class="center">
                    <%--     <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                             修改
                         </button>--%>
                   <a class="btn btn-info" href=<%=p1 %>>
                             修改
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
                    修改学生成绩
                </h4>
            </div>
            <%
                request.getSession().setAttribute("sno",x.getCh_Sno09());
                request.getSession().setAttribute("lno",x.getCh_Lno09());
                request.getSession().setAttribute("term",x.getCh_Lterm09());
            %>
            <form action="controller/update.do" method="post" >
                <div class="modal-body">
                    <div class="br">
                        <label>学号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=x.getCh_Sno09() %>
                    </div>
                    <div class="br">
                        <label>课程号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=x.getCh_Lno09() %>
                    </div>
                    <div class="br">
                        <label>分数：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="score" value=<%=x.getCh_Score09() %>>
                    </div>
                    <div class="br">
                        <label>开课学期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=x.getCh_Lterm09() %>
                    </div>
                    <div class="br">
                        <label>教师编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=x.getCh_Tno09() %>
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
