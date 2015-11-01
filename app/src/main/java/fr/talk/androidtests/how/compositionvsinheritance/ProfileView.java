package fr.talk.androidtests.how.compositionvsinheritance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import fr.talk.androidtests.R;

public class ProfileView extends BaseView {

    public ProfileView(Context context) {
        this(context, null);
    }

    public ProfileView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void updateName(Profile profile) {
        super.updateName(profile);
        if (profile != null) {
            if (profile.getName().length() > 3) {
                nameTextView.setText("A long name: " + profile.getName());
            } else {
                nameTextView.setText("A short name: " + profile.getName());
            }
        }
    }

    public void showNameInfo(Profile profile) {
        if (profile.getName().length() > 3) {
            showMessage("A long name");
        } else {
            showMessage(R.string.toast_short_name);
        }
    }
}
