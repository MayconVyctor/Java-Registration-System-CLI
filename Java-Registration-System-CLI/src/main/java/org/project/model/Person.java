package org.project.model;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private String email;
    private int age;
    private double height;
    private Map<String, String> additionalAnswers = new HashMap<>();

    public Person(String name, String email, int age, double height, Map<String, String> additionalAnswers) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
        this.additionalAnswers = additionalAnswers;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, String> getAdditionalAnswers() {
        return additionalAnswers;
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
                height + "\n" +
                String.join(", ", additionalAnswers.values());
    }
}
