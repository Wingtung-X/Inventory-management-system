package data;

public class SignUp {
//    attribute

    private String username ;
    private String password;
    private String user_type = "employee";

// getter and setter


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type() {
        this.user_type = user_type;
    }
}
