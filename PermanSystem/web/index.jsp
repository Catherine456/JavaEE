<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Catherine小天使
  Date: 2020/7/6
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  今天星期一！
  <br>
  <%
    try {
      Context context = new InitialContext();
      DataSource dataSource =
              (DataSource)context.lookup("java:comp/env/jdbc/sampleDS");
      Connection dbconn = dataSource.getConnection();
      String sql="SELECT * FROM Chenh_Students ";
      PreparedStatement pstmt = dbconn.prepareStatement(sql);
      ResultSet rst = pstmt.executeQuery();
      while(rst.next()){
        out.print(rst.getString("ch_Sno"));
        out.print(rst.getString("ch_Sname"));
        out.print(rst.getString("ch_Semail"));
        out.print(rst.getDouble("ch_Scredit"));
        out.print(rst.getString("ch_Ssex"));
        out.println("<br>");
      }
      System.out.println("脸上啦");
    }catch(NamingException ne){
      System.out.println("Exception:"+ne);
    }
  %>
  </body>
</html>
