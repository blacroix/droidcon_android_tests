package fr.talk.androidtests.compositionvsinheritance;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RuntimeEnvironment;

import fr.talk.androidtests.CustomRobolectricTestRunner;

@RunWith(CustomRobolectricTestRunner.class)
public class ProfileViewTest {

    ProfileView view;

    TextView textView = Mockito.mock(TextView.class);

    @Before
    public void setUp() throws Exception {
        view = new ProfileView(RuntimeEnvironment.application);
        view.nameTextView = textView;
    }

    @Test
    public void testUpdateName_empty() throws Exception {
        // Given

        // When
        view.updateName(null);

        // Then
        Mockito.verify(textView).setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    @Test
    public void testUpdateName_small() throws Exception {
        // Given

        // When
        view.updateName(new Profile("Jo"));

        // Then
        Mockito.verify(textView).setText("A short name: Jo");
    }

    @SuppressLint("SetTextI18n")
    @Test
    public void testUpdateName_long() throws Exception {
        // Given

        // When
        view.updateName(new Profile("John"));

        // Then
        Mockito.verify(textView).setText("A long name: John");
    }

    @Test
    public void testShowNameInfo() throws Exception {
        // Given

        // When
        view.showNameInfo(new Profile("John"));

        // Then
        // TODO verify show message call
    }
}