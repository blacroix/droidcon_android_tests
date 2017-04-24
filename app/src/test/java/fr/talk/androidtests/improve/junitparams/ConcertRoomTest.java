package fr.talk.androidtests.improve.junitparams;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ConcertRoomTest {

    //region
        // @Parameters({"15, 15, true"})
        // @Parameters(source = ConcertRoomTestDataProvider.class, method = "provideCapacityTestData")
    //endregion

    @Test
    public void concert_room_is_full() throws Exception {
        // Given
        ConcertRoom concertRoom = new ConcertRoom(15);

        // When
        concertRoom.setSpectatorsCount(15);

        // Then
        assertThat(concertRoom.isFull()).isEqualTo(true);
    }

    //region Data provider
    public static class ConcertRoomTestDataProvider {
        public static Object[] provideCapacityTestData() {
            return new Object[]{
                    new Object[]{5000, 500, false},
                    new Object[]{10000, 10000, true}
            };
        }
    }
    //endregion


}