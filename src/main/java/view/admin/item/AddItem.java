package view.admin.item;

import actionHandler.admin.ItemHandler;

import javax.swing.*;
import java.awt.*;

public class AddItem extends JDialog {
    private JLabel idLabel = new JLabel("ID:");
    private JTextField idInput = new JTextField(20);
    private JLabel nameLabel = new JLabel("Item Name:");
    private JTextField nameInput = new JTextField(20);
    private JLabel priceLabel = new JLabel("Price:");
    private JTextField priceInput = new JTextField(20);
    private JLabel descriptionLabel = new JLabel("Description:");
    private JTextField descriptionInput = new JTextField(20);
    private JButton addButton = new JButton("Add");

    private JPanel panel = new JPanel(new GridBagLayout());

    public AddItem() {
        super();
        setTitle("Add Item");
        Container container= getContentPane();

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // add padding


        // add Item Name label and input field
        c.gridx = 0;
        c.gridy = 1;
        panel.add(nameLabel, c);

        c.gridx = 1;
        panel.add(nameInput, c);

        // add Price label and input field
        c.gridx = 0;
        c.gridy = 2;
        panel.add(priceLabel, c);

        c.gridx = 1;
        panel.add(priceInput, c);

        // add Description label and input field
        c.gridx = 0;
        c.gridy = 3;
        panel.add(descriptionLabel, c);

        c.gridx = 1;
        panel.add(descriptionInput, c);

        // add Update button
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_END; // align to right
        panel.add(addButton, c);
        addButton.addActionListener(e->{
            String name = String.valueOf(nameInput.getText());
            int price = Integer.valueOf(priceInput.getText());
            String description = String.valueOf(descriptionInput.getText());
            ItemHandler itemHandler = new ItemHandler();
            itemHandler.addItemHandler(name, price, description);
        });

        container.add(panel, BorderLayout.CENTER);

        setSize(600, 400);
        setVisible(true);
    }
}
