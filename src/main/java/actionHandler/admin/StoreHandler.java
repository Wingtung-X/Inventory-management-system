package actionHandler.admin;

import dao.StoreDAO;
import data.Store;

import javax.swing.*;
import java.util.Vector;

public class StoreHandler {
    public void addStoreHandler(String nameInput, String addressInput, int telInput){
        StoreDAO storeDAO = new StoreDAO();
        Store addStore = new Store();
        addStore.setName(nameInput);
        addStore.setAddress(addressInput);
        addStore.setTel(telInput);
        System.out.println("add clicked");
        storeDAO.addStore(addStore);
    }
    public void deleteStore(int id){
        StoreDAO storeDAO = new StoreDAO();
        storeDAO.deleteStore(id);
    }
    public Vector<Vector<String>> ListStoreHandler(){
//        get data
        StoreDAO storeDAO = new StoreDAO();
        Vector<Vector<String>> storeList = storeDAO.getAllForTable();
        return storeList;
    }

    public void updateStoreHandler(int id, String name, String address, int tel){
        StoreDAO storeDAO = new StoreDAO();
        Store updateStore = new Store();
        updateStore.setId(id);
        updateStore.setName(name);
        updateStore.setAddress(address);
        updateStore.setTel(tel);
        System.out.println("update click");
        storeDAO.updateStore(updateStore);
    }
}
