package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketAmountTest {
    @DisplayName("구입 금액이 자연수가 아닌 경우 예외가 발생한다.")
    @Test
    void createTicketAmountByNotNatural() {
        String input = "-2000";

        assertThatThrownBy(() -> new TicketAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createTicketAmountByNotDivision() {
        String input = "14820";

        assertThatThrownBy(() -> new TicketAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
