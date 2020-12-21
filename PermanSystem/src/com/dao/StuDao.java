package com.dao;

import com.model.stu;

import java.sql.*;
import java.util.ArrayList;

public class StuDao extends BaseDao {
    public ArrayList<stu> stuinf() {
        ArrayList<stu> stuList = new ArrayList<stu>();
        String sql = "select * from C_studentInfo";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while(rst.next())
            {
                stu stu0=new stu();
                stu0.setCh_Sno09(rst.getString("ch_Sno09"));
                stu0.setCh_Sname09(rst.getString("ch_Sname09"));
                stu0.setCh_Mname09(rst.getString("ch_Mname09"));
                stu0.setCh_Cname09(rst.getString("ch_Cname09"));
                stu0.setCh_Sex09(rst.getString("ch_Sex09"));
                stu0.setCh_Sage09(rst.getInt("ch_Sage09"));
                stu0.setCh_Splace09(rst.getString("ch_Splace09"));
                stu0.setCh_Scredit09(rst.getInt("ch_Scredit09"));
                stuList.add(stu0);
            }
            return stuList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public stu stuinf1(String username){
        String sql = "select * from C_studentInfo where ch_Sno09= ? ";
        stu stu0=new stu();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rst = pstmt.executeQuery();
            System.out.println("查到了！");
            if(rst.next())
            {
                System.out.println("ch_Sname09");
                stu0.setCh_Sno09(rst.getString("ch_Sno09"));
                stu0.setCh_Sname09(rst.getString("ch_Sname09"));
                stu0.setCh_Mname09(rst.getString("ch_Mname09"));
                stu0.setCh_Cname09(rst.getString("ch_Cname09"));
                stu0.setCh_Sex09(rst.getString("ch_Sex09"));
                stu0.setCh_Sage09(rst.getInt("ch_Sage09"));
                stu0.setCh_Splace09(rst.getString("ch_Splace09"));
                stu0.setCh_Scredit09(rst.getInt("ch_Scredit09"));
            }
            return stu0;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public ArrayList<stu> stuinf2(String username){
        String sql = "select * from C_studentInfo where ch_Sno09= ? ";
        ArrayList<stu> stuList = new ArrayList<stu>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rst = pstmt.executeQuery();
            System.out.println("查到了！");
            if(rst.next())
            {
                stu stu0=new stu();
                System.out.println("ch_Sname09");
                stu0.setCh_Sno09(rst.getString("ch_Sno09"));
                stu0.setCh_Sname09(rst.getString("ch_Sname09"));
                stu0.setCh_Mname09(rst.getString("ch_Mname09"));
                stu0.setCh_Cname09(rst.getString("ch_Cname09"));
                stu0.setCh_Sex09(rst.getString("ch_Sex09"));
                stu0.setCh_Sage09(rst.getInt("ch_Sage09"));
                stu0.setCh_Splace09(rst.getString("ch_Splace09"));
                stu0.setCh_Scredit09(rst.getInt("ch_Scredit09"));
                stuList.add(stu0);
            }
            return stuList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
    public boolean insertstu(String sno,String sname,String mname,String cname,String sex,int age,String place,int credit){
        String sql = "insert into C_studentInfo " +
                "values(?,?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            pstmt.setString(2,sname);
            pstmt.setString(3,mname);
            pstmt.setString(4,cname);
            pstmt.setString(5,sex);
            pstmt.setInt(6,age);
            pstmt.setString(7,place);
            pstmt.setInt(8,credit);
            pstmt.executeUpdate();
            System.out.println("学生信息插入");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
 /*   public dp searchDp(String dpcode,ArrayList<dp> dplist){

        for (dp d : dplist) {
            System.out.println(d.getDpcode()+"..."+dpcode);
            if ((d.getDpcode()).equals(dpcode)) {
                System.out.println("find it/////////");
                return d;
            }
        }
        return null;
    }
    public boolean deleteDp(String dpcode) {//根据部门编号删除部门信息
        String sql = "delete from dptable where dpcode= ? ";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dpcode);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    public boolean updateDp(String dpcode,String dpname,String dpwage) {//根据部门编号更新部门信息
        String sql = "update dptable set dpname=? ,dpLeastwage=? where dpcode= ? ";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dpname);
            pstmt.setDouble(2, Double.parseDouble(dpwage));
            pstmt.setString(3, dpcode);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }*/
}
