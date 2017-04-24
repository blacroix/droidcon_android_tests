package fr.talk.androidtests.improve.assertj;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AppStoreTest {

    @Test
    public void should_keep_first_duplicate() throws Exception {
        App app = new App("fr.test", 1);
        App sameApp = new App("fr.test", 2);

        AppStore appStore = new AppStore(Arrays.asList(app, sameApp));

        //region default assertion
        Assert.assertEquals(1, appStore.getApps().size());
        Assert.assertEquals(app, appStore.getApps().get(0));
        //endregion

        //region assertJ
        assertThat(appStore.getApps())
                .overridingErrorMessage("Should keep only first duplicate")
                .containsExactly(app);
        //endregion
    }

}