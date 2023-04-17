package actionHandler.login;

import dao.SignUpDAO;
import data.SignUp;

public class SignUpHandler {

    public void signUp(String userName, String password){
        SignUp signUp = new SignUp();
        SignUpDAO signUpDAO = new SignUpDAO();
        signUp.setUsername(userName);
        signUp.setPassword(password);
        signUpDAO.addUser(signUp);
    }
}
