package com.dao;

import com.model.stu;
import com.model.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teaDao extends BaseDao{
    public ArrayList<teacher> teainf() {
        ArrayList<teacher> teacherList = new ArrayList<teacher>();
        String sql = "select * from C_teacherInfo";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while(rst.next())
            {
                teacher teacher0=new teacher();
                teacher0.setCh_Tno09(rst.getString("ch_Tno09"));
                teacher0.setCh_Tname09(rst.getString("ch_Tname09"));
                teacher0.setCh_Tsex09(rst.getString("ch_Tsex09"));
                teacher0.setCh_Tage09(rst.getInt("ch_Tage09"));
                teacher0.setCh_Ttitle09(rst.getString("ch_Ttitle09"));
                teacher0.setCh_Tphone09(rst.getString("ch_Tphone09"));
                teacherList.add(teacher0);
            }
            return teacherList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<teacher> teasearch(String Tno){
        ArrayList<teacher> teacherList=new ArrayList<teacher>();
        String sql = "select * from C_teacherInfo where ch_Tno09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1,Tno);
             ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                teacher teacher0 =new teacher();
                teacher0.setCh_Tno09(rst.getString("ch_Tno09"));
                teacher0.setCh_Tname09(rst.getString("ch_Tname09"));
                teacher0.setCh_Tsex09(rst.getString("ch_Tsex09"));
                teacher0.setCh_Tage09(rst.getInt("ch_Tage09"));
                teacher0.setCh_Ttitle09(rst.getString("ch_Ttitle09"));
                teacher0.setCh_Tphone09(rst.getString("ch_Tphone09"));
                teacherList.add(teacher0);
            }
            return teacherList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public teacher teasearch1(String Tno){
        teacher teacher0=new teacher();
        String sql = "select * from C_teacherInfo where ch_Tno09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Tno);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println("老师好");
                teacher0.setCh_Tno09(rst.getString("ch_Tno09"));
                teacher0.setCh_Tname09(rst.getString("ch_Tname09"));
                teacher0.setCh_Tsex09(rst.getString("ch_Tsex09"));
                teacher0.setCh_Tage09(rst.getInt("ch_Tage09"));
                teacher0.setCh_Ttitle09(rst.getString("ch_Ttitle09"));
                teacher0.setCh_Tphone09(rst.getString("ch_Tphone09"));
            }
            return teacher0;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
