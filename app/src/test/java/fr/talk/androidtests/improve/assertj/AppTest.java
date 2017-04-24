package fr.talk.androidtests.improve.assertj;

import junit.framework.Assert;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AppTest {

    @Test
    public void should_be_ordered_by_rating() throws Exception {
        App lowRateApp = new App("com.test", 2.2f);
        App highRateApp = new App("com.google", 4.1f);

        //region default compare
        float compareTo = lowRateApp.compareTo(highRateApp);
        Assert.assertTrue(compareTo < 1);
        //endregion

        //region assertJ compare
        assertThat(highRateApp).isGreaterThan(lowRateApp);
        //endregion
    }
}