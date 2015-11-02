package fr.talk.androidtests.improve.assertj;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AppStoreTest {


    @Test
    public void should_keep_first_duplicate() throws Exception {
        App app = new App("fr.test", 1);
        App sameApp = new App("fr.test", 2);

        AppStore appStore = new AppStore(asList(app, sameApp));

        assertThat(appStore.getApps()).overridingErrorMessage("Should keep only first duplicate").containsExactly(app);
    }

}