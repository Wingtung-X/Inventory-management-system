package dao;

import data.Item;
import jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ItemDAO {
    public boolean addItem(Item item) {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "insert into items_info (ItemName, ItemPrice, Description) values (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getItemPrice());
            ps.setString(3, item.getDescription());
//          execute update
            ps.executeUpdate();
            DBConnection.close(null, ps, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //    update use id
    public boolean updateItem(Item item) {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "update items_info set ItemName=?,ItemPrice=?,Description=? where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getItemPrice());
            ps.setString(3, item.getDescription());
//        id of update item
            ps.setInt(4, item.getId());

            boolean result = ps.executeUpdate() > 0;
//        close DB
            DBConnection.close(null, ps, conn);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //delete item
    public boolean deleteItem(int id) {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "delete from items_info where id=?";
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

    //search item (specific item)
    public Item searchItem(int id) {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "select * from items_info where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//        id of search item
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Item searchItem = new Item();
            while (rs.next()) {   //execute if the table have next column
                searchItem.setId(rs.getInt(1));
                searchItem.setItemName(rs.getString(2));
                searchItem.setItemPrice(rs.getInt(3));
                searchItem.setDescription(rs.getString(4));
            }
//        close DB
            DBConnection.close(rs, ps, conn);
            return searchItem;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //out put all items
    public List<Item> getAll() {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "select * from items_info";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//        id of search item
            ResultSet rs = ps.executeQuery();

            List<Item> itemList = new ArrayList<Item>();
            while (rs.next()) {   //execute if the table have next column
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setItemName(rs.getString(2));
                item.setItemPrice(rs.getInt(3));
                item.setDescription(rs.getString(4));
                itemList.add(item);
            }
//        close DB
            DBConnection.close(rs, ps, conn);
            return itemList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vector<Vector<String>> getAllForTable() {
//        connect db
        Connection conn = DBConnection.getConn();
//      sql prepared statement
        String sql = "select * from items_info";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//        id of search item
            ResultSet rs = ps.executeQuery();

            Vector<Vector<String>> itemList= new Vector<Vector<String>>();
            while (rs.next()) {   //execute if the table have next column
                Vector<String> item = new Vector<String>();
                item.add(rs.getString(1));
                item.add(rs.getString(2));
                item.add(rs.getString(3));
                item.add(rs.getString(4));
                itemList.add(item);
            }
//        close DB
            DBConnection.close(rs, ps, conn);
            return itemList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
