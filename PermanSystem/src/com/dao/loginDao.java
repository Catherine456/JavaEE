package com.dao;

import com.dao.BaseDao;
import java.sql.*;
import java.util.ArrayList;

public class loginDao extends BaseDao{
    public String login(String username,String password) {
        String sql = "select * from chenh_Users09 where ch_Uname09='"+username+"'";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            System.out.println(sql);
            System.out.println("进来了。");
            if(rst.next())
            {
                System.out.println(rst.getString("ch_Upassword09").length());
                System.out.println(password);
                System.out.println(rst.getInt("ch_Utpye09"));
                if(rst.getString("ch_Upassword09").equals(password))
                {
                    if(rst.getInt("ch_Utpye09")==1)
                        return "student";
                    else if(rst.getInt("ch_Utpye09")==2)
                        return "teacher";
                    else
                        return "manager";
                }
                else
                    return "密码错误";
            }
            else return "用户名不存在";
        } catch (Exception se) {
            se.printStackTrace();
            return "验证失败";
        }
    }
}
