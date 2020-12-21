package com.controller;

import com.dao.LessonDao;
import com.model.Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller/teatu.do")
public class teatu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessonDao dao =new LessonDao();
        boolean first;
        String Tno=(String) request.getSession().getAttribute("username");
        System.out.println(Tno);
        if(request.getSession().getAttribute("LessonList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<Lesson> LessonList = dao.Lessonsearch1(Tno);
        if(LessonList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("LessonList", LessonList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/tea2.jsp");
        else
            response.sendRedirect("../tea2.jsp");
    }
}
