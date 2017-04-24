package fr.talk.androidtests.how.mvp;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class FormActivityTest {

    private FormActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(FormActivity.class);
    }

    @Test
    public void should_be_state_connection_needed() throws Exception {
        Assertions.assertThat(activity.loginEditText).isVisible();
        Assertions.assertThat(activity.passwordEditText).isVisible();
        Assertions.assertThat(activity.connectButton).isVisible();
    }

    @Test
    public void should_be_disable_on_state_connected() throws Exception {
        // Given

        // When
        activity.setStateLogged();

        // Then
        Assertions.assertThat(activity.loginEditText).isDisabled();
        Assertions.assertThat(activity.passwordEditText).isDisabled();
        Assertions.assertThat(activity.connectButton).isDisabled();
    }
}