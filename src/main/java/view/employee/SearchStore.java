package view.employee;

import actionHandler.employee.SearchStoreHandler;

import javax.swing.*;
import java.awt.*;

public class SearchStore extends JDialog {
    private JLabel idLabel = new JLabel("Store ID:");
    private JTextField idInput = new JTextField(20);
    private JButton searchButton = new JButton("Search");

    private JTextArea resultArea = new JTextArea(10, 50);
    private JScrollPane scrollPane = new JScrollPane(resultArea);

    public SearchStore() {
        super();
        setTitle("Search Store by ID");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        inputPanel.add(idLabel);
        inputPanel.add(idInput);
        inputPanel.add(searchButton);
        searchButton.addActionListener(e -> {
            SearchStoreHandler searchStoreHandler = new SearchStoreHandler();
            int id = Integer.valueOf(idInput.getText());
            String result = searchStoreHandler.searchHandler(id);
            resultArea.setText(result);
        });

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
