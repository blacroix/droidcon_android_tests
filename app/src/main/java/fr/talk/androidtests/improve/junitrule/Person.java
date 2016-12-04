package fr.talk.androidtests.improve.junitrule;

class Person {

    private final int age;

    Person(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive");
        }

        this.age = age;
    }

    int getAge() {
        return age;
    }
}
