package com.controller;

import com.dao.StuDao;
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

@WebServlet( "/controller/teainfo.do")
public class teainfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        teaDao dao=new teaDao();
        boolean first;
        String Tno=request.getParameter("Tno");
        if(request.getSession().getAttribute("teacherList")!=null) {
            first=false;
        }
        else
            first=true;
        ArrayList<teacher> teacherList = dao.teasearch(Tno);
        System.out.println();
        request.getSession().setAttribute("teacherList", teacherList);
        //  request.getSession().setAttribute("stuscoreList",stuscoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/stutea1.jsp");
        else response.sendRedirect("../stutea1.jsp");
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
        //  request.getSession().setAttribute("stuscoreList",stuscoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/stutea1.jsp");
        else response.sendRedirect("../stutea1.jsp");
    }
}
