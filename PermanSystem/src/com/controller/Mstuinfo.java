package com.controller;

import com.dao.StuDao;
import com.model.stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller/Mstuinfo.do")
public class Mstuinfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno=request.getParameter("sno");
        StuDao dao=new StuDao();
        boolean first;
        if(request.getSession().getAttribute("stuList")!=null) {
            first=false;
        }
        else
            first=true;
        ArrayList<stu> stuList=dao.stuinf2(sno);
        request.getSession().setAttribute("stuList", stuList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/Man1.jsp");
        else response.sendRedirect("../Man1.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        StuDao dao=new StuDao();
        boolean first;
        if(request.getSession().getAttribute("stuList")!=null) {
            first=false;
        }
        else
            first=true;
        ArrayList<stu> stuList =new ArrayList<stu>();
        stuList=dao.stuinf();
        request.getSession().setAttribute("stuList", stuList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/Man1.jsp");
        else response.sendRedirect("../Man1.jsp");
    }
}
