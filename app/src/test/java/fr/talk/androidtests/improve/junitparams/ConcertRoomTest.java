package fr.talk.androidtests.improve.junitparams;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ConcertRoomTest {

    @Test
    @Parameters(source = ConcertRoomTestDataProvider.class, method = "provideCapacityTestData")
    public void concert_room_is_full(int maxAvailablePlaces, int spectatorsCount, boolean full) throws Exception {
        // Given
        ConcertRoom concertRoom = new ConcertRoom(maxAvailablePlaces);

        // When
        concertRoom.setSpectatorsCount(spectatorsCount);

        // Then
        assertThat(concertRoom.isFull()).isEqualTo(full);
    }

    public static class ConcertRoomTestDataProvider {
        public static Object[] provideCapacityTestData() {
            return new Object[]{
                    new Object[]{5000, 500, false},
                    new Object[]{10000, 10000, true}
            };
        }
    }


}