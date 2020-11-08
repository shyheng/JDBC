package JDBC事务机制;

import java.sql.*;

/**
 * JDBC事务机制
 *      事务机制同时进行，无法做到全部成功全部失败，无法保证安全
 *
 *
 */
public class JDBC11  {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");

            String sql = "update dept set dname = ? where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,"神部门");
            ps.setInt(2,30);

            int cou =ps.executeUpdate();
            System.out.println(cou);//执行第一次

//            重新给占位符传值
            ps.setString(1,"门");
            ps.setInt(2,20);

            int cou1 =ps.executeUpdate();
            System.out.println(cou1);//执行第二次
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
