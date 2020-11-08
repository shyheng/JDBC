package 用户登录功能实现;

import java.sql.*;

public class JDBC10 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");
            /*String sql = "insert into dept(deptno,dname,loc) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,60);
            ps.setString(2,"销售部");
            ps.setString(3,"上海");*/

/*            String sql = "update dept set dname = ? ,loc =? where deptno = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1,"研发部");
            ps.setString(2,"云南");

            ps.setInt(3,60);*/

            String sql = "delete from dept where deptno =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,60);

            int cou =ps.executeUpdate();
            System.out.println(cou);

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
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
