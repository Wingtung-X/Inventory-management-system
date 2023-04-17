package view.admin.store;



import actionHandler.admin.StoreHandler;

import javax.swing.*;
import java.awt.*;

public class DeleteStore extends JDialog {
    private JLabel deleteLabel = new JLabel("Store id");
    private JTextField deleteInput = new JTextField();
    private JButton deleteButton = new JButton("Delete");
    private GridLayout gridLayout = new GridLayout(2,2);
    private JPanel centerPanel = new JPanel(gridLayout);
    private JPanel southPanel = new JPanel(gridLayout);


    public DeleteStore() {
        super();
        setTitle("delete store");
        Container container= getContentPane();

        centerPanel.add(deleteLabel);
        centerPanel.add(deleteInput);

        southPanel.add(deleteButton);
        deleteButton.addActionListener(e->{
            int id = Integer.valueOf(deleteInput.getText());
            StoreHandler storeHandler = new StoreHandler();
            storeHandler.deleteStore(id);
        });


        container.add(centerPanel,BorderLayout.NORTH);
        container.add(southPanel,BorderLayout.SOUTH);

        setSize(600,400);
        setVisible(true);

    }
}
