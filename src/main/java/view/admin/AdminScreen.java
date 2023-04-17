package view.admin;

import view.admin.item.AddItem;
import view.admin.item.DeleteItem;
import view.admin.item.ListItem;
import view.admin.item.UpdateItem;
import view.admin.store.AddStore;
import view.admin.store.DeleteStore;
import view.admin.store.ListStore;
import view.admin.store.UpdateStore;

import javax.swing.*;
import java.awt.*;

public class AdminScreen extends JFrame {

    JButton addStore = new JButton("Add store");
    JButton updateStore = new JButton("Update store");
    JButton deleteStore = new JButton("Delete store");
    JButton listStore = new JButton("List store");
    JButton addItems = new JButton("Add items");
    JButton updateItems = new JButton("Update items");
    JButton deleteItems = new JButton("Delete items");
    JButton listItems = new JButton("list items");
    GridLayout gridLayout = new GridLayout(4,2);
    JPanel rightPanel = new JPanel(gridLayout);
    JPanel leftPanel = new JPanel(gridLayout);
    public  AdminScreen(){
        super ("Admin");
        Container container= getContentPane();
        leftPanel.add(addStore);
        addStore.addActionListener(e->{
            new AddStore();
            System.out.println("add store clicked");
        });
        leftPanel.add(updateStore);
        updateStore.addActionListener(e->{
            new UpdateStore();
            System.out.println("update button clicked");
        });
        leftPanel.add(deleteStore);
        deleteStore.addActionListener(e->{
            new DeleteStore();
            System.out.println("delete button clicked");
        });

        leftPanel.add(listStore);
        listStore.addActionListener(e->{
            new ListStore();
            System.out.println("List store button clicked");
        });

        rightPanel.add(addItems);
        addItems.addActionListener(e->{
            new AddItem();
            System.out.println("add item button clicked");
        });
        rightPanel.add(updateItems);
        updateItems.addActionListener(e->{
            new UpdateItem();
            System.out.println("update item button clicked");
        });
        rightPanel.add(deleteItems);
        deleteItems.addActionListener(e->{
            new DeleteItem();
            System.out.println("delete item button clicked");
        });
        rightPanel.add(listItems);
        listItems.addActionListener(e->{
            new ListItem();
            System.out.println("list item button clicked");
        });

        container.add(leftPanel,BorderLayout.WEST);
        container.add(rightPanel,BorderLayout.EAST);

        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }
}