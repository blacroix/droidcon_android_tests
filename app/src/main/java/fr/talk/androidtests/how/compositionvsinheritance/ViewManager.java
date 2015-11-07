package fr.talk.androidtests.how.compositionvsinheritance;

import android.view.View;

public class ViewManager {

    public void manageVisibility(Object obj, View view) {
        if (obj == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

}
