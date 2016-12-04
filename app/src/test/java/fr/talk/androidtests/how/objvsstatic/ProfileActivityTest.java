package fr.talk.androidtests.how.objvsstatic;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProfileActivityTest {

    private ProfileActivity activity;

    @Mock
    TextView textView;

    @Before
    public void setUp() throws Exception {
        activity = new ProfileActivity();
        activity.profileNameTextView = textView;
    }

    @Test
    public void testUpdateProfileName_nameUnknown() throws Exception {
        // Given

        // When
        activity.updateProfileName();

        // Then
        Mockito.verify(textView).setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    @Test
    public void testUpdateProfileName_nameKnown() throws Exception {
        // Given

        // When
        activity.updateProfileName();

        // Then
        Mockito.verify(textView).setVisibility(View.VISIBLE);
        Mockito.verify(textView).setText("John");
    }
}