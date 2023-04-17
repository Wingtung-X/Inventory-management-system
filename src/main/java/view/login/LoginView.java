package view.login;

import actionHandler.login.LoginHandler;
import view.admin.AdminScreen;
import view.employee.EmployeeScreen;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JLabel titleLabel = new JLabel("Welcome to Inventory Management System",JLabel.CENTER);

    SpringLayout springLayout = new SpringLayout();

    JPanel centerPanel = new JPanel(springLayout);
    private JLabel userNameLabel = new JLabel("Username:");
    private JTextField nameInput = new JTextField();
    private JLabel passwordLabel = new JLabel("Password:");
    private JPasswordField passwordInput = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton signUpButton = new JButton("Sign up");
    private JComboBox chooseView = new JComboBox<>(new String[]{"admin", "employee"});



    public LoginView() {
        Container container= getContentPane();

        titleLabel.setFont(new Font("Times New Roman",Font.PLAIN,20));
        titleLabel.setPreferredSize(new Dimension(0,30));


        userNameLabel.setPreferredSize(new Dimension(80,30));
        nameInput.setPreferredSize(new Dimension(200,30));
        passwordLabel.setPreferredSize(new Dimension(80,30));
        passwordInput.setPreferredSize(new Dimension(200,30));

        centerPanel.add(userNameLabel);
        centerPanel.add(nameInput);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordInput);
        centerPanel.add(loginButton);
        loginButton.addActionListener(e->{
            String inputName = nameInput.getText();
            char[] password = passwordInput.getPassword();
            String inputPassword = new String(password);
            String typeSelected = (String) chooseView.getSelectedItem();
            LoginHandler loginHandler = new LoginHandler();
            if (loginHandler.login(inputName,inputPassword,typeSelected) && typeSelected == "admin"){
                new AdminScreen();
            }else if (loginHandler.login(inputName,inputPassword,typeSelected) && typeSelected == "employee"){
                new EmployeeScreen();
            }else{
                JOptionPane.showMessageDialog(this,"Invalid user, password or user type.");
            }

        });

        centerPanel.add(signUpButton);
        signUpButton.addActionListener(e->{
            new SignUpView();
        });

        centerPanel.add(chooseView);


        wholeLayout();


        container.add(titleLabel,BorderLayout.NORTH);        container.add(centerPanel,BorderLayout.CENTER);

        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    //  getters for resetting username and password
    public JTextField getNameInput() {
        return nameInput;
    }

    public JPasswordField getPasswordInput() {
        return passwordInput;
    }

    public JComboBox getChooseView() {
        return chooseView;
    }


    private void wholeLayout() {

        Spring sWidth = Spring.sum(Spring.sum(Spring.width(userNameLabel), Spring.width(nameInput)), Spring.constant(20));
        int distance = sWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.WEST,userNameLabel,-distance, SpringLayout.HORIZONTAL_CENTER,centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH,userNameLabel,20,SpringLayout.NORTH,centerPanel);

        springLayout.putConstraint(SpringLayout.WEST,nameInput,20,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,nameInput,0,SpringLayout.NORTH,userNameLabel);

        springLayout.putConstraint(SpringLayout.EAST,passwordLabel,0,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordLabel,20,SpringLayout.SOUTH,userNameLabel);

        springLayout.putConstraint(SpringLayout.WEST,passwordInput,20,SpringLayout.EAST,passwordLabel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordInput,0,SpringLayout.NORTH,passwordLabel);

        springLayout.putConstraint(SpringLayout.WEST,loginButton,50,SpringLayout.WEST,passwordLabel);
        springLayout.putConstraint(SpringLayout.NORTH,loginButton,20,SpringLayout.SOUTH,passwordLabel);

        springLayout.putConstraint(SpringLayout.WEST,signUpButton,50,SpringLayout.EAST,loginButton);
        springLayout.putConstraint(SpringLayout.NORTH,signUpButton,0,SpringLayout.NORTH,loginButton);
    }
}

