package view.admin.store;


import actionHandler.admin.StoreHandler;

import javax.swing.*;
import java.util.Vector;

public class ListStore extends JDialog {
    private JTable jTable;

    public ListStore() {
        setTitle("Store List");
        setSize(500, 300);
//        set header
        Vector<String> header = new Vector<String>();
        header.add("id");
        header.add("name");
        header.add("address");
        header.add("tel");

        StoreHandler storeHandler = new StoreHandler();
        Vector<Vector<String>> storeList = storeHandler.ListStoreHandler();

        jTable = new JTable(storeList,header);
        add(new JScrollPane(jTable));
        setVisible(true);

    }
}
