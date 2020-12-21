package com.dao;

import com.model.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teaDao1 extends BaseDao {
    public boolean deleteteasear(String Tno){
        teacher teacher0=new teacher();
        String sql = "delete  from chenh_Teachers09 where ch_Tno09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Tno);
            pstmt.executeUpdate();
            System.out.println("教师删除成功！");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    public boolean updateteasear(String Tno,String Tname,String Title,String Phone){
        teacher teacher0=new teacher();
        String sql = "update  chenh_Teachers09 " +
                "set ch_Tname09=? , ch_Ttitle09= ? ,ch_Tphone09= ? " +
                "where ch_Tno09= ? ";
        System.out.println("开始更新");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Tname);
            pstmt.setString(2,Title);
            pstmt.setString(3,Phone);
            pstmt.setString(4,Tno);
            pstmt.executeUpdate();
            System.out.println("教师修改成功！");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    public boolean insertteasear(String Tno,String Tname,String sex,String age,String Title,String Phone){
        String sql = "insert into chenh_Teachers09 " +
                "values(?,?,?,?,?,?) ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Tno);
            pstmt.setString(2,Tname);
            pstmt.setString(3,sex);
            pstmt.setString(4,age);
            pstmt.setString(5,Title);
            pstmt.setString(6,Phone);
            pstmt.executeUpdate();
            System.out.println("教师插入成功！");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
}
