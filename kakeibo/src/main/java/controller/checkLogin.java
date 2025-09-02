package controller;

public class checkLogin {
    public boolean exitAcount (String username, String password) {
        UsersDAO dao = new UsersDAO();
        int result = dao.checkAccount(username, password);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }
}
