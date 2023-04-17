package dao;


import data.Item;
import data.Store;
import jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class StoreDAO {

//    add store
public boolean addStore(Store store) {
//        connect db
    Connection conn = DBConnection.getConn();
//      sql prepared statement
    String sql = "insert into store_info (name, address, tel) values (?, ?, ?)";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, store.getName());
        ps.setString(2, store.getAddress());
        ps.setInt(3, store.getTel());
//          execute update
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

//  update store

    public boolean updateStore(Store store) {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "update store_info set name=?,address=?,tel=? where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, store.getName());
            ps.setString(2, store.getAddress());
            ps.setInt(3, store.getTel());
//        id of update item
            ps.setInt(4, store.getId());

            boolean result = ps.executeUpdate() > 0;
//        close DB
            DBConnection.close(null, ps, conn);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    delete store

public boolean deleteStore(int id) {
//        connect db
    Connection conn = DBConnection.getConn();
//      sql prepared statement
    String sql = "delete from store_info where id=?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
//        id of delete item
        ps.setInt(1, id);

        boolean result = ps.executeUpdate() > 0;
//        close DB
        DBConnection.close(null, ps, conn);
        return result;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

//   search by id
    public String searchStore(int id) {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "select * from store_info where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//        id of search item
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Store searchStore = new Store();
            while (rs.next()) {   //execute if the table have next column
                searchStore.setId(rs.getInt(1));
                searchStore.setName(rs.getString(2));
                searchStore.setAddress(rs.getString(3));
                searchStore.setTel(rs.getInt(4));
            }
//        close DB
            DBConnection.close(rs, ps, conn);
            return ("Store id: " + searchStore.getId()+"\n"+
                    "Store name: "+ searchStore.getName()+"\n"+
                    "Store address: " +  searchStore.getAddress() + "\n"+
                    "Store tel: " + searchStore.getTel() + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //out put all stores
    public List<Store> getAll() {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "select * from store_info";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//        id of search item
            ResultSet rs = ps.executeQuery();

            List<Store> storeList = new ArrayList<Store>();
            while (rs.next()) {   //execute if the table have next column
                Store store = new Store();
                store.setId(rs.getInt(1));
                store.setName(rs.getString(2));
                store.setAddress(rs.getString(3));
                store.setTel(rs.getInt(4));
                storeList.add(store);
            }
//        close DB
            DBConnection.close(rs, ps, conn);
            return storeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //out put all stores
    public Vector<Vector<String>> getAllForTable() {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "select * from store_info";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//        id of search item
            ResultSet rs = ps.executeQuery();

            Vector<Vector<String>> storeList= new Vector<Vector<String>>();
            while (rs.next()) {   //execute if the table have next column
                Vector<String> store = new Vector<String>();
                store.add(rs.getString(1));
                store.add(rs.getString(2));
                store.add(rs.getString(3));
                store.add(rs.getString(4));
                storeList.add(store);
            }
//        close DB
            DBConnection.close(rs, ps, conn);
            return storeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
