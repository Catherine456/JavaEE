package com.dao;

import com.model.Lesson;
import com.model.stuscore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LessonDao extends BaseDao {
    public ArrayList<Lesson> Lessonsearch(String term, String cname){
            ArrayList<Lesson> LessonList = new ArrayList<Lesson>();
        String sql = "select * from C_courseInfo where ch_Cname09 = ? and ch_Lterm09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cname);
            pstmt.setString(2,term);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
            //    System.out.println(rst.getString("ch_Sname09"));
                Lesson Lesson0=new Lesson();
                Lesson0.setCh_Lno09(rst.getString("ch_Lno09"));
                Lesson0.setCh_Lname09(rst.getString("ch_Lname09"));
                Lesson0.setCh_Lperiod09(rst.getInt("ch_Lperiod09"));
                Lesson0.setCh_Ltype09(rst.getString("ch_Ltype09"));
                Lesson0.setCh_Lcredit09(rst.getInt("ch_Lcredit09"));
                Lesson0.setCh_Tno09(rst.getString("ch_Tno09"));
                Lesson0.setCh_Tname09(rst.getString("ch_Tname09"));
                Lesson0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                Lesson0.setCh_Cno09(rst.getString("ch_Cno09"));
                Lesson0.setCh_Cname09(rst.getString("ch_Cname09"));
                LessonList.add(Lesson0);
            }
            return LessonList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<Lesson> Lessonsearch1(String tno){
        ArrayList<Lesson> LessonList = new ArrayList<Lesson>();
        String sql = "select * from C_courseInfo where ch_Tno09=? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,tno);
            System.out.println("Tno="+tno);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println("存在记录");
                //    System.out.println(rst.getString("ch_Sname09"));
                Lesson Lesson0=new Lesson();
                Lesson0.setCh_Lno09(rst.getString("ch_Lno09"));
                Lesson0.setCh_Lname09(rst.getString("ch_Lname09"));
                Lesson0.setCh_Lperiod09(rst.getInt("ch_Lperiod09"));
                Lesson0.setCh_Ltype09(rst.getString("ch_Ltype09"));
                Lesson0.setCh_Lcredit09(rst.getInt("ch_Lcredit09"));
                Lesson0.setCh_Tno09(rst.getString("ch_Tno09"));
                Lesson0.setCh_Tname09(rst.getString("ch_Tname09"));
                Lesson0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                Lesson0.setCh_Cno09(rst.getString("ch_Cno09"));
                Lesson0.setCh_Cname09(rst.getString("ch_Cname09"));
                LessonList.add(Lesson0);
            }
            if(LessonList!=null)
                System.out.println("有记录！！");
            return LessonList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<Lesson> Lessonsearchall(){
        ArrayList<Lesson> LessonList = new ArrayList<Lesson>();
        String sql = "select * from C_courseInfo ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                //    System.out.println(rst.getString("ch_Sname09"));
                Lesson Lesson0=new Lesson();
                Lesson0.setCh_Lno09(rst.getString("ch_Lno09"));
                Lesson0.setCh_Lname09(rst.getString("ch_Lname09"));
                Lesson0.setCh_Lperiod09(rst.getInt("ch_Lperiod09"));
                Lesson0.setCh_Ltype09(rst.getString("ch_Ltype09"));
                Lesson0.setCh_Lcredit09(rst.getInt("ch_Lcredit09"));
                Lesson0.setCh_Tno09(rst.getString("ch_Tno09"));
                Lesson0.setCh_Tname09(rst.getString("ch_Tname09"));
                Lesson0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                Lesson0.setCh_Cno09(rst.getString("ch_Cno09"));
                Lesson0.setCh_Cname09(rst.getString("ch_Cname09"));
                LessonList.add(Lesson0);
            }
            return LessonList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
