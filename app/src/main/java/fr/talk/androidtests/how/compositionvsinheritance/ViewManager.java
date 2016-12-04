package fr.talk.androidtests.how.compositionvsinheritance;

import android.view.View;

class ViewManager {

    void manageVisibility(Object obj, View view) {
        if (obj == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

}
