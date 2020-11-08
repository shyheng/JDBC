import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 背代码
 */
public class JDBC3 {
    public static void main(String[] args) {
        try {
//        1注册驱动
//            这是第一种
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            注册驱动的常用
//            不需要接受返回值
            Class.forName("com.mysql.jdbc.Driver");

//        2,获取连接
            Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","3333");
            System.out.println(co);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
