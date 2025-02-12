package model;

public class Host  extends Person{
    private int id;
   private String email;
   private String password;

   public Host(int id, String email, String password) {
       this.id = id;
       this.email = email;
       this.password = password;
   }
    public Host(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
