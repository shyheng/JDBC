import java.sql.*;

public class JDBC2 {
    public static void main(String[] args) {
        Connection c = null;
        Statement t = null;

        try {
//        1注册驱动
            Driver d = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(d);
//        2,获取连接
            String ulr ="jdbc:mysql://127.0.0.1:3306/shy";
            String uer ="root";
            String passworl ="520";
             c = DriverManager.getConnection(ulr,uer,passworl);
            System.out.println("数据对象  "+c);

//            3获取数据库的操作对象
             t = c.createStatement();

//            4执行sql语句
//            String s = "delete from dept where deptno = 40";
            String s = "update dept set dname = '销售部',loc = '天津' where deptno = 20";
            int cun = t.executeUpdate(s);
            System.out.println(cun==1?"保存":"错了");

//            5

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (t != null) {
                try {
                    t.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
