package com.dao;

import com.model.Lesson;
import com.model.avgScore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvgDao extends BaseDao {
    public ArrayList<avgScore> avgall(String Tno){
        ArrayList<avgScore> avgScoreList = new ArrayList<avgScore>();
        String sql = "select * from chenh_CTLs09 where ch_Tno09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Tno);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                //    System.out.println(rst.getString("ch_Sname09"));
                avgScore avgScore0=new avgScore();
                avgScore0.setCh_Lno09(rst.getString("ch_Lno09"));
                avgScore0.setCh_Tno09(rst.getString("ch_Tno09"));
                avgScore0.setCh_Cno09(rst.getString("ch_Cno09"));
                avgScore0.setCh_Avgscore09(rst.getDouble("ch_Avgscore09"));
                avgScore0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                avgScoreList.add(avgScore0);
            }
            return avgScoreList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<avgScore> avgall1(String Tno,String Cno){
        ArrayList<avgScore> avgScoreList = new ArrayList<avgScore>();
        String sql = "select * from chenh_CTLs09 where ch_Tno09= ? and ch_Cno09= ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Tno);
            pstmt.setString(2,Cno);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                //    System.out.println(rst.getString("ch_Sname09"));
                avgScore avgScore0=new avgScore();
                avgScore0.setCh_Lno09(rst.getString("ch_Lno09"));
                avgScore0.setCh_Tno09(rst.getString("ch_Tno09"));
                avgScore0.setCh_Cno09(rst.getString("ch_Cno09"));
                avgScore0.setCh_Avgscore09(rst.getDouble("ch_Avgscore09"));
                avgScore0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                avgScoreList.add(avgScore0);
            }
            return avgScoreList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
