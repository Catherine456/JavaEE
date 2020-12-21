package com.controller;

import com.dao.Stuscore;
import com.dao.teaDao;
import com.model.stuscore;
import com.model.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller/Mscoreinfo.do")
public class Mscoreinfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Stuscore dao=new Stuscore();
        boolean first;
        if(request.getSession().getAttribute("teacherList")!=null) {
            first=false;
        }
        else
            first=true;
        ArrayList<stuscore> stuscoreList = dao.stuScoinf();
        System.out.println();
        request.getSession().setAttribute("stuscoreList", stuscoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/Man3.jsp");
        else response.sendRedirect("../Man3.jsp");
    }
}
