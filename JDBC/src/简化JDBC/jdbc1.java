package 简化JDBC;

import java.sql.*;

/**
 * JDBC工具类
 * 简化JDBC编程
 */
public class jdbc1 {
//    工具类的构造方法都是私有的，因为可以直接调
    private jdbc1(){}
//    静态代码块在类加载时执行，并且只执行一次
    static {
    try {
        Class.forName("com.mysql.jdbc.Driver");


    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }

    /**
     * 获取连接
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");
    }

    /**
     * 关闭资源
     * @param conn 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集
      */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (conn != null) {
            try {
                conn.close();
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
}
