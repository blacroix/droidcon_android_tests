package fr.talk.androidtests.objvsstatic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.talk.androidtests.R;

public class ProfileActivity extends Activity {

    TextView profileNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileNameTextView = (TextView) findViewById(R.id.profileNameTextView);
    }

    /**
     * Update name or set as gone if name unknown
     */
    public void updateProfileName() {
        String name = ProfileUtils.getCurrentUserName(this);
        if (name == null) {
            profileNameTextView.setVisibility(View.GONE);
        } else {
            profileNameTextView.setVisibility(View.VISIBLE);
            profileNameTextView.setText(name);
        }
    }
}
