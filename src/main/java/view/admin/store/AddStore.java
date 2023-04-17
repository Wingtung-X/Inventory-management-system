package view.admin.store;

import actionHandler.admin.StoreHandler;

import javax.swing.*;
import java.awt.*;

public class AddStore extends JDialog {
    private JLabel nameLabel = new JLabel("Name:");
    private JTextField nameInput = new JTextField(20);
    private JLabel addressLabel = new JLabel("Address:");
    private JTextField addressInput = new JTextField(20);
    private JLabel telLabel = new JLabel("Tel:");
    private JTextField telInput = new JTextField(20);
    private JButton addButton = new JButton("Add");

    private JPanel panel = new JPanel(new GridBagLayout());

    public AddStore() {
        super();
        setTitle("Add Store");
        Container container = getContentPane();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10);


        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nameInput, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(addressLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(addressInput, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(telLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(telInput, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(addButton, constraints);
        addButton.addActionListener(e->{
            String name = nameInput.getText();
            String address = addressInput.getText();
            int tel = Integer.valueOf(telInput.getText());
            StoreHandler storeHandler = new StoreHandler();
            storeHandler.addStoreHandler(name,address,tel);
        });

        container.add(panel, BorderLayout.CENTER);

        setSize(600, 400);
        setVisible(true);
    }
}
