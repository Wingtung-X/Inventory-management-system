package view.admin.item;

import actionHandler.admin.ItemHandler;

import javax.swing.*;
import java.awt.*;

public class UpdateItem extends JDialog {
    private JLabel idLabel = new JLabel("ID:");
    private JTextField idInput = new JTextField(20);
    private JLabel nameLabel = new JLabel("Item Name:");
    private JTextField nameInput = new JTextField(20);
    private JLabel priceLabel = new JLabel("Price:");
    private JTextField priceInput = new JTextField(20);
    private JLabel descriptionLabel = new JLabel("Description:");
    private JTextField descriptionInput = new JTextField(20);
    private JButton updateButton = new JButton("Update");

    private JPanel panel = new JPanel(new GridBagLayout());

    public UpdateItem() {
        super();
        setTitle("Update Item by ID");
        Container container= getContentPane();

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // add padding

        // add ID label and input field
        c.gridx = 0;
        c.gridy = 0;
        panel.add(idLabel, c);

        c.gridx = 1;
        panel.add(idInput, c);

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
        panel.add(updateButton, c);
        updateButton.addActionListener(e->{
            int id = Integer.valueOf(idInput.getText());
            String name = String.valueOf(nameInput.getText());
            int price = Integer.valueOf(priceInput.getText());
            String description = String.valueOf(descriptionInput.getText());
            ItemHandler itemHandler = new ItemHandler();
            itemHandler.updateItemHandler(id,name,price,description);
        });

        container.add(panel, BorderLayout.CENTER);

        setSize(600, 400);
        setVisible(true);
    }
}