package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TicketCountTest {

    @DisplayName("foreach메서드를 위한 단위 Test")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10, 20})
    public void shouldRunActionForEachTicketCount(int count) {
        // Given
        TicketCount ticketCount = TicketCount.from(count);

        // When
        AtomicInteger actionCounter = new AtomicInteger();
        ticketCount.forEach(actionCounter::getAndIncrement);

        // Then
        assertEquals(count, actionCounter.get());
    }
}
