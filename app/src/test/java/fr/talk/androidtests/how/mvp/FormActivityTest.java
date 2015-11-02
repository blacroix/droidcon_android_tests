package fr.talk.androidtests.how.mvp;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import fr.talk.androidtests.CustomRobolectricTestRunner;

import static org.assertj.android.api.Assertions.*;

@RunWith(CustomRobolectricTestRunner.class)
public class FormActivityTest {

    private FormActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(FormActivity.class);
    }

    @Test
    public void testOnCreate() throws Exception {
        Assertions.assertThat(activity.loginEditText).isNotNull();
        assertThat(activity.loginEditText).isVisible();
    }
}