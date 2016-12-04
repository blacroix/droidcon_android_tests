package fr.talk.androidtests.how.objvssingleton;

class LibrarySingleton {

    private static final LibrarySingleton instance =
            new LibrarySingleton();

    private String name;

    private LibrarySingleton() {
        name = "Garry Poker";
    }

    static LibrarySingleton getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

}
