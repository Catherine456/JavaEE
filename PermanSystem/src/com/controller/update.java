package com.controller;

import com.dao.SLTDao;
import com.model.SLT;
import com.model.stuscore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/controller/update.do")
public class update extends HttpServlet {
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

        SLTDao dao=new SLTDao();
        ArrayList<SLT> sltlist = (ArrayList<SLT>)request.getSession().getAttribute("sltlist");
        if(sltlist!=null)
            System.out.println("华仔");
        String tno=(String) request.getSession().getAttribute("username");
        System.out.println(tno);
        double score=Double.valueOf(request.getParameter("score")) ;
        System.out.println(score);
        String sno=(String) request.getSession().getAttribute("sno");
        System.out.println(sno);
        String lno =(String)request.getSession().getAttribute("lno");
        System.out.println(lno);
        String term=(String) request.getSession().getAttribute("term");
        System.out.println(term);
        System.out.println(sno+" "+lno+" "+score+" "+term+" "+tno);
        boolean flag= dao.updateSLT(sno,lno,score,term,tno);
        if(flag){
            response.sendRedirect("/PermanSystem_war_exploded/Tmain.jsp");
        }
        else{
            String defeat = "更新失败！";
            out.write("<script language='javascript'>swal('"+defeat+"');" +
                    "$('.confirm').click(function(){" +
                    "history.back();});"+
                    "</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SLTDao dao=new SLTDao();
        boolean first;
        String tno=(String) request.getSession().getAttribute("username");
        System.out.println(tno);
        if(request.getSession().getAttribute("sltlist")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<SLT>  sltlist = dao.searchSLTall(tno);
        if(sltlist!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("sltlist", sltlist);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/tea6.jsp");
        else
            response.sendRedirect("../tea6.jsp");
    }
}
