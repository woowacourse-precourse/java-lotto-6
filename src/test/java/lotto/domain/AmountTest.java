package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @ParameterizedTest
    @DisplayName("구입금액이 최소 금액보다 모자라다면 예외 발생")
    @ValueSource(ints = {500})
    void buyAmountIsNotEnough(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입금액이 음수일 경우 예외 발생")
    @ValueSource(ints = {-1})
    void buyAmountNegativeNumber(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입금액이 나누어 떨어지지 않을 경우 예외 발생")
    @ValueSource(ints = {1050})
    void buyAmountDivide(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
