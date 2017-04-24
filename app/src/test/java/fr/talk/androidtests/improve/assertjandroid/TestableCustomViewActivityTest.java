package fr.talk.androidtests.improve.assertjandroid;

import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import fr.talk.androidtests.BuildConfig;

import static org.assertj.android.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP, constants = BuildConfig.class)
public class TestableCustomViewActivityTest {

    private TestableCustomView customView;

    @Before
    public void setUp() throws Exception {
        TestableCustomViewActivity activity = Robolectric.setupActivity(TestableCustomViewActivity.class);
        customView = activity.customView;
    }

    @Test
    public void should_show_message() throws Exception {
        customView.showMessage("Message");

        //region assert
        Assert.assertEquals(2, customView.getChildCount());

        Assert.assertEquals(LinearLayout.VERTICAL, customView.getOrientation());

        Assert.assertEquals(View.VISIBLE, customView.messageView.getVisibility());

        Assert.assertEquals("Message", customView.messageView.getText().toString());

        Assert.assertEquals(View.GONE, customView.errorView.getVisibility());
        //endregion

        //region assertJ Android
        assertThat(customView).
                hasChildCount(2).
                hasOrientation(LinearLayout.VERTICAL);

        assertThat(customView.messageView).
                isVisible().
                hasText("Message");

        assertThat(customView.errorView).isGone();
        //endregion
    }
}