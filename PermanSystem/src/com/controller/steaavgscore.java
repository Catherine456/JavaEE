package com.controller;

import com.dao.AvgDao;
import com.dao.Stuscore;
import com.model.avgScore;
import com.model.stuscore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller/steaavgscore.do")
public class steaavgscore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AvgDao dao =new AvgDao();
        boolean first;
        String tno=(String) request.getSession().getAttribute("username");
        String cno=request.getParameter("cno");
        if(request.getSession().getAttribute("avgScoreList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<avgScore> avgScoreList = dao.avgall1(tno,cno);
        if(avgScoreList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("avgScoreList", avgScoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/tea4.jsp");
        else
            response.sendRedirect("../tea4.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AvgDao dao =new AvgDao();
        boolean first;
        String tno=(String) request.getSession().getAttribute("username");
        if(request.getSession().getAttribute("avgScoreList")!=null) {
            first=false;
        }
        else
            first=true;
        System.out.println(first);
        ArrayList<avgScore> avgScoreList = dao.avgall(tno);
        if(avgScoreList!=null)
            System.out.println("非空！");
        request.getSession().setAttribute("avgScoreList", avgScoreList);
        if(first)
            response.sendRedirect("/PermanSystem_war_exploded/tea4.jsp");
        else
            response.sendRedirect("../tea4.jsp");
        /* response.sendRedirect("stu2.jsp");*/
    }
}
