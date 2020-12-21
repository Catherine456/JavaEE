package com.dao;

import com.model.Lesson;
import com.model.SLT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SLTDao extends BaseDao {
    public boolean insertSLT(String sno,String lno,double score,String term,String tno){
        String sql="insert into chenh_SLTscore09 " +
                "values(?,?,?,?,?)";
        try(Connection conn=dataSource.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,sno);
            pstmt.setString(2,lno);
            pstmt.setDouble(3,score);
            pstmt.setString(4,term);
            pstmt.setString(5,tno);
            pstmt.executeUpdate();
            System.out.println("插入成功！");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateSLT(String sno,String lno,double score,String term,String tno){
        String sql="UPDATE chenh_SLTscore09 " +
                "set ch_Score09= ? where ch_Sno09= ? and ch_Lno09= ? and ch_Lterm09= ? and ch_Tno09= ?";
        try(Connection conn=dataSource.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setDouble(1,score);
            pstmt.setString(2,sno);
            pstmt.setString(3,lno);
            pstmt.setString(4,term);
            pstmt.setString(5,tno);
            pstmt.executeUpdate();
            System.out.println("更新成功！");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SLT> searchSLTall(String tno){
        ArrayList<SLT> sltlist=new ArrayList<SLT>();
        String sql="select * from chenh_SLTscore09 " +
                "where ch_Tno09= ? ";
        try(Connection conn=dataSource.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,tno);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next())
            {
                SLT slt0=new SLT();
                slt0.setCh_Sno09(rst.getString("ch_Sno09"));
                slt0.setCh_Lno09(rst.getString("ch_Lno09"));
                slt0.setCh_Score09(rst.getDouble("ch_Score09"));
                slt0.setCh_Lterm09(rst.getString("ch_Lterm09"));
                slt0.setCh_Tno09(rst.getString("ch_Tno09"));
                sltlist.add(slt0);
            }
            return sltlist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
