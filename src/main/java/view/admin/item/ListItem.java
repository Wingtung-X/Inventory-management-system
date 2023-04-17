package view.admin.item;



import actionHandler.admin.ItemHandler;

import javax.swing.*;
import java.util.Vector;

public class ListItem extends JDialog {
    private JTable jTable;

    public ListItem() {
        setTitle("Item List");
        setSize(500, 300);
//        get data


//        set header
        Vector<String> header = new Vector<String>();
        header.add("id");
        header.add("item name");
        header.add("item price");
        header.add("description");

        ItemHandler itemHandler = new ItemHandler();
        Vector<Vector<String>> itemList = itemHandler.listItemHandler();

        jTable = new JTable(itemList,header);
        add(new JScrollPane(jTable));
        setVisible(true);

    }
}
