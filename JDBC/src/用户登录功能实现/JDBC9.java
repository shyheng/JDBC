package 用户登录功能实现;

import java.sql.*;
import java.util.Scanner;

public class JDBC9 {
    public static void main(String[] args) {
/*
//        用户台使用，升序降序用Statement
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.print("请输入 ");
        String keyw = s.nextLine();

//        执行SQL
        Connection con = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");
            String sql = "select ename from emp order by ename ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,keyw);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
*/
//        用户台使用，升序降序用Statement
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.print("请输入 ");
        String keyw = s.nextLine();

//        执行SQL
        Connection con = null;
        Statement stat =null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");
//           获取对象
            stat = con.createStatement();
//            执行SQL
            String sql = "select ename from emp order by ename "+keyw;
            rs = stat.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
