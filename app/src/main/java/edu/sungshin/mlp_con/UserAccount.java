package edu.sungshin.mlp_con;

public class UserAccount {
    String emailId;
    String password;
    String idToken;

    public UserAccount(){    }

    public String getIdToken(){return idToken;}
    public void setIdToken(String idToken){ this.idToken = idToken;}
    public String getEmailId(){ return emailId; }
    public void setEmailId(String emailId){
        this.emailId = emailId;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
