package view.admin.store;
import actionHandler.admin.StoreHandler;

import javax.swing.*;
import java.awt.*;

public class UpdateStore extends JDialog {
    private JLabel idLabel = new JLabel("ID:");
    private JTextField idInput = new JTextField(20);
    private JLabel nameLabel = new JLabel("Name:");
    private JTextField nameInput = new JTextField(20);
    private JLabel addressLabel = new JLabel("Address:");
    private JTextField addressInput = new JTextField(20);
    private JLabel telLabel = new JLabel("Telephone:");
    private JTextField telInput = new JTextField(20);
    private JButton updateButton = new JButton("Update");

    private JPanel panel = new JPanel(new GridBagLayout());

    public UpdateStore() {
        super();
        setTitle("Update store by ID");
        Container container= getContentPane();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(idInput, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nameInput, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(addressInput, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(telLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(telInput, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(updateButton, gbc);
        updateButton.addActionListener(e->{
            int id = Integer.valueOf(idInput.getText());
            String name = String.valueOf(nameInput.getText());
            String address = String.valueOf(addressInput.getText());
            int tel = Integer.valueOf(telInput.getText());
            StoreHandler storeHandler = new StoreHandler();
            storeHandler.updateStoreHandler(id,name,address,tel);
        });

        container.add(panel, BorderLayout.CENTER);
        setSize(600, 400);
        setVisible(true);
    }
}
