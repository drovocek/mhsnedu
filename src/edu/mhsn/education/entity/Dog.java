package edu.mhsn.education.entity;

public class Dog {

    private Integer key;
    private String name;

    public boolean isNew() {
        return this.key == null;
    }

    public Dog(String name) {
        this.name = name;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
