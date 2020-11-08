package 用户登录功能实现;

import java.sql.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * 1需求，模拟用户登录功能的实现
 *    2业务需求
 *        程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码
 *        用户输入用户名和密码之后 ，提交信息，java程序收集到用户信息
 *        java程序链接数据库验证用户名和密码是否合法
 *        合法  显示登陆成功
 *        不合法  显示 登陆失败
 *     3数据准备
 *     在实际开发中 ，表的设计会使用专业的建模工具，PowerDesigner
 *
 *     用户名
     * fdsa
     * 密码
     * fdsa' or '1'='1
 *     登陆成功
 *     SQL注入（安全隐患），黑客和程序员常用
 *
 *      导致用户信息的非法信息编译进去了。原来SQL语句的含义被扭曲
 *
 *      PreparedStatement比Statement效率高，安全高，错误低
 *
 *      所以很大方面使用PreparedStatement
 *      Statement如果需要SQL需要拼接的，项目开发需要SQL写的
 */
public class jBDC7 {
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
        Statement stmt = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cor = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");
            stmt = cor.createStatement();
            String sql = "select * from t_use where logname ='"+logname+"' and logpass='"+logpass+"'";
//            以下代码正好完成了SQL语句的拼接，以下代码的含义是，发送SQL语句给DBMS，DBMC进行SQL编译
//            导致用户信息的非法信息编译进去了。原来SQL语句的含义被扭曲
            res = stmt.executeQuery(sql);
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
            if (stmt != null) {
                try {
                    stmt.close();
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
