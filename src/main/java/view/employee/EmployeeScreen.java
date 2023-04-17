package view.employee;

import view.admin.item.ListItem;

import javax.swing.*;
import java.awt.*;

public class EmployeeScreen extends JFrame {
    private JButton searchStoreButton = new JButton("search store");
    private JButton viewStoreButton = new JButton();
    private JButton viewItemButton = new JButton("view item");

    private GridLayout gridLayout = new GridLayout(1,3);

    private JPanel panel = new JPanel(gridLayout);

    public EmployeeScreen(){
        super ("Employee");
        Container container= getContentPane();
        panel.add(searchStoreButton);
        searchStoreButton.addActionListener(e->{
            new SearchStore();
        });
        panel.add(viewItemButton);
        viewItemButton.addActionListener(e->{
            new ListItem();
        });

        container.add(panel,BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);

    }
}
