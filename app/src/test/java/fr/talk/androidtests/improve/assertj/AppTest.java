package fr.talk.androidtests.improve.assertj;

import junit.framework.Assert;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AppTest {

    @Test
    public void should_be_ordered_by_rating() throws Exception {
        App lowRateApp = new App("com.test", 2.2f);
        App highRateApp = new App("com.google", 4.1f);

        //region
        float compareTo = lowRateApp.compareTo(highRateApp);
        Assert.assertTrue(compareTo < 1);
        //endregion

        //region assertJ
        Assertions.assertThat(highRateApp).isGreaterThan(lowRateApp);
        //endregion
    }
}