package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    private static final String ERROR_PREFIX = "[ERROR] ";

    @ParameterizedTest
    @ValueSource(longs = {-1L, 0L, 999L})
    @DisplayName("금액이 0 이하인 경우 예외가 발생한다.")
    void isAmountLessThenZero_Then_ExceptionOccurs(final long amount) {
        assertThatThrownBy(() -> Money.of(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @Test
    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void isMoneyNotDividedBy1000_Then_ExceptionOccurs() {
        assertThatThrownBy(() -> Money.of(1001L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }
}
