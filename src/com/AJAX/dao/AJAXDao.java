package com.AJAX.dao;

import com.AJAX.entity.name;
import java.sql.*;

public class AJAXDao {
    public String querybyid(Integer Id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";

        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String username = "root";
        String password = "123";

        String name = "";
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            sql = "select name from sex where id=?";
            pst = conn.prepareStatement(sql);
            //设置参数
            pst.setInt(1, Id);
            //执行sql
            rs = pst.executeQuery();

            if (rs.next()) {
                name = rs.getString("name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (conn != null) {
                    conn.close();
                }

                if (pst != null) {
                    pst.close();
                }

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }

        }
        return name;
    }

    /**
     * 根据id 查询所有
     * @param Id
     * @return
     */
    public name queryallbyid(Integer Id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";

        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String username = "root";
        String password = "123";

        name name = null;
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            sql = "select id,name,sex from name where id=?";
            pst = conn.prepareStatement(sql);
            //设置参数
            pst.setInt(1, Id);
            //执行sql
            rs = pst.executeQuery();

            if (rs.next()) {
                name  = new name();
                name.setId(rs.getInt("id"));
                name.setSex(rs.getString("sex"));
                name.setName(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (conn != null) {
                    conn.close();
                }

                if (pst != null) {
                    pst.close();
                }

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }

        }
        return name;
    }
}
