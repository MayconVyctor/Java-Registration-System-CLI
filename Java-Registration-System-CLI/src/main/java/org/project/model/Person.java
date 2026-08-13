package org.project.model;

public class Person {
    private String name;
    private String email;
    private int age;
    private double height;

    public Person(String name, String email, int age, double height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return  "\n" + name + "\n" +
                email + "\n"+
                age + "\n" +
                height;
    }
}
