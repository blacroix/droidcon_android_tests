package fr.talk.androidtests.improve.assertj;

import junit.framework.Assert;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class AppStoreTest {

    @Test
    public void should_keep_first_duplicate() throws Exception {
        App app = new App("fr.test", 1);
        App sameApp = new App("fr.test", 2);

        AppStore appStore = new AppStore(Arrays.asList(app, sameApp));

        //region
        Assert.assertEquals(1, appStore.getApps().size());
        Assert.assertEquals(app, appStore.getApps().get(0));
        //endregion

        //region assertJ
        Assertions.assertThat(appStore.getApps())
                .overridingErrorMessage("Should keep only first duplicate")
                .containsExactly(app);
        //endregion
    }

}