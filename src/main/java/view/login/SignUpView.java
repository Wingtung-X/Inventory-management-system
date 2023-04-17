package view.login;

import actionHandler.login.SignUpHandler;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends JFrame {
    private JLabel nameLabel = new JLabel("Username:");
    private JTextField nameInput = new JTextField(20);
    private JLabel passwordLabel = new JLabel("Password:");
    private JPasswordField passwordInput = new JPasswordField(20);
    private JButton signUpButton = new JButton("Sign up");

    public SignUpView() {
        super("Sign Up");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(Box.createVerticalStrut(20));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(nameInput);
        panel.add(Box.createVerticalStrut(20));
        panel.add(passwordLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordInput);
        panel.add(Box.createVerticalStrut(20));
        panel.add(signUpButton);
        signUpButton.addActionListener(e -> {
            String userName = String.valueOf(nameInput.getText());
            String password = String.valueOf(passwordInput.getText());
            SignUpHandler signUpHandler = new SignUpHandler();
            if (userName.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Invalid user or password");
            }else {
                signUpHandler.signUp(userName, password);
            }

        });
        panel.add(Box.createVerticalStrut(20));

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
