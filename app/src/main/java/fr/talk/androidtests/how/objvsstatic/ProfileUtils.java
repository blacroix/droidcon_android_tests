package fr.talk.androidtests.how.objvsstatic;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

class ProfileUtils {

    private static final String NAME = "NAME";
    private static final String CURRENT_USER = "CURRENT_USER";

    static String getCurrentUserName(@NonNull Context context) {
        SharedPreferences preferences = context.getSharedPreferences(CURRENT_USER, Context.MODE_PRIVATE);
        return preferences.getString(NAME, null);
    }
}
