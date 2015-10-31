package fr.talk.androidtests;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

public class ProfileView extends BaseView {

    public static final Profile profile = new Profile("John");

    public ProfileView(Context context) {
        this(context, null);
    }

    public ProfileView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        updateName(profile);
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
}
