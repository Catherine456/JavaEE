package com.controller;

import com.dao.LessonDao;
import com.dao.StuDao;
import com.dao.Stuscore;
import com.model.Lesson;
import com.model.stu;
import com.model.stuscore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet( "/controller/stuLesson.do")
public class stuLesson extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessonDao dao =new LessonDao();
        StuDao dao1= new StuDao();
        boolean first;
        String username=(String) request.getSession().getAttribute("username");
        stu stu0=dao1.stuinf1(username);
        String cname=stu0.getCh_Cname09();
        System.out.println(cname);
        String term=request.getParameter("year")+"（"+request.getParameter("season")+"）";
        if(request.getSession().getAttribute("LessonList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<Lesson> LessonList = dao.Lessonsearch(term,cname);
        if(LessonList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("LessonList", LessonList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/stu3.jsp");
        else
            response.sendRedirect("../stu3.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessonDao dao =new LessonDao();
        StuDao dao1= new StuDao();
        boolean first;
        String username=(String) request.getSession().getAttribute("username");
        stu stu0=dao1.stuinf1(username);
        String cname=stu0.getCh_Cname09();
        System.out.println(cname);
        String term="2019/2020（2）";
        if(request.getSession().getAttribute("LessonList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<Lesson> LessonList = dao.Lessonsearch(term,cname);
        if(LessonList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("LessonList", LessonList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/stu3.jsp");
        else
            response.sendRedirect("../stu3.jsp");
        /* response.sendRedirect("stu2.jsp");*/
    }
}
