package fr.talk.androidtests.how.mvp;

import android.support.annotation.VisibleForTesting;

import fr.talk.androidtests.R;
import fr.talk.androidtests.how.compositionvsinheritance.Messenger;

class FormPresenter {

    private final FormActivity activity;
    private final Messenger messenger;

    //region constructor for test
    @VisibleForTesting
    FormPresenter(FormActivity activity, Messenger messenger) {
        this.activity = activity;
        this.messenger = messenger;
    }
    //endregion

    FormPresenter(FormActivity activity) {
        this.activity = activity;
        this.messenger = new Messenger(activity);
    }

    void checkForm(String username, String password) {
        if (isValid(username) && isValid(password)) {
            //region state logged
            activity.setStateLogged();
            messenger.showMessage(R.string.toast_success_login);
            //endregion
        } else {
            //region state login needed
            activity.setStateLoginNeeded();
            //endregion
        }
    }

    @VisibleForTesting
    private boolean isValid(String value) {
        //region check login
        return value != null && value.length() > 3;
        //endregion
    }
}
