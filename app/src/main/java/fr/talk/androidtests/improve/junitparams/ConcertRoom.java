package fr.talk.androidtests.improve.junitparams;

class ConcertRoom {

    private final int maxAvailablePlaces;

    private int spectatorsCount;

    ConcertRoom(int maxAvailablePlaces) {
        this.maxAvailablePlaces = maxAvailablePlaces;
    }


    public int getSpectatorsCount() {
        return spectatorsCount;
    }

    void setSpectatorsCount(int spectatorsCount) {
        if (spectatorsCount < 0 || spectatorsCount > maxAvailablePlaces) {
            throw new IllegalArgumentException("Too many spectators for this room");
        }
        this.spectatorsCount = spectatorsCount;
    }

    boolean isFull() {
        return spectatorsCount == maxAvailablePlaces;
    }
}
