package fr.talk.androidtests.objvssingleton;

public class LibrarySingleton {

    private static final LibrarySingleton instance = new LibrarySingleton();
    private String name;

    private LibrarySingleton() {
        name = "Garry Poker";
    }

    public static LibrarySingleton getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

}
