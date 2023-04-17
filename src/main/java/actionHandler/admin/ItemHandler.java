package actionHandler.admin;

import dao.ItemDAO;
import data.Item;

import java.util.Vector;

public class ItemHandler {
    public void addItemHandler(String name, int price, String description){
        ItemDAO itemDAO = new ItemDAO();
        Item addItem = new Item();
        addItem.setItemName(name);
        addItem.setItemPrice(price);
        addItem.setDescription(description);
        System.out.println("add clicked");
        itemDAO.addItem(addItem);
    }
    public void deleteItemHandler(int id){
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.deleteItem(id);
    }
    public Vector<Vector<String>> listItemHandler(){
        ItemDAO itemDAO = new ItemDAO();
        Vector<Vector<String>> itemList = itemDAO.getAllForTable();
        return itemList;
    }

    public void updateItemHandler(int id, String name, int price, String description){
        ItemDAO itemDAO = new ItemDAO();
        Item updateItem = new Item();
        updateItem.setId(id);
        updateItem.setItemName(name);
        updateItem.setItemPrice(price);
        updateItem.setDescription(description);
        System.out.println("update click");
        itemDAO.updateItem(updateItem);
    }
}
