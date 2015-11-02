package fr.talk.androidtests.improve.assertj;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    public void should_be_ordered_by_rating() throws Exception {
        App lowRateApp = new App("com.test", 2.2f);
        App highRateApp = new App("com.google", 4.1f);

        assertThat(highRateApp).isGreaterThan(lowRateApp);
    }
}