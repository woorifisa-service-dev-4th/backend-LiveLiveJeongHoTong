package data;

public class HostDto {
    private int id;
    private String email;
    private String password;

    private HostDto(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class Builder {
        private int id;
        private String email;
        private String password;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public HostDto build() {
            return new HostDto(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    // getter 메서드들
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}