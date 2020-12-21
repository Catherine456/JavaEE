package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StuDao1 extends BaseDao {
    public boolean insertstu(String sno,String cno,String sname,String sex,String place,String born,int credit){
        String sql = "insert into chenh_Students09 " +
                "values(?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            pstmt.setString(2,cno);
            pstmt.setString(3,sname);
            pstmt.setString(4,sex);
            pstmt.setString(5,place);
            pstmt.setString(6,born);
            pstmt.setInt(7,credit);
            pstmt.executeUpdate();
            System.out.println("学生信息插入");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    public boolean updatestu(String sno,String sname,String place){
        String sql = "update chenh_Students09 " +
                "set ch_Sname09 = ? ,ch_Splace09=? where ch_Sno09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sname);
            pstmt.setString(2,place);
            pstmt.setString(3,sno);
            pstmt.executeUpdate();
            System.out.println("学生信息更新啦");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    public boolean deletestu(String sno){
        String sql = "delete from chenh_Students09 " +
                "where ch_Sno09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            pstmt.executeUpdate();
            System.out.println("学生信息删除啦");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
}
