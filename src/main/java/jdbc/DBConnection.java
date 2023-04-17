package jdbc;

import java.sql.*;

public class DBConnection {
    public static  String Driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/5100Final?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static String user = "root";
    public static String pwd = "";

    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //    connect
    public static Connection getConn(){
        try {
            return DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    close

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn){
        try {
            if (rs != null){
                rs.close();
            }if (ps != null){
                ps.close();
            }if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

