import java.sql.*;

/**
 * 背代码,不接带任何工具
 */
public class JDBC1  {
    public static void main(String[] args) {
//       1注册驱动
        Connection conn =null;
        Statement statement=null;
        try {
            Driver driver =new com.mysql.jdbc.Driver();//多态父类指向子类
            DriverManager.registerDriver(driver);
//        2获取连接
            /**
             * url统一资源定位符（网络中的某个资源的绝对路径
             * http://通信协议
             * 182.61.200.7服务器IP地址
             * 80 服务器上的软件的端口
             * index.html是服务器上的某个资源名
             *
             *
             * jdbc:mysql://127.0.0.1:3306/shy
             * jdbc:mysql://  协议
             * 127.0.0.1 IP地址
             * 3306 MySQL端口号
             * shy具体的数据库实例名
             *
             *
             * 通信协议，是通信之前就提前订好的格式
             * 数据包怎么传数据，格式提前订好。
             *
             *
             *
             */
            String  url = "jdbc:mysql://127.0.0.1:3306/shy";
            String user = "root";
            String password = "520";
             conn = DriverManager.getConnection(url,user,password);
//            数据连接对象com.mysql.jdbc.JDBC4Connection@279ad2e3
            System.out.println("数据连接对象"+conn);

//        3获取数据库操作对象
//            Statement专门执行sql语句的
             statement = conn.createStatement();

//        4执行sql
            String sql = "insert into dept(deptno,dname,loc) values(50,'人事部','北京')";
//            专门执行DML语句
//            返回值是影响数据库中的记录条数
            int cout = statement.executeUpdate(sql);
            System.out.println(cout==1?"保存":"保存失败");

//        5处理查询结果集


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//        6释放资源
//            为了保证资源一定释放
//            遵循从小到大依次关闭
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }







    }
}
