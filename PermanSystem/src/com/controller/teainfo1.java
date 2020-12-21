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

@WebServlet("/controller/teainfo1.do")
public class teainfo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        teaDao dao=new teaDao();
        String tno =(String)request.getSession().getAttribute("username");
        System.out.println(tno);
        boolean first;
        if(request.getSession().getAttribute("teacher")!=null) {
            first=false;
        }
        else
            first=true;
        teacher teacher0 = dao.teasearch1(tno);
        if(teacher0!=null)
            System.out.println("老师在");
    //    System.out.println(teacher0.getCh_Tname09());
        request.getSession().setAttribute("teacher", teacher0);
        //  request.getSession().setAttribute("stuscoreList",stuscoreList);
        if(first)
            response.sendRedirect("Tmain.jsp");
        else response.sendRedirect("../Tmain.jsp");
    }
}
