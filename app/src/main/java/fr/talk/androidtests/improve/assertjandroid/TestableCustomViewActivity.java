package fr.talk.androidtests.improve.assertjandroid;

import android.app.Activity;
import android.os.Bundle;

import fr.talk.androidtests.R;

public class TestableCustomViewActivity extends Activity {

    TestableCustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testable_custom_view_activity);
        customView = (TestableCustomView) findViewById(R.id.custom_view);
    }
}
