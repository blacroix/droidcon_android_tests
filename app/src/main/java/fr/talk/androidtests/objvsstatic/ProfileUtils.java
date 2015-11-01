package fr.talk.androidtests.objvsstatic;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class ProfileUtils {

    public static final String NAME = "NAME";
    public static final String CURRENT_USER = "CURRENT_USER";

    public static String getCurrentUserName(@NonNull Context context) {
        SharedPreferences preferences = context.getSharedPreferences(CURRENT_USER, Context.MODE_PRIVATE);
        return preferences.getString(NAME, null);
    }
}
