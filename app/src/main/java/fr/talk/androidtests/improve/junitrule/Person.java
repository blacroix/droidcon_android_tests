package fr.talk.androidtests.improve.junitrule;

public class Person {

    private final int age;

    public Person(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Age must be positive");
        }

        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
