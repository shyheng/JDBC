package 模糊查询;

import 简化JDBC.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试JHJDBC
 * 模糊查询
 */
public class JDBC13 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbc1.getConnection();
            String sql = "select ename from emp where ename like ? ";
            ps =  conn.prepareStatement(sql);
            ps.setString(1,"_A%");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc1.close(conn,ps,rs);
        }
    }
}
