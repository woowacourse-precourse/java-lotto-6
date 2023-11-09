package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    @DisplayName("금액이 0 이하인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {-1L, 0L, 999L})
    void isAmountLessThanZero_Then_ExceptionOccurs(final long amount) {
        assertThatThrownBy(() -> Money.of(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void isMoneyNotDividedBy1000_Then_ExceptionOccurs() {
        assertThatThrownBy(() -> Money.of(1001L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("구매 가능한 로또 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5000:5", "50000:50", "1500000:1500"}, delimiter = ':')
    void givenPurchaseAmount_Then_NumberOfTicketsReturns(
            final long amount,
            final long ticketCount
    ) {
        final Money money = Money.of(amount);
        assertThat(money.calculateTicketCount()).isEqualTo(ticketCount);
    }
}
