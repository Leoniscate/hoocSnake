package Snake;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
        public static void main(String[] args){

            Connection conn= getConnection("root", "root"); //获取数据库连接
            /*,,,,此处为方法名来获取连接,例如 query(conn),,,,,*/
            releaseConnection(conn); // 释放数据库连接
        }

        /*,,,,,,,,,,此处构建一个你想要的功能的方法,,,,,,,,,,,,*/


        //数据库连接
        public static Connection getConnection(String user, String pass) {

            Connection conn = null;//声明连接对象
            String driver = "com.mysql.jdbc.Driver";// 驱动程序类名
            String url = "jdbc:mysql://localhost:3306/snakegame?" // 数据库URL
                    + "useUnicode=true&characterEncoding=UTF8";// 防止乱码
            try {
                Class.forName(driver);// 注册(加载)驱动程序
                conn = DriverManager.getConnection(url, user, pass);// 获取数据库连接
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
        // 释放数据库连接
        public static void releaseConnection(Connection conn) {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}
