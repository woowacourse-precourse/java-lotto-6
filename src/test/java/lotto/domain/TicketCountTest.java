package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketCountTest {
    @DisplayName("유효한 구입 금액 입력 시 예외가 발생하지 않는다.")
    @Test
    void getTicketCount() {
        int purchaseMoney = 5000;
        TicketCount ticketCount = new TicketCount(purchaseMoney);

        int count = ticketCount.getTicketCount();

        assertEquals(5, count);
    }

    @DisplayName("구입 금액이 1000의 배수가 아닐 경우 예외가 발생한다.")
    @Test
    void countTicketByMoreThan6Numbers() {
        int purchaseMoney = 1500;

        assertThrows(IllegalArgumentException.class, () -> new TicketCount(purchaseMoney));
    }

    @DisplayName("구입 금액이 음수일 시 예외가 발생한다.")
    @Test
    void countTicketByEmptyInput() {
        int purchaseMoney = -1000;

        assertThrows(IllegalArgumentException.class, () -> new TicketCount(purchaseMoney));
    }
}
