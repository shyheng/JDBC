package 用户登录功能实现;

import java.sql.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * 解决SQL注入的问题
 *    用户提供的信息不参与SQL语句
 *   用PreparedStatement进行预先处理
 *
 *    用户使用SQL语句
 *
 */
public class JDBC8 {
    public static void main(String[] args) {
//        初始化界面
        Map<String,String> usr= initUI();
//        验证用户密码
        boolean logc = login(usr);
//        最后输出结果
        System.out.println(logc?"登陆成功":"登陆失败");
    }

    /**
     * 用户登录
     * @param usr 用户登录信息
     * @return false表示失败，true表示成功
     */
    private static boolean login(Map<String, String> usr) {
//        打标机
        boolean login = false;
//        单独定义变量
        String logname = usr.get("logname");
        String logpass = usr.get("logpass");

//        JDBC
        Connection cor = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cor = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");
//            3获取预编译对象
//            ？是一个占位符，一个？一个值
            String sql = "select * from t_use where logname =? and logpass=?";//sql语句框架，一个
//            程序到这，进行预先编译，
            ps = cor.prepareStatement(sql);
            ps.setString(1,logname);
            ps.setString(2,logpass);
//            以下代码正好完成了SQL语句的拼接，以下代码的含义是，发送SQL语句给DBMS，DBMC进行SQL编译
//            导致用户信息的非法信息编译进去了。原来SQL语句的含义被扭曲
//执行sql
            res = ps.executeQuery();
//            处理结果集
            if (res.next()){
//                登录成功
                login = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (cor != null) {
                try {
                    cor.close();
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
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return login;
    }

    /**
     * 初始化用户界面
     * @return 用户界面的用户名和密码信息
     */
    private static Map<String,String> initUI() {
        Scanner s = new Scanner(System.in);

        System.out.println("用户名");
        String logname =s.nextLine();

        System.out.println("密码");
        String logpass = s.nextLine();

        Map<String,String> uselog = new Hashtable<>();

        uselog.put("logname",logname);
        uselog.put("logpass",logpass);

        return uselog;
    }


}
