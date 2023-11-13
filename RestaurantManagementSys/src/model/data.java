package model;

public class data {
    public int id;
    public static String username;
    public String password;

    public data(int id, String username, String password){
        this.id = id;
        data.username = username;
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
