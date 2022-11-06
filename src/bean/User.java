package bean;

public class User {
    private String name;
    private String number;

    public User() {
    }

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "bean.User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
