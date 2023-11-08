package lotto.vo;

import static lotto.constant.LottoConstants.PRICE_PER_LOTTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TotalAmountTest {

    @DisplayName("가격에 따른 Ticket이 올바르게 계산 되는지 점검")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 5000, 10000, 20000})
    public void shouldCalculateTicketCountCorrectly(int amount) {
        // Given
        TotalAmount totalAmount = TotalAmount.from(amount);

        // When
        TicketCount ticketCount = totalAmount.calculateTicketCount();

        // Then
        int expectedCount = amount / PRICE_PER_LOTTO;
        assertEquals(expectedCount, ticketCount.getCount());
    }
}
