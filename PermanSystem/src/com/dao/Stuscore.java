package com.dao;

import com.model.stu;
import com.model.stuscore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Stuscore extends BaseDao {
    public ArrayList<stuscore> stuSco(String term,String username){
        ArrayList<stuscore> stuscoreList = new ArrayList<stuscore>();
        String sql = "select * from C_scoreInfo where ch_Lterm09 = ? and ch_Sno09 = ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.setString(2,username);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println(rst.getString("ch_Sname09"));
                stuscore stuscore0=new stuscore();
                stuscore0.setCh_Sno09(rst.getString("ch_Sno09"));
                stuscore0.setCh_Sname09(rst.getString("ch_Sname09"));
                stuscore0.setCh_Mname09(rst.getString("ch_Mname09"));
                stuscore0.setCh_Cname09(rst.getString("ch_Cname09"));
                stuscore0.setCh_Lname09(rst.getString("ch_Lname09"));
                stuscore0.setCh_Lcredit09(rst.getInt("ch_Lcredit09"));
                stuscore0.setCh_score09(rst.getDouble("ch_score09"));
                stuscore0.setCh_rank09(rst.getInt("ch_rank09"));
                stuscore0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                stuscore0.setCh_Lperiod09(rst.getInt("ch_Lperiod09"));
                stuscore0.setCh_Ltype09(rst.getString("ch_Ltype09"));
                stuscore0.setCh_Tno09(rst.getString("ch_Tno09"));
                stuscore0.setCh_Tname09(rst.getString("ch_Tname09"));
                stuscoreList.add(stuscore0);
            }
            return stuscoreList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<stuscore> stuSco1(String tno){
        ArrayList<stuscore> stuscoreList = new ArrayList<stuscore>();
        String sql = "select * from C_scoreInfo where ch_Tno09 = ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tno);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println(rst.getString("ch_Sname09"));
                stuscore stuscore0=new stuscore();
                stuscore0.setCh_Sno09(rst.getString("ch_Sno09"));
                stuscore0.setCh_Sname09(rst.getString("ch_Sname09"));
                stuscore0.setCh_Mname09(rst.getString("ch_Mname09"));
                stuscore0.setCh_Cname09(rst.getString("ch_Cname09"));
                stuscore0.setCh_Lname09(rst.getString("ch_Lname09"));
                stuscore0.setCh_Lcredit09(rst.getInt("ch_Lcredit09"));
                stuscore0.setCh_score09(rst.getDouble("ch_score09"));
                stuscore0.setCh_rank09(rst.getInt("ch_rank09"));
                stuscore0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                stuscore0.setCh_Lperiod09(rst.getInt("ch_Lperiod09"));
                stuscore0.setCh_Ltype09(rst.getString("ch_Ltype09"));
                stuscore0.setCh_Tno09(rst.getString("ch_Tno09"));
                stuscore0.setCh_Tname09(rst.getString("ch_Tname09"));
                stuscoreList.add(stuscore0);
            }
            return stuscoreList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<stuscore> stuSco2(String term,String tno,String sno){
        ArrayList<stuscore> stuscoreList = new ArrayList<stuscore>();
        String sql = "select * from C_scoreInfo where ch_Lterm09 = ? and ch_Sno09 = ? and ch_Tno09 = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.setString(2,sno);
            pstmt.setString(3,tno);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println(rst.getString("ch_Sname09"));
                stuscore stuscore0=new stuscore();
                stuscore0.setCh_Sno09(rst.getString("ch_Sno09"));
                stuscore0.setCh_Sname09(rst.getString("ch_Sname09"));
                stuscore0.setCh_Mname09(rst.getString("ch_Mname09"));
                stuscore0.setCh_Cname09(rst.getString("ch_Cname09"));
                stuscore0.setCh_Lname09(rst.getString("ch_Lname09"));
                stuscore0.setCh_Lcredit09(rst.getInt("ch_Lcredit09"));
                stuscore0.setCh_score09(rst.getDouble("ch_score09"));
                stuscore0.setCh_rank09(rst.getInt("ch_rank09"));
                stuscore0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                stuscore0.setCh_Lperiod09(rst.getInt("ch_Lperiod09"));
                stuscore0.setCh_Ltype09(rst.getString("ch_Ltype09"));
                stuscore0.setCh_Tno09(rst.getString("ch_Tno09"));
                stuscore0.setCh_Tname09(rst.getString("ch_Tname09"));
                stuscoreList.add(stuscore0);
            }
            return stuscoreList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<stuscore> stuScoinf(){
        ArrayList<stuscore> stuscoreList = new ArrayList<stuscore>();
        String sql = "select * from C_scoreInfo ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rst = pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println(rst.getString("ch_Sname09"));
                stuscore stuscore0=new stuscore();
                stuscore0.setCh_Sno09(rst.getString("ch_Sno09"));
                stuscore0.setCh_Sname09(rst.getString("ch_Sname09"));
                stuscore0.setCh_Mname09(rst.getString("ch_Mname09"));
                stuscore0.setCh_Cname09(rst.getString("ch_Cname09"));
                stuscore0.setCh_Lname09(rst.getString("ch_Lname09"));
                stuscore0.setCh_Lcredit09(rst.getInt("ch_Lcredit09"));
                stuscore0.setCh_score09(rst.getDouble("ch_score09"));
                stuscore0.setCh_rank09(rst.getInt("ch_rank09"));
                stuscore0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                stuscore0.setCh_Lperiod09(rst.getInt("ch_Lperiod09"));
                stuscore0.setCh_Ltype09(rst.getString("ch_Ltype09"));
                stuscore0.setCh_Tno09(rst.getString("ch_Tno09"));
                stuscore0.setCh_Tname09(rst.getString("ch_Tname09"));
                stuscoreList.add(stuscore0);
            }
            return stuscoreList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
