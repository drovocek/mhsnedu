package edu.mhsn.education.entity;

public class User {

    private Integer key;
    private String firstName;
    private String email;
    private int age;

    public boolean isNew() {
        return this.key == null;
    }

    public User() {
    }

    public User(String firstName, String email, int age) {
        this.firstName = firstName;
        this.email = email;
        this.age = age;
    }

    public User(int key, String firstName, String email, int age) {
        this.key = key;
        this.firstName = firstName;
        this.email = email;
        this.age = age;
    }

    public int getKey() {
        return key;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "key=" + key +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
