package fr.talk.androidtests.how.objvssingleton;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.annotation.Config;

import fr.talk.androidtests.BuildConfig;

@RunWith(MockitoJUnitRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP,
        constants = BuildConfig.class)
public class BookActivityTest {

    private BookActivity activity;
    private TextView textView = Mockito.mock(TextView.class);

    @Before
    public void setUp() throws Exception {
        activity = new BookActivity();
        activity.bookTextView = textView;
    }

    @Test
    public void testUpdateBookName_unknown() throws Exception {
        // Given

        // When
        activity.updateBookName();

        // Then
        Mockito.verify(textView).setVisibility(View.GONE);
        Mockito.verifyNoMoreInteractions(textView);
    }

    @SuppressLint("SetTextI18n")
    @Test
    public void testUpdateBookName_known() throws Exception {
        // Given

        // When
        activity.updateBookName();

        // Then
        Mockito.verify(textView).setVisibility(View.VISIBLE);
        Mockito.verify(textView).setText("Garry Poker");
    }
}