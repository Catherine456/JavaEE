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
<h1 class="title">首页</h1>
<br>
<div class="container" id="search">
    <div>
        <%
            stu stu0=(stu) session.getAttribute("stu");
            System.out.println( session.getAttribute("stu"));
        %>
     <%--   <%=stu0.getCh_Sno09()%> --%>
        <div class="top">
            <div>
                <span class="la">姓名</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><%=stu0.getCh_Sname09()%></span>
            </div>
            <div>
                <span class="la">专业</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><%=stu0.getCh_Mname09()%></span>
            </div>

        </div>
    </div>
</div>
<br>
<div class="box-content">
    <section id="collegenews">
        <div class="title1">
            &nbsp;<span class="iconfont iconxinwen1" id="college">&nbsp;学院新闻</span>
            <span id="fenge">|</span>
            &nbsp;<span class="iconfont icondongtai2" id="dongtai">&nbsp;学术动态</span>
            <a id="xinwendongtai" href="collegenews.html">更多>></a>
        </div>
        <div class="news" id="college1">
            <ul>
                <li>
                    <a href="more.html">学院迎来2020年春季学期首批开学返校学生</a>>
                        <span class="iconfont iconxinwen2"></span>
                        <span class="date">(04-27)</span>
                </li>
                <li>
                    <a href="#">我院召开新提任领导送任会</a>
                        <span class="iconfont iconxinwen2"></span>
                        <span class="date">(04-27)</span>
                </li>
                <li>
                    <a href="#">我院一项研究成果在虚拟现实国际顶级会议上发表</a>
                    <span class="iconfont iconxinwen2"></span>
                    <span class="date">(04-13)</span>
                </li>
                <li>
                    <a href="#">我院梁荣华等一行前往之江实验室欢送借调人员并开展合作交流</a>
                    <span class="date">(04-02)</span>
                </li>
                <li>
                    <a href="#">学院分工会组织“云上茶道”体验庆祝丽人节</a>
                    <span class="date">(03-27)</span>
                </li>
                <li>
                    <a href="#">我院王万良教授荣获“2019浙江教育年度新闻人物”称号</a>
                    <span class="date">(03-19)</span>
                </li>
                <li>
                    <a href="#">虞晓芬副校长一行来我院调研指导工作</a>
                    <span class="date">(03-19)</span>
                </li>
                <li>
                    <a href="#">学院扎实推进本科在线教学 积极应对疫情挑战</a>
                    <span class="date">(03-13)</span>
                </li>
                <li>
                    <a href="#">我院一项研究成果被计算机视觉领域国际顶级学术会议录用</a>
                    <span class="date">(03-09)</span>
                </li>
                <li>
                    <a href="#">学院召开疫情防控工作专题视频会议</a>
                    <span class="date">(02-26)</span>
                </li>
                <li>
                    <a href="#">祝全体师生员工、海内外校友新春快乐，阖家欢乐，万事如意！</a>
                    <span class="date">(01-24)</span>
                </li>
                <li>
                    <a href="#">我院软件工程教学团队获评2019年度校级优秀基层教学组织</a>
                    <span class="date">(01-17)</span>
                </li>
                <li>
                    <a href="#">学院工会开展“十全十美”年终庆典活动</a>
                    <span class="date">(01-14)</span>
                </li>
                <li>
                    <a href="#">浙江大学何钦铭教授做客我院作教学讲座</a>
                    <span class="date">(12-26)</span>
                </li>
            </ul>
        </div>
        <div class="news" id="science" >
            <ul>
                <li>
                    <a href="#">大连理工大学孔祥杰学术</a>
                        <span class="iconfont iconxinwen2"></span>
                        <span class="date">(12-24)</span>
                </li>
                <li>
                    <a href="#">北方工业大学交通信息与控制团队学术报告预告</a>>
                        <span class="iconfont iconxinwen2"></span>
                        <span class="date">(11-16)</span>
                </li>
                <li>
                    <a href="#">2019中国自动化大会会议</a>
                    <span class="date">(11-22)</span>
                </li>
                <li>
                    <a href="#">2019年浙江省和杭州市计算机学会人工智能专委会年会</a>
                    <span class="date">(11-16)</span>
                </li>
                <li>
                    <a href="#">北方工业大学张福生学术报告预告</a>
                    <span class="date">(11-16)</span>
                </li>
                <li>
                    <a href="#">2019第三届青年数据科学家论坛通知</a>
                    <span class="date">(11-14)</span>
                </li>
                <li>
                    <a href="#">中国科学院声学研究所李松斌学术报告预告</a>
                    <span class="date">(11-11)</span>
                </li>
                <li>
                    <a href="#">中国科学院信息工程研究所孙利民学术报告预告</a>
                    <span class="date">(11-05)</span>
                </li>
                <li>
                    <a href="#">第十八届全国软件与应用学术会议(NASAC 2019)预告</a>
                    <span class="date">(11-05)</span>
                </li>
                <li>
                    <a href="#">江波学术报告预告</a>
                    <span class="date">(11-01)</span>
                </li>
                <li>
                    <a href="#">杭州电子科技大学夏永祥教授学术报告预告</a>
                    <span class="date">(10-28)</span>
                </li>
                <li>
                    <a href="#">杭州医学院检验医学院宋广忠学术报告预告</a>
                    <span class="date">(10-22)</span>
                </li>
                <li>
                    <a href="#">北京大学彭宇新教授学术报告预告</a>
                    <span class="date">(10-18)</span>
                </li>
                <li>
                    <a href="#">微众银行人工智能首席科学家范力欣学术报告预告</a>
                    <span class="date">(10-15)</span>
                </li>
            </ul>
        </div>
    </section>
</div>

</body>
</html>
