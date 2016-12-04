package fr.talk.androidtests.how.compositionvsinheritance;

import android.content.Context;
import android.widget.Toast;

public class Messenger {

    private final Context context;

    public Messenger(Context context) {
        this.context = context;
    }

    void showMessage(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(int messageId) {
        Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show();
    }
}
