package fr.talk.androidtests.how.compositionvsinheritance;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RuntimeEnvironment;

import fr.talk.androidtests.CustomRobolectricTestRunner;
import fr.talk.androidtests.R;

@RunWith(CustomRobolectricTestRunner.class)
public class ProfileViewTest {

    private ProfileView view;

    private TextView textView = Mockito.mock(TextView.class);

    //region composition view manager
    private ViewManager viewManager = Mockito.mock(ViewManager.class);
    //endregion

    //region composition messenger
    private Messenger messenger = Mockito.mock(Messenger.class);
    //endregion

    @Before
    public void setUp() throws Exception {
        view = new ProfileView(RuntimeEnvironment.application);
        view.nameTextView = textView;

        //region composition view manager
        view.viewManager = viewManager;
        //endregion

        //region messenger
        view.messenger = messenger;
        //endregion
    }

    @SuppressLint("SetTextI18n")
    @Test
    public void testUpdateName_small() throws Exception {
        // Given
        Profile profile = new Profile("Jo");

        // When
        view.updateName(profile);

        // Then
        Mockito.verify(textView).setText("A short name: Jo");

        //region inheritance way
        Mockito.verify(textView).setVisibility(View.GONE);
        //endregion

        //region composition way
        Mockito.verify(viewManager).manageVisibility(profile, textView);
        //endregion
    }

    @Test
    public void should_show_long_name_message() throws Exception {
        // Given

        // When
        view.showNameInfo(new Profile("John"));

        // Then
        Mockito.verify(messenger).showMessage("A long name");
    }

    @Test
    public void should_show_short_name_message_from_id() throws Exception {
        // Given

        // When
        view.showNameInfo(new Profile("Jo"));

        // Then
        Mockito.verify(messenger).showMessage(R.string.toast_short_name);
    }
}