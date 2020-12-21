package com.controller;

import com.dao.Stuscore;
import com.model.stuscore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller/teasearchscore.do")
public class teasearchscore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stuscore dao =new Stuscore();
        boolean first;
        String tno=(String) request.getSession().getAttribute("username");
        String term=request.getParameter("year")+"（"+request.getParameter("season")+"）";
        String sno =request.getParameter("sno");
        System.out.println(tno);
        System.out.println(term);
        System.out.println(sno);
        if(request.getSession().getAttribute("stuscoreList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<stuscore> stuscoreList = dao.stuSco2(term,tno,sno);
        if(stuscoreList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("stuscoreList", stuscoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/tea3.jsp");
        else
            response.sendRedirect("../tea3.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stuscore dao =new Stuscore();
        boolean first;
        String Tno=(String) request.getSession().getAttribute("username");
        if(request.getSession().getAttribute("stuscoreList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<stuscore> stuscoreList = dao.stuSco1(Tno);
        if(stuscoreList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("stuscoreList", stuscoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/tea3.jsp");
        else
            response.sendRedirect("../tea3.jsp");
        /* response.sendRedirect("stu2.jsp");*/
    }
}
