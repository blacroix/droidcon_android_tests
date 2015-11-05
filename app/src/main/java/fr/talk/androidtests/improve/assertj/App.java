package fr.talk.androidtests.improve.assertj;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class App implements Comparable<App> {

    private final String packageName;
    private final float note;

    public App(@NonNull String packageName, float note) {
        this.packageName = packageName;
        this.note = note;
    }

    //region compare
    @Override
    public int compareTo(@Nullable App another) {
        return another == null ? -1 : Float.compare(note, another.note);
    }
    //endregion

    //region equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof App)) return false;

        App app = (App) o;

        return packageName.equals(app.packageName);

    }
    //endregion

    //region hashCode
    @Override
    public int hashCode() {
        return packageName.hashCode();
    }
    //endregion
}
