import java.sql.*;
import java.util.ResourceBundle;

/**
 * 将连接数据库的所有信息配置到配置文件中
 *
 *
 * 实际开发中不建议把连接数据库写死到java程序中
 * 写到外面，安全性高
 */
public class JDBC4 {
    public static void main(String[] args) {
//        使用资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String dri = bundle.getString("dri");
        String url = bundle.getString("url");
        String uer = bundle.getString("uer");
        String pass = bundle.getString("pass");

        Connection c = null;
        Statement t = null;
        try {
//        1注册
            Class.forName(dri);
//        2上号
            c = DriverManager.getConnection(url,uer,pass);
//        3创建游戏人物
            t = c.createStatement();
//            4执行sql语句，开始完成人物
            String s = "update dept set dname = '销售',loc = '津' where deptno = 10";
            int cun = t.executeUpdate(s);
            System.out.println(cun==1?"保存":"错了");

//            5

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

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
