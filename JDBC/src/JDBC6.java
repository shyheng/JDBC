import java.sql.*;

/**
 * 背，不用任何工具
 */
public class JDBC6 {
    public static void main(String[] args) {
        Connection co =null;
        Statement st = null;
        ResultSet  re = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            co= DriverManager.getConnection("jdbc:mysql://localhost:3306/shy","root","3333");
            st = co.createStatement();
            String sql ="";
            re = st.executeQuery(sql);
//            遍历
            while (re.next()){
                String zid =  "";
                String zid1 = "";
                String zid2 = "";
                System.out.println(zid+","+zid1+","+zid2);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            if (re != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
