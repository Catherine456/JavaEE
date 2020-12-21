package com.controller;

import com.dao.teaDao1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/controller/inputtea.do")
public class inputtea extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
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
        String tno=request.getParameter("tno");
        String tname=request.getParameter("tname");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String title=request.getParameter("title");
        String phone=request.getParameter("phone");
        teaDao1 dao=new teaDao1();
        boolean flag=dao.insertteasear(tno,tname,sex,age,title,phone);
        if(flag){
            System.out.println("回来了");
            response.sendRedirect("Mteachinfo.do");
        }
        else{
            out.write("<script language='javascript'>swal('操作失败，请重试');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
