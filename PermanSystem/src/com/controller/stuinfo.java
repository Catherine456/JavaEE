package com.controller;

import com.dao.StuDao;
import com.dao.Stuscore;
import com.model.stu;
import com.model.stuscore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller/stuinfo.do")
public class stuinfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        StuDao dao=new StuDao();
      //  Stuscore dao1 = new Stuscore();
     //   String term="2019/2020（2）";
        String username =(String)request.getSession().getAttribute("username");
        System.out.println(username);
        boolean first;
        if(request.getSession().getAttribute("stu")!=null) {
            first=false;
        }
        else
            first=true;
        stu stu0 = dao.stuinf1(username);
    //    ArrayList<stuscore> stuscoreList=dao1.stuSco(term,username);
        System.out.println(stu0.getCh_Sname09());
        request.getSession().setAttribute("stu", stu0);
      //  request.getSession().setAttribute("stuscoreList",stuscoreList);
        if(first)
            response.sendRedirect("main.jsp");
        else response.sendRedirect("../main.jsp");
    }
}
