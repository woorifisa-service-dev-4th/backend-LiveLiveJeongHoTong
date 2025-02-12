package model;

public class Host {

    private int id;
    private String email;
    private String password;

    public Host(String email) {
        this.email = email;
    }

    public int getId() {
         return id;
    }
    public String getEmail() {
         return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
         this.email = email;
    }




}
