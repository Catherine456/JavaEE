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

@WebServlet("/controller/stusearchscore.do")
public class stusearchscore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stuscore dao =new Stuscore();
        boolean first;
        String username=(String) request.getSession().getAttribute("username");
        String term=request.getParameter("year")+"（"+request.getParameter("season")+"）";
        if(request.getSession().getAttribute("stuscoreList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<stuscore> stuscoreList = dao.stuSco(term,username);
        if(stuscoreList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("stuscoreList", stuscoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/stu2.jsp");
        else
            response.sendRedirect("../stu2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stuscore dao =new Stuscore();
        boolean first;
        String username=(String) request.getSession().getAttribute("username");
        String term="2019/2020（2）";
        if(request.getSession().getAttribute("stuscoreList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<stuscore> stuscoreList = dao.stuSco(term,username);
        if(stuscoreList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("stuscoreList", stuscoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/stu2.jsp");
        else
           response.sendRedirect("../stu2.jsp");
            /* response.sendRedirect("stu2.jsp");*/
    }
}
