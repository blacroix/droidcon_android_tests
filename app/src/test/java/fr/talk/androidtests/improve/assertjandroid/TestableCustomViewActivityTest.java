package fr.talk.androidtests.improve.assertjandroid;

import android.widget.LinearLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import fr.talk.androidtests.CustomRobolectricTestRunner;

import static org.assertj.android.api.Assertions.assertThat;

@RunWith(CustomRobolectricTestRunner.class)
public class TestableCustomViewActivityTest {

    private TestableCustomViewActivity activity;
    private TestableCustomView customView;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(TestableCustomViewActivity.class);
        customView = activity.customView;

    }

    @Test
    public void should_show_message() throws Exception {
        customView.showMessage("Message");

        assertThat(customView).
                hasChildCount(2).
                hasOrientation(LinearLayout.VERTICAL);
        assertThat(customView.messageView).
                isVisible().
                hasText("Message");
        assertThat(customView.errorView).isGone();
    }
}