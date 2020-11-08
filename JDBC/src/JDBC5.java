import java.sql.*;

public class JDBC5 {
    public static void main(String[] args) {
        Connection co = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/shy","root","3333");
            st = co.createStatement();
            String sql = "select * from users";
//            st.executeUpdate()改的。返回数量
//            executeQuery()  返回ResultSet,就mysql里面的
            rs = st.executeQuery(sql);//查,专门执行DQL语句的方法
//5处理查询结果集
//            遍历
            while (rs.next()){
//                getSting()方法的特点，不管是什么都以Sting
                /*String empno= rs.getString(1);
                String ename= rs.getString(2);
                String sal= rs.getString(3);
                System.out.println(empno+","+ename+","+sal);*/


/*                String empno= rs.getString("a");
                String ename= rs.getString("ename");
                String sal= rs.getString("sal");
                System.out.println(empno+","+ename+","+sal);*/

                /*int empno= rs.getInt(1);
                String ename= rs.getString("ename");
                double sal= rs.getDouble(3);
                System.out.println(empno+","+ename+","+sal);*/


                int empno= rs.getInt("a");
                String ename= rs.getString("ename");
                double sal= rs.getDouble("sal");
                System.out.println(empno+","+ename+","+sal);




            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (co != null) {
                try {
                    co.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
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
