package fr.talk.androidtests.improve.junitparams;

public class ConcertRoom {

    private final int maxAvailablePlaces;

    private int spectatorsCount;

    public ConcertRoom(int maxAvailablePlaces) {
        this.maxAvailablePlaces = maxAvailablePlaces;
    }


    public int getSpectatorsCount() {
        return spectatorsCount;
    }

    public void setSpectatorsCount(int spectatorsCount) {
        if (spectatorsCount < 0 || spectatorsCount > maxAvailablePlaces) {
            throw new IllegalArgumentException("Too many spectators for this room");
        }
        this.spectatorsCount = spectatorsCount;
    }

    public boolean isFull() {
        return spectatorsCount == maxAvailablePlaces;
    }
}
