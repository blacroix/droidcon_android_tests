package fr.talk.androidtests.how.mvp;

import android.support.annotation.VisibleForTesting;

import fr.talk.androidtests.R;
import fr.talk.androidtests.how.compositionvsinheritance.Messenger;

public class FormPresenter {

    private final FormActivity activity;
    private final Messenger messenger;

    //region
    @VisibleForTesting
    FormPresenter(FormActivity activity, Messenger messenger) {
        this.activity = activity;
        this.messenger = messenger;
    }
    //endregion

    public FormPresenter(FormActivity activity) {
        this.activity = activity;
        this.messenger = new Messenger(activity);
    }

    public void checkForm(String username, String password) {
        if (isValid(username) && isValid(password)) {
            //region
            activity.setStateLogged();
            messenger.showMessage(R.string.toast_success_login);
            //endregion
        } else {
            //region
            activity.setStateLoginNeeded();
            //endregion
        }
    }

    @VisibleForTesting
    boolean isValid(String value) {
        //region
        return value != null && value.length() > 3;
        //endregion
    }
}