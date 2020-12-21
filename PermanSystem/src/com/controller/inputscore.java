package com.controller;

import com.dao.SLTDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/controller/inputscore.do")
public class inputscore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.write("<!DOCTYPE html>\n" +
                "<html>");
        out.write("<head>");
        out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.huangwx.cn/css/sweetalert.css\">\n" +
                "<style type=\"text/css\">\n" +
                " .sweet-alert{\n" +
                "    width: 400px;\n" +
                "    margin-left: -220px;\n" +
                "}\n" +
                ".sweet-alert h2{\n" +
                "    font-size: 25px;\n" +
                "}       \n" +
                "</style>"+
                "<script type=\"text/javascript\" src=\"https://www.huangwx.cn/js/sweetalert-dev.js\"></script>"+
                "<script src=\"https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js\"></script>");
        out.write("</head>");
        out.write("<body>");

        String sno=request.getParameter("sno");
        String lno=request.getParameter("lno");
        double score=Double.valueOf(request.getParameter("score")) ;
        String term=request.getParameter("term");
        String tno=(String) request.getSession().getAttribute("username");
        SLTDao dao =new  SLTDao();
        System.out.println(sno+" "+lno+" "+score+" "+term+" "+tno);
        boolean flag=dao.insertSLT(sno,lno,score,term,tno);
        if(flag){
            response.sendRedirect("/PermanSystem_war_exploded/Tmain.jsp");
         /*   RequestDispatcher rd = getServletContext().getRequestDispatcher("/Tmain.jsp");
            rd.forward(request, response); */
        }
        else{
            String defeat = "插入失败！";
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
