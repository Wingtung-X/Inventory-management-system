package dao;

import jdbc.DBConnection;
import data.SignUp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpDAO {
    Connection conn = DBConnection.getConn();

    //    add data
    public boolean addUser(SignUp signup) {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "insert into signup (username, password, user_type) values (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, signup.getUsername());
            ps.setString(2, signup.getPassword());
            ps.setString(3, signup.getUser_type());
//          execute update
            ps.executeUpdate();
            DBConnection.close(null, ps, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean verifyUser(String username, String password, String user_type) {
        boolean result = false;

        String sql = "SELECT * FROM signup WHERE username=? AND password=? AND user_type=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, user_type);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DBConnection.close(rs, ps, conn);
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
