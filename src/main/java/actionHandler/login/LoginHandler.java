package actionHandler.login;

import dao.SignUpDAO;


public class LoginHandler {
    public boolean login(String inputName, String inputPassword, String typeSelected){
        SignUpDAO signUpDAO = new SignUpDAO();
        return (signUpDAO.verifyUser(inputName,inputPassword,typeSelected) == true );
    }
}
