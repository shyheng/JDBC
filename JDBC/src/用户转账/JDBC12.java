package 用户转账;

import java.sql.*;

/**
 * drop table if exists t_act;
 * create table t_act(
 *      acton int,
 *      balance double(7,2)//注意7表示有效数字，2表示小数位的个数
 * );
 * insert into t_act(actno,balance) values(111,20000);
 * insert into t_act(actno,balance) values(222,0);
 * commit;
 * select * from t_act;
 *
 *
 *
 * con.setAutoCommit(false);
 * con.commit();//保存
 * con.rollback();//回滚
 */
public class JDBC12 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shy","root","520");

//            开启手动
            con.setAutoCommit(false);

            String sql = "update t_act set balance = ?  where  acton = ?";
            ps = con.prepareStatement(sql);
//转账
            ps.setDouble(1,1000);
            ps.setInt(2,111);
            int cu = ps.executeUpdate();



            ps.setDouble(1,1000);
            ps.setInt(2,222);
             cu += ps.executeUpdate();

            System.out.println(cu == 2?"转账成功":"转账失败");

//            程序到这没问题，可以手动提交
            con.commit();//保存
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();//回滚
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
