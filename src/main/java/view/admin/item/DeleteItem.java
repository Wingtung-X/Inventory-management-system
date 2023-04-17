package view.admin.item;


import actionHandler.admin.ItemHandler;

import javax.swing.*;
import java.awt.*;

public class DeleteItem extends JDialog {
    private JLabel deleteLabel = new JLabel("Item id");
    private JTextField deleteInput = new JTextField();
    private JButton deleteButton = new JButton("Delete");
    private GridLayout gridLayout = new GridLayout(2,2);
    private JPanel centerPanel = new JPanel(gridLayout);
    private JPanel southPanel = new JPanel(gridLayout);

    public DeleteItem() {
        super();
        setTitle("delete item");
        Container container= getContentPane();

        centerPanel.add(deleteLabel);
        centerPanel.add(deleteInput);

        southPanel.add(deleteButton);
        deleteButton.addActionListener(e->{
            int id = Integer.valueOf(deleteInput.getText());
            ItemHandler itemHandler = new ItemHandler();
            itemHandler.deleteItemHandler(id);
        });

        container.add(centerPanel,BorderLayout.NORTH);
        container.add(southPanel,BorderLayout.SOUTH);

        setSize(600,400);
        setVisible(true);

    }
}
