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
<h1 class="title">成绩信息</h1>
<br>
<div class="container" id="search">
    <form action="controller/Mscoreinfo.do" method="post">
        <input type="text" name="tno" placeholder="请输入教师编号">
        <input type="submit" class="btn btn-default" value="查询">
    </form>
</div>
<br>
<div class="box-content">
    <div>
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
            添加成绩信息
        </button>
    </div>

    <br>
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <th>开课学期</th>
            <th>课程名称</th>
            <th>课程性质</th>
            <th>学分</th>
            <th>成绩</th>
            <th>专业</th>
            <th>班级</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<stuscore> stuscoreList = (ArrayList<stuscore>) session.getAttribute("stuscoreList");
            for(stuscore s : stuscoreList){
        %>
        <tr>
            <td><%=s.getCh_Sno09()%></td>
            <%
                String p = "controller/deletescore.do?sno=" + s.getCh_Sno09()+"&tno="+s.getCh_Tno09()+"&term="+s.getCh_Lterm09();
                String p1 = "updatescore.jsp?sno=" + s.getCh_Sno09() + "&sname=" + s.getCh_Sname09() + "&mname=" + s.getCh_Mname09() + "&cname=" + s.getCh_Cname09() +"&lname="+ s.getCh_Lname09()+"&lcredit="+s.getCh_Lcredit09()+"&score="+s.getCh_score09()+"&rank="+s.getCh_rank09()+"&term="+s.getCh_Lterm09()+"&period="+s.getCh_Lperiod09();
            %>
            <td><%=s.getCh_Sname09()%></td>
            <td><%=s.getCh_Lterm09()%></td>
            <td><%=s.getCh_Lname09()%></td>
            <td><%=s.getCh_Ltype09()%></td>
            <td><%=s.getCh_Lcredit09()%></td>
            <td><%=s.getCh_score09()%></td>
            <td><%=s.getCh_Mname09()%></td>
            <td><%=s.getCh_Cname09()%></td>
            <td class="center">
                <a class="btn btn-info" href=<%=p1 %>>
                    修改
                </a>
                <a class="btn btn-danger" href=<%=p %>>
                    删除
                </a>
            </td>
        </tr>
        </tbody>
        <%} %>
    </table>
</div>
<br>
<!-- 模态框（Modal） -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加成绩
                </h4>
            </div>
            <form action=" controller/inputscore.do " method="post">
                <div class="modal-body">
                    <div class="br">
                        <label>学号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="sno" placeholder="请输入学号">
                    </div>
                    <div class="br">
                        <label>课程编号&nbsp;&nbsp;</label><input type="text" class="form-control" name="cno" placeholder="请输入课程编号">
                    </div>
                    <div class="br">
                        <label>分数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" class="form-control" name="score" placeholder="请输入成绩">
                    </div>
                    <div class="br">
                        <label>开课学期&nbsp;&nbsp;</label>
                        <spans class="controls">
                            <select  data-rel="chosen" name="term">
                                <option>2019/2020(1)</option>
                                <option>2019/2020(2)</option>
                                <option>2018/2019(1)</option>
                                <option>2018/2019(2)</option>
                            </select>
                        </spans>
                    </div>
                    <div class="br">
                        <label>教师编号&nbsp;&nbsp;</label><input type="text" class="form-control" name="tno" placeholder="请输入教师编号">
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
