package com.controller;

import com.dao.teaDao;
import com.model.stu;
import com.model.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller/Mteachinfo.do")
public class Mteachinfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tno= request.getParameter("tno");
        teaDao dao=new teaDao();
        boolean first;
        if(request.getSession().getAttribute("teacherList")!=null) {
            first=false;
        }
        else
            first=true;
        ArrayList<teacher> teacherList=dao.teasearch(tno);
        request.getSession().setAttribute("teacherList", teacherList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/Man2.jsp");
        else response.sendRedirect("../Man2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        teaDao dao=new teaDao();
        boolean first;
        if(request.getSession().getAttribute("teacherList")!=null) {
            first=false;
        }
        else
            first=true;
        ArrayList<teacher> teacherList = dao.teainf();
        System.out.println();
        request.getSession().setAttribute("teacherList", teacherList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/Man2.jsp");
        else response.sendRedirect("../Man2.jsp");
    }
}
