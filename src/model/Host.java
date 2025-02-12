package model;

public class Host  extends Person{
    private int id;
   private String email;
   private String password;

   private String nickName;
   public Host(int id, String email, String password,String nickName) {
       this.id = id;
       this.email = email;
       this.password = password;
       this.nickName = nickName;
   }
   public Host(String nickName) {
       this.nickName = nickName;
   }

   public String getNickName() {
       return nickName;
   }

    public int getId() {
         return id;
    }
    public String getEmail() {
         return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }
}
