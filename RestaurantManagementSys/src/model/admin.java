package model;

public class admin {
    public int id;
    public static String username;
    public String password;

    public admin(int id, String username, String password){
        this.id = id;
        admin.username = username;
        this.password = password;
    }

    public int getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
